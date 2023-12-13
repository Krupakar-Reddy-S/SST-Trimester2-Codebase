// let a = 10;

// {
//     let a = 20;
//     console.log(a); // 20
// }

// console.log(a); // 10


// let a = 2;
// {
//     let a = 3;
//     {
//         let a = 4;
//         {
//             let a = 5;
//             console.log(a); // 5
//         }
//         console.log(a); // 4
//     }
//     console.log(a); // 3
// }
// console.log(a); // 2


// let a = 10;
// console.log("line number 2", a); // 10
// function fn() {
//     // console.log("line number 4", a); // 10
//     let a = 20;
//     a++;
//     console.log("line number 7", a); // 20
//     if (a) {
//         let a = 30;
//         a++;
//         console.log("line number 11", a); // 20
//     }
//     console.log("line number 13", a); // 20
// }
// fn();
// console.log("line number 16", a); // 10


// var a = 10;
// {
//     var a = 20;
//     console.log(a); // 20
// }


var a = 10;
function fn() {
    console.log("line number 4", a); // 10
    var a = 20;
    a++;
    console.log("line number 7", a); // 20
    if (a) {
        var a = 30;
        a++;
        console.log("line number 11", a); // 20
    }
    console.log("line number 13", a); // 20
}
fn();
console.log("line number 2", a); // 10


