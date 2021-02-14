package controller;

import model.utils.Direction;
import static model.utils.Direction.*;
import java.util.Map;

//class made for easier remapping buttons
public class KeyBindings {
    public final static String USE_TELEPORT = "t";
    public final static String USE_TELEPORT_NUMERICAL = "5";
    public final static String USE_BOMB = "b";
    public final static String USE_RESET = "r";
    public final static String USE_REWIND = "h";

    private static final Map<String, Direction> moveControls = Map.of(
            "1", SOUTHWEST,
            "2", SOUTH,
            "3", SOUTHEAST,
            "4", WEST,
            "6", EAST,
            "7", NORTHWEST,
            "8", NORTH,
            "9", NORTHEAST
    );

    public static boolean isResetKey(String key) {
        return USE_RESET.equals(key);
    }
    public static boolean isMovementKey(String key) {
        return moveControls.containsKey(key);
    }

    public static Direction keyToDirection(String key) {
        if(!isMovementKey(key)) throw new IllegalArgumentException("This button isn't mapped to movement direction");
        return moveControls.get(key);
    }
}
