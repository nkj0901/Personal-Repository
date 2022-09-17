//함수안에서 this는 함수를 호출한 객체이다.

var m1 = {name: "홍길동"};
var m2 = {name: "배수지"};
function msg () {
    console.log(this);
    console.log(this.name + "님이 입장함...");
}
m1.msg = msg;
m2.msg = msg;
m1.msg();
m2.msg();