import java.util.*;
public class Multi
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 for encryption, 2 for decryption");
        int choice=sc.nextInt();
        sc.nextLine();
        int Z=26;
        String text,s;
        int key,length;
        int i,j,dup1,dup2;
        char ch;
        switch(choice)
        {
            case 1:System.out.println("Enter plaintext");
                   text=sc.nextLine();
                   System.out.println("Enter key present in Z*26");
                   key=sc.nextInt();
                   dup1=Z;
                   dup2=key;


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
                    //Encryption can be done but the resulting ciphertext cannot be decrypted back is gcd is not equal to 1
                    System.out.println("Decryption with this key will not be possible. Please enter a Integer present in Z*26");
                    break;
                 }
                 

                   length=text.length();
                   s=""; //String to store ciphertext
                   for(i=0;i<length;i++)
                   {
                       ch=text.charAt(i);
                       if((ch>='a')&&(ch<='z'))
                       {
                           ch=(char)(ch-'a');//subtracting ASCII value from character
                           ch=(char)((ch*key)%26);// doing mod in case of overflow
                           ch=(char)(ch+'a');//adding ASCII value back to get corresponding character
                           s=s+ch;
                       }
                       else if((ch>='A')&&(ch<='Z'))
                       {
                           ch=(char)(ch-'A');//subtracting ASCII value from character
                           ch=(char)((ch*key)%26);// doing mod in case of overflow
                           ch=(char)(ch+'A');//adding ASCII value back to get corresponding character
                           s=s+ch;
                       }
                       else
                       {
                            s=s+ch;
                       }
                    }
                    System.out.println("Ciphertext is "+s);
                    break;
            
            case 2:System.out.println("Enter ciphertext");
                   text=sc.nextLine();
                   System.out.println("Enter key present in Z*26");
                   key=sc.nextInt();
                   dup1=Z;
                   dup2=key;


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
                    System.out.println("Decryption with this key will not be possible. Please enter a Integer present in Z*26");
                    break;
                 }

                 //Extended Euclidean Algorithm to calculate Multiplicative Inverse
                int r1=Z;
                int r2=key;
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
                            t1=t1+Z;
                        }
                    }
                }
                //Multiplicative Inverse stored in t1

                   length=text.length();
                   s=""; //String to store plaintext
                   for(i=0;i<length;i++)
                   {
                     ch=text.charAt(i);
                     if((ch>='a')&&(ch<='z'))
                     {
                        ch=(char)(ch-'a');//subtracting ASCII value from character
                        ch=(char)((ch*t1)%26);// doing mod in case of overflow
                        ch=(char)(ch+'a');//adding ASCII value back to get corresponding character
                        s=s+ch;
                     }
                     else if((ch>='A')&&(ch<='Z'))
                     {
                        ch=(char)(ch-'A');//subtracting ASCII value from character
                        ch=(char)((ch*t1)%26);// doing mod in case of overflow
                        ch=(char)(ch+'A');//adding ASCII value back to get corresponding character
                        s=s+ch;
                     }
                     else
                     {
                         s=s+ch;
                     }
                    }
                   System.out.println("Plaintext is "+s);
                   break;
            default:System.out.println("Enter correct choice");
        }
    }
}