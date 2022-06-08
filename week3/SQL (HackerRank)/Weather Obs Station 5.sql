SELECT city, length(city) as l FROM station
ORDER BY l desc, city LIMIT 1;

SELECT city, length(city) as l FROM station
ORDER BY l asc, city LIMIT 1;