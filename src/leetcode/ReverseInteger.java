/*
    Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
    */
package leetcode;

import java.util.ArrayList;

public class ReverseInteger {
	
    public int reverse(int x) {
        ArrayList<Integer> keta = new ArrayList<Integer>();
        boolean minus;
        if(x>=0)
        {
            minus=false;
        }
        else
        {
            minus=true;
            x=0-x;
            if(x<=0)
            {
                return 0;
            }
        }
        while(x!=0)
        {
            keta.add(x-x/10*10);
            x=x/10;        
        }
        if(keta.size()>9&&keta.get(0)>2)
        {
        	return 0;
        }
        int result=0;
        for(int i=0;i<keta.size();i++)
        {
            result*=10;
            result+=keta.get(i);
        }
        if(result<0)
        {
            return 0;
        }
        if(minus==true)
        {
            result=0-result;
            if(result>0)
            {
                return 0;
            }
        }
        return result;
       
    }
    
}
