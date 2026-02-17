package Greedy;

public class GasStation {
    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
    
            int totalGas=0;
            int totalCost=0;
            for(int i=0; i<gas.length; i++){
                totalGas+=gas[i];
                totalCost+=cost[i];
            }
    
            if(totalGas<totalCost)
            return -1;
    
    int currGas=0;
    int idx=0;
            for(int i=0; i<gas.length; i++){
                currGas+=(gas[i]-cost[i]);
    
                if(currGas<0)
                {
                    idx=i+1;
                    currGas=0;
                }
            }
    
            return idx;
        }
    }
    
    // totalGas - totalCost ≥ 0  
    
    // This means:
    // (gas from k...end) + (gas from 0..k-1) ≥ (cost from k...end) + (cost from 0...k-1)
    
    // Rearranging:
    // (gas from k..end) - (cost from k...end) ≥ (cost from 0..k-1) - (gas from 0...k-1)
    
    // Left side = surplus from k→end
    // Right side = deficit from 0→k-1
    
    // surplus = gas we have after going from station k to end
    // deficit = gas we need to go from station 0 to k-1
    
    // So: surplus ≥ deficit 
}
