package ua.dnipro.restaurantsvoting;

import ua.dnipro.restaurantsvoting.model.*;

import java.util.List;
import java.util.Set;

public class TestDates {
    public static final MatcherFactory.Matcher<Dish> DISH_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();
    public static final MatcherFactory.Matcher<LunchMenu> LUNCH_MENU_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();
    public static final MatcherFactory.Matcher<Restaurant> RESTAURANT_MATCHER = MatcherFactory.usingIgnoringFieldsComparator();

    public static Dish DISH_1;
    public static Dish DISH_2;
    public static Dish DISH_3;
    public static Dish DISH_4;
    public static Dish DISH_5;
    public static Dish DISH_6;
    public static Dish DISH_7;
    public static Dish DISH_8;
    public static Dish DISH_9;

    public static Dish NEW_DISH_1;// new dishes are without id-s and lunchMenus links
    public static Dish NEW_DISH_2;
    public static Dish NEW_DISH_3;
    public static Dish NEW_DISH_4;
    public static Dish NEW_DISH_5;

    public static Dish UPDATED_NEW_DISH_1;//with id, lunchMenu etc
    public static Dish UPDATED_NEW_DISH_2;
    public static Dish UPDATED_NEW_DISH_3;

    public static Dish UPDATED_DISH_1;
    public static Dish UPDATED_DISH_2;

    public static Restaurant RESTAURANT_1;
    public static Restaurant RESTAURANT_2;
    public static Restaurant RESTAURANT_3;
    public static Restaurant RESTAURANT_4;

    public static LunchMenu LUNCH_MENU_1;
    public static LunchMenu LUNCH_MENU_2;
    public static LunchMenu LUNCH_MENU_3;
    public static LunchMenu LUNCH_MENU_4;

    public static LunchMenu UPDATED_LUNCH_MENU_MORE_DISHES;
    public static LunchMenu UPDATED_LUNCH_MENU_LESS_DISHES;

    public static User ADMIN;
    public static User USER_1;
    public static User USER_2;
    public static User USER_3;

    static {
        initDates();
    }

    public static void initDates() {
        RESTAURANT_1 = new Restaurant("Okolica");
        RESTAURANT_2 = new Restaurant("Dubrava");
        RESTAURANT_3 = new Restaurant("Shaiba");
        RESTAURANT_4 = new Restaurant("New restaurant");
        RESTAURANT_1.setId(100000);
        RESTAURANT_2.setId(100001);
        RESTAURANT_3.setId(100002);
        RESTAURANT_4.setId(100020);

        DISH_1 = new Dish(100006, "Omars", 150);
        DISH_2 = new Dish(100007, "Omlet", 35);
        DISH_3 = new Dish(100008, "Biffshtex", 75);
        DISH_4 = new Dish(100009, "Olivie", 30);
        DISH_5 = new Dish(100010, "Borshch", 45);
        DISH_6 = new Dish(100011, "Porridge", 25);
        DISH_7 = new Dish(100017, "New dish 7", 73);
        DISH_8 = new Dish(100018, "New dish 8", 37);
        DISH_9 = new Dish(100012, "Third dish", 77);


        NEW_DISH_1 = new Dish("New dish 1", 33);// new dishes are without id-s and lunchMenus links
        NEW_DISH_2 = new Dish("New dish 2", 44);
        NEW_DISH_3 = new Dish("New dish 3", 55);
        NEW_DISH_4 = new Dish("Test updated first dish", 73);
        NEW_DISH_5 = new Dish("Test updated second dish", 37);

        LUNCH_MENU_1 = new LunchMenu(100003, RESTAURANT_1, List.of(DISH_1, DISH_2));
        LUNCH_MENU_2 = new LunchMenu(100004, RESTAURANT_2, List.of(DISH_3, DISH_4));
        LUNCH_MENU_3 = new LunchMenu(100005, RESTAURANT_3, List.of(DISH_5, DISH_6, DISH_9));
        LUNCH_MENU_4 = new LunchMenu(100019, RESTAURANT_4, List.of(DISH_7, DISH_8));

        DISH_1.setLunchMenu(LUNCH_MENU_1);
        DISH_2.setLunchMenu(LUNCH_MENU_1);
        DISH_3.setLunchMenu(LUNCH_MENU_2);
        DISH_4.setLunchMenu(LUNCH_MENU_2);
        DISH_5.setLunchMenu(LUNCH_MENU_3);
        DISH_6.setLunchMenu(LUNCH_MENU_3);
        DISH_9.setLunchMenu(LUNCH_MENU_3);

        UPDATED_NEW_DISH_1 = new Dish(100008, "New dish 1", 33, LUNCH_MENU_2);
        UPDATED_NEW_DISH_2 = new Dish(100009, "New dish 2", 44, LUNCH_MENU_2);
        UPDATED_NEW_DISH_3 = new Dish(100017, "New dish 3", 55, LUNCH_MENU_2);

        UPDATED_DISH_1 = new Dish(DISH_5.getId(), "Test updated first dish", 73, DISH_5.getLunchMenu());
        UPDATED_DISH_2 = new Dish(DISH_6.getId(), "Test updated second dish", 37, DISH_6.getLunchMenu());

        UPDATED_LUNCH_MENU_MORE_DISHES = new LunchMenu(
                LUNCH_MENU_2.getId(),
                LUNCH_MENU_2.getRestaurant(),
                List.of(UPDATED_NEW_DISH_1, UPDATED_NEW_DISH_2, UPDATED_NEW_DISH_3));

        UPDATED_LUNCH_MENU_LESS_DISHES = new LunchMenu(
                LUNCH_MENU_3.getId(),
                LUNCH_MENU_3.getRestaurant(),
                List.of(UPDATED_DISH_1, UPDATED_DISH_2)
        );

        ADMIN = new User(100013, Set.of(Role.ADMIN));
        USER_1 = new User(100014, Set.of(Role.USER));
        USER_2 = new User(100015, Set.of(Role.USER));
        USER_3 = new User(100016, Set.of(Role.USER));

        RESTAURANT_1.setLunchMenu(LUNCH_MENU_1);
        RESTAURANT_2.setLunchMenu(LUNCH_MENU_2);
        RESTAURANT_3.setLunchMenu(LUNCH_MENU_3);
        RESTAURANT_4.setLunchMenu(LUNCH_MENU_4);
    }
}
