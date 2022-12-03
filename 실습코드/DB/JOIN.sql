USE 'SCOTT';

-- 카타시안 곱

SELECT empno, ename, job
FROM emp;

SELECT deptno, dname
FROM dept;

SELECT empno, ename, job, emp.deptno, dname
FROM emp, dept;

-- where 사용하여 유의미하게 데이터를 뽑아보자
SELECT empno, ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno;
-- detp 테이블에서 emp.deptno와 일치하는 래코드만 가지고 오겠다.

-- 사원 7788인 사원의 이름, 업무, 부서번호, 부서이름 조회
SELECT ename, job, deptno
FROM emp
WHERE empno = 7788;

SELECT dname
FROM dept
WHERE deptno = 20;

-- 조인을 이용하여 작성
SELECT ename, job, emp.deptno, dname
FROM emp, dept
WHERE emp.deptno = dept.deptno
AND empno = 7788;

-- inner join 키워드 활용해보자
SELECT ename, job, emp.deptno, dname
FROM emp
INNER JOIN dept
ON emp.deptno = dept.deptno -- 조인 조건
WHERE empno = 7788;

-- using이라는 것도 이용해보자 (똑같은 컬럼이 있으니 그걸 이용하겠다)
SELECT ename, job, deptno, dname
FROM emp
INNER JOIN dept
USING (deptno)
WHERE empno = 7788;

-- outer join
INSERT INTO emp
VALUES (4168, "임영산", "MANAGER", 7839, "2022-09-13", 5000, NULL, NULL);

DELETE FROM emp
where empno = 4168;

SELECT *
FROM emp;

-- 동등조인으로 이름, 부서번호, 부서 이름을 가져와
SELECT e.ename, e.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;
-- 부서가 없는 사람 "임영산"은 조회되지 않음

-- 한쪽에 기준을 주고 너 붙어
-- 없으면 없는 데로
-- 모든 사원을 기준으로
SELECT e.ename, e.deptno, d.dname
FROM emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- 이번에는 부서 테이블을 기준으로
SELECT e.ename, e.deptno, d.dname
FROM emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- 셀프 조인
-- 모든 사원번호, 이름, 매니저 번호, 매니저 이름
SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1, emp e2
WHERE e1.mgr = e2.empno
ORDER BY e2.ename;

-- inner join으로 한번 위에꺼 해보쇼
SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1
INNER JOIN emp e2
ON e1.mgr = e2.empno
ORDER BY e2.ename;

-- king이 안나왔어 e1기준으로 값이 있으면 붙여! 없으면 빈칸~~~
SELECT e1.empno, e1.ename, e1.mgr, e2.ename
FROM emp e1 LEFT OUTER JOIN emp e2
ON e1.mgr = e2.empno;

-- 비동등조인
-- 모든 사원의 사번, 이름, 급여, 급여등급을 조회하고 싶다
SELECT e.empno, e.ename, e.sal, sg.grade
FROM emp e, salgrade sg
WHERE e.sal >= sg.losal AND e.sal <= sg.hisal
ORDER BY grade DESC, e.sal DESC;

SELECT e.empno, e.ename, e.sal, sg.grade
FROM emp e, salgrade sg
WHERE e.sal BETWEEN sg.LOSAL AND sg.HISAL
ORDER BY grade DESC, e.sal DESC;