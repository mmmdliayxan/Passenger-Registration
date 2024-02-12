import java.util.Arrays;

public class PassengerOperations {
    public static Passenger registerPassenger() {
        Passenger passenger = new Passenger();
        passenger.setName(Required.requiredText("Enter the name: "));
        passenger.setSurname(Required.requiredText("Enter the surname: "));
        passenger.setAge(Required.requiredNumber("Enter the age: "));
        int seatNumber = Required.requiredNumber("Enter the seatNumber: ");
        if (checkSeatNumber(seatNumber) && Config.count == 0) {
            try {
                throw new SameSeatNumber("This seatNumber is bought by another passenger");
            } catch (SameSeatNumber e) {
                e.printStackTrace();
                Config.count++;
                Main.main(null);
            }
        } else if (checkSeatNumber(seatNumber)) {
            try {
                throw new SameSeatNumber("This seatNumber is bought by another passenger");
            } catch (SameSeatNumber e) {
                e.printStackTrace();
                Main.main(null);
            }
        }
        passenger.setSeatNumber(seatNumber);
        return passenger;
    }

    public static void fillPassengerArray() {
        int length = Required.requiredNumber("How many passenger will be registered?");
        Config.passengers[Config.count] = new Passenger[length];
        for (int i = 0; i < length; i++) {
            Config.passengers[Config.count][i] = registerPassenger();
        }
        Config.count++;
    }

    public static boolean checkSeatNumber(int seatNumber) {
        for (Passenger[] passengers1 : Config.passengers) {
            if (passengers1 == null) {
                break;
            }
            for (Passenger passenger : passengers1) {
                if (passenger == null) {
                    break;
                } else if (seatNumber == passenger.getSeatNumber()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void allPassengers(Passenger[][] passengers) {
        if (passengers[0] == null) {
            System.err.println("There isn't any person who is registered");
        } else {
            for (Passenger[] passenger : passengers) {
                if (passenger == null) {
                    break;
                }
                for (Passenger value : passenger) {
                    if (value == null) {
                        break;
                    }
                    System.out.println(value.getName() + " " + value.getSurname() + " " +
                            value.getAge() + " " + value.getSeatNumber());
                }
            }
        }
    }

    public static void findPassenger() {
        if (Config.passengers[0] == null) {
            System.out.println("There isn't any person who is registered");
        } else {
            String text = Required.requiredText("Which passenger do you want to find?");

            int count = 0;

            for (int i = 0; i < Config.passengers.length; i++) {
                Passenger[] passengers = Config.passengers[i];
                if (passengers == null) {
                    break;
                }
                for (Passenger passenger : passengers) {
                    if (passenger == null) {
                        break;
                    } else if (text.equalsIgnoreCase(passenger.getName())||text.equalsIgnoreCase(passenger.getSurname())) {
                        count++;
                    }
                }
            }
            Passenger[] result = new Passenger[count];
            int temp = 0;
            for (int i = 0; i < Config.passengers.length; i++) {
                Passenger[] passengers = Config.passengers[i];
                if (passengers == null) {
                    break;
                }
                for (Passenger passenger : passengers) {
                    if (passenger == null) {
                        break;
                    } else if (text.equalsIgnoreCase(passenger.getName())||text.equalsIgnoreCase(passenger.getSurname())) {
                        result[temp++] = passenger;
                    }
                }
            }
            System.out.println(Arrays.toString(result));
        }
    }

    public static void updatePassenger() {
        if (Config.passengers[0] == null) {
            System.out.println("There isn't any person who is registered");
        } else {
            int seatNumber = Required.requiredNumber("Which passenger do you want to update who sit on that seatNumber");

            if (!checkSeatNumber(seatNumber)) {
                System.err.println("There isn't any person in this seatNumber. Enter seatNumber again!");
            } else {
                String text = Required.requiredText("For what do you want to update passenger");
                String[] strArray = text.split(",");
                for (String value : strArray) {
                    for (Passenger[] passengers : Config.passengers) {
                        if (passengers == null) {
                            break;
                        }
                        for (Passenger passenger : passengers) {
                            if (passenger == null) {
                                break;
                            }
                            if (passenger.getSeatNumber() == seatNumber) {
                                switch (value) {
                                    case "name" -> passenger.setName(Required.requiredText("Enter the name:"));
                                    case "surname" -> passenger.setSurname(Required.requiredText("Enter the surname:"));
                                    case "age" -> passenger.setAge(Required.requiredNumber("Enter the age:"));
                                    case "seatNumber" -> passenger.setSeatNumber(Required.requiredNumber("Enter the seatNumber"));
                                    default -> System.out.println("Passenger hasn't any field like this");
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
