/**
 * 자바스크립트 문자열 - 1
 *
 * - "" 로 감싼다.
 * - '' 로 감싼다.
 * - ``(backtick) 로 감싼다.
 */
let msg = "자바스크립트 문자열";
msg = '자바스크립트 문자열';
msg = `자바스크립트 문자열`;

let name = "홍길동";
msg = `나의 이름은 ${name}입니다.`;

console.log(msg);

let msg2 = `저의
                 이름은
                 홍길동 입니다.`;
console.log(msg2);

console.log('I\'m Father');
console.log('저의 \n 이름은 OOO입니다.')
// https://apps.timwhitlock.info/emoji/tables/unicode#emoji-modal
console.log('\u{1F60B}')

'양명균'.length
'양명균'[1]
'양명균'.charAt(1)
'양명균'[100] //undefined
'양명균'.charAt(100) //빈문자열


/* 
    자바스크립트 문자열 - 2
    
	- 문자열과 숫자 타입의 + 연산의 결과는 문자열
	- 문자열과 숫자 타입의 + 연산 이외의 결과는 숫자
 */
// 하나라도 문자열이면 문자열로 +
// 2+2+'1' ->  '41'
// console.log("1"+2+2); 122
console.log(1 + "20"); // 120
console.log("1" + "20"); // 120
console.log("1" + 20); // 120
console.log("100" - 8); // 92
console.log("100" * 8); // 800

Number('123n')//NaN
Number(' 0123 ')    //123
Number(false)   //0
Number(undefined)   //NaN
Number(null)    //0

String()
