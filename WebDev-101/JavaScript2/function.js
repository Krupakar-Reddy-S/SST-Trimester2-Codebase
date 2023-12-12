function sayHi() {
    console.log("Hello World!");
}

sayHi();

function serveBevarage(drink="Water", quantity="1") {
    console.log("Here is your " + drink + ", " + quantity );
}

serveBevarage("Coffee", "2 cups");
serveBevarage();


// Function Expression
var sayHiExpression = function() {
    console.log("I am an function expression");
}
console.log(sayHiExpression);

sayHiExpression();

var sayHiArrow = () => {
    console.log("I am an arrow function");
}

sayHiArrow();


// Higher Order Function
function HOF(callback) {
    console.log("I am an Higher Order Function");
    callback();
    console.log("I am an HOF and I am done with my work");
}

HOF(sayHi);


// IIFE -> Immediately Invoked Function Expression
// A function that is executed right after it is created.
// It has no name and is not stored in a variable.

(function() {
    console.log("I am an IIIFE");
})();

// Function in JS are first class citizens as they can be:
// 1. Stored in a variable
// 2. Passed as an argument to another function
// 3. Returned from a function
// 4. Stored in an object or array

// Some simple examples of functions


function add(a, b) {
    return a + b;
}
console.log(add(1, 2));
