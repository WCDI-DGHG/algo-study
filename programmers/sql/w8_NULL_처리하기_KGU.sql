/* 
NULL 처리하기
프로그래머스_SQL
Code_By_Goun
*/

SELECT  animal_type, NVL(name, 'No name') as name, sex_upon_intake
FROM    animal_ins;