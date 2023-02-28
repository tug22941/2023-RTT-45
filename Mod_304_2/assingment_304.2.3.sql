-- Assingment 304.2.3 : Simple Queries

-- Problem 1
select p.productName as "Name", p.productLine as "Product Line" , p.buyPrice as "Buy Price"
from products p
order by p.buyPrice desc;

-- Problem 2
select c.contactFirstName as "First Name", c.contactLastName as "Last Name", c.city as "City"
from customers c
order by "Last Name" asc;

-- Problem 3
select distinct status
from orders
group by status
order by status asc;

-- Problem 4
select * 
from payments
where paymentDate >= "2005-01-01"
order by paymentDate desc;

-- Problem 5
select e.firstName, e.lastName, e.email, e.jobTitle, o.city
from employees e, offices o
where o.city = "San Francisco"
order by e.lastName;

-- Problem 6
select productName, productLine, productScale, productVendor
from products p
where productLine = "Vintage Cars"
	or productLine = "Classic Cars"
order by productName asc;