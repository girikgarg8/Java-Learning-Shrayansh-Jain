import java.util.*;

public class Main {
    public static void main(String [] args) {

        new Parent().childPrint();
        Outer outer = new Outer();

        Outer.Inner innerObj = outer.new Inner();
        innerObj.print();

        OuterClass outerObj = new OuterClass();
        outerObj.display();

        SuperClass superClassObj = new SuperClass();
        SuperClass.InnerClass2 innerClassObj = superClassObj.new InnerClass2();
        innerClassObj.print();

        MyDemo myDemo = new MyDemo();
        MyDemo2 myDemo2 = new MyDemo2();

        Vehicle vehicle = new Vehicle() {
            @Override
            public void drive() {
                System.out.println("Hello, I am driving");
            }
        };

        vehicle.drive();

    }
}