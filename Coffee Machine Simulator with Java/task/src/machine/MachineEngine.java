package machine;

public class MachineEngine {

    private final static int STARTING_WATER = 400;
    private final static int STARTING_MILK = 540;
    private final static int STARTING_BEANS = 120;
    private final static int STARTING_CUPS = 9;
    private final static int STARTING_MONEY = 550;
    private final static int CUPS_PER_COFFEE = 1;
    private final static int EMPTY_BALANCE = 0;
    private final static int CLEANING_THRESHOLD = 10;
    private int cupsMade = 0;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public MachineEngine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    /**
     * Default constructor for the MachineEngine class.
     * Initializes the machine with default starting quantities, including water, milk, coffee beans,
     * disposable cups, and money. These default values are defined by the constants
     * STARTING_WATER, STARTING_MILK, STARTING_BEANS, STARTING_CUPS, and STARTING_MONEY.
     */
    public MachineEngine() {
        this(STARTING_WATER, STARTING_MILK, STARTING_BEANS, STARTING_CUPS, STARTING_MONEY);
    }

    /**
     * Displays the main menu prompt to the user.
     * This method prints a message to the console requesting the user to select an action
     * for interacting with the coffee machine. Available actions include:
     * - buy: Purchase a coffee.
     * - fill: Refill machine resources, such as water, milk, beans, and cups.
     * - take: Withdraw money from the machine.
     * - clean: Clean the coffee machine.
     * - remaining: Show the current status of machine resources.
     * - exit: Exit the program.
     * This method does not accept any parameters or return any values;
     * it simply outputs the menu prompt to guide user interaction.
     */

    public void showMenu() {
        System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
    }

    /**
     * Withdraws all money from the coffee machine and resets the machine's monetary balance.
     * This method prints the amount of money withdrawn to the console and sets the machine's
     * internal money balance to zero, represented by the constant {@code EMPTY_BALANCE}.
     * <p>
     * This operation is typically triggered by the "take" action in the user menu and is used
     * to collect earnings from coffee sales. It does not return any value.
     */
    public void takeMoneyOut() {
        System.out.printf("I gave you $%d%n", this.money);
        this.money = EMPTY_BALANCE;
    }

    /**
     * Displays the current status of the coffee machine's resources and monetary balance.
     * This method prints the quantities of water, milk, coffee beans, disposable cups,
     * and money currently available in the machine's inventory.
     * <p>
     * The output format includes:
     * - The quantity of water (in milliliters).
     * - The quantity of milk (in milliliters).
     * - The quantity of coffee beans (in grams).
     * - The number of disposable cups.
     * - The amount of money (in the machine's currency).
     * <p>
     * This informational method is typically used to provide an overview of the
     * machine's internal state after user actions, such as purchasing coffee,
     * refilling resources, or withdrawing money.
     * <p>
     * The method does not take any parameters and does not return any value;
     * it outputs the status to the console directly.
     */
    public void printMachineStatus() {
        System.out.printf("The coffee machine has:%n%d of water%n%d of milk%n%d of coffee beans%n%d disposable cups%n%d of money%n", this.water, this.milk, this.beans, this.cups, this.money);
    }

    /**
     * Replenishes the coffee machine's resources by adding the specified quantities
     * of water, milk, coffee beans, and disposable cups to the machine's inventory.
     * This method updates the machine's internal state with the provided values.
     *
     * @param water the amount of water to add to the machine's reservoir, in milliliters
     * @param milk  the amount of milk to add to the machine's reservoir, in milliliters
     * @param beans the number of coffee beans to add to the machine, in grams
     * @param cups  the number of disposable cups to add to the machine
     */
    public void fillMachine(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    /**
     * Handles the purchase of coffee based on the user's selection.
     * This method allows the user to choose a coffee option and initiates
     * the process of making the selected coffee if resources are enough.
     * If the option specified by the user is "back", the method exits without
     * performing any action. For valid coffee options, the method checks resources
     * and updates the machine's state accordingly.
     *
     * @param coffeeOption the user's choice of coffee. Valid options include:
     *                     "1" for espresso, "2" for latte, "3" for cappuccino.
     *                     Use "back" to cancel and return to the previous menu.
     */
    public void buyCoffee(String coffeeOption) {
        if ("back".equals(coffeeOption)) {
            return;
        }

        switch (coffeeOption) {
            case "1" -> processCoffeePurchase(CoffeeType.ESPRESSO);
            case "2" -> processCoffeePurchase(CoffeeType.LATTE);
            case "3" -> processCoffeePurchase(CoffeeType.CAPPUCCINO);
            default -> System.out.println("Unknown option");
        }
    }

    /**
     * Determines which ingredient is lacking for making a cup of coffee based on the required quantities.
     * If all ingredients are enough, it returns "none". If an ingredient is missing, it returns the name
     * of the missing ingredient.
     *
     * @param waterNeeded the amount of water required to make the coffee, in milliliters
     * @param milkNeeded  the amount of milk required to make the coffee, in milliliters
     * @param beansNeeded the number of coffee beans required to make the coffee, in grams
     * @return a string indicating the missing ingredient ("water", "milk", "coffee beans", "disposable cups"),
     * or "none" if all required ingredients are available
     */
    private String findMissingIngredient(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (this.water < waterNeeded) return "water";
        if (this.milk < milkNeeded) return "milk";
        if (this.beans < beansNeeded) return "coffee beans";
        if (this.cups < CUPS_PER_COFFEE) return "disposable cups";
        return "none";
    }

    /**
     * Checks whether the coffee machine needs cleaning.
     * The machine is considered dirty if the number of cups made
     * since the last cleaning equals or exceeds the cleaning threshold.
     *
     * @return true if the machine needs cleaning, false otherwise
     */
    public boolean isDirty() {
        return this.cupsMade >= CLEANING_THRESHOLD;
    }

    /**
     * Processes the purchase of a specific type of coffee. This method checks if the machine
     * needs cleaning or has enough resources to fulfill the coffee request. If the machine
     * needs cleaning, the purchase process is not executed. If an ingredient is missing, it
     * notifies the user about the shortage. Otherwise, it makes the coffee by updating the
     * machine's resources accordingly.
     *
     * @param coffeeType the type of coffee selected for purchase, which includes the
     *                   specific quantities of water, milk, coffee beans, and price
     *                   required to make the coffee
     */
    private void processCoffeePurchase(CoffeeType coffeeType) {

        String missing = findMissingIngredient(coffeeType.water, coffeeType.milk, coffeeType.beans);

        if (!missing.equals("none")) {
            System.out.println("Sorry, not enough " + missing + "!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            updateResources(coffeeType);
        }
    }

    /**
     * Updates the coffee machine's resource levels based on the specified coffee type.
     * This method deducts the required amounts of water, milk, coffee beans, and disposable cups
     * from the machine's resources for making the selected coffee. Additionally, it increments
     * the machine's monetary balance by the price of the coffee and updates the count of cups made.
     *
     * @param coffeeType the type of coffee selected, which includes the specific quantities of
     *                   water, milk, coffee beans, and the price associated with making this coffee
     */
    private void updateResources(CoffeeType coffeeType) {
        this.water -= coffeeType.water;
        this.milk -= coffeeType.milk;
        this.beans -= coffeeType.beans;
        this.cups -= CUPS_PER_COFFEE;
        this.money += coffeeType.price;
        this.cupsMade += CUPS_PER_COFFEE;
    }

    /**
     * Cleans the coffee machine by resetting the count of cups made to zero.
     * This method is used to maintain the hygiene of the machine after a specified
     * number of cups of coffee have been prepared. Once the cleaning operation
     * is completed, a confirmation message is printed to the console.
     * <p>
     * This method modifies the machine's internal state by setting the {@code cupsMade}
     * field to zero. It does not accept any parameters or return a value.
     */
    public void cleanMachine() {
        this.cupsMade = 0;
        System.out.println("I have been cleaned!");
    }

}

