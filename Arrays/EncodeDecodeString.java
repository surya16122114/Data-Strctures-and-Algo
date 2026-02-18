
import java.util.ArrayList;
import java.util.List;
public class EncodeDecodeString {
   class Solution {

    public String encode(List<String> strs) {


            StringBuilder sb=new StringBuilder();
            for(String s: strs){
                sb.append(s.length()).append('#').append(s);
            }

            return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> ans=new ArrayList<>();

        int i=0;
        while(i<str.length()){
            int j=i;

            while(str.charAt(j)!='#'){
                j++;
            }


            //length of the string
            int len=Integer.parseInt(str.substring(i,j));

           String s= str.substring(j+1, j+1+len);
           ans.add(s);

           i=j+1+len;
        }

        return ans;

    }
}
 
}
//leetcode problem link: https://leetcode.com/problems/encode-and-decode-strings/description/
