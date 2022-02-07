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

    //addANewRestaurant (without menu)
    public Restaurant addANewRestaurant(String restaurantName) {
        return adminRepository.saveEntity(new Restaurant(restaurantName));
    }

    //updateLunchMenu (for exist restaurant)
    public boolean updateLunchMenu(Restaurant restaurant, LunchMenu lunchMenu) {
        restaurant.setLunchMenu(lunchMenu);
        lunchMenu.setRestaurant(restaurant);
        return adminRepository.saveEntity(restaurant) != null && adminRepository.saveEntity(lunchMenu) != null;
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

    //add lunchMenu(without restaurant link)
    public LunchMenu addLunchMenu(List<Dish> dishSet) {
        return null;
    }

    public Dish addDish(String dishName, int price) {
        return null;
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
