package ua.dnipro.restaurantsvoting.model;

public class Vote extends AbstractBaseEntity{
    private Restaurant restaurant;
    private User user;

    public Vote(Integer id, Restaurant restaurant, User user) {
        super(id);
        this.restaurant = restaurant;
        this.user = user;
    }
}
