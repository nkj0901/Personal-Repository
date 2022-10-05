/*
    - const 키워드를 사용해서 선언한다
    - 변수의 중복 선언이 불가능
*/
const id = "hong";
console.log(id);
id = "kim";
console.log(id);

//블록스코프
//대문자 스네이크 케이스
//선언시 값을 할당해야함.
//상수로 사용

// 블록스코프
const a = "aaa"
{
    const a = "bbb"
}


const BIRTHDAY = "2022.08.03"

