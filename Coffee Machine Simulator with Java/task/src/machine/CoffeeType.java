package machine;

public enum CoffeeType {

    ESPRESSO(CoffeeRecipes.WATER_PER_ESPRESSO, CoffeeRecipes.MILK_PER_ESPRESSO, CoffeeRecipes.BEANS_PER_ESPRESSO, CoffeeRecipes.PRICE_PER_ESPRESSO),
    LATTE(CoffeeRecipes.WATER_PER_LATTE, CoffeeRecipes.MILK_PER_LATTE, CoffeeRecipes.BEANS_PER_LATTE, CoffeeRecipes.PRICE_PER_LATTE),
    CAPPUCCINO(CoffeeRecipes.WATER_PER_CAPPUCCINO, CoffeeRecipes.MILK_PER_CAPPUCCINO, CoffeeRecipes.BEANS_PER_CAPPUCCINO, CoffeeRecipes.PRICE_PER_CAPPUCCINO);

    final int water;
    final int milk;
    final int beans;
    final int price;

    CoffeeType(int water, int milk, int beans, int price) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.price = price;
    }

}
