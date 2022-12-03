USE world;

SELECT @@autocommit;
SET AUTOCOMMIT=FALSE;

DESC countrylanguage;
DESC country;
DESC city;

SELECT *
FROM countrylanguage;

SELECT *
FROM country;

-- 'AAA'라는 코드를 가진 나라를 추가해줬음.
INSERT INTO country
VALUES('AAA', 'A', 'ASIA', 'EAST ASIA', '111111', NULL, 100000000, 10, 100, 100, 'A', 'FREE','GOOD','11','C');

-- 1. 추가할 수 없는 이유를 생각해서 필요한 부분 수정해서 추가하기
INSERT INTO countrylanguage
VALUES('AAA', '외계어','F','10');

-- 2. countrylanguage에 추가하 수 없는 이유 생각해보고 수정하여 추가하기
-- -> 프라이머리 키인 ABW-Dutch가 이미 있기 때문 (Dutch 뒤에 1을 붙여주었다)
INSERT INTO countrylanguage
VALUES('ABW', 'Dutch1','F','10');

-- 3. country에 다음 자료를 추가할 수 없는 이유를 생각하고 필요한 부분을 수정하여 추가
-- 행을 삽을 할 때 NULL이면 안되는 부분을 채워주지 않았기 때문이다. 마구자비로 채워주자. CODE도 길이 줄여~
INSERT INTO country (code, name, continent, region, surfaceARea, population, localName, governmentform, code2)
VALUES('TCo', 'TCode', 'ASIA', 'TRegion', '11111', '1111111','TCode','TCode', 'TC'); 

-- 4. city에서 id가 2331인 자료의 인구를 10% 증가시킨 후 조회하시오
UPDATE city SET population = population*1.1 where id = 2331;

SELECT *
FROM city
WHERE id = 2331;

-- 5. country에서 code가 'USA'인 자료를 삭제하시오.
-- city와 countryLanguage에 있는 외래키 때문에 프라이머리 키 관계 때문에 지울 수 없음. 다 지워버리자
DELETE FROM country WHERE code = 'USA';
DELETE FROM city WHERE CountryCode = 'USA'; 
DELETE FROM countrylanguage WHERE CountryCode = 'USA';

-- 6. 이제 까지의 DML 작업을 모두 되돌리기 위해 rollback 처리하자
rollback;

-- 7. test_user라는 이름으로 새로운 schema를 생성하시오
-- 8. 만약 user라는 테이블이 있다면 삭제
CREATE SCHEMA test_user;
DROP table if exists user;

-- 9. test_user에 다음 조건을 만족하는 테이블을 생성
CREATE TABLE test_user.user(
	id varchar(50) not null primary key,
    name varchar(100) not null default "익명",
    pass varchar(100) not null
);

desc test_user.user;

-- 10. user 테이블에 다음의 자료를 추가하기
INSERT INTO test_user.user
VALUES ('ssafy', '1234', '김싸피'),
('hong', '5678', '홍싸피'),
('test', 'test', '테스트');

-- 11. id가 test인 계정의 pass를 id@pass형태로 변경하고 조회하시오.
UPDATE test_user.user SET pass = 'id@pass' where id = 'test';

-- 12. id가 test인 계정의 자료를 삭제하고 조회하시오
DELETE FROM test_user.user WHERE id = 'test';

SELECT * FROM test_user.user;

-- 13. 현재까지의 내용을 영구 저장하기 위해서 commit 처리하시오.
commit;

