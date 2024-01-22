let fs = require("fs");

// let f1Promise = fs.promises.readFile('f1.txt');
// f1Promise.then(function(dataFile1) {
//     console.log(dataFile1 + "");

//     let f2Promise = fs.promises.readFile('f2.txt');
//     f2Promise.then(function(dataFile2) {
//         console.log(dataFile2 + "");

//         let f3Promise = fs.promises.readFile('f3.txt');
//         f3Promise.then(function(dataFile3) {
//             console.log(dataFile3 + "");
//         });
//     });
// });

// But this creates a Promise Hell: Callback Hell -> Promise Hell
// To avoid this we use Promises Chaining by returning a promise from a then() callback function

// let f1Promise = fs.promises.readFile('f1.txt');
// f1Promise.then(function(dataFile1) {
//     console.log(dataFile1 + "");

//     let f2Promise = fs.promises.readFile('f2.txt');
//     return f2Promise;
// }).then(function(dataFile2) {
//     console.log(dataFile2 + "");

//     let f3Promise = fs.promises.readFile('f3.txt');
//     return f3Promise;
// }).then(function(dataFile3) {
//     console.log(dataFile3 + "");
// });

// Now we got rid of the Promise Hell/Callback Hell
// But this is not the best way to do this because we are creating a new promise everytime
// To avoid this we use Promise.all() method

let f1Promise = fs.promises.readFile('f1.txt', 'utf-8');
let f2Promise = fs.promises.readFile('f2.txt', 'utf-8');
let f3Promise = fs.promises.readFile('f3.txt', 'utf-8');

Promise.all([f1Promise, f2Promise, f3Promise]).then(function(data) {
    console.log(data);
});
