package ua.dnipro.restaurantsvoting.inMemory.repository;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.Dish;

@Repository
public class DishMemRepo extends InMemoryBaseRepository<Dish> implements DishRepository {
}
