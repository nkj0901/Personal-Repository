USE world;

DESC city;
DESC countrylanguage;
DESC country;

-- 1. 도시명 kabul이 속한 국가의 이름은?
-- 먼저 kabul이 속한 국가의 코드를 가져온다. 그 국가의 코드와 국가 이름을 가져온다.
 SELECT CountryCode
 FROM City
 WHERE name = 'kabul';
 
 SELECT code, name
 FROM country
 WHERE code = (SELECT CountryCode
			   FROM City
			   WHERE name = 'kabul');
               
-- 2. 국가의 공식 언어 사용율이 100%인 국가의 정보를 출력하시오. 국가 이름으로 오름차순 정렬한다.
SELECT c.name, c1.language, c1.percentage
FROM countrylanguage c1
INNER JOIN country c
on c1.CountryCode = c.code
WHERE Percentage = 100 AND IsOfficial = 'T'
ORDER BY NAME;

-- 3. 도시명 amsterdam에서 사용되는 주요 언어와 amsterdam이 속한 국가는?
-- 암스테르담의 컨트리 코드 가지고와~
SELECT CountryCode
FROM city
WHERE NAME = 'Amsterdam';

SELECT Language
FROM countrylanguage
WHERE CountryCode = (SELECT CountryCode
					 FROM city
					 WHERE NAME = 'Amsterdam')
AND isofficial = 't';

SELECT c1.name, c1.language, c.name
FROM country c
INNER JOIN city c1
ON c1.CountryCode = c.code
WHERE c1.countrycode = (SELECT CountryCode
					    FROM city
						WHERE NAME = 'Amsterdam')
AND c1.IsOfficial='T';


