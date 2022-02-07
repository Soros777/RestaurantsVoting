package ua.dnipro.restaurantsvoting.model;

import javax.persistence.*;
import java.util.Set;

@NamedQueries({
        @NamedQuery(name = LunchMenu.ALL, query = "SELECT lm FROM LunchMenu lm")
})

@Entity
@Table(name = "lunch_menus")
public class LunchMenu extends AbstractBaseEntity{
    public static final String ALL = "LunchMenu.getAll";

    @OneToOne
    @JoinColumn(name = "restaurant_id", nullable = false, unique = true)
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "lunchMenu")
    private Set<Dish> dishes;

    public LunchMenu() {
    }

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

    public LunchMenu(LunchMenu lm) {
        this.id = lm.id;
        this.dishes = lm.dishes;
        this.restaurant = lm.restaurant;
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
