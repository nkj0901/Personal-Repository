#Noom

Zoom Clone using NodeJS, WebRTC and Websockets.

###환경설정
Babel, Nodemon, Express를 활용해서 NodeJS프로젝트를 설정

1. touch README.md
2. npm i nodemon -D
3. babel.config.json 파일 추가
4. nodemon.config.json 파일 추가
5. src 폴더 추가
6. src 디렌토리에 server.js 추가
7. 바벨 설치(git init . 그리고 npm i @babel/core @babelcli @babel/node @babel/preset-env -D  
   @babel/preset-env -> 모든 es6 기능을 컴파일할 모든 plugin 들을 얻은 것. 단순 es6 plugin을 설치한다.
8. .gitignore 파일 만들어주기
9. node_modules는 업로드 하지 않을거니까 안에 /node_modules 넣어주기
10. nodemon 설정 파일에 {"exex" : "babel-node src/server.js(실행할 파일 넣어주기)"}
    babel-node 명령어로 src/server.js를 실행하겠다.
11. package.json에 scripts dev = nodemon 추가
    dev는 nodemon을 호출할거고 그거만 할거다. nodemon이 호출되면 nodemon이 nodemon.json을 살펴보고 거기있는 코드를 실행한다.
12. npm i express 실행
13. npm i pug
14. server.js에 import expree from "express";
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
2. src/views/server.js에 app.set("view engine", "pug");, app.set("views", _dirname + )
