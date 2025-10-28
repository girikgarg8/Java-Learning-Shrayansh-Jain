import java.util.*;

public class LazySynchronized {
    private static LazySynchronized instance;

    private LazySynchronized() {

    }

    public synchronized static LazySynchronized getInstance() {
        if (instance == null) {
            instance = new LazySynchronized();
        }
        return instance;
    }

};