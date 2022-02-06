package ua.dnipro.restaurantsvoting.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lunch_menus")
public class LunchMenu extends AbstractBaseEntity{

    @OneToOne
    @JoinColumn(name = "restaurant_id", nullable = false, unique = true)
    private Restaurant restaurant;

    @OneToMany(fetch = FetchType.LAZY)
    @CollectionTable(name = "lunch_dishes", joinColumns = @JoinColumn(name = "lunch_id"))
    @Column(name = "dish_id")
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
