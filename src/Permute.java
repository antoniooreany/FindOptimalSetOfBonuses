import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Permute {

    private static List<List<Integer>> lists = new ArrayList<>();

    static List<List<Integer>> permute(List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            Collections.swap(arr, i, k);
            permute(arr, k + 1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            lists.add(new ArrayList<>(arr));
        }
        return lists;
    }

    static List<List<Integer>> permute(List<Integer> arr) {
        return permute(arr, 0);
    }

    public static void main(String[] args) {
        System.out.println(permute(Arrays.asList(1, 2, 3)));
    }
}