package ua.dnipro.restaurantsvoting.repository;

import ua.dnipro.restaurantsvoting.model.LunchMenu;

import java.util.Collection;

public interface LunchMenuRepository {

    LunchMenu save(LunchMenu menu);

    boolean delete(int id);

    LunchMenu get(int id);

    Collection<LunchMenu> getAll();
}
