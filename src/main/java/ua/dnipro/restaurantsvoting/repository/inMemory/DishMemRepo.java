package ua.dnipro.restaurantsvoting.repository.inMemory;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.Dish;
import ua.dnipro.restaurantsvoting.repository.DishRepository;

@Repository
public class DishMemRepo extends InMemoryBaseRepository<Dish> implements DishRepository {
}
