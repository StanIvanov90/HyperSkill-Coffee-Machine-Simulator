package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineEngine engine = new MachineEngine();
        System.out.println("Write how many cups of coffee you will need:");
        if (scanner.hasNextInt()) {
            int cups = scanner.nextInt();
            engine.printNeededIngredients(cups);
        }
    }
}