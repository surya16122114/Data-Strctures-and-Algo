import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.*;

public class FindAllPossibleRecipes {
    class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {


        Set<String> supplySet=new HashSet<>(Arrays.asList(supplies));

        Map<String, Integer> recipeToIdx=new HashMap<>();

        for(int i=0; i<recipes.length; i++){
            recipeToIdx.put(recipes[i], i);
        }

     // recipes---[ingredients]
        Map<String, List<String>> adj=new HashMap<>();

        for(int i=0; i<recipes.length; i++)
        adj.put(recipes[i], new ArrayList<>());


        //making the graph now
        int[] degree=new int[recipes.length];

        for(int i=0; i<recipes.length; i++){
           //String recipe=recipes[i];

            for(String ingredient: ingredients.get(i)){
                if(supplySet.contains(ingredient))
                continue;

                else if(recipeToIdx.containsKey(ingredient))
                {
                    adj.get(ingredient).add(recipes[i]);

                    degree[i]++;
                }

                else{

                    //ingredient is neither a recipe nor contained in supplies, we cant make that particular recipe

                    degree[i]=Integer.MAX_VALUE;
                }
            }
        }
  Queue<String> q=new LinkedList<>();
    for(int i=0; i<recipes.length; i++){
        if(degree[i]==0)
        q.offer(recipes[i]);
    }
          
            List<String> res=new ArrayList<>();

            while(!q.isEmpty()){
                String curr=q.poll();
                res.add(curr);

                for(String neighbor: adj.get(curr)){
                  int index=  recipeToIdx.get(neighbor);
                    degree[index]--;

                    if(degree[index]==0)
                    q.offer(neighbor);
                }
            }

            return res;
        
    }
}
}
