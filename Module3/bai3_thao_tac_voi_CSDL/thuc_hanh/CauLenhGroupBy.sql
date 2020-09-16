use classicmodels;

-- Kiểm tra trạng thái của tất cả các đơn hàng 
select `status` from orders
group by `status`;

-- Đếm số lượng của mỗi trạng thái đơn hàng 
select status, COUNT(*) as 'So luong status'
from orders
group by status;

-- Tính tổng số tiền của các đơn hàng theo trạng thái đặt hàng
select status, sum(quantityOrdered * priceEach) as amount
from orders 
inner join orderdetails on orders.ordernumber = orderdetails.ordernumber
group by status;

-- Tính tổng tiền của từng đơn hàng 
select orderNumber, sum(quantityOrdered * priceEach) as total
from orderdetails
group by orderNumber;

-- Tính tổng doanh thu của những năm lớn hơn năm 2003.
select year(orderDate) as year, sum(quantityOrdered * priceEach) as total
from orders 
inner join orderdetails on orders.orderNumber = orderdetails.orderNumber
where status = 'shipped'
group by year
having year > 2003;

