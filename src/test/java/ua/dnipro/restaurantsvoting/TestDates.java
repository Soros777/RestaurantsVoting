package ua.dnipro.restaurantsvoting;

import ua.dnipro.restaurantsvoting.model.*;

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

    public static Restaurant RESTAURANT_1;
    public static Restaurant RESTAURANT_2;
    public static Restaurant RESTAURANT_3;

    public static LunchMenu LUNCH_MENU_1;
    public static LunchMenu LUNCH_MENU_2;
    public static LunchMenu LUNCH_MENU_3;

    public static User ADMIN;
    public static User USER_1;
    public static User USER_2;
    public static User USER_3;

    static {
        initDates();
    }

    public static void initDates() {
        DISH_1 = new Dish(100003, "Omars", 150);
        DISH_2 = new Dish(100004, "Omlet", 35);
        DISH_3 = new Dish(100005, "Biffshtex", 75);
        DISH_4 = new Dish(100006, "Olivie", 30);
        DISH_5 = new Dish(100007, "Borshch", 45);
        DISH_6 = new Dish(100008, "Porridge", 25);

        RESTAURANT_1 = new Restaurant("Okolica");
        RESTAURANT_2 = new Restaurant("Dubrava");
        RESTAURANT_3 = new Restaurant("Shaiba");

        LUNCH_MENU_1 = new LunchMenu(100009, RESTAURANT_1, Set.of(DISH_1, DISH_2));
        LUNCH_MENU_2 = new LunchMenu(100010, RESTAURANT_2, Set.of(DISH_3, DISH_4));
        LUNCH_MENU_3 = new LunchMenu(100011, RESTAURANT_3, Set.of(DISH_5, DISH_6));

        ADMIN = new User(100012, Set.of(Role.ADMIN));
        USER_1 = new User(100013, Set.of(Role.USER));
        USER_2 = new User(100014, Set.of(Role.USER));
        USER_3 = new User(100015, Set.of(Role.USER));

        RESTAURANT_1.setId(100000);
        RESTAURANT_2.setId(100001);
        RESTAURANT_3.setId(100002);

        RESTAURANT_1.setLunchMenu(LUNCH_MENU_1);
        RESTAURANT_2.setLunchMenu(LUNCH_MENU_2);
        RESTAURANT_3.setLunchMenu(LUNCH_MENU_3);
    }
}
