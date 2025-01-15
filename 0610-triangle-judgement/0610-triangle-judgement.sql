# Write your MySQL query statement below
-- SELECT
--   *,
--   IF(x + y > z AND x + z > y AND y + z > x, 'Yes', 'No') AS triangle
-- FROM Triangle;


select x,y,z, 
case when x+y>z and x+z>y and y+z>x then 'Yes' else 'No' end as triangle from triangle