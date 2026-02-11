package machine;

public class MachineEngine {

    //Ingredients needed to make coffee
    private final static int WATER_PER_CUP = 200;
    private final static int MILK_PER_CUP = 50;
    private final static int BEANS_PER_CUP = 15;

    private int water;
    private int milk;
    private int beans;

    public MachineEngine(int water, int milk, int beans) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
    }

    public void checkCapabilities(int requestedCups) {
        int possibleByWater = this.water / WATER_PER_CUP;
        int possibleByMilk = this.milk / MILK_PER_CUP;
        int possibleByBeans = this.beans / BEANS_PER_CUP;

        int totalPossible = Math.min(possibleByWater,
                Math.min(possibleByMilk, possibleByBeans));

        if (totalPossible == requestedCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (totalPossible > requestedCups) {
            int extra = totalPossible - requestedCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extra + " more than that)");
        } else {
            System.out.println("No, I can make only " + totalPossible + " cup(s) of coffee");
        }
    }


    public void printNeededIngredients(int cups) {
        int water = cups * WATER_PER_CUP;
        int milk = cups * MILK_PER_CUP;
        int beans = cups * BEANS_PER_CUP;

        System.out.printf("For %d cups of coffee you will need:%n", cups);
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", beans);
    }

    public static void printStepsToMakeCoffe(){
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
