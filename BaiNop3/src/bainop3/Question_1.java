/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bainop3;

import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Minh Tri
 */
public class Question_1 {
    private Vector A = new Vector();
    private Vector B = new Vector();
    private Vector C = new Vector();
    public void get_array_from_file() throws FileNotFoundException, IOException
    {
//        FileInputStream f = new FileInputStream("a.txt");
//        DataInputStream dis = new DataInputStream(f);
//        System.out.println(dis.readInt());
//        f.close();
//        dis.close();
        FileReader f = new FileReader("a.txt");
        BufferedReader br = new BufferedReader(f);
        String line;
        String[] temp = null;
        while ((line = br.readLine()) != null){
            temp = line.split(" ");
        }
        for(int i = 0; i < temp.length; i++)
        {
            A.add(temp[i]);
        }
        f.close();
        br.close();
    }
    public void create_random_array(int m) // create a B array with random components
    {
        Random rd = new Random();
        for(int i = 0; i < m; i++)
        {
            B.add(rd.nextInt(100));
        }
    }
    public void output_into_file_array_B() throws IOException // output all of components into file b.txt
    {
        File f = new File("b.txt");
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        for(int i = 0; i < 10; i++)
        {
            writer.write(B.get(i)+" "); 
        }
        writer.flush();
        writer.close();    
    }
    public void copy_A_to_C() // create a C array from A array by copy all A
    {
        for(int i = 0; i < A.size(); i++)
        {
            C.add(A.get(i));
        }
    }
    public void exchange_B_C() // exchange 3 last components of B to components 1 -> 3 of C
    {
        
        int y = C.size();
        int j = 1;
        for(int i = 0; i < 3; i++)
        {
            C.set(i, B.get(y-j));
            j++;
        }
    }
    public void sort_of_C() throws IOException // arrange C array by increace and output C into c.txt
    {
        int size_C = 0;
        size_C = C.size();
        int a[] = new int[size_C];
        
        for(int i = 0; i < C.size(); i++)
        {
            a[i] = Integer.parseInt((String)C.elementAt(i));
        }
        for(int i = 0; i < a.length - 1; i++)
        {
            for(int j = i + 1; j < a.length; j++)
            {
                if(a[i] > a[j])
                {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        
        File f = new File("c.txt");
        f.createNewFile();
        FileWriter writer = new FileWriter(f);
        for(int i = 0; i < a.length; i++)
        {
            writer.write(a[i]+" "); 
        }
        writer.flush();
        writer.close();
        
        
    }
    public void ouput()
    {
        int i;
        for(i = 0; i < A.size(); i++)
        {
            System.out.print(A.get(i)+" ");
        }
        System.out.println();
        for(i = 0; i < B.size(); i++)
        {
            System.out.print(B.get(i)+" ");
        }
        System.out.println();
        for(i = 0; i < C.size(); i++)
        {
           System.out.print(C.get(i)+" ");
        }
        System.out.println();
    }
    public void output_A()
    {
        for(int i = 0; i < A.size(); i++)
        {
            System.out.print(A.get(i)+" ");
        }
    }
    public void output_B()
    {
        for(int i = 0; i < B.size(); i++)
        {
            System.out.print(B.get(i)+" ");
        }
    }
    public void output_C()
    {
        for(int i = 0; i < C.size(); i++)
        {
            System.out.print(C.get(i)+" ");
        }
    }
    
}
