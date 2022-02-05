package ua.dnipro.restaurantsvoting.util;

import org.springframework.context.ConfigurableApplicationContext;
import ua.dnipro.restaurantsvoting.model.*;
import ua.dnipro.restaurantsvoting.repository.UserRepository;
import ua.dnipro.restaurantsvoting.service.AdminService;
import ua.dnipro.restaurantsvoting.service.UserService;

import java.util.Set;

public class AppMain {
    private static AdminService adminService;
    private static UserService userService;
    private static UserRepository userRepository;

    public static void runApp(ConfigurableApplicationContext appCtx) {
        adminService = appCtx.getBean(AdminService.class);
        userService = appCtx.getBean(UserService.class);
        userRepository = appCtx.getBean(UserRepository.class);
        // Admin can input a restaurant and it's lunch menu of the day (2-5 items usually, just a dish name and price)
        // Menu changes each day (admins do the updates)
        adminAddThreeRestaurantsWIthMenus();

        userService.getAllLunchMenus().forEach(AppMain::displayLunch);
        System.out.println("===============================");
        User user1 = userRepository.save(new User(Role.USER));
        userService.doVote(user1, 100002);

    }

    private static void displayLunch(LunchMenu lunchMenu) {
        StringBuilder dishes = new StringBuilder();
        lunchMenu.getDishes().forEach(dish -> dishes.append(dish.getDishName() + " : " + dish.getPrice() + " : " + dish.getId() + "; "));
        StringBuilder result = new StringBuilder();
        result.append("LunchMenuId: " + lunchMenu.getId() + ", restaurant: " + lunchMenu.getRestaurant().getName() + " : " + lunchMenu.getRestaurant().getId() +
                ", dishes: " + dishes);
        System.out.println(result);
    }

    private static void adminAddThreeRestaurantsWIthMenus() {
        Restaurant restaurant1 = adminService.addANewRestaurant("Okolica"); // a restaurant (has id) without menu
        Restaurant restaurant2 = adminService.addANewRestaurant("Dubrava");
        Restaurant restaurant3 = adminService.addANewRestaurant("Shayba");

        Dish dish1 = adminService.addDish("Omar", 150);// a dish (has id), without lunch and restaurant links
        Dish dish2 = adminService.addDish("Omlet", 35);

        Dish dish3 = adminService.addDish("Biffshtex", 75);
        Dish dish4 = adminService.addDish("Olivie", 30);

        Dish dish5 = adminService.addDish("Borshch", 45);
        Dish dish6 = adminService.addDish("Porridge", 25);

        LunchMenu lunchMenu1 = adminService.addLunchMenu(Set.of(dish1, dish2));// a lunchMenu (has id), without restaurant link
        LunchMenu lunchMenu2 = adminService.addLunchMenu(Set.of(dish3, dish4));
        LunchMenu lunchMenu3 = adminService.addLunchMenu(Set.of(dish5, dish6));

        adminService.updateLunchMenu(restaurant1, lunchMenu1);
        adminService.updateLunchMenu(restaurant2, lunchMenu2);
        adminService.updateLunchMenu(restaurant3, lunchMenu3);




    }
}
