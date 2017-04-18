/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bainop3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 *
 * @author Minh Tri
 */
public class Question_5 {
    
    Question_5() throws FileNotFoundException, IOException
    {
        Vector components = new Vector();
        FileReader fr = new FileReader("input.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        int n = 0;
        while ((line = br.readLine()) != null)
        {
            String[] temp = line.split(",");
            n = temp.length;
            for(int i = 0; i < temp.length; i++)
            {
                components.add(temp[i]);
            }
        }
        
          
        Fraction a[][] = new Fraction[2][n]; // n is all of components every line in file
        Fraction Tong[] = new Fraction[n]; // n is all of components every line in file
        Fraction Tich[] = new Fraction[n]; // n is all of components every line in file
        int t = 0;
        for(int i = 0; i < 2; i++) 
        {
            for(int j = 0; j < n; j++)
            {
                String chuoi_ps = (String)components.elementAt(t);
                a[i][j] = new Fraction();
                a[i][j].set(chuoi_ps);
                t++;
            }
        }
        for(int i = 0; i < n; i++)
        {
            Tong[i] = new Fraction(); // initialize of every comeponent 
            Tong[i] = a[0][i].sum(a[1][i]);
            Tich[i] = new Fraction();
            Tich[i] = a[0][i].multi(a[1][i]);
        }
        for(int i = 0; i < Tich.length-1; i++)
        {
            for(int j = i + 1; j < Tich.length; j++)
            {
                if(Tich[j].equal_after_ultimate(Tich[i]) == false)
                {
                    Fraction temppp = new Fraction();
                    temppp = Tich[j].copy();
                    Tich[j] = Tich[i].copy();
                    Tich[i] = temppp.copy();
                }
            }
        }
        for(int i = 0; i < Tong.length-1; i++)
        {
            for(int j = i + 1; j < Tong.length; j++)
            {
                if(Tong[j].equal_after_ultimate(Tong[i]) == false)
                {
                    Fraction temppp = new Fraction();
                    temppp = Tong[j].copy();
                    Tong[j] = Tong[i].copy();
                    Tong[i] = temppp.copy();
                }
            }
        }
        
        File f = new File("output.txt");
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        for(int i = 0; i < Tong.length; i++)
        {
            writer.write(Tong[i].out_file()+" ");           
        }
        writer.write("\r\n");
        for(int i = 0; i < Tich.length; i++)
        {
            writer.write(Tich[i].out_file()+" "); 
        }
        writer.flush();
        writer.close();
        
        
    }
    
    
    
}
