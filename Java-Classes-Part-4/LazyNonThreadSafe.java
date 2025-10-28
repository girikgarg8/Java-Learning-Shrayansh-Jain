import java.util.*;

public class LazyNonThreadSafe {
  private static LazyNonThreadSafe instance;

  private LazyNonThreadSafe() {

  }

  public static LazyNonThreadSafe getInstance() {
      if (instance == null) {
          instance = new LazyNonThreadSafe();
      }
      return instance;
  }

};