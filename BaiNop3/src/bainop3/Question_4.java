/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bainop3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Minh Tri
 */
public class Question_4 {
    private Vector Matrix = new Vector();
    Question_4() throws FileNotFoundException, IOException
    {
        FileReader f = new FileReader("matrix.txt");
        BufferedReader br = new BufferedReader(f);
        String line;
        while ((line = br.readLine()) != null){
            String[] temp = line.split(" ");
            for(int i = 0; i < temp.length; i++)
            {
                Matrix.add(temp[i]);
                
            }
        }
        for(int i = 0; i < Matrix.size(); i++)
        {
            System.out.print(Matrix.get(i)+" ");
        }
        
    }
    public void Minimum()
    {
        int minimum  = Integer.parseInt((String) Matrix.elementAt(0));
        for(int i = 1; i < Matrix.size(); i++)
        {
            if(minimum > Integer.parseInt((String) Matrix.elementAt(i)))
                minimum = Integer.parseInt((String) Matrix.elementAt(i)); 
        }
        System.out.print("The minimum of Matrix is: "+minimum);
    }
    public void Maximum()
    {
        int maximum  = Integer.parseInt((String) Matrix.elementAt(0));
        for(int i = 1; i < Matrix.size(); i++)
        {
            if(maximum < Integer.parseInt((String) Matrix.elementAt(i)))
                maximum = Integer.parseInt((String) Matrix.elementAt(i)); 
        }
        System.out.print("The minimum of Matrix is: "+maximum);
    }
    public boolean check_prime_number(int n)
    {
        for(int i = n - 1; i > 1; i--)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public void Prime_number()
    {
        String s = "Prime number of Matrix are: ";
        for(int i = 0; i < Matrix.size(); i++)
        {
            int k = Integer.parseInt((String) Matrix.elementAt(i));
            if(check_prime_number(k)==true)
                s += Matrix.get(i)+" ";
        }
        System.out.println(s);
    }
    public void Sum()
    {
        int sum = 0;
        for(int i = 0; i < Matrix.size(); i++)
        {
            sum += Integer.parseInt((String) Matrix.elementAt(i));
        }
        System.out.print(sum);
    }
}
