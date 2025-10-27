import java.util.*;

public class Generic  <T extends ParentClass & Interface1 & Interface2> {
    public void fun() {
        System.out.println("Generic method executing");
    }
};