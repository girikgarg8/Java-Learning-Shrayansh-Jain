import java.util.*;

public class Sparrow implements BirdSub {
    @Override
    public int getMinimumFlyHeight() {
        return 60;
    }

    @Override
    public void fly() {
        System.out.println("Sparrow flying");
    }
};