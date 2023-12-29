#include<bits/stdc++.h>
using namespace std;

const char nl = '\n';

int main(){
    int day;
    cout << "Enter a Day number: ";
    cin >> day;

    switch(day) {
        case 1:
            cout << "Monday" << nl;
            break;
        case 2:
            cout << "Tuesday" << nl;
            break;
        case 3:
            cout << "Wednesday" << nl;
            break;
        case 4:
            cout << "Thursday" << nl;
            break;
        case 5:
            cout << "Friday" << nl;
            break;
        case 6:
            cout << "Saturday" << nl;
            break;
        case 7:
            cout << "Sunday" << nl;
            break;
        default:
            cout << "Enter a valid day number!" << nl;
    }

    return 0;
}