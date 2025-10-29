import java.util.*;

public interface BirdDemo extends Bird {
    public default int getMinimumFlyHeight() {
        System.out.println("Parent fly height is " + Bird.super.getMinimumFlyHeight());

        return 128;
    }
}