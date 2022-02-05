package ua.dnipro.restaurantsvoting.repository.inMemory;

import org.springframework.stereotype.Repository;
import ua.dnipro.restaurantsvoting.model.User;
import ua.dnipro.restaurantsvoting.repository.UserRepository;

@Repository
public class UserMemRepo extends InMemoryBaseRepository<User> implements UserRepository {
}
