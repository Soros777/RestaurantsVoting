package ua.dnipro.restaurantsvoting.inMemory.repository;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.User;

@Repository
public class UserMemRepo extends InMemoryBaseRepository<User> implements UserRepository {
}
