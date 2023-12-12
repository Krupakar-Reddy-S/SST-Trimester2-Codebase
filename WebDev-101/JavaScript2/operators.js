// Arithmatic Operators: -, +, * , /, %, **, ++, --
// Relational Operators: ==, ===, !=, !==, >, <, >=, <=
// Logical Operators: &&, ||, !
// Assignment Operators: +=, -=, *=, /=, %=, ?:

var a = 10;
var b = 20;
console.log(a + b);

var a = 10;
var b = "20";
console.log(a + b);

var a = 2;
var b = 1;
console.log(a - b);

var a = 2;
var b = "1";
console.log(a - b);

var a = 2;
var b = "I am a string";
console.log(a - b);
console.log(typeof NaN);

var a = 2;
var b = "I am a string";
console.log(a * b);

var a = "I am a string";
var b = true;
console.log(a + b);

if(3 == "3") { // it only checks the value
    console.log("Both are equal");
} else {
    console.log("Both are not equal");
}

if(3 === "3") { // it checks the value and type
    console.log("Both are equal");
} else {
    console.log("Both are not equal");
}

if(NaN == NaN) {
    console.log("Equal");
} else {
    console.log("Not Equal");
}

var c = 30;
var stringC = String(c);
console.log(typeof stringC);
console.log(typeof c);
