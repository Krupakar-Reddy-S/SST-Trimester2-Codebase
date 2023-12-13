var a = 10; // global scope

function fxn() {
    console.log(a);
    // var a = 20; // local scope

    
    function gxn() {
        console.log(a); // lexical scope
    }
    gxn();
}

fxn(); // 20, lexical scope