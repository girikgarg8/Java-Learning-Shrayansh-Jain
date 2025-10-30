import java.util.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class <Bird> birdClass = (Class <Bird>) Class.forName("Bird");

        Class <Bird> birdClass2 = Bird.class;

        Bird bird = new Bird();

        Class <Bird> birdClass3 = (Class <Bird>) bird.getClass();

        System.out.println(birdClass.getName());
        System.out.println(Modifier.toString(birdClass2.getModifiers()));

//        Method [] methods = birdClass.getMethods();
        Method [] methods = birdClass.getDeclaredMethods();

        for (Method method: methods) {
            System.out.println("Method name: " + method.getName());
            System.out.println("Return type: "+ method.getReturnType());
            System.out.println("Declaring class: " + method.getDeclaringClass());
            System.out.println("****");
        }

        // Invoking method using reflection
        Object eagleObject = birdClass.getDeclaredConstructor().newInstance();
        Method flyMethod = birdClass.getMethod("fly", int.class, boolean.class, String.class);

        flyMethod.invoke(eagleObject, 1, true, "hello");

        Field [] fields = birdClass.getFields();
        for (Field field: fields ) {
            System.out.println("Field Name: " + field.getName());
            System.out.println("Type :" + field.getType());
            System.out.println("Modifier: " + Modifier.toString(field.getModifiers()));
            System.out.println("***");
        }

        Bird birdObj = new Bird();
        Field field = birdClass.getDeclaredField("breed");
        field.set(birdObj, "abc");

        System.out.println("Value is " + birdObj.breed);

        Field canSwimField = birdClass.getDeclaredField("canSwim");
        canSwimField.setAccessible(true);
        canSwimField.set(birdObj, true);
        if (canSwimField.getBoolean(birdObj)) {
            System.out.println("Value of can swim is set to true");
        }

        Class eagleClass = Eagle.class;
        Constructor [] constructors = eagleClass.getDeclaredConstructors();

        for (Constructor constructor: constructors) {
            System.out.println("Modifier: "+ Modifier.toString(constructor.getModifiers()));
            constructor.setAccessible(true);
            Eagle eagleObj = (Eagle) constructor.newInstance();

            eagleObj.fly();
        }
    }
}
