import java.util.*;

public interface Demo extends Bird {
  public void canFly();

  public default void minimumFlyingHeight() {
        myStaticPublicMethod();
        myPrivateMethod();
        myPrivateStaticMethod();
  }

  public static void myStaticPublicMethod() {

  }

  private void myPrivateMethod() {

  }

  private static void myPrivateStaticMethod() {

  }
};