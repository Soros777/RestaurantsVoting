package ua.dnipro.restaurantsvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dnipro.restaurantsvoting.model.Dish;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.model.Restaurant;
import ua.dnipro.restaurantsvoting.model.User;
import ua.dnipro.restaurantsvoting.repository.AdminRepository;
import ua.dnipro.restaurantsvoting.repository.UserRepository;
import ua.dnipro.restaurantsvoting.util.DateTimeUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {
    // Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
    // Menu changes each day (admins do the updates)

    private final AdminRepository adminRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository, UserRepository userRepository) {
        this.adminRepository = adminRepository;
        this.userRepository = userRepository;
    }

    public Restaurant addANewRestaurant(String restaurantName, Dish ... dishes) {
        LunchMenu lunchMenu = createLunchMenu(Arrays.asList(dishes));
        Restaurant restaurant = new Restaurant(restaurantName, lunchMenu);
        lunchMenu.setRestaurant(restaurant);
        return adminRepository.saveEntity(restaurant);
    }

    private LunchMenu createLunchMenu(List<Dish> dishes) {
        dishes.forEach(adminRepository::saveEntity);
        LunchMenu lunchMenu = new LunchMenu(dishes);
        return adminRepository.saveEntity(lunchMenu);
    }

    public boolean updateLunchMenu(Restaurant restaurant, Dish ... dishes) {
        LunchMenu newLunchMenu = updateLunchMenu(dishes, restaurant);
        restaurant.setLunchMenu(newLunchMenu);
        return adminRepository.saveEntity(restaurant) != null;
    }

    private LunchMenu updateLunchMenu(Dish[] dishes, Restaurant restaurant) {
        LunchMenu oldLunchMenu = restaurant.getLunchMenu();
        List<Dish> oldDishes = oldLunchMenu.getDishes();
        List<Dish> newDishes = updateDishes(oldDishes, Arrays.asList(dishes));
        oldLunchMenu.setDishes(newDishes);
        LunchMenu newLunchMenu = adminRepository.saveEntity(oldLunchMenu);
        return newLunchMenu;
    }

    private List<Dish> updateDishes(List<Dish> oldDishes, List<Dish> newDishes) {
        for (int i = 0; i < oldDishes.size(); i++) {
            if(newDishes.size() <= i) {
                adminRepository.deleteDish(oldDishes.get(i).getId());
                continue;
            }
            Dish oldDish = oldDishes.get(i);
            Dish newDish = newDishes.get(i);
            newDish.setId(oldDish.getId());
            newDish.setLunchMenu(oldDish.getLunchMenu());
            adminRepository.saveEntity(newDish);
        }
        if(newDishes.size() > oldDishes.size()) {
            LunchMenu lunchMenu = oldDishes.get(0).getLunchMenu();
            for (int i = oldDishes.size(); i < newDishes.size(); i++) {
                Dish newDish = newDishes.get(i);
                newDish.setLunchMenu(lunchMenu);
                adminRepository.saveEntity(newDish);
            }
        }
        return newDishes;
    }

    public List<LunchMenu> getAllLunchMenus() {
        return adminRepository.getAllLunchMenus();
    }

    // once a day admin reset not actual votes
    public boolean resetVotes() {
        return adminRepository.resetAllVotes();
    }

    public Restaurant getRestaurant(int id) {
        return adminRepository.getRestaurantById(id);
    }

    public Set<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = adminRepository.getAllRestaurants();
        return new HashSet<>(restaurants);
    }

    public boolean doVote(int restaurantId, User user) {
        if(user.isVotedToday() && !DateTimeUtil.isBefore11am()) {
            return false;
        }
        return userRepository.doVote(restaurantId, user);
    }

    public List<User> getAllUsers() {
        return adminRepository.getAllUsers();
    }

    public LunchMenu getById(int id) {
        return adminRepository.getById(id);
    }
}
