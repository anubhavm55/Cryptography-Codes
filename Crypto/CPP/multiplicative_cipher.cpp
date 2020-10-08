#include<iostream>
using namespace std;

int find_multiplicative_inverse(int r2,int r1)
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

int main()
{
    cout<<"enter the number"<<endl;
    int b;cin>>b;
    cout<<"enter modulo number"<<endl;
    int n;cin>>n;
    int x=find_multiplicative_inverse(b,n);
    if(x<0)
    cout<<"multiplicative inverse is: " <<x+n<<endl;
    if(x==0)
    cout<<"multiplicative inverse does not exist"<<endl;
    return 0;
}
