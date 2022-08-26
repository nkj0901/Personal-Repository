function func1(num) {
  return num * num;
}

var func = (num) => {
  return num * num;
}; 

var func = (num) => num * num; // {} 없이 사용할 경우에는 return 문을 생략한다. return 쓰면 에러
console.log(func1(1)); // 1
