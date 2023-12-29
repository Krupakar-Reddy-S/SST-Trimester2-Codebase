#include<bits/stdc++.h>
using namespace std;

const char nl = '\n';

int main(){
    
    string str = "Hello World";
    for (int i = 0; i < 5; i++) {
        cout << str + " " << i << nl;
    }
    cout << nl;

    int i = 0;

    while (i < 5) {
        cout << str + " " << i << nl;
        i++;
    }
    cout << nl;

    do{
        cout << str + " " << i << nl;
        i--;
    } while (i > 0);

    return 0;
}