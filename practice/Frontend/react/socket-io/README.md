1. npx create-react-app socket-io
2. npm i nodemon express socket.io cors
3. npm i styled-components'
4. npm i styled-reset


## 2차시도
1. npm i socket.io
2. 일반적으로 React 프로젝트에는 public 폴더나 static 폴더 안에 <div> 요소 하나가 덩그러니 있는 index.html 파일이 존재하기 마련인데요. React 라이브러리는 이 id 속성이 root로 설정되어 있는 <div> 요소의 내용을 동적으로 채워주는 방식으로 동작합니다. 즉, HTML 문서를 만들어내는 과정이 모두 자바스크립트를 통해 브라우저에서 일어나게 되죠.

그러므로 index.html 파일을 열고 <script> 요소를 넣어주기만 하면 일반 웹사이트처럼 자바스크립트를 불러올 수 있습니다. 아마도 이 방법이 React 앱에서 <script> 태그를 사용하는 가장 간단한 방법일 것입니다.

**index.html에 <script src="/socket.io/socket.io.js"></script>추가**

## server 환경설정
1. npm install socket.io
2. npm install http
3. npm install nodemon

```js
const http = require("http");
const express = require("express");
const app = express();
const io = require('socket.io');

const httpServer = http.createServer(app).listen(3000);
// 3000번 포트에서 서버를 오픈한다.

const socketServer = io(httpServer, {
	cors: {
		origin: "*",
		methods: ["GET", "POST"]
	}
});
```

## client 환경설정
1. npm init -y (package.json생성)
2. npm install webpack webpack-cli webpack=dev-server html-webpack-plugin (webpack 설치)
3. npm install @babel/core @babel/preset-env @babel/preset-react babel-loader (babel 설치)
4. npm install react react-router react-router-dom react 설치
5. npm install socket.io-client(socket.io-client 설치)

참고 https://phsun102.tistory.com/89

6. npm i react-select (셀렉트 박스를 만들기 위해)