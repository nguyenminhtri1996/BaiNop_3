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
public class Fraction {
    private int numerator;
    private int denominator;
    Fraction(){}
    Fraction(int _numerator, int _denominator)
    {
        numerator = _numerator;
        denominator = _denominator;
    }
    public void output()
    {
        if(denominator == 1)
            System.out.print(numerator);
        else
            System.out.print(numerator+"/"+denominator);
    }
    public int  greatest_common_divisor(int a, int b)
    {      
        int t = (a > b) ? b : a;
        for(int i = t; i > 1; i--)
        {
            if((a % i) == 0 && (b % i) == 0)
            {
                return i;
            }
        }
        return 1;
    }
    public void ultimate()
    {
        int t = greatest_common_divisor(numerator, denominator);
        numerator = numerator / t;
        denominator = denominator / t;
    }
    public Fraction sum(Fraction a)
    {
        Fraction t = new Fraction();
        t.numerator = (numerator*a.denominator) + (denominator*a.numerator);
        t.denominator = denominator*a.denominator;
        t.ultimate();
        return t;
    }
    public Fraction multi(Fraction a)
    {
        Fraction t = new Fraction();
        t.numerator = numerator*a.numerator;
        t.denominator = denominator*a.denominator;
        t.ultimate();
        return t;
    }
    public void set(String s)
    {
        String[] temp = s.split("/"); 
        numerator = Integer.parseInt(temp[0]);
        denominator = Integer.parseInt(temp[1]);
    }
    public boolean equal_after_ultimate(Fraction a)
    {
        int x = numerator*a.denominator;
        int y = a.numerator*denominator;
        if(x > y)
            return true;
        return false;
    }
    public Fraction copy()
    {
        Fraction a = new Fraction();
        a.numerator = numerator;
        a.denominator = denominator;
        return a;
    }
    public String out_file()
    {
        String s ="";
        if(denominator == 1)
            s += numerator;
        else
            s += numerator+"/"+denominator;
        return s;
    }
}
