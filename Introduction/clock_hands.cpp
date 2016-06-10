//need some modification
//needs to consider the fact that the small arrow doesn't stay at the same place as the minutes arrow moves

#include <csstudio>
#iclude <cmath>
using namespace std;

int main(){
    
    double angle = 360 / 60;
    int joker, h, tm, um, m;
    double f, s;
     
    while(scanf("%d:%d%d", &h, &tm, &um) && (h || tm || um)) {
               m = tm * 10 + um;
               joker = (h * 5) - m;
               joker = abs(joker);
               f = joker * angle;
               s = 360 - f;
               if ( f >= s) {
                    printf("%d\n", s);   
               }
               else {
                 printf("%d\n", f);
               }                                            
    }
}
