package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

       NotificacionService notificacion = (NotificacionService) context.getBean(NotificacionService.class);

       UserService user= (UserService) context.getBean(UserService.class);

        System.out.println(user.notificacionService.saludo());
    }
}