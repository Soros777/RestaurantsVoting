package ua.dnipro.restaurantsvoting.util;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring/spring-app.xml");
//        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        AppMain.runApp(appCtx);

        appCtx.close();
    }
}
