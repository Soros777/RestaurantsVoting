package ua.dnipro.restaurantsvoting.inMemory.repository;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.Restaurant;

@Repository
public class RestaurantMemRepo extends InMemoryBaseRepository<Restaurant> implements RestaurantRepository {
}
