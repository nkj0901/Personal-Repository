-- 데이터베이스를 생성하는 명령어
create database ssafy default character set utf8mb4;

-- 모든 데이터베이스 목록 조회
show databases;

-- 데이터베이스를 지워~~
drop database if exists ssafy;

-- 해당 데이터베이스 사용할게
use ssafy;
-- ---------------------------

create table ssafy_member (
	idx int auto_increment,
    user_id varchar(20) not null,
    user_name varchar(20) not null,
    user_pwd varchar(20) not null,
    user_age int,
    email_id varchar(20),
    email_domain varchar(30),
    jointdate timestamp not null default current_timestamp,
    primary key (idx)
);

desc ssafy_member;
-- 전체입력
insert into ssafy_member
values (4, "go", "양", "1234", 55, "godqhr5627", "gmai.com", now());
-- 원하는 컬럼만 입력
insert into ssafy_member (user_id, user_name, user_pwd)
values ("qhr", "균", "3210");

-- 수정
update ssafy_member
set user_name = "anonymous";

update ssafy_member
set email_domain = "ssafy.com"
where email_domain is null;

delete from ssafy_member
where idx = 13;

delete from ssafy_member;

select * from ssafy_member;

-- ---MYSQL 내장함수-----------

-- 2의 3제곱
-- SELECT은 선택해서 보여주는 것이다.
SELECT POW(2,3) AS "2**3";

-- 8 나누기 3의 나머지
SELECT MOD(8, 3) AS "8%3";

-- 최대값, 최소값
SELECT greatest(7,17,86,17,100,77,999,2,13,31,97), least(7,17,86,17,100,77,999,2,13,31,97);

-- 반올림
SELECT round(1526.159), round(1526.159, 0), round(1526.159, 1), round(1526.159, 2), round(1526.159, 3);


