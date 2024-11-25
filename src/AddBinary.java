
//https://leetcode.com/problems/add-binary/description/?envType=problem-list-v2&envId=string

//Можно использовать StringBuilder, для ускорения кода
//Но мне лень ¯\_(ツ)_/¯
public class AddBinary {
    public static String addBinary(String a, String b) {
        String res = "";

        int carry = 0;
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        while (indexA >= 0 && indexB >= 0) {

            if(a.charAt(indexA) == '1' && b.charAt(indexB) == '1') {
                if(carry == 1) {
                    res = "1" + res;
                }else res = "0" + res;
                carry = 1;
            }else if(a.charAt(indexA) == '1' || b.charAt(indexB) == '1') {
                if(carry != 1)
                    res =  "1" + res;
                else {
                    res = "0" + res;
                }
            }else {
                if(carry == 0) {
                    res = "0" + res;
                }else{
                    res = "1" + res;
                    carry = 0;
                }
            }

            indexA--;
            indexB--;
        }

        while(indexA >= 0) {
            if(a.charAt(indexA) == '1') {
                if(carry == 1)
                    res = "0" + res;
                else res = "1" + res;
            }else {
                if(carry == 1) {
                    res = "1" + res;
                    carry = 0;
                }else res = "0" + res;
            }
            indexA--;
        }

        while(indexB >= 0 ) {
            if(b.charAt(indexB) == '1') {
                if(carry == 1) res = "0" + res;
                else res = "1" + res;
            }else {
                if(carry == 1) {
                    res = "1" + res;
                    carry = 0;
                }else res = "0" + res;
            }
            indexB--;
        }
        if(carry == 1)
            res = "1" + res;


        return res;
    }

}
