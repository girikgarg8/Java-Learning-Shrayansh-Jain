import java.lang.annotation.*;
import java.util.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyCustomAnnotation {
    String name() default "hello";
};
