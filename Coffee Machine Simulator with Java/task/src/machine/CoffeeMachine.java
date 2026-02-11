package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Get current supplies from the user
        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableBeans = scanner.nextInt();

        MachineEngine engine = new MachineEngine(availableWater, availableMilk, availableBeans);

        //Get the number of cups the user wants
        System.out.println("Write how many cups of coffee you will need:");
        int requestedCups = scanner.nextInt();

        engine.checkCapabilities(requestedCups);


    }
}