# context와 redux의 차이점

둘 다 저장된 값을 다양한 컴포넌트에서 가져다 쓸 수 있음
컨텍스트는 자주 바뀌는 값에는 적절하지 않다. 많이 사용하다보면 엄청나게 중첩된 JSX를 반환할 수 있다.
하나의 컨텍스트를 만들어서 모든 컴포넌트들을 감싸면 안되냐고 생각할 수 있지만, 그렇게 하면 한 파일에 너무 많은 코드들이 들어가 복잡한 코드로 이뤄지게 되어 
코드관리가 어려워 질 수 있다. 

### 컨텍스트의 단점
1. 복잡한 코드와 관리, 설정
2. 퍼포먼스 문제(고빈도 상태변경에는 적절하지 않음)
(작은 프로젝트에서는 문제가 되지 않을 수 있다. 한계를 알아두자)   
   
이런 단점이 없는, 컨텍스트의 대안 리덕스를 알아보자.   

- 절대로 저장된 데이터를 컴포넌트에서 직접 조작하지 않는다. 리듀서 함수를 이용해서 값을 조정할 것이다.
- 컴포넌트가 Action dipatch(보낸다). Action을 Recucer로 전달한다. Action이 원하는 것을 Reducer가 하게 된다.
- 데이터 저장소의 상태가 업데이트되면 구독 중인 컴포넌트가 알림을 받게 되고 컴포넌트는 UI를 업데이트할 수 있게 된다.

*노드js를 사용하면 브라우저 밖에서 자바스크립트를 사용할 수 있게 된다.
- npm init -y 하기 (여기서 y는 수동으로 yes 입력하지 않고 자동으로 yes라고 입력되게 함)
- npm install redux
- import redux
- 해야할 일 : 저장소 만들기, 리듀스 함수 만들기, 액션과 컴포넌트 만들기

## 해야할 일 시작!
- const store =  redux.createStore();
- reduce 함수 만들기 const counterReducer = (state, action) => {return{counter: state.couter + 1}}; 함수 안에는 부수적인 기능들이 있으면 안된다.
- 리듀스 함수는 항상 2개의 입력이 주어진다 (기존 상태와 액션)
- 생성된 리듀스 함수를 createStore()에 넣어준다.
- 함수가 실행되면 구독하고 있는 아이들에게 알려주기 store.subscribe(counterSubscriber);
- redux-demo.js 실행
- 오류가 뜬다! state에 default값을 설정해주지 않았기 때문(처음 입력할 때) state = { counter: 0}
- dispatch로 action 보내기. action은 자바스크립트 객체이다. 식별자 역할을 하는 타입 프로퍼티를 갖는다. type은 고유한 문자열이어야 한다. store.dispatch({type:"increment"})