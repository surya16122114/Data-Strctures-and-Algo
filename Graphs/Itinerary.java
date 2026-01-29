import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Itinerary{
    class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        

        Map<String, List<String>> adj=new HashMap<>();

        for(List<String> t: tickets){
            adj.putIfAbsent(t.get(0), new ArrayList<>());
        }

        tickets.sort((a,b)->a.get(1).compareTo(b.get(1)));

        for(List<String> t: tickets){
            adj.get(t.get(0)).add(t.get(1));
        }


        List<String> res=new ArrayList<>();
        res.add("JFK");
        if(dfs("JFK", res, adj, tickets.size()+1))
        return res;
        else
        return new ArrayList<>();

    }


    public boolean dfs(String src, List<String> res, Map<String, List<String>> adj, int targetLen){
        if(res.size()==targetLen)
        return true;

        if(!adj.containsKey(src))
        return false;
        List<String> temp=new ArrayList<>(adj.get(src));

        for(int i=0; i<temp.size(); i++){
            adj.get(src).remove(i);
            res.add(temp.get(i));

            if(dfs(temp.get(i), res, adj, targetLen))
            return true;
//if dfs failed, then remove the last element from the result and try different node now.
            res.remove(res.size()-1);
            adj.get(src).add(i, temp.get(i));
        }

        return false;
    }
}
}