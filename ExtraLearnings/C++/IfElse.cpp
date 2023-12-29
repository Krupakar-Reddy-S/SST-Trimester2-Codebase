#include<bits/stdc++.h>
using namespace std;

const char nl = '\n';

int main(){
    // 1. take an Age as input and return whether the person is eligible to vote or not

    int age;
    cout << "Enter your age: ";
    cin >> age;

    if (age >= 18) {
    cout << "Eligible to vote" << "\n";
    }
    else {
    cout << "Not eligible to vote" << "\n";
    }

    /*
    2. A school has following rules for grading system:
        a. Below 24 - F
        b. 25 to 44 - E
        c. 45 to 49 - D
        d. 50 to 59 - C
        e. 60 to 79 - B
        f. Above 80 - A
    */

    int marks;
    cout << "Enter you marks: ";
    cin >> marks;
   
    if (marks >= 80) {
        cout << "Your Grade is: A" << nl;
    }
    else if (marks <= 79 && marks >= 60) {
        cout << "Your Grade is: B" << nl;
    }
    else if (marks <= 59 && marks >= 50) {
        cout << "Your Grade is: C" << nl;
    }
    else if (marks <= 49 && marks >= 45) {
        cout << "Your Gerade is: D" << nl;
    }
    else if (marks <= 44 && marks >= 25) {
        cout << "Your Grade is: E" << nl;
    }
    else if (marks <= 24 && marks >= 0) {
        cout << "Your Grade is: F" << nl;
    }
    else {
        cout << "Please Enter a valid mark!";
    }

    return 0;
}