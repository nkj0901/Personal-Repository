document.title = "내가 컨트롤";

document.body.style.background = "red"; // 배경을 붉은색으로 변경하기

setTimeout(() => (document.body.style.background = ""), 3000); // 원상태로 복구하기
