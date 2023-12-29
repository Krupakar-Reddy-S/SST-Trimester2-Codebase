#include<bits/stdc++.h>
using namespace std;

int main(){

    cout << "Hello World" << endl; // endl is used to print a new line

    cout << "Hello World" << "\n"; // \n is also used to print a new line, and is faster than endl

    int x;
    cin >> x; // cin is used to take input from the user
    cout << "Value of x: " << x << endl;

    int a, b;
    cin >> a >> b; // cin can be used to take multiple inputs
    cout << "Value of a: " << a << " and b: " << b << endl;

    // Note: cin for input of strings uses spaces as delimiters
    // To input a string with spaces, use getline(cin, string_name)

    string sentence;
    getline(cin, sentence);
    cout << sentence << endl;

    return 0;
}