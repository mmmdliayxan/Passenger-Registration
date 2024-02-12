package program;

import method.Check;
import method.Required;

public class Main {
    public static void main(String[] args) {

        while (true) {
            int number = Required.requiredNumber("1.Register\n2.All passenger.Passenger\n" +
                    "3.Find passenger.Passenger\n4.Update passenger.Passenger\n0.Stop Operation");
            Check.check(number);
        }
    }
}
