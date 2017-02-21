import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Permute_sout {
    static void permute(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            System.out.println(Arrays.toString(arr.toArray()));
        }
    }

    static void permute(List<Integer> arr) {
        permute(arr, 0);
    }

    public static void main(String[] args) {
        permute(Arrays.asList(1, 2, 3));
    }
}
