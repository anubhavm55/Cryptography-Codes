#include<iostream>
#include<string>
using namespace std;

string get_cipher_text(string plain_text,int key1,int key2)
{
    for(int i=0;i<plain_text.length();i++)
    {
        if(int(plain_text[i])==32)
        continue;
        else
        {
           
            int p=plain_text[i]-97;
            
            p=(((p*key2)%26)+key1)%26;

            p=p+97;
            plain_text[i]=char(p);
        }
    }
    return plain_text;
}

int get_keyInverse(int r2,int r1)
{
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
    }
    
    if(r1==1)
    return t1;
    else 
    return 0;
}

string get_plain_text(string cipher_text,int key1,int key2)
{
        for(int i=0;i<cipher_text.length();i++)
    {
        if(int(cipher_text[i])==32)
        continue;
        else
        {
           
            int p=cipher_text[i]-97;
            
            int k=get_keyInverse(key2,26);
            if(k<0)
            k=k+26;
            p=k*(p-key1)%26;
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
    cout<<"enter additive key"<<endl;
    int key1;cin>>key1;
    cout<<"enter multiplicative key"<<endl;
    int key2;cin>>key2;
    cout<<"cipher text is: "<<get_cipher_text(plain_text,key1,key2)<<endl;
    cout<<"plain text is: "<<get_plain_text(get_cipher_text(plain_text,key1,key2),key1,key2)<<endl;
    return 0;
}
