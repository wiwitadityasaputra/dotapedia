package wiwitaditya.demo.dotapedia.controller;

public class LookupUtil {

    public static <E extends Enum<E>> E lookup(Class<E> e, String id) {
        if (id == null) {
            return null;
        }
        try {
            return Enum.valueOf(e, id);
        } catch (Exception ex) {
            // log error or something here
            return null;
        }
    }
}
