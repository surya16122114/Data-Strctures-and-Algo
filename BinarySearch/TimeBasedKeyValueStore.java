package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    class TimeMap {

    class Pair{
        String value;
        int timestamp;
        Pair(String value, int timestamp){
            this.value=value;
            this.timestamp=timestamp;
        }
    }
   Map<String, List<Pair>>m;

    public TimeMap() {
        m=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        m.putIfAbsent(key, new ArrayList<>());
        m.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!m.containsKey(key))
        return "";

       List<Pair> list= m.get(key);
       String res="";
       int left=0;
       int right=list.size()-1;

       while(left<=right){
        int mid=left+(right-left)/2;

        if(timestamp>=list.get(mid).timestamp){
               left=mid+1;
               res=list.get(mid).value;
        }
     
        else 
        right=mid-1;

     
       }


       return res;
        
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
}
