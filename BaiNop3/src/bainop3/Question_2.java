/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bainop3;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Minh Tri
 */
public class Question_2 {
    private static int x;
    public void Set_x()
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Let's type x: ");
        int t = in.nextInt();
        x = t;  
    }
    public void Get_x()
    {
        System.out.println("x = "+x);
    }
    public void Check_Document_File() throws IOException
    {
        FileReader fr = new FileReader("c.txt");
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] temp = null;
        while ((line = br.readLine()) != null){
            temp = line.split(" ");
        }
        int flag = 0;
        int position = 0;
        for(int i = 0; i < temp.length; i++)
        {
            int kk = Integer.parseInt(temp[i]);
            if(x == kk)
            {
                flag = 1;
                position = i;
                break;
            }
        }
        if(flag == 1)
        {
            System.out.print("x is in the c.txt file at position: "+position);
        }
        else
        {
            System.out.print("x is not in the c.txt file");
        }
    }
    public void Check_Binary_File() throws FileNotFoundException, IOException
    {
        DataInputStream d = new DataInputStream(new FileInputStream("c.txt"));
        String s;
        String[] temp = null;
        while((s = d.readLine()) != null)
        {
            temp = s.split(" ");
        }   
        int flag = 0;
        int position = 0;
        for(int i = 0; i < temp.length; i++)
        {
            int kk = Integer.parseInt(temp[i]);
            if(x == kk)
            {
                flag = 1;
                position = i;
                break;
            }
        }
        if(flag == 1)
        {
            System.out.print("x is in the c.txt file at position: "+position);
        }
        else
        {
            System.out.print("x is not in the c.txt file");
        }
    }
    
}
