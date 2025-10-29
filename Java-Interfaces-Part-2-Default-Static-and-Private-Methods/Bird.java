import java.util.*;

public interface Bird {
    public void fly();

    default int getMinimumFlyHeight() {
        return 100;
    }

    public static void sayHello() {
        System.out.println("Saying hello from bird interface");
    }
};