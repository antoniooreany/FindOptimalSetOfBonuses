import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Test {
    public static void main(String[] args) {
        List<List<Integer>> lists = new ArrayList<>();

        List<Integer> integers0 = Arrays.asList(1, 2, 3);
        List<Integer> integers1 = Arrays.asList(4, 5, 6);
        List<Integer> integers2 = Arrays.asList(7, 8, 9);

        boolean add0 = lists.add(integers0);
        boolean add1 = lists.add(integers1);
        boolean add2 = lists.add(integers2);

        System.out.println(lists);

    }
}
