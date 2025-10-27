import java.util.*;

class OuterClass {
    private int instanceVariable = 1;
    private static int classVariable = 10;

    public void display() {
        int methodLocalVariable = 11;

        class InnerClass {
            private int localVariable = 4;

            public void print() {
                System.out.println("instance variable: " + instanceVariable + " classVariable: " + classVariable + " methodLocalVariable: "+ methodLocalVariable + " localVariable: " + localVariable);
            }
        };

        InnerClass innerObj = new InnerClass();
        innerObj.print();
    }
};