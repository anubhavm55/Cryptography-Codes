import java.util.*;
public class KeylessCol 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String plain,cipher;
        System.out.println("Enter 1 for encryption, 2 for decryption");
        int choice=sc.nextInt();
        int i,j,k;
        int length,rows;
        char c1;
        char mat[][];
        sc.nextLine();
        switch(choice)
        {
            case 1:System.out.println("Enter plaintext");
                    plain=sc.nextLine();
                    cipher="";
                    length=plain.length();
                    j=0;
                    k=0;
                    rows=(int)Math.ceil(length/4.0);;
                    mat=new char[rows][4];
                    i=0;
                    for(j=0;j<rows;j++)
                    {
                        for(k=0;k<4;k++)
                        {
                            if(i==length)
                            break;
                            mat[j][k]=plain.charAt(i++);
                        }
                    }
                    for(j=0;j<4;j++)
                    {
                        for(k=0;k<rows;k++)
                        {
                            cipher=cipher+mat[k][j];
                        }
                    }
                    System.out.println(cipher.trim());
                    break;
            case 2:System.out.println("Enter ciphertext");
                    cipher=sc.nextLine();
                    plain="";
                    length=cipher.length();
                    rows=(int)Math.ceil(length/4.0);;
                    mat=new char[rows][4];
                    i=0;
                    for(j=0;j<4;j++)
                    {
                        for(k=0;k<rows;k++)
                        {
                            if(i==length)
                            break;
                            mat[k][j]=cipher.charAt(i++);
                        }
                    }
                    for(j=0;j<rows;j++)
                    {
                        for(k=0;k<4;k++)
                        {
                           plain=plain+mat[j][k];
                        }
                    }
                    System.out.println(plain.trim());
                    break;
            default:System.out.println("Please enter correct choice");
        }

    }
}
