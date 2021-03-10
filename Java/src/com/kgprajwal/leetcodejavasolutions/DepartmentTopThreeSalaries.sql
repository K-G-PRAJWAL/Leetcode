SELECT a.Department, a.Employee, a.Salary FROM
(
Select b.Name as Department,a.Name as Employee,a.salary As Salary,
DENSE_RANK() over (PARTITION BY b.Name ORDER BY a.Salary DESC)  as dept_sal_rank
from Employee a
INNER JOIN Department b ON a.DepartmentId = b.Id ) a

where a.dept_sal_Rank <=3
