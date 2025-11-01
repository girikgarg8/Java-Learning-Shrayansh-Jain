import java.lang.annotation.Repeatable;
import java.util.*;

@Repeatable(Categories.class)
public @interface Category {
    String name();
}
