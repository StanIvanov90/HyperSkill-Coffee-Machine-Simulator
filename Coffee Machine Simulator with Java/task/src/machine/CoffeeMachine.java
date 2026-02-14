package machine;

import java.util.Scanner;

/**
 * Entry point for the Coffee Machine program.
 * Handles user input and delegates actions to the MachineEngine.
 */
public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineEngine machine = new MachineEngine();

        // Main interaction loop
        while (true) {
            machine.showMenu();
            String action = scanner.next();

            switch (action) {
                case "buy" -> handleBuyAction(scanner, machine);
                case "fill" -> handleFillAction(scanner, machine);
                case "take" -> machine.takeMoneyOut();
                case "remaining" -> machine.printMachineStatus();
                case "clean" -> machine.cleanMachine();
                case "exit" -> { return; }
                default -> System.out.println("Unknown action.");
            }
        }
    }

    /**
     * Handles the "buy" action for the coffee machine. Prompts the user to select a coffee option
     * and processes the user's choice by delegating to the appropriate method in the machine.
     * If the machine requires cleaning, the user is informed and no further action is taken.
     *
     * @param scanner a {@code Scanner} object used to capture user input
     * @param machine a {@code MachineEngine} object representing the coffee machine,
     *                responsible for executing the coffee purchase process
     */
    private static void handleBuyAction(Scanner scanner, MachineEngine machine) {
        if (machine.isDirty()) {
            System.out.println("I need cleaning!");
        } else {
            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
            String coffeeOption = scanner.next();
            machine.buyCoffee(coffeeOption);
        }
    }

    /**
     * Handles the "fill" action for the coffee machine, prompting the user to input
     * quantities of water, milk, coffee beans, and disposable cups to add to the machine's inventory.
     * The provided quantities are then updated in the machine's internal state.
     *
     * @param scanner a {@code Scanner} object used to capture user input
     * @param machine a {@code MachineEngine} object representing the coffee machine,
     *                which processes the replenishment of machine resources
     */

    private static void handleFillAction(Scanner scanner, MachineEngine machine) {
        System.out.println("Write how many ml of water do you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        int coffeeBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int cups = scanner.nextInt();
        machine.fillMachine(water, milk, coffeeBeans, cups);
    }
}