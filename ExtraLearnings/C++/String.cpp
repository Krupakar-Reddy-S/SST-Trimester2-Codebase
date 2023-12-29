#include<bits/stdc++.h>
using namespace std;

const char nl = '\n';

int main(){
    // string is a sequence of characters and the ith character of a string can be accessed using str[i]

    string str = "Hello World";
    cout << str << nl;

    // To get the length of a string, we use str.length() or str.size()
    for (int i = 0; i < str.length(); i++) {
        cout << str[i] << nl;
    }
    
    return 0;
}