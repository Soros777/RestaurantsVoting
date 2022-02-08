package ua.dnipro.restaurantsvoting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.dnipro.restaurantsvoting.model.LunchMenu;
import ua.dnipro.restaurantsvoting.model.User;
import ua.dnipro.restaurantsvoting.repository.UserRepository;
import ua.dnipro.restaurantsvoting.util.DateTimeUtil;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<LunchMenu> getAllLunchMenus() {
        return userRepository.getAllLunchMenus();
    }

    public boolean doVote(User user, int restaurantId) {
        if(user.isVotedToday() && !DateTimeUtil.isBefore11am()) {
            return false;
        }
        return userRepository.doVote(restaurantId, user);
    }
}
