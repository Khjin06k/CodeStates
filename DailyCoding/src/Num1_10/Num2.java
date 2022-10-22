package Num1_10;
import java.util.*;

public class Num2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int output = s.computeWhenDouble(7);
        System.out.println(output); // --> 11
    }
}

class Solution2 {
    public int computeWhenDouble(double interestRate) {
        // TODO:
        double money = 100;
        int count = 0;
        while(money <200){
            money *= (interestRate+100)/100;
            count++;
        }
        return count;
    }
}
