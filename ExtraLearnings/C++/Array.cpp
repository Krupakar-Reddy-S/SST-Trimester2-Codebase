#include<bits/stdc++.h>
using namespace std;

const char nl = '\n';

int main(){
    int arr[5];

    cout << arr[0] << nl;
    cout << arr[1] << nl;
    cout << arr[2] << nl;
    cout << arr[3] << nl;
    cout << arr[4] << nl;

    cin >> arr[0] >> arr[1] >> arr[2] >> arr[3];

    cout << arr[0] << nl;
    cout << arr[1] << nl;
    cout << arr[2] << nl;
    cout << arr[3] << nl;
    cout << arr[4] << nl; // This will print a garbage value as we have not assigned any value to arr[4]

    int arr2[5] = {1, 2, 3, 4, 5}; // This somehow now puts 0 as the value of arr[4]

    int arr3[5] = {1, 2, 3}; // This will put 0 as the value of arr[3] and arr[4]

    int arr4[] = {1, 2, 3, 4, 5}; // This will automatically assign the size of the array

    int arr5[5] = {0}; // This will assign 0 to all the elements of the array

    int arr6[5] = {}; // This will also assign 0 to all the elements of the array

    return 0;
}