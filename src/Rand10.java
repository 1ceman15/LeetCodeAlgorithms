

//https://leetcode.com/problems/implement-rand10-using-rand7/description/

import java.util.Random;

public class Rand10 {

    Random random = new Random();

    public int rand10() {
        while (true){
            int row = rand7();
            int col = rand7();

            int num = (row - 1) * 7 + col;
            if(num <= 40){
                return 1 + (num - 1) % 10;
            }
        }
    }

    public int rand7(){

        return random.nextInt(7);
    }
}
