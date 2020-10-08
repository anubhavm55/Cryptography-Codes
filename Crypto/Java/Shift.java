import java.util.*;
public class Shift
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter 1 for encryption, 2 for decryption");
        int choice=sc.nextInt();
        sc.nextLine();
        /*nextInt() does not take \n and since we are going to input
        string next \n would be taken as string. Therefore to remove
        this error we are rejecting \n by reading it but not storing
        it anywhere*/
        String text,s;
        int key,length;
        int i,j;
        char ch,bogus;
        switch(choice)
        {
            case 1:System.out.println("Enter plaintext");
                   text=sc.nextLine();
                   System.out.println("Enter key");
                   key=sc.nextInt();
                   length=text.length();
                   s=""; //String to store ciphertext
                   for(i=0;i<length;i++)
                   {
                       ch=text.charAt(i);
                       if((ch>='a')&&(ch<='z'))
                       {
                           ch=(char)(ch-'a');//subtracting ASCII value from character
                           ch=(char)((ch+key)%26);// doing mod in case of overflow
                           ch=(char)(ch+'a');//adding ASCII value back to get corresponding character
                           s=s+ch;
                       }
                       else if((ch>='A')&&(ch<='Z'))
                       {
                           ch=(char)(ch-'A');//subtracting ASCII value from character
                           ch=(char)((ch+key)%26);// doing mod in case of overflow
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
                   System.out.println("Enter key");
                   key=sc.nextInt();
                   length=text.length();
                   s=""; //String to store plaintext
                   for(i=0;i<length;i++)
                   {
                     ch=text.charAt(i);
                     if((ch>='a')&&(ch<='z'))
                     {
                        ch=(char)(ch-'a');//subtracting ASCII value from character
                        ch=(char)((ch+(26-key))%26);// doing mod in case of overflow
                        ch=(char)(ch+'a');//adding ASCII value back to get corresponding character
                        s=s+ch;
                     }
                     else if((ch>='A')&&(ch<='Z'))
                     {
                        ch=(char)(ch-'A');//subtracting ASCII value from character
                        ch=(char)((ch+(26-key))%26);// doing mod in case of overflow
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