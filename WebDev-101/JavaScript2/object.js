// empty object
// var obj = {}

// CRUD -> Create, Read, Update, Delete

// object with properties
var obj = {
            name: "Krupakar Reddy",
            age: 18,
            gender: 'M',
            isStudent: false,
            friends: ["Naresh Kumar", "Suraj Guduru"],
            address:{
                country: "India",
                state: "Karnataka",
                city: "Bengaluru",
                pincode: "560037"
            }
        }

console.log(obj);

//dot notation
console.log(obj.name);

//bracket notation
console.log(obj["name"]);

//dot notation with variable -> not possible (use bracket notation)
var Age = "age";

//bracket notation will treat Age as variable
console.log(obj[Age]);

//dot notation will treat Age as property
console.log(obj.Age);

var friendsofKrupakar = obj.friends;
console.log(friendsofKrupakar);

var address = obj.address;
console.log(address.country);
console.log(address.city);

// Update
obj.isStudent = true;
console.log(obj);

obj.friends.push("Rohith Thirunagari");
console.log(obj.friends);

obj.institute = "Scaler School of Technology";

// Delete
delete obj.address.state;
console.log(obj.address);

