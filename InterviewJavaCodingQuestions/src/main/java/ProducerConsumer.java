import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumer {

    private boolean executionFinished = false;

    static class Producer implements Runnable {
        private final Queue<Integer> sharedQueue;

        private final ReentrantLock lock ;
        private final Condition isEmpty ;
        private final Condition isFull ;
        private final int MAX_SIZE ;
        private AtomicBoolean executionFinished;


        Producer(Queue<Integer> sharedQueue, ReentrantLock lock, Condition isEmpty, Condition isFull, int max_size, AtomicBoolean executionFinished) {
            this.sharedQueue = sharedQueue;
            this.lock = lock;
            this.isEmpty = isEmpty;
            this.isFull = isFull;
            this.MAX_SIZE = max_size;
            this.executionFinished = executionFinished;
        }

        public void run() {
            for(int i=0 ; i<20; ++i){
                try{
                    lock.lock();
                    while(sharedQueue.size() == MAX_SIZE){
                        isFull.await();
                    }
                    sharedQueue.add(i);
                    System.out.println("Produced: " + i);
                    isEmpty.signal();
                    Thread.currentThread().sleep(300); // Simulate processing time
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally {
                    lock.unlock();
                }
            }
            try{
                lock.lock();
                executionFinished.set(true);
                isEmpty.signalAll();
            }
            finally {
                lock.unlock();
            }
        }
    }

    static class Consumer implements Runnable {
        private final Queue<Integer> sharedQueue;

        private final ReentrantLock lock ;
        private final Condition isEmpty ;
        private final Condition isFull ;
        private final AtomicBoolean executionFinished;


        Consumer(Queue<Integer> sharedQueue, ReentrantLock lock, Condition isEmpty, Condition isFull, AtomicBoolean executionFinished) {
            this.sharedQueue = sharedQueue;
            this.lock = lock;
            this.isEmpty = isEmpty;
            this.isFull = isFull;
            this.executionFinished = executionFinished;
        }

        public void run() {
            while(!executionFinished.get()){
                try{
                    lock.lock();
                    while(sharedQueue.isEmpty()){
                        if(executionFinished.get()){
                            return;
                        }
                        isEmpty.await();
                    }
                    int value = sharedQueue.poll();
                    System.out.println("Consumed: " + value);
                    isFull.signal();
                }
                catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
                finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(500); // Simulate processing time
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition isEmpty = lock.newCondition();
        Condition isFull = lock.newCondition();
        int MAX_SIZE = 10;
        AtomicBoolean executionFinished = new AtomicBoolean(false);
        Queue<Integer> sharedQueue = new LinkedList<>();
        Thread producerThread = new Thread(new Producer(sharedQueue, lock, isEmpty, isFull, MAX_SIZE, executionFinished));
        Thread consumerThread = new Thread(new Consumer(sharedQueue, lock, isEmpty, isFull, executionFinished));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
