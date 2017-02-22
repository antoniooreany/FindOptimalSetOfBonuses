import java.util.*;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Main {
    private static final int INITIAL_BONUS = 4;
    private static final List<Integer> INITIAL_LIST = Arrays.asList(1, 2, 3);
    private static Map<List<Integer>, Integer> resultedMap = new HashMap<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = Permute.permute(INITIAL_LIST);
        for (List<Integer> list : lists) {
            List<Integer> resultedList;
            int currentBonus;
            int nextBonus = INITIAL_BONUS;
            int nextElem;
            for (int nextIndex = 0; nextIndex < list.size(); nextIndex++) {
                currentBonus = nextBonus;
                nextElem = list.get(nextIndex);
                nextBonus = nextBonus - nextElem;
                if (currentBonus >= 0 && nextBonus < 0) {
                    resultedList = list.subList(0, nextIndex);
                    System.out.println("list = " + list.toString()
                            + "    resultedList = " + resultedList.toString()
                            + "    currentBonus = " + currentBonus
                    );
                    resultedMap.put(resultedList, currentBonus);
                }
            }
        }
        System.out.println("//////////////////////////////////////////////////////////////////////////");

        Set<List<Integer>> resultedSet = resultedMap.keySet();
        int minBonus = INITIAL_BONUS;
        List<List<Integer>> bestLists = new ArrayList<>();
        for (List<Integer> resultedList : resultedSet) {
            Integer resultedBonus = resultedMap.get(resultedList);
            if (resultedBonus <= minBonus) {
                minBonus = resultedBonus;
            }
        }
        for (List<Integer> resultedList :
                resultedSet) {
            Integer bonus = resultedMap.get(resultedList);
            if (bonus == minBonus) {
                bestLists.add(resultedList);
            }
        }
        System.out.println("bestLists = "+ bestLists);
    }
}
