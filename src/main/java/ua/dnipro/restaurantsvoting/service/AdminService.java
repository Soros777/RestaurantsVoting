package ua.dnipro.restaurantsvoting.service;

import org.springframework.stereotype.Service;
import ua.dnipro.restaurantsvoting.model.Dish;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.model.Restaurant;
import ua.dnipro.restaurantsvoting.repository.DishRepository;
import ua.dnipro.restaurantsvoting.repository.LunchMenuRepository;
import ua.dnipro.restaurantsvoting.repository.RestaurantRepository;
import ua.dnipro.restaurantsvoting.repository.inMemory.DishMemRepo;
import ua.dnipro.restaurantsvoting.repository.inMemory.LunchMenuMemRepo;
import ua.dnipro.restaurantsvoting.repository.inMemory.RestaurantMemRepo;

import java.util.Set;

@Service
public class AdminService {
    private RestaurantRepository restaurantRepository = new RestaurantMemRepo();
    private DishRepository dishRepository = new DishMemRepo();
    private LunchMenuRepository menuRepository = new LunchMenuMemRepo();

    // Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
    // Menu changes each day (admins do the updates)

    //addANewRestaurant (without menu)
    public Restaurant addANewRestaurant(String restaurantName) {
        return restaurantRepository.save(new Restaurant(restaurantName));
    }

    //updateLunchMenu (for exist restaurant)
    public boolean updateLunchMenu(Restaurant restaurant, LunchMenu lunchMenu) {
        restaurant.setLunchMenu(lunchMenu);
        lunchMenu.setRestaurant(restaurant);
        return true;
    }

    //add lunchMenu(without restaurant link)
    public LunchMenu addLunchMenu(Set<Dish> dishSet) {
        return menuRepository.save(new LunchMenu(dishSet));
    }

    public Dish addDish(String dishName, int price) {
        return dishRepository.save(new Dish(dishName, price));
    }
}
