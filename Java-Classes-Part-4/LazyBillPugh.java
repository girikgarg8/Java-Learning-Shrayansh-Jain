import java.util.*;

public class LazyBillPugh {
  private LazyBillPugh() {

  }

  private static class LazyBillPughHelper {
      public static LazyBillPugh instance = new LazyBillPugh();
  }

  public static LazyBillPugh getInstance() {
      return LazyBillPughHelper.instance;
  }
};