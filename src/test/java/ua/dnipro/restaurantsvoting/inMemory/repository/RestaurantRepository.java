package ua.dnipro.restaurantsvoting.inMemory.repository;

import ua.dnipro.restaurantsvoting.model.Restaurant;

import java.util.Collection;

public interface RestaurantRepository {

    Restaurant save(Restaurant restaurant);

    boolean delete(int id);

    Restaurant get(int id);

    Collection<Restaurant> getAll();
}
