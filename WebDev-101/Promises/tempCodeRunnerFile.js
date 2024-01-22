let f1Promise = fs.promises.readFile('f1.txt');
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