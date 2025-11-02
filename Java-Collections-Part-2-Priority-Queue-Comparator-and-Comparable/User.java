import java.util.*;

public class User implements Comparable <User> {
  private final Integer id;
  private final String name;

  public User(final Integer id, final String name) {
      this.id = id;
      this.name = name;
  }

  public Integer getId() {
      return id;
  }

  public String getName() {
      return name;
  }

  @Override
  public String toString() {
      return "Id: " + id + " Name: " + name;
  }

  @Override
  public int compareTo(User user2) {
      return this.id - user2.id;
  }

};