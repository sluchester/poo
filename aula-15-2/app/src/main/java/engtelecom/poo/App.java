/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package engtelecom.poo;

import java.util.ArrayList;

public class App {
    private Carro carro;

    public static void main(String[] args) {
        Motor motorMustang = new Motor(100, 4, 200);
        Motor motor2 = new Motor(200, 6, 300);
        Carro mustang = new Carro("mustang","Ford", motor2);

        System.out.println(mustang);
    }
}
