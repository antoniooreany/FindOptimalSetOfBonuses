import java.util.Arrays;
import java.util.List;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Main {

    private static final int MAX_BONUS = 4;
    private static final List<Integer> LIST_INTEGERS = Arrays.asList(1, 2, 3);
    private static int listIndex;
    private static int elemIndex;

    public static void main(String[] args) {

        List<Integer[]> lists = Permute.permute(LIST_INTEGERS);
        for (Integer[] permuteList : lists) {
            int currentBonus = MAX_BONUS;
            for (Integer elem : permuteList) {
                currentBonus = currentBonus - elem;
                if (currentBonus < 0) {
                    System.out.println(/*permuteList.toString() + */Arrays.deepToString(permuteList) + "    " + currentBonus);
                }
            }
        }
    }
}
