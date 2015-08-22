/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * */

package leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
        {
        	return 0;
        }
        
        int res = 1;
        HashSet<Character> hs = new HashSet<Character>();
        int start =0;

        for(int i = 0 ; i < s.length() ; i++)
        {
        	char curc = s.charAt(i);
        	if(hs.contains(curc))
        	{
        		while(s.charAt(start) != curc)
        		{
        			hs.remove(s.charAt(start++));
        		}
        		start++;
        	}
        	else
        	{
        		hs.add(curc);
        		res = Math.max(res, i - start + 1);
        	}
        }
        return res;
    }
}
