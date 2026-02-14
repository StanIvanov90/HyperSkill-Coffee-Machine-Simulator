package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MachineEngine machine = new MachineEngine();
        while (true) {
            machine.showMenu();
            String action = scanner.next();
            switch (action) {
                case "buy" -> {
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeOption = scanner.next();
                    machine.buyCoffee(coffeeOption);
                }
                case "remaining" -> machine.printMachineStatus();
                case "take" -> machine.takeMoneyOut();
                case "fill" -> {
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
                case "clean" -> machine.cleanMachine();
                case "exit" -> {
                    return;
                }
            }
        }
    }
}