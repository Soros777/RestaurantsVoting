package ua.dnipro.restaurantsvoting.inMemory.repository;

import ua.dnipro.restaurantsvoting.model.Dish;

import java.util.Collection;

public interface DishRepository {

    Dish save(Dish dish);

    boolean delete(int id);

    Dish get(int id);

    Collection<Dish> getAll();
}
