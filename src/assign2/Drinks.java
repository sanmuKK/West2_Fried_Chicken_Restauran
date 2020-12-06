package assign2;

import java.time.LocalDate;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate production_date;
    protected int shelf_life;

    public Drinks(String name, double cost, LocalDate production_date, int shelf_life) {
        this.name = name;
        this.cost = cost;
        this.production_date = production_date;
        this.shelf_life = shelf_life;
    }

    public boolean is_overdue() {
        LocalDate now = LocalDate.now();
        return production_date.plusDays(shelf_life).isBefore(now);
    }

    @Override
    public abstract String toString();
}
