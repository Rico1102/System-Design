public class MainController {

    public static void main(String[] args) throws InterruptedException {
        // Initialize the application
        System.out.println("Welcome to the Call Centre Application!");

        CallCentreController callCentreController = new CallCentreController();

        callCentreController.takeCall("Customer needs assistance with billing issue.");
        callCentreController.takeCall("Customer wants to report a service outage.");
        callCentreController.takeCall("Customer has a general inquiry about services.");
        callCentreController.takeCall("Customer is requesting a refund for a recent purchase.");
        callCentreController.takeCall("Customer is experiencing technical difficulties with their device.");
        callCentreController.takeCall("Customer is unhappy with the service and wants to escalate the issue.");
        callCentreController.takeCall("Customer is requesting a callback from a manager.");
        Thread.sleep(2000);
        callCentreController.takeCall("Customer is asking for a product recommendation.");
        callCentreController.takeCall("Customer is inquiring about a new service plan.");
        callCentreController.takeCall("Customer is reporting a lost or stolen device.");

        // Here you can add more functionality, such as starting a GUI or processing commands
        // For example, you might want to create instances of CallCentre, Agent, and Customer classes
        // and simulate interactions between them.
    }

}
