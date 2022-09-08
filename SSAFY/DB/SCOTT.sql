DROP DATABASE IF EXISTS `SCOTT`;

CREATE DATABASE `SCOTT` DEFAULT CHARACTER SET utf8mb4;

USE SCOTT;

CREATE TABLE IF NOT EXISTS `BONUS` ( 
`ENAME` varchar(10) DEFAULT NULL,
`JOB` varchar(9) DEFAULT NULL,
`SAL` double DEFAULT NULL,
`COMM` double DEFAULT NULL);

drop table IF EXISTS dept;

CREATE TABLE IF NOT EXISTS `DEPT` ( 
`DEPTNO` int(11) NOT NULL,
`DNAME` varchar(14) DEFAULT NULL,
`LOC` varchar(13) DEFAULT NULL,
PRIMARY KEY (`DEPTNO`));

INSERT INTO `DEPT` (`DEPTNO`,`DNAME`,`LOC`)
VALUES(10, 'ACCOUNTING', 'NEW YORK'),
	  (20, 'RESEARCH', 'DALLAS'),
      (30, 'SALES', 'CHICAGO'),
      (40, 'OPERATIONS', 'BOSTON');

CREATE TABLE IF NOT EXISTS `EMP` ( 
`EMPNO` int(11) NOT NULL,
`ENAME` varchar(10) DEFAULT NULL,
`JOB` varchar(9) DEFAULT NULL,
`MGR` int(11) DEFAULT NULL,
`HIREDATE` datetime DEFAULT NULL,
`SAL` double DEFAULT NULL,
`COMM` double DEFAULT NULL,
`DEPTNO` int(11) DEFAULT NULL,
PRIMARY KEY (`EMPNO`),
KEY `PK_EMP` (`DEPTNO`));

INSERT INTO	`EMP` ( `EMPNO`, `ENAME`, `JOB`, `MGR`, `HIREDATE`, `SAL`, `COMM`, `DEPTNO`)
VALUES 
       (7839, 'KING', 'PRESIDENT', NULL, '1981-11-17 00:00:00', 5000, NULL, 10),
       (7782, 'CLARK', 'MANAGER', 7839, '1981-06-09 00:00:00', 2450, NULL, 10),
       (7934, 'MILLER', 'CLERK', 7782, '1982-01-23 00:00:00', 1300, NULL, 10),
       (7566, 'JONES', 'MANAGER', 7839, '1981-04-02 00:00:00', 2975, NULL, 20),
       (7788, 'SCOTT', 'ANALYST', 7566, '1987-04-19 00:00:00', 3000, NULL, 20),
       (7876, 'ADAMS', 'CLERK', 7788, '1987-05-23 00:00:00', 1100, NULL, 20),
       (7902, 'FORD', 'ANALYST', 7566, '1981-12-03 00:00:00', 3000, NULL, 20),
       (7369, 'SMITH', 'CLERK', 7902, '1980-12-17 00:00:00', 800, NULL, 20),
       (7698, 'BLAKE', 'MANAGER', 7839, '1981-05-01 00:00:00', 2850, NULL, 30),
       (7499, 'ALLEN', 'SALESMAN', 7698, '1981-02-20 00:00:00', 1600, 300, 30),
       (7521, 'WARD', 'SALESMAN', 7698, '1981-02-22 00:00:00', 1250, 500, 30),
	   (7654, 'MARTIN', 'SALESMAN', 7698, '1981-09-28 00:00:00', 1250, 1400, 30),
       (7844, 'TURNER', 'SALESMAN', 7698, '1981-09-08 00:00:00', 1500, 0, 30),
       (7900, 'JAMES', 'CLERK', 7698, '1981-12-03 00:00:00', 950, NULL, 30);
       
       

CREATE TABLE IF NOT EXISTS `SALGRADE` ( 
`GRADE` double DEFAULT NULL,
`LOSAL` double DEFAULT NULL,
`HISAL` double DEFAULT NULL);

INSERT INTO `SALGRADE` (`GRADE`, `LOSAL`, `HISAL`)
VALUES (1, 700, 1200),
       (2, 1201, 1400),
	   (3, 1401, 2000),
       (4, 2001, 3000),
       (5, 3001, 9999);
       
ALTER TABLE `EMP` ADD CONSTRAINT `PK_EMP` FOREIGN KEY (`DEPTNO`) REFERENCES `DEPT` (`DEPTNO`) ON
DELETE SET NULL ON UPDATE CASCADE;

-- 모든 사원 정보 검색
SELECT*FROM emp;

-- 사원이 근무하는 부서 번호
-- 별칭 = AS
SELECT DISTINCT deptno AS "부서번호"
FROM emp;

-- 사원의 이름, 부서번호 업무 조회
SELECT ename, deptno, job FROM emp;

-- 사원의 이름, 사번, 커미션, 급여, 커미션 포함 급여 조회
SELECT ename 이름, empno 사번, comm 커미션,
		sal 급여, sal+comm 커미션포함급여, sal + ifnull(comm, 0) 커미션포함급여2
FROM emp;

-- CASE FUNTION을 써보자
SELECT empno, ename, sal,
	CASE WHEN sal >= 5000 THEN "고액연봉"
		 WHEN sal >= 2000 THEN "평균연봉"
		 ELSE "저액연봉"
	END AS "연봉등급"
FROM emp;

-- 부서 번호가 30인 사원중 급여가 1500 이상인 사원의 이름, 급여, 부서번호 조회
SELECT ename, sal, deptno
FROM emp
where deptno = 30 AND sal >= 1500;

-- 부서 번호가 20 또는 30인 부서에서 근무하는 사원의 사번, 이름, 부서번호 조회
SELECT empno, ename, deptno
FROM EMP
WHERE deptno != 30 AND deptno <> 20;

SELECT empno, ename, deptno
FROM EMP
WHERE NOT (deptno = 30 OR deptno = 20) ;

SELECT empno, ename, deptno
FROM EMP
WHERE deptno NOT IN (30, 20) ;

-- 업무가 MANAGER, ANALYST, PRESIDENT인 사원의 이름, 사번, 업무조회
SELECT ename, empno, job
FROM emp
WHERE job IN ('MANAGER', 'ANALYST', 'PRESIDENT');

-- 급여가 2000이상 3000이하인 사원의 사번, 이름, 급여조회
SELECT empno, ename, sal
FROM emp
WHERE sal BETWEEN 2000 AND 3000;

-- 입사일이 1981년인 직원의 사번, 이름, 입사일 조회
SELECT empno, ename, hiredate
FROM emp
WHERE hiredate BETWEEN '1981-01-01' AND '1981-12-31';

-- 이름이 'A', 'B', 'C'로 시작하는 직원의 사번, 이름 조회
SELECT empno, ename
FROM emp
WHERE ename BETWEEN 'A' AND 'D'; 

-- 커미션이 NULL인 사람의 사번, 이름, 업무, 커미션 조회
SELECT empno, ename, comm
FROM emp
-- WHERE comm = null;
WHERE comm IS NULL;

-- 커미션이 NULL이 아닌 사람의 사번, 이름, 업무, 커미션 조회
SELECT empno, ename, comm
FROM emp
WHERE comm IS NOT NULL;

-- 이름이 M으로 시작하는 사원의 사번, 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE 'M%';

-- 이름에 E가 포홤된 사원의 사번, 이름 조회
-- %는 이 자리에 문자가 몇개가 있어도 상관없다 0이어도 된다.
SELECT empno, ename
FROM emp
WHERE ename LIKE '%E%';

-- 이름의 세번째 알파벳이 'A'인 사원의 사번, 이름 조회
SELECT empno, ename
FROM emp
WHERE ename LIKE '__A%';

-- 모든 직원의 모든 정보를 이름을 기준으로 내림차순 정렬
SELECT *
FROM emp
ORDER BY ename;

SELECT *
FROM emp
ORDER BY ename DESC;

-- 모든 사원의 사번 이름 급여를 조회 급여 내림차순
SELECT ename, empno, sal
FROM emp
ORDER BY sal DESC;

-- 20,30번 부서에 근무하는 사원의 사번, 이름, 부서번호, 급여조회(부서별 오름차순, 급여순 내림차순)
SELECT empno, ename, deptno, sal
FROM emp
ORDER BY deptno, sal DESC;

-- MYSQL FUNCTION 쓰자

-- 아스키 코드값 얻기
SELECT ascii('0'), ascii('A'), ascii('a');

-- CONCAT 메서드를 써보자
SELECT concat('PRESIDENT의 이름은 ', ename, "입니다.") 소개
FROM emp
where job = 'president';

-- 이름의 길이가 5인 직원의 이름을 조회
SELECT ename
FROM emp
where length(ename) = 5;

-- 김싸피
-- length는 바이트, char_length는 문자로 처리
-- 한글은 3바이트로 처리를 하나보다~~
-- 이모지는 4바이트 그래서 위에 mb4로 설정해놈
SELECT length('김싸피'), char_length('김싸피');

-- 문자열 변경
SELECT replace('Hello abc abc', 'abc', 'ssafy');

-- 문자열 인덱스 - 인덱스 1부터 시작
-- 데이터 원래 구분하지만 마이에스큐엘에서 뭔가 설정이 되어있어서 조회가 되는 것이다.
SELECT instr('Hello SSAFY', 'ssafy');

-- 모든 직원의 이름 3자리 조회
SELECT substr(ename, 2, 3)
FROM emp;

-- LPAD RPAD
SELECT lpad('SSAFY', 10, '*'), rpad('SSAFY', 10, '*');

-- REVERSE
SELECT reverse('HELLO SSAFY');
SELECT reverse('우영우역삼역기러기인도인토마토별똥별');

-- 날짜관련함수
-- 2초 더하기 / 727일 더하기 / 오늘은?
SELECT addtime("2022-09-07 21:20:00", "2");
SELECT datediff("2022-04-21", "2022-09-06");
SELECT now(), day(now()), month(now()), year(now()), yearweek(now());

-- 모든 사원에 대하여 사원수, 금여총액, 평균급여, 최고급여, 최저급여 조회
SELECT COUNT(*) 사원수, SUM(sal), avg(sal), max(sal), min(sal)
FROM emp;

-- 부서별로 조회하고, 소수점 둘째자리에서 반올림
SELECT deptno 부서, COUNT(*) 사원수, SUM(sal) 급여총액, round(avg(sal),2) 평균급여, max(sal) 최고급여, min(sal) 최저급여
FROM emp
GROUP BY deptno;

SELECT *
FROM emp
ORDER BY deptno;

SELECT deptno 부서, job 업무, COUNT(*) 사원수, SUM(sal) 급여총액, round(avg(sal),2) 평균급여, max(sal) 최고급여, min(sal) 최저급여
FROM emp
GROUP BY deptno, job
ORDER BY deptno;

-- 급여 커미션 포함 평균이 2000이상인 부서번호, 부서별 사원수, 평균급여(커미션포함) 조회
SELECT deptno 부서번호, COUNT(*) 사원수, round(avg(SAL+IFNULL(comm, 0)),2) "평균급여(커미션포함)"
FROM emp
GROUP BY deptno
HAVING avg(SAL+IFNULL(COMM, 0)) >= 2000;

-- 오토 커밋 안할래
set autocommit = 0;