import java.util.*;

public class Eagle implements Bird, LivingOrganism {
    @Override
    public void fly() {
        System.out.println("Eagle flying");
    }

    @Override
    public int getMinimumFlyHeight() {
        return 70;
    }

    // we cannot override a static method from an interface, the below function without @Override annotation is tereated as a new function
    public static void sayHello() {
        System.out.println("Saying hello from eagle class");
    }
}