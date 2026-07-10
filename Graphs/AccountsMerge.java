import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;
public class AccountsMerge {
    class Solution {
    int[] parent, size;

    int find(int x){
        if(parent[x]!=x)
        parent[x]=find(parent[x]);
        return parent[x];
    }

    void union(int a, int b){
        int ra=find(a);
        int rb=find(b);
        if(size[ra]<size[rb]){
            parent[ra]=rb;
            size[rb]+=size[ra];
        }
        else{
            parent[rb]=ra;
            size[ra]+=size[rb];
        }
        
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
        parent=new int[n];
        size=new int[n];

        for(int i=0; i<n; i++){
            parent[i]=i;
            size[i]=1;
        }

        Map<String, Integer> emailToIdx=new HashMap<>();

        //union
        for(int i=0; i<n; i++){
            List<String> account=accounts.get(i);

            //exclude the name

            for(int j=1; j<account.size(); j++){
                if(!emailToIdx.containsKey(account.get(j))){
                    emailToIdx.put(account.get(j), i);
                }
                else{
                    union(emailToIdx.get(account.get(j)), i);
                }
            }
        }

        //group emails by root
        Map<Integer, Set<String>> groupedEmails=new HashMap<>();

        for(Map.Entry<String, Integer> entry: emailToIdx.entrySet()){
            String email=entry.getKey();
            int index=entry.getValue();
            int root=find(index);
            if (!groupedEmails.containsKey(root)) {
                groupedEmails.put(root, new HashSet<>());
            }
            groupedEmails.get(root).add(email);
        }

        List<List<String>> res=new ArrayList<>();

        for(Map.Entry<Integer, Set<String>> entry: groupedEmails.entrySet()){
            List<String> list=new ArrayList<>();

            int root=entry.getKey();
            Set<String> emails=entry.getValue();

            //add the name
            list.add(accounts.get(root).get(0));
            List<String> sortedEmails=new ArrayList<>(emails);
            Collections.sort(sortedEmails);
            list.addAll(sortedEmails);

            res.add(list);
        }

        return res;
        
    }
}
}

//leetcode problem link