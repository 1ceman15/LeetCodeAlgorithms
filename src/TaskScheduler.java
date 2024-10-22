
//https://leetcode.com/problems/task-scheduler/description/


import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        Arrays.sort(freq);

        int maxFreq = freq[25] - 1;
        int idleSlots = maxFreq * n;


        for (int i = 24; i >= 0 && freq[i] > 0; i--) {
            //Вычитать минимальный нужно из-за того, что в последний раз, когда выполняется задача
            //Задержка отсутствует, а если имеется два элемента, встречающиеся одинаковое кол-во раз
            //То оно занимает лишнее место, например в случаи например char[]{'A', 'A', 'A', 'B', 'B', 'B' };
            // [A] [ ] [ ]
            // [A] [ ] [ ]
            // [A] .......
            //В этом случаи третья B займет место одной из задержек
            idleSlots -= Math.min(freq[i], maxFreq);
        }

        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }


}
