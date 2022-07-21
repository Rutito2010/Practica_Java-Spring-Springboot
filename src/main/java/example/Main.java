package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("beans.xml");

        Saludo imprimir = (Saludo) context.getBean("saludo");

        System.out.println( imprimir.imprimirSaludo());
    }
}