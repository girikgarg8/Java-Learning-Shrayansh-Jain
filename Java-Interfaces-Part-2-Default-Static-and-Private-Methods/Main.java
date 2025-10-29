import java.util.*;

public class Main {
  public static void main(String [] args) {
      Bird bird = new Eagle();
      bird.fly();
      System.out.println(bird.getMinimumFlyHeight());
      Bird.sayHello();

      BirdChild swan = new Swan();
      System.out.println(swan.getMinimumFlyHeight());

      BirdSub sparrow = new Sparrow();
      sparrow.fly();
      System.out.println(sparrow.getMinimumFlyHeight());

      BirdDemoImpl birdDemo = new BirdDemoImpl();
      System.out.println(birdDemo.getMinimumFlyHeight());
  }
};