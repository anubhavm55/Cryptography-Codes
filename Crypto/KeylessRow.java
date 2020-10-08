import java.util.*;
public class KeylessRow
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String plain,cipher;
        System.out.println("Enter 1 for encryption, 2 for decryption");
        int choice=sc.nextInt();
        int i,j,k;
        int length;
        char c1;
        sc.nextLine();
        switch(choice)
        {
            case 1:System.out.println("Enter plaintext");
                    plain=sc.nextLine();
                    cipher="";
                    length=plain.length();
                    j=0;
                    k=0;
                    String upper="";
                    String lower="";
                    /*creating row matrix of keyless cipher
                    upper contains element that will appear in
                    upper row, lower contains elements that will
                    appear in lower row*/
                    while(j<length)
                    {
                        c1=plain.charAt(j);
                        while(c1==' ')
                        {
                            j++;
                            if(j==length)
                            {
                                break;
                            }
                            c1=plain.charAt(j);
                        }
                        if(j==length)
                        {
                            break;
                        }
                        
                        if(k==0)
                        {
                            upper=upper+c1;
                        }
                        else
                        {
                            lower=lower+c1;
                        }
                        k=(k+1)%2;
                        j++;
                    }
                    System.out.println(upper+lower);
                    break;
            case 2:System.out.println("Enter ciphertext");
                    cipher=sc.nextLine();
                    plain="";
                    length=cipher.length();
                    int cols=(int)Math.ceil(length/2.0);;
                    char mat[][]=new char[2][cols];
                    i=0;
                    //creating row matrix
                    for(j=0;j<2;j++)
                    {
                        for(k=0;k<cols;k++)
                        {
                            if(i==length)
                            break;
                            mat[j][k]=cipher.charAt(i++);
                        }
                    }
                    //creating plaintext
                    i=0;
                    k=0;
                    while(i<cols)
                    {
                        if(k==1)
                        {
                            plain=plain+mat[k][i];
                            i++;
                            k=(k+1)%2;
                        }
                        else
                        {
                            plain=plain+mat[k][i];
                            k=(k+1)%2;
                        }
                        
                    }
                    System.out.println(plain.trim());
                    break;
            default:System.out.println("Please enter correct choice");
        }
    }
}
