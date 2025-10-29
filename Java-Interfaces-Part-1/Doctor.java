import java.util.*;

public class Doctor implements Human {
    @Override
    public void breathe() {
        System.out.println("Doctor is breathing");
    }

    @Override
    public void listen() {
        System.out.println("Doctor is listening");
    }

    @Override
    public void sayHello() {
        System.out.println("Doctor is saying hello");
    }
};