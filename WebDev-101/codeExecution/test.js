// abc(); // TypeError: abc is not a function

var abc = function() {
    console.log(" I am a function expression");
}

var abc;
console.log(abc); // [Function: abc]
abc(); // I am a function expression
    