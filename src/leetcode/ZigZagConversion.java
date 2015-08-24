/*The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 *  (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * */

package leetcode;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
        if(numRows==1)
        {
        	return s;
        }
   	 	String[] subresults = new String[numRows];
        
   	 	for(int i =0;i<numRows;i++)
   	 	{
   	 		subresults[i]="";
   	 	}
        for(int i =0;i<s.length();i++)
        {
       	 	char getc = s.charAt(i);
       	 	int index = i%(numRows*2-2);
       	 	if(index>numRows-1)
       	 	{
       	 		index = numRows-1-(index-numRows+1);
       		}
       	 	subresults[index]+=getc;
        }
        String result ="";
        for(int i =0;i<numRows;i++)
        {
        	result+=subresults[i];
        }
        return result;
    }
}
