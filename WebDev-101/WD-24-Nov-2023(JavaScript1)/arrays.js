var arr = ['c', 2, "awff", true, 99];
console.log(arr);

var arr2d = [23,"m", ["ef", 82, false], [0], '1'];
console.log(arr2d);

arr2d[4] = "Hello World";
console.log(arr2d);
console.log(arr2d[2]);

var carCollection = ["Urus", "BMW", "Swift", "Audi"];
console.log(carCollection);

carCollection.push("Nano");
console.log(carCollection);

carCollection.unshift("Ferrari");
carCollection.shift();
console.log(carCollection);

carCollection.pop();
console.log(carCollection);

var deleted = carCollection.splice(2, 2, "random car");
console.log(carCollection);
console.log("deleted elements: " + deleted);

var part = carCollection.slice(1, 3);
console.log(part);