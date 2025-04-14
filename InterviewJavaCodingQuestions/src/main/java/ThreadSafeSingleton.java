public class ThreadSafeSingleton {

    static ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {
        // private constructor to prevent instantiation
        if (instance != null) {
            // This is to prevent reflection from creating a new instance
            throw new RuntimeException("Use getInstance() method to get the single instance.");
        }
    }

    public static ThreadSafeSingleton getInstance() {
        // Double-checked locking to ensure thread safety
        if(instance == null){
            synchronized (ThreadSafeSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeSingleton();
                }
            }
        }
        return instance ;
    }

}
