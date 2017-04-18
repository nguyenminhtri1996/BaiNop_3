/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bainop3;

/**
 *
 * @author Minh Tri
 */
public class Question_3 {
    Question_3(int n)
    {
        int a[][] = new int[n][n];
        a[0][0] = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 1; j < n; j++)
            {
                a[i][j] = 0;
            }
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(j == 0)
                {
                    a[i][j] = 1;
                }
                else
                {
                    if(i > 0 && j > 0)
                    {
                        a[i][j] = a[i-1][j-1] + a[i-1][j];
                    }
                }
            }
        }
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
               if(a[i][j] == 0)
                   System.out.print("");
               else
                   System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
    
}
