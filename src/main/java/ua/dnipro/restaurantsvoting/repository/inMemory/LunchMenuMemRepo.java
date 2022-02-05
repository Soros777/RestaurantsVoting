package ua.dnipro.restaurantsvoting.repository.inMemory;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.repository.LunchMenuRepository;

@Repository
public class LunchMenuMemRepo extends InMemoryBaseRepository<LunchMenu> implements LunchMenuRepository {
}
