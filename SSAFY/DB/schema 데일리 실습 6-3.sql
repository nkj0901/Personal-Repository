USE world;

-- 1. 현재 날짜와 올해가 몇 일 지났는지, 100일 후는 몇일인지 출력
SELECT DATE(SYSDATE()) 오늘, DATEDIFF(DATE(SYSDATE()),"2022-01-01")"올해 지난 날", ADDDATE(DATE(SYSDATE()),100) "100일 후";

-- 2. aisa에 있는 나라 중 희망 수명이 있는 경우 
-- 기대 수명이 80초과면 장수국가, 60초과면 일반국가, 그렇지 않으면 단명국
SELECT name, continent, LifeExpectancy,
CASE
	WHEN lifeexpectancy > 80
    THEN "장수국가"
    WHEN lifeexpectancy > 60
    THEN "일반국가"
    ELSE "단명국가"
END 구분
FROM country
WHERE lifeexpectancy IS NOT NULL AND Continent = "asia"
ORDER BY lifeexpectancy;

-- 3. country에서 (gnp-gnpold)를 gnp 향상이라고 표현하시오, 단 gnpold가 없는 경우 신규라고 출력하고 name으로 정렬
SELECT name, gnp, gnpold, 
CASE
	WHEN gnpold is null
    THEN "신규"
    ELSE gnp-gnpold
END "gnp 향상"
FROM country
ORDER BY name;

-- 4. 2020년 어린이 날이 평일이면 행복, 토요일 또는 일요일이면 불행이라고 출력하시오
SELECT 
CASE 
	WHEN dayname("2020-05-05") = "Sunday" or dayname("2020-05-05") = "saturday"
    THEN "불행"
	ELSE "행복"
END "2020-05-05";

-- 5. 전체 자료의 수와 독립 연도가 있는 자료의 수를 각각 출력하시오.
SELECT COUNT(*) 전체, COUNT(indepyear) "독립 연도 보유" 
FROM country;

-- 6. 기대 수명의 함계, 평균, 최대, 최소를 출력하시오. 평균은 소수점 2자리로 반올림한다.
SELECT sum(lifeexpectancy) 합계, round(avg(lifeexpectancy), 2) 평균,  max(lifeexpectancy) 최대, MIN(lifeexpectancy) 최소
FROM country;

-- 7. continent 별 국가의 개수와 인구의 합을 구하시오. 국가 수로 정렬 처리한다.
SELECT CONTINENT, COUNT(*) "국가 수", SUM(population) "인구 합"
FROM country
GROUP BY CONTINENT
ORDER BY COUNT(*) DESC;

-- 8. country에서 대륙별 국가 표면적의 합을 구하시오. 면적의 합으로 내림차순 정렬하고 상위 3건만 출력한다.
SELECT continent, sum(surfaceArea) "표면적 합"
FROM country
GROUP BY Continent
ORDER BY sum(surfaceArea) DESC
LIMIT 3;

-- 9. 대륙별로 인구가 50,000,000이상인 나라의 GNP 총 합을 구하시오. 합은 오름차순 정렬한다.
SELECT CONTINENT, SUM(GNP) "GNP 합"
FROM country
WHERE population >= 50000000
GROUP BY Continent
ORDER BY SUM(GNP);

-- 10. 대륙별로 인구가 50,000,000이상인 나라의 gnp 총 합을 구하시오. 이때 gnp의 합이 5,000,000이상인 것만 출력
SELECT E.CONTINENT, E.GNP합
FROM (SELECT CONTINENT, SUM(GNP) GNP합
	  FROM country
	  WHERE population >= 50000000
	  GROUP BY Continent
	  ORDER BY SUM(GNP)) E
WHERE E.GNP합 >= 5000000;

-- 11. country에서 연도별로 10개 이상의 나라가 독립한 해는 언제인가?
SELECT indepyear, COUNT(*) "독립 국가 수"
FROM country
WHERE indepyear IS NOT NULL
GROUP BY indepyear;

SELECT I.indepyear, I.독립 "독립 국가 수"
FROM (SELECT indepyear, COUNT(*) 독립
	  FROM country
      WHERE indepyear IS NOT NULL
	  GROUP BY indepyear) I
WHERE I.독립 >= 10;

-- 12. 국가별로 gnp와 함께 전세계 평균 gnp, 대륙평균 gnp를 출력하시오
-- 대륙 평균 gnp 구하기
SELECT c.Continent, name, gnp, c2.전체평균, c1.대륙평균
FROM country c, ( SELECT CONTINENT, AVG(GNP) 대륙평균
				  FROM country
				  GROUP BY CONTINENT) c1,
                  (SELECT AVG(GNP) 전체평균
				   FROM country) c2
WHERE c.continent = c1.continent;

 SELECT CONTINENT, AVG(GNP)
 FROM country
 GROUP BY CONTINENT;
 
  SELECT AVG(GNP)
 FROM country;
