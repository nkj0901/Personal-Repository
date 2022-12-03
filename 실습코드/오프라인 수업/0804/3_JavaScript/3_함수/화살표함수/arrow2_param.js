function func1(num) {
  console.log("func1", num);
};
func1(1);

// 매개변수가 하나있는 경우
var func2 = (num) => {
  console.log("익명 func2", num);
};
func2(2);

var func2 = num => {
  console.log("익명 func2", num);
};
func2(3);


var func3 = function (num1, num2) {
    console.log("익명함수 func3", num1, num2);
}
func3(1, 2);

// 매개변수가 여러개인 경우는 (..)로 묶어서 선언해야 함..
func3 = (num1, num2) => {
    console.log("익명함수 func3", num1, num2);
}
func3(10, 20);
