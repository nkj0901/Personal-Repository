사실은 한 페이지에 머물러 있지만, 화면에 보이는 내용을 리액트를 통해

# Router
1. npm install react-Router-dom (리액트에 라우팅 기능을 추가해준다.)

2. src 안에 components, pages 폴더 만들기
컴포넌트 안에 임베드될 컴포넌트들은 components
페이지로 로딩될 컴포넌트들은 pages에 저장하는 식으로 구분
-> 라우터에 의해 로딩되는 페이지로 사용되는 컴포넌트

3. index.js에 import { BrowserRouter } from 'react-router-dom';
BrowserRouter도 하나의 컴포넌트이다. 그래서 html element로 사용할 수 있다.
<BrowserRouter> <App /> </BrowserRouter> App을 BrowserRouter 태그로 감싸준다.
이건 예전에 본 적 없는 비표준 컴포넌트이다. 즉, 비 html 컴포넌트에 의해 감싸져 있는 형태.
우리가 만든 컴포넌트를 wrappable하게 만드는 방법

4. 어떤 url에 어떤걸 보여줄지는 **App.js**에서 해준다.
import { Route } from 'react-router-dom';
BrowserRouter처럼 Route도 컴포넌트이다. 그래서 보통 컴포넌트처럼 사용한다.
<Route path='/'> <실제로 로딩될 컴포넌트를 집어 넣는다.> </Route>

- **에러 기록**
 Uncaught Error: A <Route> is only ever to be used as the child of <Routes> element, never rendered directly. Please wrap your <Route> in a <Routes>.   
요딴 에러가 나는데, 이건 6.x.x을 5.x.x로 버전을 다운 시켜야 해결된다.
npm i react-router-dom@5.2.0

## 충첩된 페이지 만들기
1. import { Route, Switch } form 'react-router-dom' Switch 추가하기
2. 우리가 만든 Router <Switch>태그로 감싸주기. 이렇게 하면 리액트 라우터에게 여러 Route 중에서 단 하나만 활성화하라고 지시할 수 있다.
3. '/', '/favorites'를 같이 Switch 안에 넣게 되면 '/favorites'를 했을 때, '/'가 렌더링되는 문제가 발생한다. 그렇기 때문에 '/' Route에 exact prop을 추가해야 한다. exact={true} exact만 적어줘도 된다.

## 네비게이션 바를 추가해보자
1. components 폴더 아래 layout 폴더만들고 안에 MainNavigation.js 만들기. 이 컴포넌트는 라우터를 통해 페이지로 로딩되지 않기 때문에 component에 만든다.
2. 헤더 아이템에 링크를 걸 때 <a>태그로 링크를 걸면 링크를 클릭할 때마다 새로운 request가 가게 된다. 서버로 요청을 보내게 된다. 서버에 요청을 보내는 것은 굳이 할 필요가 없다. 완전히 새로운 페이지를 얻기 위해 요청을 보낼 필요가 없다는 것.
3. 그래서 react-router-dom에 있는 **Link**를 사용할 것이다. import { Link } from 'react-router-dom'.
4. <Link> 이것도 결국 <a>태그를 렌더링하겠지만 내부적으로 react-router-dom이 <a>태그에 클릭 리스너를 추가한다. 클릭하면 브라우저가 서버로 request하는 것을 방지하고 옮겨가려는 경로의 url을 해석해서 브라우저의 url 창을 변경한다.
5. url은 to props를 이용하여 설정해준다. to="/"

## 스타일 입히기
1. 해당 컴포넌트에만 css 적용되게 하기. css모듈을 활용하자.
2. 우선 css 파일 이름을 특정 방식으로 지정해야 한다. 반드시 이름이 '.module.css'로 끝나야 한다.
3. 해당 css를 js 파일에 임포트한다. import classes(원하는 이름) from './MainNavigation.module.css'
4. 별도의 빌드 과정이 코드가 브라우저에 도착하기 전에 해석하고 변환해주기 때문에 이렇게 css 파일을 import 할 수 있다.
5. className={classes.header} 이런 식으로 설정할 수 있다.

## 배열 받아와서 컴포넌트에 동적으로 출력하기
map을 이용하면 쉽게 렌더링할 수 있다.   

1. JSX 배열로 렌더링 가능 {}를 이용하여 동적 표현식을 쓰고 그 안에 배열을 추가하면 된다.
2. 자바스크립트에는 한 배열을 다른 데이터의 배열로 변환하는 방법이 있다. 배열에 내장 함수인 map을 호출한다. map을 이용하면 함수를 실행할 수 있다.
```js
// 모든 map에 있는 데이터들에 대해 화살표 함수를 실행하겠다는 의미
{ DUMMY_DATA.map( (meetup) => {}) }
```
3. 각 리스트의 자식 노드들은 고유한 key prop을 가져야 한다. 리스트를 효과적으로 업데이트하고 렌더링하기 위해서이다. ex) <li key={meetup.id}>

## 더 많은 리액트 컴포넌트 추가하기
1. components 안에 meetups 폴더를 만든다.
컴포넌트는 아주 작은 단위로 분리하는 것이 좋다. (재사용이 가능할 수 있도록)
2. MeetupItem 컴포넌트 여러개를 MeetupList 컴포넌트에 넣을 것이다. props를 통해 데이터 전달해주기.
3. MeetupList에서 바로 데이터를 불러오지 않고 props로 전달하는 이유는 이 컴포넌트의 재사용성을 높이기 위함이다. Favorites와 MeetupList에서 사용할거다.
4. 배열의 객체를 하나씩 넘겨줄 때에는 key props를 넣어주는 것을 잊지 말자.

## props.children을 이용 이용하여 wrapper 컴포넌트 만들기
1. 그림자가 있는 카드모양으로 보여주고 싶은데, 이 디자인은 흔하기 때문에 재활용가능할 수 있도록 컴포넌트로 만들고 다른 컴포넌트를 감싸는 wrapper로 동작하게 만들 것이다.
2. components 폴더 안에 ui 폴더 만들기
3. 해당 컴포넌트 태그로 원하는 곳을 감싸기
4. 특별한 props를 이용해서 태그 사이에 있는 애들을 어떻게 처리할 것인지 알려주기
5. wrapper 컴포넌트에 매개변수로 props 넣어주고(props.children을 하용하기 위해서 넣어준다.)
6. {props.children} children prop은 모든 컴포넌트가 기본적으로 받아들이는 prop이다. children은 항상 콘텐츠를 가지고 있는다. 오프닝, 클로징 사이에 있는 컴포넌트 텍스트가 그 내용이다. (여기에선 Card 태그 사이에 있는 것들을 말한다.)
7. className이 적용된 div 태그 사이에 {props.children}을 넣어준다.
8. 전체적인 틀을 잡고 싶을 때도 이런 방법을 사용하면 된다. Layout.js 참고

- form 안에 버튼을 넣은 상태에서는 버튼을 누르면 폼이 제출된다.

## 새로운 Meetup 등록하기
1. 우리는 버튼을 누러졌을 때 입력값을 받고, http request를 막아 페이지가 리로딩 되는 것을 막아야 한다. 폼에 버튼이 있을 때 버튼을 클릭하면 디폴트로 submit 이벤트가 발생한다.
2. 우리는 폼이 제출되는 것을 감지해야 한다. form 태그에 **onSubmit={우리가 원하는 로직 구현}**
3. 기본적으로 브라우저는 자동으로 request를 보내려고 한다. 이런 기본 동작을 원하지 않는다. 결국 우리가 만든 로직에서도 request를 보내긴 하지만 브라우저를 리로딩하진 않는다. 이벤트가 일어났을 때, 리액트는 자동으로 함수로 even 인자를 넘긴다. event에는 preventDefault 메소드가 있어서 브라우저의 기본 동작을 막을 수 있게 해준다. event를 매개변수로 받아서 **event.preventDefault();** -> 브라우저의 기본동작 차단
4. 폼에 입력된 값을 읽어오기 위한 방법으로는 useState를 사용하거나 onChange prop 사용하기 두가지 방법이 있다.
5. onChange는 키를 누를 때마다 함수를 트리거한다. 함수를 통해 입력값을 받아오고 state를 업데이트해준다. 하지만 여기에서는 버튼을 눌렀을 당시의 값만 알면 되므로 ref 개념을 사용한다.
6. 리액트는 DOM element로 reference를 설정할 수 있게 해준다. 이를 통해 DOM element에 직접적으로 액세스가 가능하다.
7. **import {useRef} from 'react'**
8. 우리의 함수 컴포넌트 안에서 useRef(); 실행하면 ref 객체, 즉 참조 객체가 생성된다. titleInputRef라는 이름으로 상수로 저장. 값을 가져오고 싶은 태그에 ref prop 설정. ref={titleInputRef}
9. 상수에다가 값 저장하기 const enteredTitle = titleINputRef.current.value;
10. 계속해서 바뀌는 값을 화면에 보여주고 싶은거라면 state를 이용해야 한다.
11. 위에서 상수(enterecTitle)에 저장한 값 이용하여 객체 만들기 등을 통하여 다양한 데이터를 백으로 보낼 수 있다.

## back으로 데이터를 보내기
1. 더비 백엔드를 이용할 것이다 -> firebase
2. request를 보낼 수 있기 데이터베이스에 데이터를 저장할 수도 있다.
3. NewMeetupForm의 Meetup 데이터를 부모 컴포넌트로 포워딩
4. http request를 보내기 위해서는 fetch 함수를 사용한다. 자바 스크립트에서 기본적으로 제공하는 함수로 리액트와는 관련이 없다.
```js
fetch("요청보낼 url/테이블 이름.json"); //테이블 생성
```
5. axios와 같은 서드파티 패키지를 사용할 수도 있다.
6. 진짜 데이터베이스에 저장하려면 post를 사용해야 한다.
7. fetch는 디폴트로 get 요청을 보낸다.
8. get 요청이 아니라 post 요청을 보내려면 두번째 인자를 추가해야 한다.
9. 두번째 인자는 fetch 함수와 http request를 설정할 수 있게 해준다. method 속성을 설정하고 사용할 http 메소드를 정의할 수 있다.
10. headers에는 "Content-Type": "application/json" 등 데이터 타입 설정
19. 함수 실행하면 데이터베이스에 저장되어 있는 것을 볼 수 있다.

## 완료가 되면 화면을 전화시켜주자
1. import {useHistory} from 'react-router-dom' //react에 내장된 hook이다.
2. const history = useHIstory(); //히스토리 구현체 만들어주기
3. fetch로 가져오는 값을 promise 객체로 반환
4. fetch().then(() => {여기 안에 history를 실행하고, 페이지를 전환하는 메소드를 구현}); 
5. push() 메소드는 페이지 더미에 새로운 페이지를 삽입한다. (이전 페이지로 돌아갈 때 사용) 그러므로 여기서는 **history.replace("원하는 페이지  url")** 메소드를 사용한다. 이건 이전 페이지로 돌아가는 "뒤로가기"버튼을 비활성화한다. Link의 to 프롬프트로 연결된다.

## 데이터 가져오기
1. 우리는 데이터베이스에 저장되어 있는 Meetup 리스트를 가져와서 메인화면에 보여주고 싶다. 
2. 그렇다면 이 컴포넌트가 렌더링될 때 http request 보내서 리스트를 받아와야 한다.
3. 컴포넌트 함수에다 데이터를 직접 fetch하는 것이다.
4. 아까처럼 fetch 함수안에 우리 firebase url을 넣어준다.
5. 두번째 인자는 적어주지 않아도 된다.디폴트가 get이고 우리는 get 요청을 해야하므로.
5. fetch는 promise 객체를 반환하므로 .then(response => { return response.json()}).then(data => {});이용. json도 promise를 반환하기 때문에 한번 return 해주고 then을 해줘야한다.
6. react는 동기방식으로 작동해야 하므로 함수 전체를 async, await의 방식으로 만들 수 없다. jsx를 바로 반환해야 함. 응답을 할 때까지 반환을 연결할 수는 없다는 것이다. 로딩 스피너와 같은 임시 jsx 코드를 반환하는 것이다. 로딩이 다 되면 return 코드에 추가해주면 된다.
7. state을 이용하여 특정 조건이 바뀔 때 화면에 표시되는 것을 다르게 나타낼 것이다.
8. useState는 배웠듯이 항상 두 개의 요소를 포함하는 배열을 반환한다. 
9. state로 초기값을 true로 로딩이 완료되면(데이터를 얻으면) false로 바꿔준다. 
10. 상태 업데이트 함수를 호출하면 리액트가 이 컴포넌트 함수를 재실행하고 재평가한 다음에 업데이트된 jsx 코드를 return 한다.
11. 그렇기 때문에 set 함수를 부르면 계속계속 fetch 함수가 다시 실행되어 무한루프가 형성된다.

## useEffect 사용하기
1. 무한루프가 형성되는 것은 매우 흔하고 쉽게 발생하는 문제이기 때문에 리액트 자체로도 해결할 수 있다.
2. 리액트에서 가져올 수 있는 도다른 훅이 있다. 바로 useEffect 훅 import { useEffect } from 'react'
3. useEffect를 사용하며 이 코드가 실행되는 것을 제한하고 실행 조건을 설정할 수 있다.
4. useEffect() 함수를 컴포넌트 함수에 바로 실행
5. useEffect는 두개의 인자를 갖는다. 첫번째 인자는 함수. 두번째 인자는 배열이다.(의존형 배열)
6. 함수안에 배치코드를 실행한다. 여기서는 fetch 함수
7. 두번째 인자의 값이 바뀔 때마다 effect 함수를 실행한다. 의존성을 지정하지 않는다면, effect 함수는 컴포넌트가 실행될 때마다 실행될 것이다. 처음 렌더링될 때 딱 한 번만 실행된다.
(리액트에서 상태 업데이트 함수들은 절대 바뀌지 않는다는 것을 보장한다. 매번 같은 작업을 수행한다.)
9. 우리는 데이터베이스에서 데이터를 가져올 때 배열로 가져오지 않아서 오류를 맞이하게 된다.
10. 주어진 키를 가진 중첩 객체를 만들어 보자
```js
// for/in문 객체의 모든 열거할 수 있는 프로퍼티의 개수만큼 반복적으로 실행하고자 하는 실행문
for(const key in data){
    // 전개 연산자를 이용하여 중첩객체 만들기
    const meetup = {
        id: key,
        ...data[key]
    }
    meetups.push(meetup)
}
```

## 여러개에 영향을 미치는 state를 관리하자

