package method;

import config.Config;

public class Check {

    public static void check(int number) {

        switch (number) {
            case 1 -> {
                PassengerOperations.fillPassengerArray();
                System.out.println("Passenger's registration is successfully completed");
            }
            case 2 -> PassengerOperations.allPassengers(Config.passengers);
            case 3 -> PassengerOperations.findPassenger();
            case 4 -> PassengerOperations.updatePassenger();
            default -> System.exit(0);
        }
    }
}
