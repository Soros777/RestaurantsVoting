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
import ua.dnipro.restaurantsvoting.model.Restaurant;

import java.util.Set;

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

        assertThat(adminService.resetVotes()).isEqualTo(true);

        adminService.getAllRestaurants().forEach(restaurant ->
                assertThat(restaurant.getVotes()).isEqualTo(0));
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