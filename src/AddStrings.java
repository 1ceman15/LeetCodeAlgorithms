
//https://leetcode.com/problems/add-strings/description/


public class AddStrings {


    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int carry = 0;

        while (index2 >= 0 || index1 >= 0){
            int digit1 = index1 >= 0? num1.charAt(index1--) - '0' : 0;
            int digit2 = index2 >= 0? num2.charAt(index2--) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = 0;

            if(sum >= 10){
                sum = sum%10;
                carry = 1;
            }
            result.insert(0,sum);
        }


        if(carry == 1)
            result.insert(0, 1);

        return result.toString();

    }
}
