
### Zoom Clone using NodeJS, WebRTC and Websockets.  

# 환경설정
___
## 1. Babel, Nodemon, Express를 활용해서 Node.js프로젝트를 설정  
___

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

___
## 2. static 파일과 유저에게 가게 될 파일만들기  
___
    webPack은 사용하지 않고 자바스크립트를 유저한테 보내고 그걸 브라우저가 이해할 수 있도록 만들 것

    pug는 템플릿 엔진으로 자바스크립트를 사용하여 HTML을 렌더링할 수 있게 해준다. 따라서 기존 HTML과 문법이 살짝 다를 수 있고, 자바스크립트 문법이 들어가기도 한다. 템플릿 엔진에는 대표적으로 퍼그(PUG), 넌적스(Nunjucks), EJS, Handlebars 등이 있다.

1. src/public/js/app.js만들기
2. src/views/server.js에 app.set("view engine", "pug");, 
3. app.set("views", _dirname + "/views");
4. app.set("view engine", "pug");
5. app.use("/public", express.static(__dirname + "/public"));
6. app.get("/", (req, res) => res.render("home"));
7. app.js에서는 FrontEnd에서 구동, server.js는 BackEnd에서 구동
8. public 폴더는 유저들에게 공개하는 것들(보안상으로 안좋을 수 있으니 볼 수 있는 파일을 정해줘야 한다.)

___
## 3. WebSocket
___

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
3. express는 ws를 지원하지 않기 때문에 funtion을 추가해야 된다.
4. http import하고 const server = http.createServer(app); 이제 이 http server에서 webSocket을 만들 수 있다. 
5. import WebSocket from "ws"; 임포트 후, const wss = new WebSocket.Server(); 괄호 안에 굳이 server를 넣지 않아도 됨
6. 이제 http 서버와 webSocket 서버를 둘 다 돌릴 수 있다. http 서버가 필요없다면 안 만들어도 된다. 여기서는 2개가 같은 port에 있길 원하기 때문에, 이렇게 함. http 서버 위에 ws서버를 만들기 위함.  

____
## 4. 환경설정은 모두 끝!!! 첫번째 connection을 만들자
___
    ws를 사용해서 back-end와 front-end를 연결. 연결하는데는 추가적인 것의 설치가 필요하지 않다. 브라우저가 해줌(IE, 모바일에서도 가능)  

    addEventListener하는 것처럼 이벤트를 걸고 fn을 실행시킬거다.  

    webSocket은 Listen할 특정 이벤트가 있음(close, connection, error, headers, listening)

1. wss.on("connection", handleconnection(funtion)); callback으로 socket을 받는데 이 socket은 연락을 하는 대상의 socket. wss는 connection이라는 이벤트를 기다림. socket은 너(서버)와 브라우저 사이의 연결
2. front-end와 back-end 연결. <App.js>에 const socket = new WebSocket(`ws://${window.location.host}`); -> 우리가 어디에 있는지 알려준다.
3. front-end에 있는 socket은 메시지를 보내는 것. 여기 에서의 socket은 서버와 연결하는 socket
4. back-end에 있는 socket은 메시지를 받는 것. 여기에서의 socket은 우리와 연결되어 있는 브라우저를 의미

    <front-end와 back-end 입장에서 모두 생각해보기> 

    - 메세지 보내기  
    wss.on("connetion", (socket) => { 
    
    - 연결되었을 때 메시지 띄우기  
    socket.addEventListener("open", () => {
    console.log("Connected to Server");
    })

    - 메시지 받은 것을 띄우기  
    socket.addEventListener("message", (message) => {
    console.log(message)});  
    여러 종류의 메시지가 있을 때(여러 개의 입력창이 있을 때 ex) 닉네임 입력창, 메시지 입력창) 각각의 메시지에 따라 종류를 만들고 case문으로 처리한다.
    다음에 배울 framework에선 case문을 사용하지 않고 바로 키값으로 이벤트를 걸 수 있다.

    - 서버와 연결이 끊어졌을 때 메시지 띄우기
    socket.addEventListener("close", () => { 
    console.log("message");
    });
   

백엔드와 프론트가 통신할 때 왜 String을 써야 하는걸까?
- 하나의 언어에 종속적이면 안되기 때문에...
____
## 5. 모든 것을 간편하게 만들어줄 framework(SocketIO)를 사용해보자.
___
    참고 https://socket.io/docs/v4/

    이제부터 말하는 이전은 SoketIO를 사용하지 않고 ws만 사용했을 때를 의미함

    SocketIO는 실시간, 양방향, event 기반의 통신을 가능하게 한다. Websoket만을 사용하지 않고 다른 방법도 이용하기 때문에 WebSoket을 지원하지 않는 환경에서도 작동한다. ex) websocket을 연결할 수 없는 경우 HTTP long polling을 사용한다.
    socketIO는 연결이 끊기만 automatic reconnection을 시도한다. firewall, proxy가 있어도 리얼타임으로 작동한다.

실시간 기능 같은 것들을 더 쉽게 만드는 편리한 코드를 제공한다.

1. socket.io 설치 npm i socket.io  
2. 서버 만들기   
<server.js>    
이전에는 http서버를 먼저 만들고 websocket을 만들 때 HTTP를 위에 쌓아올려서 만들었다.  
import SocketIO form "socket.io";
const wss = new WebSocket.Server({ server });를 const io = SocketIO(server);으로 바꿈
3. socket.io의 url은 localhost:3000/socket.io/socket.io.js <home.pug>에 script(scr=
"/socket.io/socket.io.js"), socript(scr="/public/js/app.js")
4. 이전에는 브라우저가 주는 websocket API를 사용하면 되어 아무것도 설치해줄 필요가 없었는데, SoketIO는 더 많은 기능을 주기 때문에 호환이 안됨
5. io는 자동적으로 back-end socket.io와 연결해주는 function이다. 그렇기 때문에 <app.js>에서 socket 연결하는 방법은 const socket = io(); 하면 끝. io function은 알아서 socket.io를 실행하고 있는 서버를 찾는다.

___
## 6. 이제는 public chat이 아니라 room을 만들어서 채팅을 하도록 만들거다.
___

    socket io에는 이미 room 기능이 있음.  
    방을 만드는 것과 방에 들어가는 것은 차이가 없다.
    방을 만드는 것은 방에 사람이 한 명이 있게 되는 것이고 들어가는 것은 사람이 여러명 있는 것이다.

1. 방을 만들거나, 방에 참가할 수 있는 form을 만들자.
2. <app.js> socket.send가 아니라 socket.emit을 사용한다. 예전에는 message만 보낼 수 있었음. 메시지만 보낼 필요가 없고 단지 우리가 원하는 것을 event명을 만들어서 emit해주면 된다. case문으로 함수가 길어지는 걸 막을 수 있음. event명에는 어떤 말이든 사용해도 된다. => custom event!!! 또 이전에는 String만을 보낼 수 있었음. 여기서는 모든 원하는 것을 보낼 수 있다. 객체도 보낼 수 있다. 알아서 object -> String -> object 변환해줌 (ex) socket.emit("room", { payload: input.value }); 이전에는 String으로 바꿔야 했음. 한가지만 보내야한다는 제약이 없어짐. 내가 보내고 싶은걸 다 보낼 수 있다.
3. 3번재 인자(argument)로 callback 함수 만들어주기 / 첫번째 argument는 event이름이 들어간다. 두번째 argument는 보내고 싶은 payload가 들어간다. 마지막 argument는 서버에서 호출하는 function이 들어간다.
<app.js>  
socket.on("enter_room", { payload: input.value }, () => {console.log(msg);});  
<server.js>  
socket.on("enter_room", (msg, done) => {console.log(msg); setTimeout(()=>{backendDone()})}, 10000);  
back-end는 front-end의 함수를 실행해서는 안된다. 그렇게 된다면 엄청난 보안 문제가 생긴다. callback 함수를 back-end에서 실행 명령을 내리면 front-ent에서 실행하게 된다.   
4. 방에 들어가게 만드는 방법은 socket.join("방이름");
5. socket.onAny((event, ...args) => {console.log(`got ${event}`)}); 어느 이벤트간에 수console.log를 할 수 있음
6. 기본적으로 user는 이미 방에 혼자 들어가 있다. 유저의 id는 방의 id와 같다. socketIO에서 모든 socket은 기본적으로 User와 서버 사이에 private room이 있기 때문이다. 어떤 룸에 있는지 알기 위해선 console.log(socket.rooms);
7. 방 나가기 socket.leave("room이름")  
8. 방에 있는 모든 사람에게 메시지 보내기 socket.to("others").emit("an event", { some: "data"}); 여러개의 방에 메시지를 보내려면 to("others")를 체이닝 하면 된다. 나를 제외하고 메시지를 보내준다.
9. roomname input창과 message input창을 둘다 만드는데 처음부터 message창이 있으면 안되기 때문에 쿼리 샐렉터로 가져와서 .hidden = true;로 설정해준다. 방에 들어가면 false로 바꿔주기.
10. 다른 사람 socket id를 가지고 있다면 private Message를 보낼 수 있다. socket.to("another socket id").emit("msg");
)
11. Disconnecting은 고객이 접속을 중단할 것이지만, 아직 방을 완전히 나가지는 않은 상태이다. 완전히 끝나기 전에 굿바이 메시지를 보낼 수 있게 된다.
12. wsServer.sockets.emit("hi", "everyone"); 모든 사람에게 메시지를 보낼 수 있음
13. wsServer.socketsJoin("room"); 강제로 참여하게 할 수 있다.
14. wsServer.in("room").socketsJoin(["room2", "room3"]); room에 있는 모든 사람을 room2, room3에 들어가게 할 수도 있다.
____
## 7. Adapter에 대해 알아보자
___
    Adapter가 기본적으로 하는 일은 다른 서버들 사이에 실시간 어플리케이션 동기화를 하는 것.

    connection이 많아지면 여러 개의 서버를 만들게 될 것이다. 서버들은 각각의 Memory를 가지고 있어서 다른 서버에 있는 memory에 접근할 수 없다.   
    -> Adapter는 DBMS를 사용해서 서버간의 통신을 해준다.
    Adapter에서는 모든 memory의 정보를 볼 수 있다.

Adapter는 누가 연결되었는지, 현재 어플리케이션에 room이 얼마나 있는지 알려줄거다.
wsServer.sockets.adapter<BE>

Adapter에서 확인할 수 있는 것
1. rooms id(rooms)
2. socket id들(sids)

const sids = wsServer.sockets.adapter.sids;
const rooms = wsServer.sockets.adapter.rooms;

Public Room 찾기
rooms id를 socket id에서 찾을 수 없다면, 우리는 Public room을 찾은 것.
rooms id와 socket id 정보는 map으로 되어 있다.
rooms.forEach((_, key) => { if(sids.get(key) === undefined){ console.log(key)})

연결된 모든 소켓에게 메시지 보내기<BE>
wsServer.sockets.emit("room_change", publicRooms());
한 명에게만 보내기<BE>
socket.to(roomName).emit("welcome", socket.nickname);

<FE>
socket.on("room_change", console.log);

disconecting event는 socket이 방을 떠나기 바로 직전에 발생한다.
disconnect는 연결이 끊어졌을 때.

방에 몇명있는지 알아보기<BE>
wsServer.sockets.adapter.rooms.get(roomName)?.size;
___
## 8. Admin UI
___
클라이언트와 서버상태를 볼 수 있음.
프라이빗룸, 퍼플릭룸, 서버 상태를 볼 수 있음.
instrument를 import해주고 server를 만들었던 방식을 약간 수정해준다.

1. npm i @socket.io/admin-ui
2. <BE> const { instrument } = from "@socket.io/admin-ui";
3. 데모가 작동하는데 필요한 환경설정
4. instrument 설정
```js
const { createServer } = from "http";
const { Server } = from "socket.io";
const { instrument } = trom "socket.io/admin-ui";

const httpServer = http.createServer(app);

const wsServer = new Server(httpServer, {
    // 데모가 작동하는 데 필요한 환경설정
    cors: {
        origin: ["https://admin.socket.io"];
        credentials: true
    }
});
instrument(wsServer, {
    auth: false
    //패스워드를 설정하려면
    auth: {
        type: "basic",
        username: "admin",
        password: "@$%DFSDFWEHG!@#FGWEFS.eWDF$$%"
    }
});
```
5. URL 마우스 오른쪽 클릭하여 private 창에서 열기
6. Connection 창 Server URL에 서버 주소/admin
7. path 설정해줄 필요없음.   

___

## 9. 비디오
___

1. 무엇보다도 먼저 유저로부터 비디오를 가져와 화면에 비디오를 보여줘야 한다.
2. 버튼을 만들건데, 마이크를 음소거 및 음소거 해제하는 버튼 카메라를 껏다 켰다 하는 버튼, 전면 후면 카메라 전환.

```js
// <home.pug>
video#myFace(autoplay, playsinline)
//playsinline은 모바일에서 영상을 볼 때 필요한 프로퍼티. 핸드폰에서 영상이 전체화면으로 보여지는 것을 막음
```
3. <FE> const myFace = document.getElementById("myFace");
4. stream은 오디오와 비디오가 합쳐진 것이라는 것을 주의할 것.
Generally, you will accesss the MediaDevices singleton object using navigator.mediaDevices. 유저의 유저미디어 String을 줄거다. 클라이언트가 처음 창을 맞이하게 되면 "카메라를 사용을 허용하겠습니까?"라는 창이 보일 것이다.

```js
let myStream;

async function getMedia(){
    try {
        myStream - await navigator.mediaDevices.getUserMedia( 
            //constraints를 넣는 자리. 기본적으로 우리가 무엇을 얻고 싶은지 적는 곳
            {   
                audio: true,
                video: true,
            }
        )
        // 이 myStream을 myFace 안에 넣어준다.
        myFace.srcObject = myStream;
        } catch(e){
        console.log(e);
    }
}

getMedia();
```
5. home.pug에 button 달아주기 이벤트 달아서 innerText 변경해주기
   
stream의 멋진 점은 우리에게 track이라는 것을 제공해준다는 것이다. 비디오, 오디오, 자막 등 다 track이 될 수 있고 상태를 바꿔줄 수 있다. 접근할 수 있음.

6. 카메라 바꿔주기 기능(아래코드 참조) getMedia()함수는 비디오를 다시 시작하게 만드는 함수이다.

```js
//audio on/off
myStream.getAudioTracks().forEach((track) => (track.enabled = !track.enabled));

//video on/off
myStream.getVideoTracks.forEach((track) => (track.enabled = !track.enabled));


const devices = await navigator.mediaDevices.enumerateDevices();

async function getCameras() {
  try {
    //연결된 모든 장치의 정보를 가져오기
    const devices = await navigator.mediaDevices.enumerateDevices();
    //카메라 정보 가지고 오기
    const cameras = devices.filter((device) => device.kind === "videoinput");
    const currentCamera = myStream.getVideoTracks()[0];
    cameras.forEach((camera) => {
      const option = document.createElement("option");
      option.value = camera.deviceId;
      option.innerText = camera.label;
      if (currentCamera.label === camera.label) {
        option.selected = true;
      }
      camerasSelect.appendChild(option);
    });
  } catch (e) {
    console.log(e);
  }
}
```
7. 셀카와 후면카메라를 설정하는 방법 / 장치를 선택하는 방법
```js
{audio: true, video: {facingMode: {exact: "user"/"environment"}}}
{video: {diviceId: myPreferredCameraDeviceId}}
```

```js
// getMedia할 때 인자(DeviceId)가 없을 때, 문제가 생기지 않기 위하여 initialConstrains 설정
const initialConstrains = { 
    audio = true,
    video = {facingMode: "user"},
}

const cameraConstraints = {
    audio: true,   
    video: {deviceId: mypreferredCameraDeviceId}//이건 이 장치 없으면 다른 걸 연결해줌
    video: {deviceId: {exact: myExactCameraOrBustDeviceId}}//이건 무조건 이 장치만 연결한다. 만약 찾지 못하면 비디오를 보여주지 않는다. 우리는 이걸 사용할 것이다.
}

```
___
## WebRTC
___
Real-Time-Communication

    우리가 chat을 구현했을 때 이건 peer-to-peer이 아니었다. 이때는 서버가 메시지를 받으면 그 메시지를 사용자들에게 보내주는 역할을 했다. 서버를 언제나 사용해야 했다. p2p는 내영상과 내오디오와 내 텍스트가 서버로 가지 않는다는 뜻이다. 브라우저와 브라우저가 바로 연결된다. 우리는 서버가 필요없고, 이게 바로 '실시간(real time)'이 속다가 엄청 빠른 이유이다. webSocket은 Socket이 다른 Socket에게 바로 메시지를 전달하지 못하고 반드시 서버를 거쳐가야 한다.

    webRTC는 서버가 필요하긴한데 영상이나 오디오를 전송하기 위해 필요한 것은 아니다. 서버는 signaling이란걸 하기 위해 서버가 필요하다. signaling이 끝나면 peer-to-peer 연결이 된다.

    브라우저와 브라우저를 연결하려고 하는데, 브라우저가 연결하려는 사람의 ip주소를 알 수 있을까? 하나도 모름. 그래서 우리가 할 것은 브라우저로 하여금 상대가 어디 있는지 알게 해주는 것이다. 브라우저는 서버한테 configuration과 그 브라우저의 인터넷에서의 위치, settings, 방화벽이나 라우터가 있는지 등등의 정보만을 전달한다.

    서버는 어떤 브라우저에게 다른 한 브라우저의 위치를 알려줄 때만 사용된다.

1. welcome, call을 둘 다 있는 상태에서 숨기기만 할 것이다. 왜냐면 사용자가 먼저 room에 참가한 다음에 call을 시작하고 싶기 때문이다.

먼저 따로 설정과 연결이 이뤄진다. 이후 서버를 통해서 둘을 이어줄 것이다. (socket.io를 통해서)

<image src="https://www.dropbox.com/s/1y5z4jkazbkqpjo/WebRTC.PNG?dl=0">

연결하는 것을 해보자.
```js
// app.js
//addStream
myPeerConnection = new RTCPeerConnection();
myStream.getTracks().forEach((track) => myPeerConnection.addTrack(track, myStream));
// 브라우저들을 연결하진 않았지만, 양쪽 브라우저에서 카메라와 마이크의 데이터 Stream을 받아서 그것들을 연결 안에 집어 넣었다.
```
peerA는 offer(다른 사람들이 채팅방에 참여할 수 있도록 초대장을 만다는 것)을 만들어야 함. peerB는 answer을 만든다.
PeerA는 방을 먼저 들어가는 사람

```js
// app.js (A실행)
//createOffer
Socket.on("welcom", async () => {
const = offer = await myPeerConnecton.createOffer();
//setLocalDescription offer에
myPeerConnection.setLocalDescription(offer)
//이제 이 offer을 peerB에게 보내자.
socket.emit("offer", offer, roomName(어디에 보내줄 건지 알려줘야 한다.))
})

// server.js
    socket.on("offer", (offer, roomName)) => {
        socket.to(roomName).emit("offer", offer);
    }

// app.js(B실행)
socket.on("offer", async(offer) => {
    //peerA가 준 LocalDescription을 받기
    mypeerConnection.setRemotDesription(offer);
    const answer = await myPeerConnection.createAnswer();
    myPeerConnection.setLocalDescription(answer);
    socket.emit("answer", answer, roomName); //A가 보내줬던 것처럼 정보 보내주기
})

// server.js
socket.on("answer", (answer, roomName) => {
    socket.to(roomName).emit("answer", answer);
});

// app.js(A실행)
socket.on("answer", answer => {
    myPeerConnetion.setRemoteDescription(answer);
})
```

주고 받는 것이 모두 끝나면 peer-to-peer 연결의 양쪽에서 icecandidate라는 이벤트를 실행하기 시작한다.
ICE라는 것은 Internet Connectivity Establishment(인터넷 연결 생성)   
IceCandidate는 webRTC에 필요한 프로토콜들을 의미. 멀리 떨어진 장치와 소통할 수 있게 해준다. 어떤 소통 방법이 가장 좋은 것인지 제안할 때 쓰는 것. 다수의 candidate(후보)들이 각가의 연결에서 제안되고 그들은 서로의 동의 하에 하나를 선택한다.

이제 해야하는 일은 icecandidate event를 listen하는 것이다.
서로 candidate들을 보내줘야 한다. 

```js
// app.js
// makeConnection() 함수에 icecandidate라는 이벤트를 단다.
myPeerConnection.addEventListener("icecandidate", handleIce);
myPeerConnection.addEventListener("addstream", handleStream);

function handleIce(data){
// 서로 candidate를 주고 받는 함수
    socket.emit("ice", data.cadidate, roomName);
}

function handleAddStream(data){

}

// server.js
socket.on("ice", (ice, roomName) => {
    socket.to(roomName).emit("ice", ice);
})

// app.js
socket.on("ice", ice => {
    myPeerConnection.addIceCandidate(ice);
})
```

카메라를 바꿔도 상대방 화면에선 바뀌지 않는 문제를 해결해보자.
Sender는 우리의 peer로 보내진 media stream track을 컨드롤하게 해준다.
음소거, 카메라 변경 반영을 도와준다.
```js
async function handleCameraChange() {
    await getMedia(camerasSEect.value);
    if(myPeerConnection){
        const videoSender = myPeerConnection.getSenders().find((sender) => sender.track.kind === "video");
        videoSender.replaceTrack()
    }
}
```

아직 폰으로는 테스트를 할 수 없다.
폰으로 테스트를 해보자.
1. npm i lacaltunnel (local tunnel은 서버를 전세계와 공유하게 해준다. 일시적으로만 무료)
2. npm i -g localtunnel
3. lt를 사용해서 local tunnel을 호출할 수 있다.
4. lt --port 3000 => 여기에 url이 나온다.
5. url로 핸드폰 접속 가능함. (이건 stun service로 가능하게 된 것이다.)
6. 하지만 컴퓨터와 폰이 다른 WIFI에 있지 않으면 에러가 생긴다. STUN 서버가 필요하다.

___
## STUN
___

STUN 서버는 컴퓨터가 공용 IP주소를 찾게 해준다.
STUN 서버는 어떤 것을 request하면 인터넷에서 네가 누군지 알려주는 서버이다. **너의 장치에 공용주소를 알려준다.** 구글이 제공해주는 무료 서비스를 이용하는데, 이렇게 테스트가 아니라 진짜 서비스를 운영하게 위해서는 내 소유 STUN 서버를 소유해야 한다.

```JS
function makeConnection() {
  myPeerConnection = new RTCPeerConnection({
    iceServers: [
      {
        urls: [
          "stun:stun.l.google.com:19302",
          "stun:stun1.l.google.com:19302",
          "stun:stun2.l.google.com:19302",
          "stun:stun3.l.google.com:19302",
          "stun:stun4.l.google.com:19302",
        ],
      },
    ],
  });
  myPeerConnection.addEventListener("icecandidate", handleIce);
  myPeerConnection.addEventListener("addstream", handleAddStream);
  myStream
    .getTracks()
    .forEach((track) => myPeerConnection.addTrack(track, myStream));
}
```

## RTCPeerConnection.createDataChannel()
Data Channel는 peer-to-peer 유저가 언제든지 모든 종류의 데이터를 주고 받을 수 잇는 채널이다. Socket.io없이도 채팅을 만들 수 있다. 그냥 채팅을 만들면 메세지가 peer-to-peer로 전달된다. 위치를 계속 보낼 수 있음

```js
// Offerer side
var pc = new RTCPeerConnection(options);
var channel = pc.createDataChannel("chat");
//channel.onopen은 channel.addEventListener("open")과 같다.
channel.onopen = function(event) {
    channel.send('hi you!');
}
channel.onmessage = function(event) {
    console.log(enent.data);
}

//Answerer side
var pc = new RTCPeerConnection(options);
pc.ondatachannel = function(event){
    var channel = event.channel;
    channel.onopne = funtion(event) {
        channel.send('Hi back!');
    }
    channel.onmessage = function(event){
        console.log(event.data);
    }
}

```

webRTC의 안좋은점
    우리가 너무 많은 peer을 가질 때. peer 수가 많아지면 속도가 느려질 것이다. 세명까지만 하는 것이 좋을 것 같다. 다른 사람의 비디오 등을 가져오는데 힘이 너무 든다.
    -> 몇몇 회사는 SFU Selective Forwarding Unit을 이용하는데, 이건 서버에 의존한다. 모두가 스트림을 중앙 서버에 업로드하고 다운로드 하고 있다. 이 서버는 스트림들을 압축하고 있다. 우리가 서버에 업로드하면, 서버는 다른 사람들에게 저사양의 스트림을 제공한다. 누가 말하고 있는지, 누가 스크린을 공유하고 있는지에 따라 사양을 달리하여 제공한다. webRTC는 우리가 최고사양의 스트림을 다운로드하거나 업로드했었다. 채팅을 하거나 위치를 보낼 때에는 상관이 없지만 비디오를 사용할 때에 문제가 생긴다.

    webRTC는 큰 서버가 필요없다는 점에서는 좋다.

    서버가 있는 것이 상관이 없다면 Socket.IO가 좋은 선택
    메세지를 보내는데 서버가 필요없다면 Data Channel이 한 가지 방법이 될 것 같다.

## Data Channel

offer을 만들기 전에 Data Channel을 만들어야 한다.

```js
// 이 부분은 A에게 일어나는 일
socket.on("welcome", async () => {
  myDataChannel = myPeerConnection.createDataChannel("chat");
  myDataChannel.addEventListener("message", (event) => console.log(event.data));
  console.log("made data channel"); //다른 Peer은 다른 채널을 만들 필요가 없다.
  const offer = await myPeerConnection.createOffer();
  myPeerConnection.setLocalDescription(offer);
  console.log("sent the offer");
  socket.emit("offer", offer, roomName);
});

// 이 부분은 B에게 일어나는 일
socket.on("offer", async (offer) => {
  myPeerConnection.addEventListener("datachannel", (event) => {
    myDataChannel = event.channel;
    myDataChannel.addEventListener("message", (event) =>
      console.log(event.data)
    );
  });
  console.log("received the offer");
  myPeerConnection.setRemoteDescription(offer);
  const answer = await myPeerConnection.createAnswer();
  myPeerConnection.setLocalDescription(answer);
  socket.emit("answer", answer, roomName);
  console.log("sent the answer");
});

// 메시지를 보내는 방법
myDataChannel.send("hello")
```

console 찍어가면서 data 조회해보기




