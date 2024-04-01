USE world;

SELECT * FROM city;

SELECT * FROM country;

SELECT * FROM countrylanguage;

-- 3 code가 KOR인 자료 조회
SELECT code, name, continent, region
FROM country 
WHERE code = "KOR";

-- 4 gnp변동량(gnp-gnpold)이 양수인 국가에 대해 gnp변동량의 오름차순으로 정렬
SELECT code, name, gnp, gnpold, GNP-GNPOLD "GNP변동량"
FROM country
WHERE GNP-GNPOLD > 0
ORDER BY GNP-GNPOLD;

-- 5 continent를 중복 없이 조회, continent의 길이로 정렬
SELECT DISTINCT continent
FROM country
ORDER BY char_length(continent);

-- 6 asia 대륙에 속하는 국가들의 정보를 출력, name으로 정렬
SELECT concat(Name, "은 ", Region, "에 속하며 인구는 ", Population, "명이다." ) 정보
FROM country
WHERE continent = "asia";

-- 7 독립 년도에 대한 기록이 없고 인구가 10000인 국가의 정보를 인구의 오름차순으로 출력
SELECT name, continent, gnp, population
FROM country
WHERE IndepYear IS NULL AND population >= 10000
ORDER BY population;

-- 8 인구가 1억 <= x <= 2억인 나라를 인구기준으로 내림차순 정렬해서 상위 3개만 출력
SELECT code, name, population
FROM country
WHERE population >=100000000 AND population <= 200000000
ORDER BY population DESC
LIMIT 3;

-- 9 800, 1810, 1811, 1901에 독립한 나라를 독립년 기준으로 오름차순 출력
-- 단 독립 년이 같다면 code를 기준으로 내림차순
SELECT code, name, indepyear
FROM country
WHERE indepyear in (800, 1810,1811,1901)
ORDER BY indepyear, code DESC;

-- 10 country에서 region에 asia가 들어가고 name의 두 번째 글자가 'o'인 정보를 출력
SELECT code, name, region
FROM country
WHERE region LIKE '%asia%' AND name LIKE '_o%';

-- 11 '홍길동'과 'hong'의 글자 길이를 각각 출력하시오.
SELECT char_length('홍길동') 한글, char_length('hong') 영문;

-- 12 country에서 governmentform에 republic이 들어있고 
-- name의 길이가 10이상인 자료를 name 길이의 내림차순으로 상위 10개만 출력
SELECT code, name, governmentform
FROM country
WHERE governmentform LIKE "%republic%" AND char_length(name)>=10
ORDER BY char_length(name) DESC
LIMIT 10;

-- 13 country에서 code가 모음으로 시작하는 나라의 정보를 출력
-- 이때 name의 오름차순으로 정렬하고 3번부터 3개반 출력한다.
SELECT code, name
FROM country
WHERE substr(code, 1, 1) in ('a', 'e', 'i', 'o', 'u')
ORDER BY name
LIMIT 2, 3;

-- 14 country에서 name을 맨 앞과 맨 뒤에 2글자를 제외하고
-- 나머지는 *로 처리해서 출력
SELECT repeat('*', char_length(name)-4)
FROM country;

SELECT name, concat(substr(name, 1, 2), repeat('*', char_length(name)-4), substr(name, char_length(name)-1, char_length(name))) GUESS
FROM country;

-- 15 country에서 region을 중복 없이 가져오는데 공백을 _로 대체, region 길이로 정렬
 SELECT DISTINCT replace(region, " ", "_") 지역들
 FROM country
 ORDER BY char_length(region) DESC;
 
 -- 16 country에서 인구가 1억 이상인 국가들의 1인당 점유면적(surfacearea/population)을 반올림해서
 -- 소수점 3자리로 표현하시오. 1인당 점유 면적의 오름차순으로 정렬
 SELECT name, surfacearea, population, round(surfacearea/population, 3) "1인당 점유면적"
 FROM country
 WHERE population >= 100000000
 ORDER BY round(surfacearea/population, 3);
 

