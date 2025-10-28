import java.util.*;

final class ImmutableClass {
    private final String name;
    private final List <String> phones;

    MyImmutableClass(String name, List<String> phones) {
        this.name = name;
        this.phones = phones;
    }

    public static getPhones() {
        return new ArrayList<>(phones); // returning a copy
    }

};