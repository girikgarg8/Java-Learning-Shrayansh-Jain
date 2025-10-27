import java.util.*;

public class Main {
    public static void main(String [] args) {
        ColorPrint cp = new ColorPrint();

        cp.setValue("Hello");
        System.out.println("Value is "+ cp.getValue());

        Print <String> bp = new BlackPrint<>();
        bp.setValue("Hi");
        System.out.println("Value is "+ bp.getValue());

        // Internally, it passed Object as parametrized type
        Print rawTypePrintObject = new BlackPrint<>();
        rawTypePrintObject.setValue("1");
        rawTypePrintObject.setValue(1L);

        Pair <String, Integer> pair = new Pair<>("Hello", 4);
        System.out.println("Key: " + pair.getKey() + " Value: " + pair.getValue());

        Color.print("Hello");
        Color.print(1L);

        Calculator <Integer> calculator = new Calculator<>();
        System.out.println(calculator.identity(1));

        Generic <A> generic = new Generic<>();
        generic.fun();

        Vehicle car = new Car();
        Vehicle bus = new Bus();

        List <Bus> busList = new ArrayList<>();
        List <Car> carList = new ArrayList<>();

        PrintExample.setPrintValues(List.of(car,bus));
        PrintExample.display(List.of(new Object()));

        PrintExample.print(busList, busList);
        // PrintExample.print(busList, carList); WILL THROW ERROR

        PrintExample.fun(busList, carList);
    }
}