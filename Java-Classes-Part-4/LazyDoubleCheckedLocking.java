import java.util.*;

public class LazyDoubleCheckedLocking {
  private static volatile LazyDoubleCheckedLocking instance;

  private LazyDoubleCheckedLocking () {

  }

  public static LazyDoubleCheckedLocking getInstance() {
      if (instance == null) {
          synchronized (LazyDoubleCheckedLocking.class) {
              if (instance == null) {
                  instance = new LazyDoubleCheckedLocking();
              }
          }
      }
      return instance;
  }
};