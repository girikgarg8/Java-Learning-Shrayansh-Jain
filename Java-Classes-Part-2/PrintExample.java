import java.util.*;

public class PrintExample {
  public static void setPrintValues(List <? extends Vehicle> list) {
      System.out.println("Printing values");
  }

  public static void display(List <? super Vehicle> list) {
      System.out.println("Displaying values");
  }

  public static <T extends Vehicle> void print(List <T> source, List <T> dest) {
        System.out.println("Executing print");
  }

  public static void fun(List <? extends Vehicle> source, List <? extends Vehicle> destination ) {
      System.out.println("Executing fun");
  }

};