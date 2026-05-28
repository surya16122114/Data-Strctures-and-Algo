package TwoPointers;

// import java.util.HashMap;
// import java.util.Map;

public class TwoSumIIInputSortedArray {
    //approach 1 On(n) and O(n) using hashmap
//     class Solution {
//     public int[] twoSum(int[] numbers, int target) {
        
//         Map<Integer, Integer> m=new HashMap<>();
//         for(int i=0; i<numbers.length; i++){
            
//             if(m.containsKey(target-numbers[i])){
//                 return new int[]{m.get(target-numbers[i])+1, i+1};
//             }

//             m.put(numbers[i], i);
//         }

//     return new int[]{};
     
//     }
// }

//O(n) and O(1) using two pointers

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
     int l=0; 
     int r=numbers.length-1;

    int sum=0;
     while(l<=r){
        sum=numbers[l]+numbers[r];

        if(sum>target){
            r--;
        }
        else if(sum<target){
            l++;
        }

        else{
            return new int[]{l+1, r+1};
        }
     }
     return new int[]{};
     
    }
}
}


