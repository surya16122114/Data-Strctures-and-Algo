package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatenationOfWords {
    class Solution {
        public List<Integer> findSubstring(String s, String[] words) {

            Map<String, Integer> target = new HashMap<>();
            int totalLen = 0;

            for (int i = 0; i < words.length; i++) {
                target.put(words[i], target.getOrDefault(words[i], 0) + 1);
                totalLen += words[i].length();
            }
            int len = words[0].length();
            List<Integer> res = new ArrayList<>();

            for (int start = 0; start < len; start++) {

                int left = start;
                int right = start;

                Map<String, Integer> window = new HashMap<>();

                while (right + len <= s.length()) {
                    String curr = s.substring(right, right + len);

                    if (target.containsKey(curr)) {
                        window.put(curr, window.getOrDefault(curr, 0) + 1);

                        while (right - left + len > totalLen) {
                            String leftString = s.substring(left, left + len);
                            window.put(leftString, window.get(leftString) - 1);
                            if (window.get(leftString) == 0)
                                window.remove(leftString);
                            left += leftString.length();
                        }

                        int count = 0;
                        for (String str : target.keySet()) {
                            if (window.containsKey(str) && window.get(str).equals(target.get(str)))
                                count++;
                        }
                        if (count == target.size())
                            res.add(left);
                    } 
                    
                    else {
                        window.clear();
                        left = right + len;
                    }

                    right = right + len;
                }

            }

            return res;

        }
    }
}
