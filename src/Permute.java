import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Permute {

    private static List<Integer[]> lists = new ArrayList<>();

    static List<Integer[]> permute(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
//            System.out.println(Arrays.toString(arr.toArray()));

            Integer[] integers = (Integer[]) arr.toArray();
            lists.add(integers);
        }
        return lists;
    }

    static List<Integer[]> permute(List<Integer> arr) {
        return permute(arr, 0);
    }

    public static void main(String[] args) {
        List<Integer[]> listIntegers = permute(Arrays.asList(1, 2, 3));
        for (Integer[] integers : listIntegers) {
            System.out.println(Arrays.deepToString(integers));
        }
    }
}
