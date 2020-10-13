import java.util.*;
public class Keyed
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array of keys for keyed cipher");
        int key[]=new int[6];
        char keyed[]=new char[6];
        int i,j,k;
        int length;
        char c1;
        //Key for Keyed Cipher
        for(i=1;i<=5;i++)
        {
            key[i]=sc.nextInt();
        }
        String plain,cipher;
        System.out.println("Enter 1 for encryption, 2 for decryption");
        int choice=sc.nextInt();
        sc.nextLine();
        switch(choice)
        {
            case 1:System.out.println("Enter plaintext");
                    plain=sc.nextLine();
                    cipher="";
                    length=plain.length();
                    j=0;
                    while(j<length)
                    {
                        //forming an array of 5 letters
                        for(k=1;k<=5;k++)
                        {
                            if(j==length)
                            {
                                break;
                            }
                            c1=plain.charAt(j);

                            while(c1==' ')
                            {
                                j++;
                                c1=plain.charAt(j);
                            }
                            keyed[k]=c1;
                            j++;
                        }
                        //adding bogus letters
                        while(k<=5)
                        {
                            keyed[k]='z';
                            k++;
                        }
                        //constructing ciphertext according to key 
                        for(k=1;k<=5;k++)
                        {
                            cipher=cipher+keyed[key[k]];
                        }
                        cipher=cipher+" ";
                    }
                    //removing extra space at end
                    System.out.println(cipher.trim());
                    break;
            case 2:System.out.println("Enter ciphertext");
                    cipher=sc.nextLine();
                    plain="";
                    length=cipher.length();
                    j=0;
                    while(j<length)
                    {
                        //creating original 5 letters
                        for(k=1;k<=5;k++)
                        {
                            if(j==length)
                            {
                                break;
                            }
                            c1=cipher.charAt(j);

                            while(c1==' ')
                            {
                                j++;
                                c1=cipher.charAt(j);
                            }
                            keyed[key[k]]=c1;
                            j++;
                        }
                        //constructing 5 letter word removing bogus letter
                        for(k=1;k<=5;k++)
                        {
                            if(keyed[k]=='z')
                            {
                                continue;
                            }
                            plain=plain+keyed[k];
                        }
                        
                    }
                    //removing extra spaces
                    System.out.println(plain.trim());
                    break;
            default:System.out.println("Enter correct choice");
        }
                    


        
        
    }
}