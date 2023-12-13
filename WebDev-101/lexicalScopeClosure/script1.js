function fxn() {
    // console.log(a); // ReferenceError: a is not defined
    function gxn() {
        var a = 30; // local scope
        function gxn2() {
            console.log(a); // lexical scope
        }
        gxn2();
    }
    gxn();
}

fxn(); // 30, lexical scope