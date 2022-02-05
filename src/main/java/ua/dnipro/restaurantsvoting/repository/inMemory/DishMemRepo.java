package ua.dnipro.restaurantsvoting.repository.inMemory;

import ua.dnipro.restaurantsvoting.model.Dish;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DishMemRepo {
    private final Map<Integer, Dish> dishes = new ConcurrentHashMap<>();

}
