import java.util.*;

/**
 * Created by gorshkov on 21.02.2017.
 */
public class Main {
    private static final int INITIAL_BONUS = 4;
    private static final List<Integer> INITIAL_LIST = Arrays.asList(1, 2, 3, 4);
    private static Map<List<Integer>, Integer> resultedMap = new HashMap<>();

    public static void main(String[] args) {
        List<List<Integer>> lists = Permute.permute(INITIAL_LIST);
        for (List<Integer> list : lists) {
            List<Integer> resultedList;
            int currentBonus;
            int nextBonus = INITIAL_BONUS;
            int nextElem;
            int nextIndex;
            for (nextIndex = 0; nextIndex < list.size(); nextIndex++) {
                currentBonus = nextBonus;
                nextElem = list.get(nextIndex);
                nextBonus = nextBonus - nextElem;
                if ((currentBonus >= 0 && nextBonus < 0)) {
                    resultedList = list.subList(0, nextIndex);
                    PrintToConsole(list, resultedList, currentBonus, nextBonus);
                    resultedMap.put(resultedList, currentBonus);
                }
                if (nextBonus >= 0 && nextIndex == list.size() - 1) {
                    resultedList = list;
                    PrintToConsole(list, resultedList, currentBonus, nextBonus);
                    resultedMap.put(resultedList, nextBonus);
                }
            }
        }
        System.out.println("//////////////////////////////////////////////////////////////////////////");

        Set<List<Integer>> resultedSet = resultedMap.keySet();
        int minBonus = INITIAL_BONUS;
        List<List<Integer>> bestLists = new ArrayList<>();
        minBonus = getMinBonus(resultedSet, minBonus);
        bestLists = bestListsCreation(resultedSet, minBonus, bestLists);
        System.out.println("bestLists = " + bestLists);
    }

    private static List<List<Integer>> bestListsCreation(Set<List<Integer>> resultedSet, int minBonus, List<List<Integer>> bestLists) {
        for (List<Integer> resultedList : resultedSet) {
            Integer bonus = resultedMap.get(resultedList);
            if (bonus == minBonus) {
                bestLists.add(resultedList);
            }
        }
        return bestLists;
    }

    private static int getMinBonus(Set<List<Integer>> resultedSet, int minBonus) {
        for (List<Integer> resultedList : resultedSet) {
            Integer resultedBonus = resultedMap.get(resultedList);
            if (resultedBonus <= minBonus) {
                minBonus = resultedBonus;
            }
        }
        return minBonus;
    }

    private static void PrintToConsole(List<Integer> list, List<Integer> resultedList, int currentBonus, int nextBonus) {
        System.out.println("list = " + list.toString()
                + "    resultedList = " + resultedList.toString()
                + "    currentBonus = " + currentBonus
                + "    nextBonus = " + nextBonus
        );
    }
}
