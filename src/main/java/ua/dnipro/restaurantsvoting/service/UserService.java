package ua.dnipro.restaurantsvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.model.Restaurant;
import ua.dnipro.restaurantsvoting.model.User;
import ua.dnipro.restaurantsvoting.repository.LunchMenuRepository;
import ua.dnipro.restaurantsvoting.repository.RestaurantRepository;
import ua.dnipro.restaurantsvoting.repository.UserRepository;
import ua.dnipro.restaurantsvoting.util.DateTimeUtil;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private LunchMenuRepository lunchMenuRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    //Users can vote on which restaurant they want to have lunch at

    // get lunchMenus of this day
    public Set<LunchMenu> getAllLunchMenus() {
        return new HashSet<>(lunchMenuRepository.getAll());
    }

    // vote for the restaurant with liked lunchMenu
    public void doVote(User user, int restaurantId) {
        if(user.isVotedToday() && !DateTimeUtil.isBefore11am()) {
            return;
        }
        Restaurant restaurant = restaurantRepository.get(restaurantId);
        restaurant.incrementVotes();
        restaurantRepository.save(restaurant);
        user.setVotedToday(true);
        userRepository.save(user);
    }

    /*
        Only one vote counted per user
        If user votes again the same day:
            - If it is before 11:00 we assume that he changed his mind.
            - If it is after 11:00 then it is too late, vote can't be changed
     */

}
