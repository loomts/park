#include <bits/stdc++.h>
#define fi first
#define se second
#define endl '\n'
#define lowbit(x) x&-x
using namespace std;

const int maxv=1e6+100;
const int mod=2008;
const int maxNum=0x7fffffff-10;
const double eps=1e-8;
const double PI=3.1415926535;
typedef long long LL;

inline int read(){
    int x=0, f=1;
    char ch=getchar();
    while (ch < '0' || ch > '9'){
        if (ch == '-') f = -1;
        ch = getchar();
    }
    while (ch >= '0' && ch <= '9'){
        x = (x << 1) + (x << 3) + (ch ^ 48);
        ch = getchar();
    }
    return x * f;
    //    return x;
}
inline void write(__int128 x){
    if (!x) putchar('0');
    char F[200];
    __int128 tmp = x > 0 ? x : -x;
    if (x < 0) putchar('-');
    int cnt = 0;
    while (tmp > 0) F[cnt++] = tmp % 10 + '0',tmp /= 10;
    while (cnt > 0) putchar(F[--cnt]);
    // putchar('\n');
    // putchar(' ')
}
char getn(){return rand()%10+'0';}
char getch(int ind){if(!ind) return rand()%26+'a';return rand()%26+'A';}
FILE *fp1=fopen("test5.out", "w");
FILE *fp2=fopen("test6.out", "w");
FILE *fp3=fopen("test7.out", "w");
void printtest5(int ind){
    fprintf(fp1,"{");
    fprintf(fp1,"errcode: \"0.0\",");
    fprintf(fp1,"errmsg: \"\",");
    fprintf(fp1,"data: [");
    fprintf(fp1,"{");
    fprintf(fp1,"id: \"%c%c%c%c%c%c%c%c-%c%c%c%c-%c%c%c%c-%c%c%c%c-%c%c%c%c%c%c%c%c%c%c%c%c\",",getch(0),getch(0),getn(),getn(),getch(0),getch(0),getch(0),getch(0),getn(),getch(0),getch(0),getch(0),getn(),getn(),getn(),getn(),getch(0),getch(0),getch(0),getn(),getn(),getch(0),getch(0),getch(0),getn(),getn(),getch(0),getch(0),getch(0),getn(),getn(),getch(0));
    fprintf(fp1,"name: \"device%d\",",ind);
    fprintf(fp1,"esn: \"%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c%c\",",getn(),getn(),getn(),getn(),getn(),getn(),getn(),getch(1),getch(1),getch(1),getn(),getn(),getn(),getn(),getn(),getn(),getn(),getn(),getn(),getn());
    fprintf(fp1,"deviceIp: \"10.1%c%c.1%c.%c%c\",",getn(),getn(),getn(),getn(),getn());
    fprintf(fp1,"neType: \"%c%c%c%c%c-%c%c%c-%c%c-%c%c\",",getch(1),getn(),getn(),getn(),getn(),getn(),getn(),getn(),getch(1),getch(1),getch(1),getch(1),getch(1));
    fprintf(fp1,"status: 0,");
    fprintf(fp1,"gisLon: \"%.1lf\",",121.4+(getn()-'0')+(getn()-'0')*0.1-(getn()-'0')-(getn()-'0')*0.1);
    fprintf(fp1,"gisLat: \"%.1lf\",",31.2+(getn()-'0')+(getn()-'0')*0.1-(getn()-'0')-(getn()-'0')*0.1);
    fprintf(fp1,"traffic: \"%d.%d\",",(getn()-'0'+1)*1000+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'),(getn()-'0'));
    fprintf(fp1,"onlineUsers: %d,",(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp1,"cpuRate: %d,",rand()%80+20);
    int upwardSpeed1=(getn()-'0')*1000+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0');
    fprintf(fp1,"upwardSpeed: \"%d.%d\",",upwardSpeed1,(getn()-'0'));
    fprintf(fp1,"downwardSpeed: \"%d.%d\",",upwardSpeed1+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'),(getn()-'0'));
    fprintf(fp1,"mac: \"%c%c:%c%c:%c%c:%c%c:%c%c:%c%c\"",getn(),getn(),getn(),getch(1),getch(1),getn(),getn(),getn(),getch(1),getch(1),getch(1),getn());
    fprintf(fp1,"}");
    fprintf(fp1,"]");
    fprintf(fp1,"}");
    fprintf(fp1,"\n");
}
void printtest6(){
    fprintf(fp2,"{");
    fprintf(fp2,"errcode: \"0.0\",");
    fprintf(fp2,"errmsg: \"\",");
    fprintf(fp2,"data: [");
    fprintf(fp2,"{");
    fprintf(fp2,"siteId: \"%c%c%c%c%c%c%c%c-%c%c%c%c-%c%c%c%c-%c%c%c%c-%c%c%c%c%c%c%c%c%c%c%c%c\",",getch(0),getch(0),getn(),getn(),getch(0),getch(0),getch(0),getch(0),getn(),getch(0),getch(0),getch(0),getn(),getn(),getn(),getn(),getch(0),getch(0),getch(0),getn(),getn(),getch(0),getch(0),getch(0),getn(),getn(),getch(0),getch(0),getch(0),getn(),getn(),getch(0));
    if(getn()<=8+'0') fprintf(fp2,"deviceHealth: 100,");
    else fprintf(fp2,"deviceHealth: %d,",(90+(getn()-'0')));
    if(getn()<=7+'0') fprintf(fp2,"radioHealth: 100,");
    else fprintf(fp2,"radioHealth: %d,",(90+(getn()-'0')));
    if(getn()<=8+'0') fprintf(fp2,"siteHealth: 100,");
    else fprintf(fp2,"siteHealth: %d",(90+(getn()-'0')));
    fprintf(fp2,"}");
    fprintf(fp2,"]");
    fprintf(fp2,"}");
    fprintf(fp2,"\n");
}
void printtest7(){
    fprintf(fp3,"{");
    fprintf(fp3,"errcode: \"0.0\",");
    fprintf(fp3,"errmsg: \"\",");
    fprintf(fp3,"data: ");
    fprintf(fp3,"{");
    fprintf(fp3,"exprWorse: %d,",(getn()-'0'));
    fprintf(fp3,"exprBad: %d,",(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"exprGood: %d,",1000+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"exprBetter: %d,",(getn()-'0')*1000+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"speedBad: %d,",(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"speedGood: %d,",(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"speedBetter: %d,",(getn()-'0')*1000+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"oneHour: %d,",(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"oneToTwoHour: %d,",(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"twoToFourHour: %d,",(getn()-'0')*1000+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"fourToSixHour: %d,",(getn()-'0')*1000+(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"sixToEightHour: %d,",(getn()-'0')*100+(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"eightHour: %d,",(getn()-'0')*10+(getn()-'0'));
    fprintf(fp3,"}");
    fprintf(fp3,"}");
    fprintf(fp3,"\n");
}
signed main(){
    for(int i=1;i<=1e3;i++) printtest5(i);
    //for(int i=1;i<=1e3;i++) printtest6();
    //for(int i=1;i<=1e3;i++) printtest7();
    fclose(fp1);//fclose(fp2);fclose(fp3);
    return 0;
}