package ua.dnipro.restaurantsvoting.inMemory.repository;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.LunchMenu;

@Repository
public class LunchMenuMemRepo extends InMemoryBaseRepository<LunchMenu> implements LunchMenuRepository {
}
