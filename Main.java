import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Сортируем массив для удобства пропуска дубликатов
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));  // Если цель достигнута, добавляем комбинацию в результат
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) continue; // Пропуск дубликатов
                if (candidates[i] > remain) break;  // Прекращаем поиск, если число больше оставшейся цели
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain - candidates[i], i + 1); // i + 1, потому что не можем использовать один элемент дважды
                tempList.remove(tempList.size() - 1); // Убираем последний элемент для возврата в предыдущую точку
            }
        }
    }
}