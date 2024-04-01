USE 'SCOTT';

-- 사번이 7788인 사원의 부서 이름을 조회하고 싶다
SELECT deptno
FROM emp
WHERE empno = 7788;

SELECT dname
FROM dept
WHERE dept.DEPTNO = (SELECT deptno
					 FROM emp
					 WHERE empno = 7788);
                     
-- 매니저 이름이 king인 사원의 사번, 이름, 부서번호, 업무 조회
SELECT empno
FROM emp
WHERE ename = 'KING';

SELECT empno, ename, deptno, job
FROM emp
WHERE mgr = (SELECT empno
			 FROM emp
			 WHERE ename = 'KING');
             
-- 7566 사원보다 급여를 많이 받는 사원의 이름, 급여를 조회
SELECT sal
FROM emp
WHERE empno = 7566;

SELECT ename, sal
FROM emp
WHERE sal > (SELECT sal
			 FROM emp
			 WHERE empno = 7566);
             
-- 20번 부서의 평균 급여보다 급여가 많은 사원의 사번, 이름, 업무, 급여조회
SELECT AVG(sal)
FROM emp
WHERE deptno = 20;

SELECT empno, ename, job, sal
FROM emp
WHERE sal > (SELECT AVG(sal)
			 FROM emp
			 WHERE deptno = 20)
ORDER BY SAL;

-- 업무가 'TURNER'와 같고 사번이 7934인 직원보다 급여가 많은 사원의 사번, 이름, 업무를 조회
SELECT job
FROM emp
WHERE ename = 'TURNER';

SELECT sal
FROM emp
where empno = 7934;

SELECT empno, ename, job, sal
FROM emp
WHERE job = (SELECT job
			 FROM emp
			 WHERE ename = 'TURNER')
AND sal > (SELECT sal
		   FROM emp
		   where empno = 7934)
AND ename != 'TURNER';

-- 다중행 IN / ANY / ALL
-- 업무가 SALESMAN인 직원들 중 최소 한명 이상보다 많은 급여를 받는 사원의 이름, 급여, 업무를 조회하시오.
SELECT sal
FROM emp
WHERE job = 'SALESMAN';

SELECT ename, sal, job
FROM emp
WHERE sal > ANY (SELECT sal
			FROM emp
			WHERE job = 'SALESMAN'); 
            -- 하나라도 크면 됨
            -- > ANY (최솟값보다는 커야해) < ANY (최대값보다는 작아야해)  

-- 업무가 SALESMAN인 모든 직원보다 급여(커미션포함)를 많이 받는 사원의 이름, 급여, 업무, 입사일, 부서번호 조회
SELECT sal + ifnull(comm, 0)
FROM emp
WHERE job = 'SALESMAN';

SELECT ename, sal, job, HIREDATE, deptno
FROM emp
WHERE sal + ifnull(comm, 0) > ALL (SELECT sal
								   FROM emp
								   WHERE job = 'SALESMAN');
                                   -- > ALL 최대값보다 큼 / < ALL 최소값보다 작음
                                   
-- 직원이 최소 한 명이라도 근무하는 부서의 부서번호, 부서이름, 위치
SELECT DISTINCT deptno
FROM emp;

SELECT deptno, dname, loc
from dept
WHERE deptno in (SELECT DISTINCT deptno
				 FROM emp);
                 
-- 이름이 ford인 사원과 매니저 및 부서가 같은 사원의 이름, 매니저 번호, 부서번호를 조회
SELECT mgr, deptno
FROM emp
WHERE ename = 'FORD';

SELECT ename, mgr, deptno
FROM emp
WHERE (mgr, deptno) = (SELECT mgr, deptno
						FROM emp
						WHERE ename = 'FORD')
AND ename != 'FORD';

-- 각 부서별 입사일이 가장 빠른 사원의 사번, 이름, 부서번호, 입사일 조회
SELECT ifnull(deptno, "대기발령"), MIN(hiredate)
FROM emp
GROUP BY deptno;

SELECT empno, ename, deptno, hiredate
FROM emp
WHERE (deptno, hiredate) IN (SELECT ifnull(deptno, "대기발령"), MIN(hiredate)
							FROM emp
							GROUP BY deptno); -- 여러 행이니까 in을 이용해야 함

-- 소속 부서의 평균 급여보다 많은 급여를 받는 사원의 이름, 급여, 부서번호, 입사일, 업무를 조회
SELECT AVG(sal)
FROM emp
GROUP BY deptno;

SELECT ename, sal, deptno, hiredate, job
FROM emp e
WHERE sal > (SELECT AVG(sal)
			 FROM emp
			 WHERE deptno = e.deptno);
             
-- 모든 사원의 평균급여보다 적게 받는 사원들과 같은 부서에서 근무하는 사원의 사번, 이름, 급여, 부서번호를 조회
SELECT AVG(sal)
FROM emp;

SELECT DISTINCT deptno
FROM emp
WHERE sal < (SELECT AVG(sal)
			 FROM emp); 
             
SELECT e.empno, e.ename, e.sal, e.deptno
FROM emp e, (SELECT DISTINCT deptno
			 FROM emp
			 WHERE sal < (SELECT AVG(sal)
						  FROM emp)) d -- join 하는 것처럼
WHERE  e.deptno = d.deptno;   

-- 모든 사원에 대하여 사원의 이름, 부서번호, 급여, 사원이 소속된 부서의 평균 급여를 조회
SELECT deptno, AVG(sal) as sal
FROM emp
GROUP BY deptno;

SELECT ename, e.deptno, e.sal, d.sal
FROM emp e, (SELECT deptno, AVG(sal) as sal
			 FROM emp
			 GROUP BY deptno) d
WHERE e.deptno = d.deptno
ORDER BY ename;

-- 스칼라서브쿼리
-- 사원이름, 부서번호, 급여, 소속부서의 평균급여를 조회
SELECT AVG(sal)
FROM emp
WHERE deptno = d.deptno;


SELECT ename, deptno, e.sal, (SELECT AVG(sal)
							  FROM emp
							  WHERE deptno = e.deptno) avgsal
FROM emp e;

-- 모든 사원의 번호, 이름, 부서번호, 입사일을 조회, 단 부서 이름 기준 내림차순 정렬
SELECT empno, ename, deptno, hiredate
FROM emp e
ORDER BY (SELECT dname
		  FROM dept d
          WHERE deptno = e.deptno) DESC;

-- 테이블 카피
CREATE TABLE emp_copy
(SELECT * FROM emp);

SELECT * FROM emp_copy;

-- 구조만 가지고 오고 싶다
CREATE TABLE emp_blank
(SELECT * FROM emp WHERE 1 = 0);

SELECT * FROM emp_blank; 

INSERT INTO emp_blank
(SELECT * FROM emp WHERE deptno = 30);