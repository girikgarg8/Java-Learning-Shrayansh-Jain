import java.util.*;

public class ErrorDemo {
    public static void main(String [] args) {
        // Will result in an Out of Memory "Error" (not Exception)
        String [][] matrix = new String[2000000000][2000000000];

    }
}
