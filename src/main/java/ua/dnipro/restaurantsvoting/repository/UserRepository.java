package ua.dnipro.restaurantsvoting.repository;

import ua.dnipro.restaurantsvoting.model.User;

public interface UserRepository {
    User save(User user);
}
