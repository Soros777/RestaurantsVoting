package ua.dnipro.restaurantsvoting.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ua.dnipro.restaurantsvoting.TestDates;
import ua.dnipro.restaurantsvoting.model.Dish;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.model.Restaurant;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.dnipro.restaurantsvoting.TestDates.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDb.sql", config = @SqlConfig(encoding = "UTF-8"))
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Before
    public void resetTestModels() {
        TestDates.initDates();
    }

    @Test
    public void addANewRestaurant() {
        adminService.addANewRestaurant("NewRestaurant");
        Set<Restaurant> allRestaurants = adminService.getAllRestaurants();
        assertThat(allRestaurants.size()).isEqualTo(4);
    }

    @Test
    public void restaurantsDontHaveVotes() {
        Set<Restaurant> restaurants = adminService.getAllRestaurants();
        restaurants.forEach(restaurant -> assertThat(restaurant.getVotes()).isEqualTo(0));
    }

    @Test
    public void restaurantHas1Vote() {
        assertThat(adminService.doVote(RESTAURANT_1.getId(), ADMIN)).isEqualTo(true);
        assertThat(adminService.getRestaurant(RESTAURANT_1.getId()).getVotes()).isEqualTo(1);
    }

    @Test
    public void userCanNotVoteTwiceTheSameDayAfter11am() {
        assertThat(adminService.doVote(RESTAURANT_1.getId(), ADMIN)).isEqualTo(true);
        assertThat(adminService.getRestaurant(RESTAURANT_1.getId()).getVotes()).isEqualTo(1);
        assertThat(adminService.doVote(RESTAURANT_1.getId(), ADMIN)).isEqualTo(false);
        assertThat(adminService.getRestaurant(RESTAURANT_1.getId()).getVotes()).isEqualTo(1);
    }

    @Test
    public void updateLunchMenu() {
        Map<Integer, List<Dish>> testMatchMap = new HashMap<>();
        testMatchMap.put(RESTAURANT_1.getId(), List.of(DISH_1, DISH_2));
        testMatchMap.put(RESTAURANT_2.getId(), List.of(DISH_3, DISH_4));
        testMatchMap.put(RESTAURANT_3.getId(), List.of(DISH_5, DISH_6));
        adminService.getAllLunchMenus().forEach(lunchMenu ->
                DISH_MATCHER.assertMatch(lunchMenu.getDishes(), testMatchMap.get(lunchMenu.getRestaurant().getId())));
    }

    @Test
    public void compareTwoDishLists() {
        LunchMenu lunchMenu = adminService.getById(LUNCH_MENU_1.getId());
        DISH_MATCHER.assertMatch(lunchMenu.getDishes(), LUNCH_MENU_1.getDishes());
    }

    @Test
    public void compareInitialsLunchMenus() {List<LunchMenu> allLunchMenus = adminService.getAllLunchMenus();
        LUNCH_MENU_MATCHER.assertMatch(allLunchMenus, LUNCH_MENU_1, LUNCH_MENU_2, LUNCH_MENU_3);
    }

    @Test
    public void resetVotes() {
        adminService.doVote(RESTAURANT_1.getId(), ADMIN);
        adminService.doVote(RESTAURANT_1.getId(), USER_1);
        adminService.doVote(RESTAURANT_2.getId(), USER_2);
        adminService.doVote(RESTAURANT_3.getId(), USER_3);
        assertThat(adminService.getRestaurant(RESTAURANT_1.getId()).getVotes()).isEqualTo(2);
        assertThat(adminService.getRestaurant(RESTAURANT_2.getId()).getVotes()).isEqualTo(1);
        assertThat(adminService.getRestaurant(RESTAURANT_3.getId()).getVotes()).isEqualTo(1);
        adminService.getAllUsers().forEach(user ->
                assertThat(user.isVotedToday()).isTrue());

        assertThat(adminService.resetVotes()).isEqualTo(true);

        adminService.getAllRestaurants().forEach(restaurant ->
                assertThat(restaurant.getVotes()).isEqualTo(0));
        adminService.getAllUsers().forEach(user ->
                assertThat(user.isVotedToday()).isFalse());
    }

    @Test
    public void getRestaurant() {
        Restaurant restaurant = adminService.getRestaurant(100000);
        Assert.assertNotNull(restaurant);
    }

    @Test
    public void addLunchMenu() {
    }

    @Test
    public void addDish() {
    }
}