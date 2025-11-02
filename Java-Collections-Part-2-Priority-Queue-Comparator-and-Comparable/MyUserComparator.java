import java.util.*;

public class MyUserComparator implements Comparator <User> {
    @Override
    public int compare(User user1, User user2) {
        return user2.getName().compareTo(user1.getName());
    }
}