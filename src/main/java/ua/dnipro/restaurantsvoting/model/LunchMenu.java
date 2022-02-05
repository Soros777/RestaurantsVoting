package ua.dnipro.restaurantsvoting.model;

import java.util.Set;

public class LunchMenu extends AbstractBaseEntity{

    // @ManyToOne
    private Restaurant restaurant;

    // @OneToMany
    private Set<Dish> dishes;

    public LunchMenu(Integer id, Restaurant restaurant, Set<Dish> dishes) {
        super(id);
        this.restaurant = restaurant;
        this.dishes = dishes;
    }

    public LunchMenu(Restaurant restaurant, Set<Dish> dishes) {
        this(null, restaurant, dishes);
    }

    public LunchMenu(Set<Dish> dishes) {
        this(null, dishes);
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    @Override
    public String toString() {
        StringBuilder allDishes = new StringBuilder();
        dishes.forEach(dish -> allDishes.append(
                "DishName : " + dish.getDishName() + ", dishPrice : " + dish.getPrice() + ", dishId : " + dish.getId() + "; "));
        return "LunchMenu{" +
                "id=" + id +
                ", restaurantName=" + restaurant.getName() + ", restaurantId=" + restaurant.getId() +
                ", dishes=" + allDishes +
                '}';
    }
}
