package util;

import java.util.Arrays;

/**
 * Created by ivar on 29.10.2015.
 */
public class ArrayUtil {
    public static <T> String prettyJoin(T[] a) {
        StringBuilder s = new StringBuilder();
        int l = a.length;
        for(int i = 0; i < l-2; i++) s.append(a[i] + ", ");
        if(l > 1) s.append(a[l-2] + " og ");
        if(l != 0) s.append(a[l-1]);
        return s.toString();
    }
}
