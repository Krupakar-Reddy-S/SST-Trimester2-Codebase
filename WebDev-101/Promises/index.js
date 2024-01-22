let myPromise = new Promise(function(resolve, reject) {
    let a = 5;
    let b = 5;

    if (a == b) {
        resolve("Success! yes they are equal");
    }
    else {
        reject("Failed! no they are not equal");
    }
});

console.log(myPromise);

// Promise { <pending> } it is pending because it is not resolved or rejected yet
// to get the result of the promise we use .then() and .catch() methods

// .then() is used when the promise is resolved
// .catch() is used when the promise is rejected

myPromise.then(function(data) {
    console.log("Promise kept");
    console.log(data);
}).catch(function(error) {
    console.log("Promise not kept");
    console.log(error);
});

// .finally is used after the promise is resolved or rejected

myPromise.finally(function() {
    console.log("Done!");
});