#Noom

Zoom Clone using NodeJS, WebRTC and Websockets.

###환경설정
Babel, Nodemon, Express를 활용해서 NodeJS프로젝트를 설정

1. touch README.md
2. npm i nodemon -D 
   nodemon은 파일에 변경사항이 있을 때 마다 서버를 다시 실행시켜준다.
3. babel.config.json 파일 추가
4. nodemon.config.json 파일 추가
5. src 폴더 추가
6. src 디렌토리에 server.js 추가
7. 바벨 설치(git init . 그리고 npm i @babel/core @babelcli @babel/node @babel/preset-env -D  
   @babel/preset-env -> 모든 es6 기능을 컴파일할 모든 plugin 들을 얻은 것. 단순 es6 plugin을 설치한다.
8. .gitignore 파일 만들어주기
9. node_modules는 업로드 하지 않을거니까 안에 /node_modules 넣어주기
10. nodemon 설정 파일에 {"exex" : "babel-node src/server.js(실행할 파일 넣어주기)"}
    만약 어떤 파일을 수정해도 서버가 재시작하는 걸 원하지 않으면 "ignore"이라는 키워드로 설정해주면 된다.
    babel-node 명령어로 src/server.js를 실행하겠다.
    babel은 일반 NodeJS로 코드로 컴파일 해주는 아이
11. package.json에 scripts dev = nodemon 추가
    dev는 nodemon을 호출할거고 그거만 할거다. nodemon이 호출되면 nodemon이 nodemon.json을 살펴보고 거기있는 코드를 실행한다.
12. npm i express 실행
13. npm i pug
14. server.js에 import express from "express";
15. server.js에 app만들어주기 const app = express();
16. 실행 npm run dev
(babel 자체로는 아무것도 안함, plugin이 컴파일, 매번 plugin 패키지 설치, .babelrc에 더하는 것이 귀찮, preset으로 plugin 그룹 한번에 설치
  공식 preset 사용 (@bable/core))


###static 파일과 유저에게 가게 될 파일만들기
webPack은 사용하지 않고 자바스크립트를 유저한테 보내고 그걸 브라우저가 이해할 수 있도록 만들 것

pug는 템플릿 엔진으로 자바스크립트를 사용하여 HTML을 렌더링할 수 있게 해준다. 따라서 기존 HTML과 문법이 살짝 다를 수 있고,
자바스크립트 문법이 들어가기도 한다.
템플릿 엔진에는 대표적으로 퍼그(PUG), 넌적스(Nunjucks), EJS, Handlebars 등이 있다.

1. src/public/js/app.js만들기
2. src/views/server.js에 app.set("view engine", "pug");, 
3. app.set("views", _dirname + "/views");
4. app.set("view engine", "pug");
5. app.use("/public", express.static(__dirname + "/public"));
6. app.get("/", (req, res) => res.render("home"));
7. app.js에서는 FrontEnd에서 구동, server.js는 BackEnd에서 구동
8. public 폴더는 유저들에게 공개하는 것들(보안상으로 안좋을 수 있으니 볼 수 있는 파일을 정해줘야 한다.)

**WebSocket은 http 프로토콜처럼 stateless상태가 아니라 연결되어 있기 때문에 원한다면 서버가 유저에게 메세지를 보낼 수 있다.**  

브라우저에는 내장된 webSocket API가 있다.  
webSocket은 어떤 프로그래밍 언어에 국핸돼 있지 않다. 그저 protocol의 한가지일 뿐이다.
Back-End 사이에서도 Back-End와 브라우저 사이에서도 가능.  

웹소켓 라이브러리 ws(Node.js WebSoket library)  
사용하기 편하고, 아주 빠르며, 클라이언트와 서버사이이 webSocket실행에서 검증됨.  

사용자들이 들어가는 방에 대한 규칙을 개발자들이 코드로 녹여내는 과정을 진행하게 된다.  

ws만을 가지고 사람들이 들어고 나가는 채팅방을 구현할 수 없다. -> ws를 사용한 framework 만들어진 것이 있다.
ws는 그저 webSocket의 core  

1. npm i ws
2. express를 이용해서 http 서버만들기(express서버에 놓고 합치기. express는 http) 
3. expree는 ws를 지원하지 않기 때문에 funtion을 추가해야 된다.
4. http import하고 const server = http.createServer(app); 이제 이 http server에서 webSocket을 만들 수 있다. 
5. import WebSocket from "ws"; 임포트 후, const wss = new WebSocket.Server(); 괄호 안에 굳이 server를 넣지 않아도 됨
6. 이제 http 서버와 webSocket 서버를 둘 다 돌릴 수 있다. http 서버가 필요없다면 안 만들어도 된다. 여기서는 2개가 같은 port에 있길 원하기 때문에, 이렇게 함. http 서버 위에 ws서버를 만들기 위함.

## 환경설정은 모두 끝!!!  
첫번째 connection을 만들거다. ws를 사용해서 back=end와 front-end를 연결. 연결하는데는 추가적인 것의 설치가 필요하지 않다. 브라우저가 해줌(IE, 모바일에서도 가능)  

addEventListener하는 것처럼 이벤트를 걸고 fn을 실행시킬거다.  

webSocket은 LIsten할 특정 이벤트가 있음(close, connection, error, headers, listening)

1. wss.on("connection", handleconnection(funtion)); callback으로 socket을 받는데 이 socket은 연락을 하는 대상의 socket. wss는 connection이라는 이벤트를 기다림. socket은 너(서버)와 브라우저 사이의 연결
2. front-end와 back-end 연결. const socket = new WebSocket(`ws://${window.location.host}`);

3,4는 확인이 필요

3. front-end에 있는 socket은 메시지를 보내는 것. 여기 에서의 socket은 서버와 연결하는 socket
4. back-end에 있는 socket은 메시지를 받는 것. 여기에서의 socket은 우리와 연결되어 있는 브라우저를 의미

- 메세지 보내기  
wss.on("connetion", (socket) => { socket.send("hello!!!") });
- 연결되었을 때 메시지 띄우기  
socket.addEventListener("open", () => {
  console.log("Connected to Server");
})
- 메시지 받은 것을 띄우기  
socket.addEventListener("message", (message) => {
  console.log(message)});
- 서버와 연결이 끊어졌을 때 메시지 띄우기
socket.addEventListener("close", () => { 
  console.log("message");
});

백엔드로 보낼땐 string으로 보내야함 JSON.stringify
왜 object로 보내면 안되지? 왜 string으로 보내줘야 하는걸까?
이렇게 하는 이유는 백엔드가 GO, NODE.js 등 다양할 수 있기 때문에 어떤 한 백엔드에 종속적이면 안됨. 그래서 string으로 바꿔서 보내준다.
