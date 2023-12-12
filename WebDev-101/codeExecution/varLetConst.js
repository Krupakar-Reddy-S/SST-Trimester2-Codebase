console.log(a); // undefined

var a = 10; // initialization
console.log(a); // 10
a = 20; // re assignment

console.log(a); // 20

var a = 30; // re initialization is possible
console.log(a); // 30

// console.log(b); // ReferenceError: Cannot access 'b' before initialization
let b = 10;
console.log(b); // 10

b = 20;
console.log(b); // 20

// let b = 30; // SyntaxError: Identifier 'b' has already been declared
// console.log(b);

const c = 10;
console.log(c); // 10

// c = 30; // TypeError: Assignment to constant variable.
// console.log(c);

// const d; // SyntaxError: Missing initializer in const declaration
// d = 30;

