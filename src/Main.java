import java.util.Arrays;
import java.util.List;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Main {

    private static final int INITIAL_BONUS = 4;
    private static final List<Integer> INITIAL_LIST = Arrays.asList(1, 2, 3);

    private static Integer[] minCurrentArray;
    private static int minPreviousBonus;
    private static int minCurrentBonus = INITIAL_BONUS;
    private static int minArrayIndex;
    private static int minElemIndex;
    private static List<List<Integer>> bestArrays;

    public static void main(String[] args) {

        List<Integer[]> arrays = Permute.permute(INITIAL_LIST);
        int arrayIndex = 0;
        for (Integer[] currentArray : arrays) {
            int currentBonus = INITIAL_BONUS;
            int elemIndex = 0;
            for (Integer elem : currentArray) {
                int previousBonus = currentBonus;
                currentBonus = currentBonus - elem;
                if (previousBonus >= 0 && currentBonus < 0) {
                    System.out.println("INITIAL_BONUS = " + INITIAL_BONUS
                            + "     currentArray = " + Arrays.deepToString(currentArray)
                            + "     previousBonus = " + previousBonus
                            + "     currentBonus = " + currentBonus
                            + "     arrayIndex = " + arrayIndex
                            + "     elemIndex = " + elemIndex);
                    if (currentBonus <= minCurrentBonus) {
                        minCurrentArray = currentArray;
                        minPreviousBonus = previousBonus;
                        minCurrentBonus = currentBonus;
                        minArrayIndex = arrayIndex;
                        minElemIndex = elemIndex;
                    }
                }
                elemIndex++;
            }
            arrayIndex++;
        }
        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("INITIAL_BONUS = " + INITIAL_BONUS
                + "     minCurrentArray = " + Arrays.deepToString(minCurrentArray)
                + "     minPreviousBonus = " + minPreviousBonus
                + "     minPreviousBonus = " + minCurrentBonus
                + "     minArrayIndex = " + minArrayIndex
                + "     minElemIndex = " + minElemIndex);
    }
}
