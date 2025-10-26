public enum EnumSample implements MyInterface {

    MONDAY("Hello, I am Monday") {
        @Override
        public void greet() {
            System.out.println("Hi");
        }
    },
    TUESDAY("Hello, I am Tuesday") {
        @Override
        public void greet() {
            System.out.println("Hi");
        }
    },
    WEDNESDAY("Hello, I am Wednesday") {
        @Override
        public void greet() {
            System.out.println("Hi");
        }
    },
    THURSDAY("Hello, I am Thursday") {
        @Override
        public void greet() {
            System.out.println("Hi");
        }
    },
    FRIDAY("Hello, I am Friday") {
        @Override
        public void dummyMethod() {
            System.out.println("Friday's dummy method");
        }

        @Override
        public void greet() {
            System.out.println("Hurray, it's Friday");
        }
    },
    SATURDAY("Hello, I am Saturday") {
        @Override
        public void greet() {
            System.out.println("Hi");
        }
    },
    SUNDAY("Hello, I am Sunday") {
        @Override
        public void greet() {
            System.out.println("Hi");
        }
    };

    private String comment;

    private EnumSample(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public static EnumSample getByComment(String comment) {
        for (EnumSample enumSample: EnumSample.values()) {
            if (enumSample.comment.equals(comment)) return enumSample;
        }
        return null;
    }

    public void dummyMethod() {
        System.out.println("Default dummy method");
    }

    public abstract void greet();

    @Override
    public String toLowerCase() {
        return this.name().toLowerCase();
    }
};