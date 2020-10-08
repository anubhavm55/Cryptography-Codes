import java.util.*;
public class playfair
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        //Creating playfair matrix
        String mat[][]={{"L","G","D","B","A"},
                      {"Q","M","H","E","C"},
                      {"U","R","N","IJ","F"},
                      {"X","V","S","O","K"},
                      {"Z","Y","W","T","P"}};
        
        System.out.println("Enter 1 for encryption,2 for decryption");
        int choice=sc.nextInt();
        sc.nextLine();
        String text;
        char ch,ch2;
        int i,length,j,k;
        String text2="";
        int row1,col1,row2,col2;
        row1=row2=col1=col2=-1;
        switch(choice)
        {
            case 1: System.out.println("Enter plaintext");
                    text=sc.nextLine();
                    length=text.length();
                    
                    String cipher="";
                    /*Checking pairwise for same letters
                    to add bogus letter 'X' in between*/
                    for(i=0;i<length-1;i=i+2)
                    {
                        ch=text.charAt(i);
                        ch2=text.charAt(i+1);
                        if(ch!=ch2)
                        {
                            text2=text2+ch+ch2;
                        }
                        else
                        {
                            text2=text2+ch+'X';
                            i--;
                        }
                        
                    }
                    /*If length is odd add 
                    bogus letter in the end*/
                    if(text2.length()%2==1)
                    {
                        text2=text2+'X';
                    }
                    length=text2.length();
                    
                    
                    for(i=0;i<length-1;i=i+2)
                    {
                        ch=text2.charAt(i);
                        ch2=text2.charAt(i+1);
                        for(j=0;j<5;j++)
                        {
                            for(k=0;k<5;k++)
                            {
                                if(mat[j][k].indexOf(ch)!=-1)
                                {
                                    row1=j;
                                    col1=k;
                                }
                                if(mat[j][k].indexOf(ch2)!=-1)
                                {
                                    row2=j;
                                    col2=k;
                                }
                            }
                        }
                        if(row1==row2)
                        {
                            cipher=cipher+mat[row1][(col1+1)%5]+mat[row2][(col2+1)%5];
                        }
                        if(col1==col2)
                        {
                            cipher=cipher+mat[(row1+1)%5][col1]+mat[(row2+1)%5][col2];
                        }
                        if((row1!=row2)&&(col1!=col2))
                        {
                            cipher=cipher+mat[row1][col2]+mat[row2][col1];
                        }
                    }
                    System.out.println("Ciphertext is "+cipher);
                    break;
            case 2: System.out.println("Enter ciphertext");
                    text=sc.nextLine();
                    length=text.length();
                    
                    String plain="";
                    
                    for(i=0;i<length-1;i=i+2)
                    {
                        ch=text.charAt(i);
                        ch2=text.charAt(i+1);
                        for(j=0;j<5;j++)
                        {
                            for(k=0;k<5;k++)
                            {
                                if(mat[j][k].indexOf(ch)!=-1)
                                {
                                    row1=j;
                                    col1=k;
                                }
                                if(mat[j][k].indexOf(ch2)!=-1)
                                {
                                    row2=j;
                                    col2=k;
                                }
                            }
                        }
                        if(row1==row2)
                        {
                            text2=text2+mat[row1][(col1+4)%5]+mat[row2][(col2+4)%5];
                        }
                        if(col1==col2)
                        {
                            text2=text2+mat[(row1+4)%5][col1]+mat[(row2+4)%5][col2];
                        }
                        if((row1!=row2)&&(col1!=col2))
                        {
                            text2=text2+mat[row1][col2]+mat[row2][col1];
                        }
                    }
                    for(i=0;i<length;i++)
                    {
                        if(text2.charAt(i)!='X')
                        {
                            plain=plain+text2.charAt(i);
                        }
                    }
                    System.out.println("Plaintext is "+plain);
                    break;
            default:System.out.println("Please enter correct input");

        }
        
    }
}