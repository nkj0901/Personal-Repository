let student = {
  name: "김싸피",
  age: 20,
  hobby: ["공부", "숙면"],
  "favorite singer": "아이유",
};

// Object -> JSON

let jsonData = JSON.stringify(student)
console.log(jsonData)
console.log(typeof jsonData)


let parseData = JSON.parse(jsonData)

console.log(parseData)
console.log(typeof parseData)
