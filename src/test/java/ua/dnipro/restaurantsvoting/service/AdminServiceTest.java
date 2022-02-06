package ua.dnipro.restaurantsvoting.service;

import org.junit.Assert;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ua.dnipro.restaurantsvoting.model.Restaurant;

import java.util.Set;

import static org.junit.Assert.*;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDb.sql", config = @SqlConfig(encoding = "UTF-8"))
public class AdminServiceTest {

    @Autowired
    private AdminService adminService;

    @Test
    public void addANewRestaurant() {
        adminService.addANewRestaurant("NewRestaurant");
        Set<Restaurant> allRestaurants = adminService.getAllRestaurants();
        assertThat(allRestaurants.size()).isEqualTo(4);
    }

    @Test
    public void updateLunchMenu() {
    }

    @Test
    public void resetVotes() {
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