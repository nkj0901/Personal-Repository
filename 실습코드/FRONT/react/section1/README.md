# React란?
사용자 인터페이스 구축을 위한 자바스크립트 라이브러리.

자바스크립트 구문 속에 HTML 코드를 쓴다.
빌드단계를 거쳐야하기 때문에 파일이 다양하게 여러가지가 있다.

1. node.js 설치
서버 자동 리로딩, 코드를 브라우저에서 작동하게 만들기 위해. create-react-app을 설치하고 설치 후 사용할 때 내부적으로 계속 node.js를 쓰게 되기 때문에 설치가 필요함.
2. Create React App
```js
//원하는 폴더 위치로 이동한 후에 아래 코드 실행
npx create-reate-app my-app(내가 원하는 이름)
//위 코드를 수행하면 원하는 폴더 위치 안에 내가 지정한 이름으로 react 프로젝트가 생긴다.
cd my-app
//npm은 node package manager
npm start
```
3. server 종료는 ctrl+c
    
4. **index.js**가 우리 프로젝트의 시작점이 된다. 여기에 작성하는 코드가 브라우저에서 실행되는 최초의 코드이다.   
자바스크립트 구문 안의 HTML 코드는 빌드를 통해서만 사용 가능하다. 이런 코드를 jsx라고 한다.
```js
ReactDOM.render(<App />, document.getElementById('root'));
//root라는 것 아래 <App>을 render할거다.
```

5. **index.html**은 이 프로젝트에서 유일한 html 파일이다. 리액트가 그 파일상의 DOM과 화면에 표시되는 내용을 제어한다.
6. **APP.js**는 함수이다. export해서 밖에서 사용하도록 만든 함수. 특이한 점은 **jsx 코드를 리턴**한다는 것이다. 이것이 바로 리액트 컴포넌트이다.
html element처럼 사용할 수 있다. 컴포넌트는 반드시 결과값을 리턴해야 한다. 보통 html인 경우가 많다.
7. 개발 서버는 자동으로 리로딩 된다.
8. 함수안에 적힘 html 코드는 진자 html element가 아니라 자바스크립트 언어로 작동한다. 그렇기 때문에 태그안에 class를 입력하면 자바스크립트 키워드 class로 인식하기 때문에
className으로 class를 설정해야 한다.
9. 보통 App.js를 제외한 components는 폴더를 만들어 따로 저장한다.
10. **함수명는 무조건 대문자로 시작해야 한다** html element로 사용하려면 대문자로 시작해야 한다. 
왜냐하면 내장 html element와 구분할 수 있기 때문이다. 사용자 정의 html element는 대문자로 시작해야 한다. 원하는 곳에 import해주고(.js는 생략가능) <함수명 />으로 원하는 곳에 넣어주기

## props
1. 모든 함수 컴포넌트가 매개변수(props(아무 이름이나 상관없음))를 받을 수 있음
2. <Todo text="내가 원하는 내용 넣기"/> 이런식으로 사용자 정의 html element를 넣고 props도 전달해줄 수 있다.
3. props는 자바스크립트 객체이고 key-value형태로 들어오게 된다.
4. 보통 자바스크립트에서 객체 속성을 점 표기법으로 사용한다. ex)props.text 이렇게만 적으면 이 텍스트 그대로 출력되어 버린다. html element나 단순 텍스트로 인식되기 때문이다.
jsx 코드에서도 동적 표현식을 사용할 수 있다. **단순 텍스트가 아니라 자바스크립트로 취급하라고 지시해야 한다. {}을 사용한다.** {}안에 한줄 표현식은 아무거나 쓸 수 있지만 block문을 쓸 수 없다. ex) if문


## event
1. 리액트에서는 선언형 접근을 사용한다. 목표 결과를 기술하는 방식
2. onClick={function() {} } 또는 onClick={ () => {} } 또는 onClick={함수이름} (여기에 있는 함수는 실행하지 않을 거니까 ()을 넣으면 안된다. 버튼을 클릭했을 때 함수를 실행하고 싶지 코드가 검증되는 순간에 실행하고 싶은게 아니다.)
3. 함수를 만들어서 함수명을 onClick에 달고 싶으면, 해당 파일의 함수 안에 중첩된 함수로 만들어야 한다.
*사담, 특정 이벤트가 Handler를 통해 일어났을 때 호출되는 함수인 경우 이벤트 이름에 Handler를 붙이는 규칙이 좋다.

## 레이어 창 만들기


vscode 추천 extensions
1. prettier   
단축키 확인 file - preference - keyboard shortcuts 
file - setting - formatter -> 기본 포매터를 prettier으로 설정
2. Material Icon Theme    
파일 아이콘을 바꿔줌
