public class Main {
    public static void main(String[] args) {

        while (true) {
            int number = Required.requiredNumber("1.Register\n2.All Passenger\n" +
                    "3.Find Passenger\n4.Update Passenger\n0.Stop Operation");
            Check.check(number);
        }
    }
}
