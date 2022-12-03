/*
    - let 키워드를 사용해서 선언한다
    - 변수의 중복 선언이 불가능
*/
let id = "hong";
console.log(id);
let id = "kim";
console.log(id);


//재선언 불가 / 재할당 가능 / 블록스코프
id = "kim";

let job = "teacher";
{
  let job = "student";
}
console.log(job)
