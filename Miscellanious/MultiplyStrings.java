package Miscellanious;

public class MultiplyStrings {
    class Solution {
        public String multiply(String num1, String num2) {
            //res array contains the max size of len(num1)+len(num2)
            //try with an example if u have doubt
    
            int[] result=new int[num1.length()+num2.length()];
    
            //Major thing here, we you multiply two numbers the result will land in i+j+1 and i+j positions..Check if u have any doubt
            int m=num1.length()-1;
            int n=num2.length()-1;
    
            for(int i=m; i>=0; i--){
                for(int j=n; j>=0; j--){
                    int mul= (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
    //add to the existing value and store one's digit value
    int sum=mul+result[i+j+1];
                  
                    result[i+j+1]=sum%10;
    //add carry to the ten's place
                    result[i+j]=result[i+j]+sum/10;
                }
            }
            
    
    
    StringBuilder sb=new StringBuilder();
    
    for(int i: result){
        if(sb.length()==0 && i==0)
        continue;
    
        sb.append(i);
    }
    
    return sb.length() == 0 ? "0" : sb.toString();
    
        }
    }
}
