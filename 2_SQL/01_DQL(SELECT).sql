/*
    <SELECT>
    SELECT 가져오고 싶은 정보 FROM 테이블;
    SELECT (*) 또는 컬럼1, 컬럼2, 컬럼3... FROM 테이블;
*/

--모든 사원의 모든 정보를 조회
SELECT * FROM EMPLOYEE;

--모든 사원의 이름, 주민등록번호, 핸드폰번호
SELECT EMP_NAME, EMP_NO, PHONE
FROM EMPLOYEE;

------------------ 실습 ------------------
--JOB테이블의 직급명만 조회
SELECT JOB_NAME FROM JOB;

--DEPARTMENT 테이블의 모든 컬럼 조회
SELECT * FROM DEPARTMENT;

--DEPARTMENT 테이블의 부서코드 부서명 조회
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT;

--EMPLOYEE 테이블의 사원명, 이메일, 전화번호, 입사일, 급여 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY FROM EMPLOYEE;

-- <컬럼값을 통한 산술 연산>
-- SELECT절 컬럼명 작성 부분에 산술연산을 할 수 있다

--EMPLOYEE테이블의 사원명, 사원의 연봉(SALARY * 12) 조회
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

--EMPLOYEE 테이블의 사원명, 급여, 보너스, 연봉, 보너스포함 연봉(급여 + (급여 * 보너스)) * 12
SELECT EMP_NAME, SALARY, BONUS, SALARY * 12, (SALARY + (SALARY * BONUS)) * 12
FROM EMPLOYEE;
--산술연산 과정중에 NULL 데이터가 포함되어 있다면 무조건 결과값은 NULL

--EMPLOYEE 테이블의 사원명, 입사일, 근무일수 조회
--현재시간 - 입사일 = 근무기간
--DATE - DATE -> 결과는 무조건 일로 표기함
--코드실행시 현재시간을 표시하는 상수 : SYSDATE
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

SELECT SYSDATE FROM DUAL;
--DUAL : 오라클에서 제공해주는 가상데이터 테이블

/*
<컬럼명에 별칭 지정하기>
산술연산을 하게되면 컬럼명이 지저분해진다.
이때 컬럼명에 별칭을 부여해서 깔끔하게 가져올 수 있다.
[표현법]
컬럼명 별칭 / 컬럼명 AS 별칭 / 컬럼명 "별칭" / 컬럼명 AS "별칭"
*/

SELECT EMP_NAME 사원명, SALARY AS 급여, BONUS "보너스", (SALARY * 12) AS "연봉", (SALARY + (SALARY * BONUS)) * 12 "총소득"
FROM EMPLOYEE;

/*
<리터럴>
임의로 지정한 문자열('')
조회된 결과에 모든 행에 반복적으로 출력
*/
SELECT EMP_ID, EMP_NAME, SALARY, '원' AS "단위"
FROM EMPLOYEE;

/*
<연결연산자 : ||>
여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있다.
*/

--사번, 이름, 급여를 하나의 컬럼으로 조회
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

--EMPLOYEE 테이블에서 모든 사원의 월급을 조회한다
--다음과 같은 결과가 나오도록 출력한다
--XX의 월급은 XX원입니다.
SELECT EMP_NAME || '의 월급은 ' || SALARY || '원 입니다.' AS "급여"
FROM EMPLOYEE;

/*
<DISTINCT>
중복제거 - 컬럼에 표시된 값들을 한번씩만 조회하고자 할 때 사용
*/

--EMPLOYEE의 직급코드 조회
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

--EMPLOYEE의 부서코드 조회(중복제거)
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

--DISTINCT는 한번만 사용 가능하다.
SELECT DISTINCT JOB_CODE, DEPT_CODE
--위처럼 사용시(JOB_CODE, DEPT_CODE)를 쌍으로 묶어서 중복을 제거한 값을 보여준다.
FROM EMPLOYEE;

--=============================================================================

/*
<AND, OR 연산자>
조건을 여러개 연결할 때 사용

[표현법]
조건A AND 조건B -> 조건A, B가 모두 만족하는 값만 참으로 간주
조건A OR 조건B -> 조건A, B 둘 중 하나만 만족해도 참으로 간주

<BETWEEN AND>
조건식에 사용되는 구문
몇 이상 몇 이하인 범위에 대한 조건을 제시할 때 주로 사용하는 연산자(이상, 이하만 가능)

[표현법]
비교대상 컬럼 BETWEEN 하한값 AND 상한값
*/

--급여가 350만원 이상, 600만원 이하인 모든 사원의 사원명, 사번, 급여조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY >= 3500000 AND SALARY <= 6000000;
WHERE SALARY BETWEEN 3500000 AND 6000000;

--급여가 350만원 미만, 600만원 초과인 모든 사원의 사원명, 사번, 급여조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY < 3500000 OR SALARY > 6000000
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
--NOT은 SALARY 앞 혹은 뒤 위치는 상관없다

--NOT : 논리부정 연산자
--컬럼명 앞 또는 BETWEEN앞에 선언 가능
--입사일이 '90/01/01' ~ '01/01/01'인 사람들을 전체 조회
SELECT *
FROM EMPLOYEE
--WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

--=============================================================================

/*
<LIKE>
비교하고자 하는 컬럼값이 내가 제시한 특정 패턴에 만족할 경우 조회

[표현법]
비교할 대상 컬럼 LIKE '특정패턴'; -> 일치하는 것만 가져온다.

특정패턴을 제시할 때 와일드카드라는 특정 패턴이 정의되어야 한다
1. '%' : 포함문자 검색(0글자 이상 전부 조회)
EX) 비교할 대상 컬럼 LIKE '문자%' : 비교할 대상 컬럼 값 중에서 해당 문자로 시작하는 값들만 가져온다
    비교할 대상 컬럼 LIKE '%문자' : 비교할 대상 컬럼 값 중에서 해당 문자로 끝나는 값들만 가져온다
    비교할 대상 컬럼 LIKE '%문자%' : 비교할 대상 컬럼 값 중에서 해당 문자가 포함된 값들만 가져온다

2. '_' : 1글자를 대체하는 검색
EX) 비교할 대상 컬럼 LIKE '_문자' : 비교할 대상 컬럼 값 문자 앞에 아무 글자나 한글자 있는 값 조회
    비교할 대상 컬럼 LIKE '문자_' : 비교할 대상 컬럼 값 문자 뒤에 아무 글자나 한글자 있는 값 조회
    비교할 대상 컬럼 LIKE '_문자_' : 비교할 대상 컬럼 값 문자 앞뒤에 아무 글자나 한글자 있는 값 조회
    
    비교할 대상 컬럼 LIKE '__문자____' : 내가 원하는 형태로 _를 통해 문자수를 조절할 수 있다
*/

--사원들 중 성이 전씨인 사원의 사원명, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

--사원들 중 이름이 나라인 사원의 사원명, 급여, 입사일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%나라';

--사원들 중 이름에 '하'라는 글자가 포함된 사원의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';

--사원들 중 이름의 중간에 '하'라는 글자가 포함된 사원의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_하_';

--전회번호 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '__1%';

--이메일 중 _앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
--WHERE EMAIL LIKE '____%'; -> 와일드카드 문자 때문에 정상출력이 되지 않는다
--와일드카드 문자와 일반문자를 구분해줘야 한다
--데이터값으로 취급하고 싶은 와일드카드 문자 앞에 나만의 탈출문자를 제시해서 탈출시켜주면 된다
--ESCAPE OPTION을 등록해서 사용
WHERE EMAIL LIKE '___\_%' ESCAPE '\';

--=============================== 실습 ===============================
--1. 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

--2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

--3. 이름에 '하'가 포함되어 있고 급여가 240만원 이상인 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;

--4. 부서 테이블에서 해외영업부인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '%해외%';

--====================================================================

/*
<IN>
WHERE절에서 비교대상 컬럼값이 내가 제시한 목록중에 일치하는 값이 있는지 검사

[표현법]
비교대상 컬럼 IN ('값, '값', '값')
*/

--부서코드가 D6이거나 D8이거나 D5인 부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

--====================================================================

/*
<연산자 우선순위>
1. 산술연산자
2. 연결연산자
3. 비교연산자
4. IS NULL / LIKE / IN
5. BETWEEN A AND B
6. NOT
7. AND
8. OR
*/

--=============================== 문제 ===============================

--1. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사번, 부서코드 조회

SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

--2. 연봉(보너스 미포함)이 3천만원 이상이고 보너스를 받지 않는 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE SALARY * 12 >= 30000000 AND BONUS IS NULL;

--3. 입사일이 '95/01/01' 이상이고 부서배치를 받지 않은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE HIRE_DATE >= '95/01/01' AND DEPT_CODE IS NULL;

--4. 급여가 200만원 이상이고 500만원 이하인 사원 중에서 입사일이 '01/01/01' 이상이고 보너스를 받지 않은
--   사원들의 사번, 사원명, 급여, 입사일, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE (SALARY BETWEEN 2000000 AND 5000000) AND HIRE_DATE >= '01/01/01' AND BONUS IS NULL;

--5. 보너스를 포함한 연봉이 NULL이 아니고 이름에 '하'가 포함된 사원들의 사번, 사원명, 급여, 보너스포함 연봉 조회
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY + (SALARY * BONUS)) * 12 "보너스 포함 연봉"
FROM EMPLOYEE
WHERE (SALARY + (SALARY * BONUS)) * 12 IS NOT NULL AND EMP_NAME LIKE '%하%';