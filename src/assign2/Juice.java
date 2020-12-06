package assign2;

import java.time.LocalDate;

public class Juice extends Drinks {
    public Juice(String name, double cost, LocalDate production_date) {
        super(name, cost, production_date, 2);
    }

    @Override
    public String toString() {
        return "{This juice is called " + name + ". It costs " + cost + " yuan. " +
                "The production date is " + production_date + ". The shelf life is 2 days}";
    }
}
