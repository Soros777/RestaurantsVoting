package ua.dnipro.restaurantsvoting.repository.inMemory;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.Restaurant;
import ua.dnipro.restaurantsvoting.repository.RestaurantRepository;

@Repository
public class RestaurantMemRepo extends InMemoryBaseRepository<Restaurant> implements RestaurantRepository {
}
