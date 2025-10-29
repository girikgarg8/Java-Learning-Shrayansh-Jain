import java.util.*;

public interface LivingOrganism {
    default int getMinimumFlyHeight() {
        return 50;
    }
};