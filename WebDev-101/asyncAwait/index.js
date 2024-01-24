const fs = require("fs");

async function gxn() {
    console.log("Hello from async function");
}

console.log(gxn()); // Returns a Promise, which will be resolved to undefined (Promise { undefined })

async function gxnWithReturn() {
    console.log("Hello from async function with return");
    return "Returned value from async function";
}

console.log(gxnWithReturn()); // Returns a Promise, which will be resolved to "Returned value from async function" (Promise { "Returned value from async function" })

async function readFiles() {
    console.log("Inside readFiles");

    let f1Promise = fs.promises.readFile(__dirname + '/f1.txt', 'utf-8');
    let f2Promise = fs.promises.readFile(__dirname + '/f2.txt', 'utf-8');
    let f3Promise = fs.promises.readFile(__dirname + '/f3.txt', 'utf-8');

    let f1Data = await f1Promise;
    console.log(f1Data);

    let f2Data = await f2Promise;
    console.log(f2Data);

    let f3Data = await f3Promise;
    console.log(f3Data);
}

console.log("Before calling readFiles");
readFiles(); // Reads contents of f1.txt, f2.txt and f3.txt in sequence and prints them
console.log("After calling readFiles");

// Try This:
function delay(ms) {
    return new Promise(resolve => {
            setTimeout(resolve, ms);
    });
}
console.log(1);
async function exampleAsyncFunction() {
        console.log('Start');
        await delay(2000);
        console.log('After 2 seconds');
        console.log('end')
}
exampleAsyncFunction(); 
console.log(2);

// Output:
// 1
// Start
// 2
// After 2 seconds
// end

