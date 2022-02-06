package ua.dnipro.restaurantsvoting.inMemory.repository;

import ua.dnipro.restaurantsvoting.model.User;

public interface UserRepository {
    User save(User user);
}
