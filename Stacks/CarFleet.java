import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CarFleet {
    class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        double[][] cars=new double[n][2];
 //position, time to reach the target
        for(int i=0; i<n; i++){
            cars[i][0]=position[i];
            cars[i][1]=(double)(target - position[i]) / speed[i];
        }

//sort based on the position--descending order
//since we need to find the car behind the current car can catch upto this car or not
  Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        Deque<Double> stack=new ArrayDeque<>();

        for(double[] car:cars){
            double time =car[1];
//if the current car is taking longer time than the cars ahead, meaning new fleet
            if(stack.isEmpty() || time>stack.peek())
            stack.push(time);
        }

        return stack.size();
    }
}


//solution 2
// class Solution {
//     public int carFleet(int target, int[] position, int[] speed) {
//         int n=position.length;
//         double[][] cars=new double[n][2];
//  //position, time to reach the target
//         for(int i=0; i<n; i++){
//             cars[i][0]=position[i];
//             cars[i][1]=(double)(target - position[i]) / speed[i];
//         }

// //sort based on the position--descending order
// //since we need to find the car behind the current car can catch upto this car or not
//   Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

// double maxTime=0;
// int fleets=0;
//         for(double[] car:cars){
//             double time =car[1];
// //if the current car is taking longer time than the cars ahead, meaning new fleet
//             if(time>maxTime){
//                 maxTime=time;
//                 fleets++;
//             }
    
//         }

//         return fleets;
//     }
// }
}
