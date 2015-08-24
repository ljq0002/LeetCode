package leetcode;

import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public void letterCombinations(String digits,List<String> res,StringBuilder cur)
    {
	   	 char[][] dic ={{},{'a','b','c'},
	   			 			{'d','e','f'},
	   			 			{'g','h','i'},
	   			 			{'j','k','l'},
	   			 			{'m','o','n'},
	   			 			{'p','q','r','s'},
	   			 			{'t','u','v'},
	   			 			{'w','x','y','z'}};
	   	 if(digits.length()==0)
	   	 {
	   		 res.add(cur.toString());
	   		 return;
	   	 }
	   	 char[] curkey = dic[digits.charAt(0)-'1'];
	   	 String after = digits.substring(1);
	   	 for(int i= 0;i<curkey.length;i++)
	   	 {
	   		 cur.append(curkey[i]);
	   		 letterCombinations(after,res,cur);
	   		 cur.deleteCharAt(cur.length()-1);
	   	 }
   	 
    }

}
