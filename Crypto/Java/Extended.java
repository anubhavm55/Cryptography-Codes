import java.util.*;
public class Extended
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter two numbers in order a and b where we want to calculate a inverse mod b");
        int a=sc.nextInt();
        int b=sc.nextInt();
        int dup1=a; //Duplicate variables to calculate gcd
        int dup2=b;
        //Calculating GCD
        while(dup1!=dup2)
        {
            if(dup1<dup2)
            {
                dup2=dup2-dup1;
            }
            else if(dup2<dup1)
            {
                dup1=dup1-dup2;
            }
        }
        //GCD stored in dup1 and dup2
        if(dup1!=1)
        {
            System.out.println("Multiplicative inverse not possible");
        }
        else
        {
            //Extended Euclidean Algorithm to calculate Multiplicative Inverse
            int r1=b;
            int r2=a;
            int t1=0;
            int t2=1;
            int q,t,r;
            while(r2>0)
            {
                q=r1/r2;
                r=r1-q*r2;
                r1=r2;
                r2=r;
                t=t1-q*t2;
                t1=t2;
                t2=t;
                if(r1==1)
                {
                    while(t1<0)
                    {
                        t1=t1+b;
                    }
                    System.out.println("Multiplicative Inverse is "+t1);
                    break;
                }
            }
        }
    }
}