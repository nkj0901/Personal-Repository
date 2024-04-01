### JdbcTemplate
JdbcTemplate은 JDBC 코어 패키지의 중심 클래스입니다. 

- SQL 쿼리 실행
- 명령문 및 저장 프로시저 호출을 업데이트합니다.
- 인스턴스에 대해 반복을 수행하고 반환된 매개변수 값을 추출합니다.(ResultSet)
- JDBC 예외를 포착하여 패키지에 정의된 일반적이고 더 많은 정보를 제공하는 예외 계층 구조로 변환합니다.  

스프링 공식문서 https://docs.spring.io/spring-framework/reference/data-access/jdbc/core.html#jdbc-JdbcTemplate

TsstDao를 보면 하나는 JdbcTemplate을 썼고 하나는 쓰지 않았다.

jdbcTemplate을 사용하면 데이터베이스와의 상호작용을 단순화하고, 코드를 간경하게 유지할 수 있도록 도와준다.
또한, 스프링 'JdbcTemplate'은 데이터베이스 연결 관리, 예오 처리 등을 자동으로 처리하여 개발자가 직접 처리할 필요가 없게 한다.
따라서, 대부분의 경우에 'jdbcTemplate'을 사용하는 것이 더 편리하고 안정적이라고 한다.