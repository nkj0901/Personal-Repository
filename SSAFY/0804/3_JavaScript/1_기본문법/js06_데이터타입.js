let num1 = 10;  // number
let num2 = 10.2;
let msg = "hi";  // string
let bool = true;  // boolean
let nullVal = null;  // null
let unVal;  // undefined
let obj = {};  // object
let obj2 = new Object();  //object

console.log("number : " + num1);
console.log("number : " + num2);
console.log("string : " + msg);
console.log("bool : " + bool);
console.log("null : " + nullVal);
console.log("undefined : " + unVal);
console.log("object : " + obj);
console.log("object : " + obj2);

/*
-- 실행결과
number : 10
number : 10.2
string : hi
bool : true
null : null
undefined : undefined
object : [object Object]
object : [object Object]
*/

console.log(typeof ("test"));  // string
console.log(typeof (10));      // number 
console.log(typeof (true));    // boolean
console.log(typeof (null));    // object
console.log(typeof (a));       // undefined
console.log(typeof ({}));      // object
// function : 함수는 특별한 기능을 가진 객체(일급 객체)
console.log(typeof (function () {}));   // function 
console.log(typeof Symbol())  // symbol


// 동적 데이터 타입
var val = 10;
console.log(val, typeof (val));   //  10 'number'
val = "hello";
console.log(val, typeof (val));   //  hello string
val = true;
console.log(val, typeof (val));   //  true 'boolean'
