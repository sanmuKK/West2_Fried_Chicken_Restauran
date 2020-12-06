package assign2;

public class SetMeal {
    private final String set_meal_name;
    private final double price;
    private final String fried_chicken_name;
    private final Drinks drinks;


    public double getPrice() {
        return price;
    }


    public Drinks getDrinks() {
        return drinks;
    }


    public SetMeal(String set_meal_name, double price, String fried_chicken_name, Drinks drinks) {
        this.set_meal_name = set_meal_name;
        this.price = price;
        this.fried_chicken_name = fried_chicken_name;
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "The package name is \"" + set_meal_name + "\" and the price is \"" +
                price + "\" yuan" + " with \"" + fried_chicken_name + "\" and \"" + drinks.name + "\"";
    }
}
