let student = {
  name: "김싸피",
  age: 20,
  hobby: ["공부", "숙면"],
  "favorite singer": "아이유",
};

console.log(student.name);
console.log(student[age]); // 에러
console.log(student.hobby);
console.log(student["favorite singer"]);

// 프로퍼티 생성
var member = {};
member["id"] = "ssafy";
member.name = "싸피";



// 프로퍼티 수정
let member = {id: "shy", email: "ssafy@a.com"}
member["id"] = "ssafy";  
member.email = "ssafy@ssafy.com";  

// 프로퍼티 제거
let member = { id: "shy", email: "ssafy@a.com" };
delete member.id;
console.log(member);

//
