import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         Set<String> s=new HashSet<>(wordList);  
        if (!s.contains(endWord)) return 0;

        Queue<Pair> q=new LinkedList<>();

        q.offer(new Pair(beginWord,1));
        s.remove(beginWord);

        while(!q.isEmpty()){
           Pair p= q.poll();

           String word=p.s;
           int steps=p.steps;
           if(word.equals(endWord))
           return steps;

           for(int i=0; i<word.length(); i++){
            char[] charArray=word.toCharArray();
            for(char c='a'; c<='z'; c++){
                charArray[i]=c;
                String st=new String(charArray);

                if(s.contains(st)){
                    s.remove(st);
                    q.offer(new Pair(st, steps+1));

                }
            }
           }
        }

        return 0;
    }
}

class Pair{
    String s;
    int steps;

     Pair(String s, int steps){
        this.s=s;
        this.steps=steps;
     }
}
}


//Really hard problem..I dont know how people think of such kinds..