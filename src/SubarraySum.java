
//Дан целочисленный массив, найти подмассив, содержащий заданную сумму.
//Input [0,1,4,-1,2] target = 3 Output [2,3]

import java.util.HashMap;

public class SubarraySum {
    public static int[] findSubarrayWithTargetSum(int[] nums, int target) {
        // Хэш-таблица для хранения накопленной суммы
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        // Инициализируем хэш-таблицу
        prefixSumMap.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Проверяем, существует ли `prefixSum - target` в таблице
            if (prefixSumMap.containsKey(prefixSum - target)) {
                int startIdx = prefixSumMap.get(prefixSum - target) + 1;
                return new int[]{startIdx, i}; // Возвращаем индексы подмассива
            }

            // Сохраняем текущую накопленную сумму и индекс
            prefixSumMap.put(prefixSum, i);
        }

        // Если подмассив не найден
        return new int[]{-1, -1};
    }

}
