package ua.dnipro.restaurantsvoting.model;

import java.time.LocalDate;
import java.util.Set;

public class LunchMenu extends AbstractBaseEntity{

    // @ManyToOne
    private Restaurant restaurant;

    private LocalDate date;

    // @OneToMany
    private Set<Dish> dishes;

    public LunchMenu(Integer id, Restaurant restaurant, LocalDate date, Set<Dish> dishes) {
        super(id);
        this.restaurant = restaurant;
        this.date = date;
        this.dishes = dishes;
    }
}
