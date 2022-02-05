package ua.dnipro.restaurantsvoting.util;

import ua.dnipro.restaurantsvoting.model.Dish;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.model.Restaurant;
import ua.dnipro.restaurantsvoting.service.AdminService;
import ua.dnipro.restaurantsvoting.service.UserService;

import java.util.Set;

public class AppMain {
    private static AdminService adminService = new AdminService();
    private static UserService userService = new UserService();

    public static void main(String[] args) {
        // Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
        // Menu changes each day (admins do the updates)
        Restaurant restaurant1 = adminService.addANewRestaurant("Okolica"); // a restaurant (has id) without menu
        Restaurant restaurant2 = adminService.addANewRestaurant("Dubrava");
        Restaurant restaurant3 = adminService.addANewRestaurant("Shayba");

        Dish dish1 = adminService.addDish("Omar", 150);// a dish (has id), without lunch and restaurant links
        Dish dish2 = adminService.addDish("Omlet", 35);

        LunchMenu lunchMenu1 = adminService.addLunchMenu(Set.of(dish1, dish2));// a lunchMenu (has id), without restaurant link

        adminService.updateLunchMenu(restaurant1, lunchMenu1);

        // here we have to have restaurant, lunchMenu and dishes - all in repository, with id
        // and user can see those all
        System.out.println(restaurant1);
//        System.out.println(lunchMenu1);

    }
}
