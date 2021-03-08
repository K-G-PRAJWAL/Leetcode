SELECT DISTINCT
c1.Num AS ConsecutiveNums
FROM Logs c1, Logs c2, Logs c3
WHERE c1.Id=c2.Id-1
AND c2.Id=c3.Id-1
AND c1.Num=c2.Num
AND c2.Num=c3.Num;