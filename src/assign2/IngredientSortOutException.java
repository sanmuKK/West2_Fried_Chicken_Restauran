package assign2;

public class IngredientSortOutException extends RuntimeException {
    public IngredientSortOutException(String message) {
        super();
        System.out.println("The " + message + " is sold out");
    }
}
