import java.util.*;

public class Main {
  public static void main(String [] args) {
      SingletonEager instance = SingletonEager.getInstance();

      LazyNonThreadSafe example = LazyNonThreadSafe.getInstance();

      LazySynchronized obj = LazySynchronized.getInstance();

      LazyDoubleCheckedLocking object = LazyDoubleCheckedLocking.getInstance();

      LazyBillPugh instance1 = LazyBillPugh.getInstance();

      DBConnection dbConnection = DBConnection.INSTANCE;
  }
};