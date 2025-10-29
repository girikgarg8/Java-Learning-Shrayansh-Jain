import java.util.*;

public class Main {
    public static void main(String [] args) {
        Doctor doctor = new Doctor();

        doctor.breathe();
        doctor.listen();
        doctor.sayHello();

        Sample sample = new SampleImpl();
        sample.sayHello();
        sample.sayHi();

        Outer outer = new OuterImpl();
        outer.sayHi();

        Outer.Inner inner = new InnerImpl();
        inner.sayHello();
    }
}