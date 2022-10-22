package Num1_10;
import java.util.*;

public class Num1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();

        String[] arr = new String[]{"Queen", "Elizabeth", "Of Hearts", "Beyonce"};
        HashMap<String, String> output = s.transformFirstAndLast(arr);
        System.out.println(output); // --> { Queen : 'Beyonce' }
    }
}
class Solution1 {
    public HashMap<String, String> transformFirstAndLast(String[] arr) {
        // TODO:
        HashMap<String,String> hashMap = new HashMap<>(); //새로운 HashMap 생성
        int size = arr.length; //배열 크기
        if(size == 0) return null; //빈 배열이면 null 출력
        else {
            hashMap.put(arr[0],arr[size-1]);//새로 생성한 Map에 첫 요소를 key, 마지막 요소를 value로 하여 put 진행
            return hashMap; // 리턴타입이 HashMap이기에 해당 Map을 그대로 리턴
        }

        //어떤 경우에 새로운 Map을 생성 후 반환해야 하고 어떤 경우에 그대로 사용해도 되는 것인지에 대한 구분 및 학습 필요
    }
}
