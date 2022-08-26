let member1 = {id: "hong", email: "hong@a.com"}
let member2 = member1;
member2.id = "kang";

console.log(member1.id);  // kang
console.log(member2.id);  // kang