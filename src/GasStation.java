//https://leetcode.com/problems/gas-station/description/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int start = 0;
        int sumGas = 0;
        int sumCost = 0;
        for (int i = 0; i < gas.length; i++) {
            sumCost += cost[i];
            sumGas += gas[i];
            if (total < 0) {
                total = 0;
                start = i;
            }
            total += gas[i] - cost[i];
        }


        return sumGas >= sumCost ? start: -1;
    }
}
