package ua.dnipro.restaurantsvoting.model;

import java.time.LocalDate;

public class Vote extends AbstractBaseEntity{
    private LocalDate date;
    private Restaurant restaurant;
    private User user;

    public Vote(Integer id, LocalDate date, Restaurant restaurant, User user) {
        super(id);
        this.date = date;
        this.restaurant = restaurant;
        this.user = user;
    }
}
