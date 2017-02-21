import java.util.Arrays;
import java.util.List;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Main {

    private static final int MAX_BONUS = 4;
    private static final List<Integer> list = Arrays.asList(1, 2, 3);


    public static void main(String[] args) {

        List<List<Integer>> lists = Permute.permute(list);
//        System.out.println(lists);
        for (List<Integer> permuteList : lists) {
            int currentBonus = MAX_BONUS;
            for (int elem : permuteList) {
                currentBonus = currentBonus - elem;
                if (currentBonus <= 0) {
                    System.out.println(permuteList.toString() + "    " + currentBonus);
                }
            }
//            System.out.println(permuteList.toString() + "    " + currentBonus);
        }

    }

}
