package assign2;

import java.time.LocalDate;

public class Beer extends Drinks {
    private final float alcohol_degree;

    public Beer(String name, double cost, LocalDate production_date, float alcohol_degree) {
        super(name, cost, production_date, 30);
        this.alcohol_degree = alcohol_degree;
    }

    @Override
    public String toString() {
        return "{This beer is called " + name + ". It costs " + cost + " yuan. " +
                "The production date is " + production_date + ". The shelf life is 30 days." +
                " The degree is " + alcohol_degree + " degrees}";
    }
}
