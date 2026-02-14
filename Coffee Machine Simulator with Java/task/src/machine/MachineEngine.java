package machine;

public class MachineEngine {

    //Ingredients needed to make coffee
    private final static int STARTING_WATER = 400;
    private final static int STARTING_MILK = 540;
    private final static int STARTING_BEANS = 120;
    private final static int STARTING_CUPS = 9;
    private final static int STARTING_MONEY = 550;
    private final static int CUPS_PER_COFFEE = 1;
    private final static int EMPTY_BALANCE = 0;

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

    public MachineEngine() {
        this(STARTING_WATER, STARTING_MILK, STARTING_BEANS, STARTING_CUPS, STARTING_MONEY);
    }

    public void showMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }

    public void takeMoneyOut() {
        System.out.printf("I gave you $%d%n", this.money);
        this.money = EMPTY_BALANCE;
    }

    public void printMachineStatus() {
        System.out.printf("The coffee machine has:%n%d of water%n%d of milk%n%d of coffee beans%n%d disposable cups%n%d of money%n", this.water, this.milk, this.beans, this.cups, this.money);
    }

    public void fillMachine(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

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

    private String findMissingIngredient(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (this.water < waterNeeded) return "water";
        if (this.milk < milkNeeded) return "milk";
        if (this.beans < beansNeeded) return "coffee beans";
        if (this.cups < CUPS_PER_COFFEE) return "disposable cups";
        return "none";
    }

    private void processCoffeePurchase(CoffeeType coffeeType) {
        String missing = findMissingIngredient(coffeeType.water, coffeeType.milk, coffeeType.beans);

        if (!missing.equals("none")) {
            System.out.println("Sorry, not enough " + missing + "!");
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            this.water -= coffeeType.water;
            this.milk -= coffeeType.milk;
            this.beans -= coffeeType.beans;
            this.cups -= CUPS_PER_COFFEE;
            this.money += coffeeType.price;
        }
    }

}

