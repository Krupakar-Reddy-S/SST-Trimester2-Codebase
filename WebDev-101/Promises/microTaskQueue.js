function logA() { console.log('A') }
function logB() { console.log('B') }
function logC() { console.log('C') }
function logD() { console.log('D') }
function logE() { console.log('E') }

logA();
setTimeout(logB, 0);
Promise.resolve().then(logC);
Promise.resolve().then(logE);
logD();

// Output: A D C E B

// Reason: A, D are logged first because they are in the call stack
// C, E are logged next because they are in the microtask queue
// B is logged last because it is in the callback queue
