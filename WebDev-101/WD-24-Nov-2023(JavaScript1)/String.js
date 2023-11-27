var str = "Hello I am a String";

var arr = [];

var start = 0;

for(var i = 0; i < str.length; i++){
    if(str[i] == " "){
        arr.push(str.substring(start, i));
        start = i+1;
    }
}
arr.push(str.substring(start))

console.log(arr);
