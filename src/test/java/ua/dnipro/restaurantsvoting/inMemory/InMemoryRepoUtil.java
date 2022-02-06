package ua.dnipro.restaurantsvoting.inMemory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.dnipro.restaurantsvoting.inMemory.repository.DishRepository;
import ua.dnipro.restaurantsvoting.inMemory.repository.LunchMenuRepository;
import ua.dnipro.restaurantsvoting.inMemory.repository.RestaurantRepository;
import ua.dnipro.restaurantsvoting.inMemory.repository.UserRepository;
import ua.dnipro.restaurantsvoting.model.*;

import java.util.Set;

@Component
public class InMemoryRepoUtil {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private LunchMenuRepository lunchMenuRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    public void initRepositories() {
        Dish dish1 = dishRepository.save(new Dish("Pizza", 15));
        Dish dish2 = dishRepository.save(new Dish("Omlet", 25));
        Dish dish3 = dishRepository.save(new Dish("Olivie", 35));
        Dish dish4 = dishRepository.save(new Dish("Borshch", 40));
        Dish dish5 = dishRepository.save(new Dish("Omar", 45));
        Dish dish6 = dishRepository.save(new Dish("Porridge", 12));

        LunchMenu lunchMenu1 = lunchMenuRepository.save(new LunchMenu(Set.of(dish1, dish2)));
        LunchMenu lunchMenu2 = lunchMenuRepository.save(new LunchMenu(Set.of(dish3, dish4)));
        LunchMenu lunchMenu3 = lunchMenuRepository.save(new LunchMenu(Set.of(dish5, dish6)));

        Restaurant restaurant1 = restaurantRepository.save(new Restaurant("Dubrava"));
        Restaurant restaurant2 = restaurantRepository.save(new Restaurant("Okolica"));
        Restaurant restaurant3 = restaurantRepository.save(new Restaurant("Shaiba"));

        lunchMenu1.setRestaurant(restaurant1);
        restaurant1.setLunchMenu(lunchMenu1);

        lunchMenu2.setRestaurant(restaurant2);
        restaurant2.setLunchMenu(lunchMenu2);

        lunchMenu3.setRestaurant(restaurant3);
        restaurant3.setLunchMenu(lunchMenu3);

        userRepository.save(new User(Role.ADMIN));
        userRepository.save(new User(Role.USER));
        userRepository.save(new User(Role.USER));
        userRepository.save(new User(Role.USER));
    }
}
