package machine;

public class MachineEngine {

    //Ingredients needed to make coffee
    private final static int STARTING_WATER = 400;
    private final static int STARTING_MILK = 540;
    private final static int STARTING_BEANS = 120;
    private final static int STARTING_CUPS = 9;
    private final static int STARTING_MONEY = 550;
    private final static int WATER_PER_ESPRESSO = 250;
    private final static int BEANS_PER_ESPRESSO = 16;
    private final static int PRICE_PER_ESPRESSO = 4;
    private final static int WATER_PER_LATTE = 350;
    private final static int MILK_PER_LATTE = 75;
    private final static int BEANS_PER_LATTE = 20;
    private final static int PRICE_PER_LATTE = 7;
    private final static int WATER_PER_CAPPUCCINO = 200;
    private final static int MILK_PER_CAPPUCCINO = 100;
    private final static int BEANS_PER_CAPPUCCINO = 12;
    private final static int PRICE_PER_CAPPUCCINO = 6;
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

    public void takeMoneyOut() {
        System.out.printf("I gave you $%d", this.money);
        this.money = EMPTY_BALANCE;
    }

    public void printMachineStatus() {
        System.out.printf("The coffee machine has:%n%d of water%n%d of milk%n%d of coffee beans%n%d disposable cups%n%d of money",
                this.water, this.milk, this.beans, this.cups, this.money);
    }

    public void fillMachine(int water, int milk, int beans, int cups) {
        this.water += water;
        this.milk += milk;
        this.beans += beans;
        this.cups += cups;
    }

    public void buyEspresso() {
        this.water -= WATER_PER_ESPRESSO;
        this.beans -= BEANS_PER_ESPRESSO;
        this.money += PRICE_PER_ESPRESSO;
        this.cups--;
    }

    public void buyLatte() {
        this.water -= WATER_PER_LATTE;
        this.milk -= MILK_PER_LATTE;
        this.beans -= BEANS_PER_LATTE;
        this.money += PRICE_PER_LATTE;
        this.cups--;
    }

    public void buyCappuccino() {
        this.water -= WATER_PER_CAPPUCCINO;
        this.milk -= MILK_PER_CAPPUCCINO;
        this.beans -= BEANS_PER_CAPPUCCINO;
        this.money += PRICE_PER_CAPPUCCINO;
        this.cups--;
    }

    public void buyCoffee(int coffeeOption) {
        switch (coffeeOption) {
            case 1 -> buyEspresso();
            case 2 -> buyLatte();
            case 3 -> buyCappuccino();
            default -> throw new IllegalArgumentException("Invalid coffee option: " + coffeeOption);
        }
    }

}

