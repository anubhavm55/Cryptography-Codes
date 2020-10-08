#include<iostream>
#include<string>
using namespace std;

string get_cipher_text(string plain_text,int key)
{
    for(int i=0;i<plain_text.length();i++)
    {
        if(int(plain_text[i])==32)
        continue;
        else
        {
            //  storing the ASCII value of each character except the space character into p
            //  shifting the ASCII value by adding the key value
            //  apply modulo operation
            //  converting the new ASCII value to character equivalent to get cipher text

            int p=plain_text[i]-97;
            
            p=p+key;

            p=p%26;

            p=p+97;
            plain_text[i]=char(p);
        }
    }
    return plain_text;
}

string get_plain_text(string cipher_text,int key)
{
        for(int i=0;i<cipher_text.length();i++)
    {
        if(int(cipher_text[i])==32)
        continue;
        else
        {
            //  storing the ASCII value of each character except the space character into p
            //  shifting the ASCII value by subtracting the key value
            //  if value is negative add 26
            //  apply modulo operation
            //  converting the new ASCII value to character equivalent to get cipher text

            int p=cipher_text[i]-97;
            
            p=p-key;
            if(p<0)
            p=p+26;
            p=p%26;

            p=p+97;
            cipher_text[i]=char(p);
        }
    }
  return cipher_text;
}

int main()
{
    cout<<"enter plain text"<<endl;
    string plain_text;
    getline(cin,plain_text);
    cout<<"enter key"<<endl;
    int key;cin>>key;
    cout<<"cipher text is: "<<get_cipher_text(plain_text,key)<<endl;
    cout<<"plain text is: "<<get_plain_text(get_cipher_text(plain_text,key),key)<<endl;
    return 0;
}
