import java.util.*;
import java.util.concurrent.*;

public class MyDemo2 extends SuperClass.InnerClass1 {
    public MyDemo2() {
        new SuperClass().super();

//        This is essentially equivalent to the following:
//
//        SuperClass outerInstance = new SuperClass(); // Create outer instance
//        SuperClass.InnerClass1 inner = outerInstance.new InnerClass1(); // Inner instance bound to outer instance

        // hen you use new SuperClass().super() inside a constructor, this explicitly ties the superclass (InnerClass1) to a newly created enclosing SuperClass instance, fulfilling the requirement for a non-static inner class to be tied to an enclosing instance.
    }
}