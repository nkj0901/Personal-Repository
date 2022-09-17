// 개수 안중요함.
function fn1(num) {
  console.log("fn1", num);
}
fn1();
fn1(100);
fn1(100, 100);

//
function fn2() {
  console.log(arguments.length);
  for (let i = 0; i < arguments.length; i++) {
    console.log(arguments[i]);
  }
}
fn2(1);
fn2(1, 10, 100);

//
function fn() {
  console.log(1);
}
function fn() {
  console.log(2);
}
function fn(num) {
  console.log(num);
}
fn();
fn(1);

//

function hello(name = "김싸피") {
  console.log(name + "님 안녕하세요.");
}
hello();
hello("양명균");
