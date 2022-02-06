package ua.dnipro.restaurantsvoting.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import ua.dnipro.restaurantsvoting.util.InMemoryRepoUtil;

@ContextConfiguration("classpath:spring/spring-app.xml")
@RunWith(SpringRunner.class)
public class AdminServiceTest {

    @Autowired
    private AdminService service;

    @Autowired
    private InMemoryRepoUtil inMemoryRepoUtil;

    @Before
    public void setUp() {
        inMemoryRepoUtil.initRepositories();
    }

    @Test
    public void addANewRestaurant() {
        service.addANewRestaurant("Sambrera");
    }

    @Test
    public void updateLunchMenu() {
    }

    @Test
    public void resetVotes() {
    }

    @Test
    public void getRestaurant() {
    }

    @Test
    public void addLunchMenu() {
    }

    @Test
    public void addDish() {
    }
}