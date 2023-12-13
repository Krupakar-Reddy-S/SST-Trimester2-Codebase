function fxn() {
    let a = 10; // local scope
    function gxn() {
        console.log(a); // lexical scope
    }
    return gxn; // closure
}

let innerFxn = fxn(); // closure

innerFxn(); // 10, lexical scopet