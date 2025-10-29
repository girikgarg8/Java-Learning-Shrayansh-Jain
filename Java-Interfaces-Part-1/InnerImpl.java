import java.util.*;

public class InnerImpl implements Outer.Inner {
    @Override
    public void sayHello() {
        System.out.println("Saying hello");
    }
};