package com.example.cm.algroithms;

/**
 * Created by cm on 01/12/2017.
 */

public class STRINGMATCHING_FUNCTIONS {

    public Boolean String_Match(String text,String pattern)
    {
       // String text ="hello worrld ya people";
        //String pattern="hello";
        int flag=0;
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i <= n-m; i++) {

            for (int j = 0; j <= m-1; j++) {

                if(text.charAt(i)==pattern.charAt(j))
                {
                    flag++;
                    i++;
                }else
                {
                    i=i-flag;
                    flag=0;
                    break;
                }

            }

            if(flag==m)
            {

                return  true;
            }


        }
        return  false;
    }
}
