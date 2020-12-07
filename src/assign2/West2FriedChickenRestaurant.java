package assign2;

import java.time.LocalDate;
import java.util.ArrayList;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double balance;
    private final ArrayList<Beer> beer_list;
    private final ArrayList<Juice> juice_list;
    static final private ArrayList<SetMeal> set_meal_list;

    public West2FriedChickenRestaurant(double balance) {
        this.balance = balance;
        beer_list = new ArrayList<>();
        juice_list = new ArrayList<>();
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Beer> getBeer_list() {
        return beer_list;
    }

    public ArrayList<Juice> getJuice_list() {
        return juice_list;
    }

    public ArrayList<SetMeal> getSet_meal_list() {
        return set_meal_list;
    }


    private void use(Beer b) {
        beer_list.removeIf(Drinks::is_overdue);
        if (!beer_list.remove(b)) {
            throw new IngredientSortOutException(b.name);
        }
    }

    private void use(Juice j) {
        juice_list.removeIf(Drinks::is_overdue);
        if (!juice_list.remove(j)) {
            throw new IngredientSortOutException(j.name);
        }
    }

    @Override
    public void sale_package(SetMeal s) {
        Drinks d = s.getDrinks();
        balance += s.getPrice();
        try {
            if (d instanceof Beer) {
                use((Beer) d);
            } else if (d instanceof Juice) {
                use((Juice) d);
            }
        } catch (IngredientSortOutException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void bulk_purchase() {
        double sum = 0;
        for (SetMeal i : set_meal_list) {
            Drinks a = i.getDrinks();
            sum += a.cost;
            if (a instanceof Beer) {
                beer_list.add((Beer) a);
            } else if (a instanceof Juice) {
                juice_list.add((Juice) a);
            }
        }
        try {
            if (balance < sum)
                throw new OverdraftBalanceException(sum - balance);
            balance -= sum;
        } catch (OverdraftBalanceException e) {
            e.printStackTrace();
        }
    }

    static {
        SetMeal no1 = new SetMeal("NO.1", 12.5, "fried_chicken",
                new Juice("juice1", 7.7, LocalDate.of(2020, 12, 6)));
        SetMeal no2 = new SetMeal("NO.2", 13.5, "fried_chicken",
                new Juice("juice2", 8.7, LocalDate.of(2020, 11, 11)));
        SetMeal no3 = new SetMeal("NO.3", 14.5, "fried_chicken",
                new Beer("beer1", 9.7, LocalDate.of(2020, 11, 21), (float) 3.7));
        SetMeal no4 = new SetMeal("NO.4", 15.5, "fried_chicken",
                new Beer("beer2", 10.7, LocalDate.of(2020, 12, 3), (float) 6.9));
        set_meal_list = new ArrayList<>();
        set_meal_list.add(no1);
        set_meal_list.add(no2);
        set_meal_list.add(no3);
        set_meal_list.add(no4);
    }
}
