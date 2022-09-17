var arr1 = [];
var arr2 = new Array();

arr1[0] = 10;
arr1[2] = 30;
console.log(arr1[0], arr1[1], arr1[2]);  // 10 undefined 30
console.log(arr1.length);  // 3

arr1[3] = "문자열";
arr1[4] = {};
arr1[5] = [1, 2, 3];
arr1[6] = true;
arr1["msg"] = "가즈아 피자먹으러..";
console.log(arr1);



arr1.push("추가"); // 배열 마지막 추가
arr1.pop() // 배열 마지막 제거
arr1.unshift("추가") // 배열 가장 앞 추가
arr1.shift() // 배열 가장 앞 제거
arr1.includes() //특정값 있는지 판별
arr1.indexOf() // 인덱스 반환 없으면 -1
arr1.join() // 구분자로 연결하여 반환 생략시 쉼표 기본

//ArrayHelper Method
      