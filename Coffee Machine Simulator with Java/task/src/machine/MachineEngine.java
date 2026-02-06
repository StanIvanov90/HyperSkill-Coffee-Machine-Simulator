package machine;

public class MachineEngine {

    //Ingredients needed to make coffee
    private final static int WATER_PER_CUP = 200;
    private final static int MILK_PER_CUP = 50;
    private final static int BEANS_PER_CUP = 15;


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
