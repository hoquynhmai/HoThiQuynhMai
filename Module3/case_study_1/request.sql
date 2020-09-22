use furuma;

/*Task 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự */
select *
from employee
where (name_employee like 'H%' or name_employee like 'T%' or name_employee like 'K%') and length(name_employee) <= 15;
-- where name_employee
-- regexp '^([a-zA-Z]+[ ])+[H,K,T][a-zA-Z]+$' and length(name_employee) <= 15 ; : Tìm tên viết theo kiểu họ trước tên sau !
-- regexp '^[HKT]{1}(.)*$' and length(name_employee) <= 15;  -- Tìm tên theo kiểu tên trước họ sau !
-- '(H|K|T)[:alpha:]*$' and length(name_employee) <= 15 : Tìm tên tiếng Việt viết theo kiểu họ trước tên sau !


/*Task3: Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.*/
select * 
from customer
where ((year(now()) - year(day_of_birth_customer)) between 18 and 50)
	and address_customer = 'Da Nang' or address_customer = 'Quang Tri';
-- where (year(day_of_birth_customer) between 1970 and 2002) and address_customer in ('Da Nang', 'Quang Tri'); 


/*Task 4: Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
		  Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
		  Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond” */
select count(contract.id_customer) as count_contract, customer.name_customer, type_customer.name_type_customer
from customer
	left join contract on contract.id_customer = customer.id_customer
	join type_customer on type_customer.id_type_customer = customer.id_type_customer
where type_customer.name_type_customer = 'Diamond'
group by customer.id_customer
order by count(contract.id_customer);


/* Task 5: Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
		   (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
		   cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra) */
select c.id_customer, c.name_customer, t.name_type_customer, co.id_contract, co.contract_date, co.contract_end_date,
sum(se.cost_rent + (cd.amount_contract_detail * sa.price)) as total_money
from customer c
	left join type_customer t on c.id_type_customer = t.id_type_customer
    left join contract co on co.id_customer = c.id_customer
    left join contract_detail cd on co.id_contract = cd.id_contract
    left join service_accompanied sa on cd.id_service_accompanied = sa.id_service_accompanied
    left join service se on co.id_service = se.id_service
group by c.id_customer;


/* Task 6: Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của 
		   tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3) */
select se.id_service, se.name_service, se.area, se.cost_rent, t.name_type_service
from service se
	left join type_service t on t.id_type_service = se.id_type_service
where se.id_service not in (
	select se.id_service 
    from service se
		left join contract co on co.id_service = se.id_service
	where month(co.contract_date) < 4 and year(co.contract_date) = 2019
    );


/* Task 7:  Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
			của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 
			nhưng chưa từng được Khách hàng đặt phòng trong năm 2019 */
select se.id_service, se.name_service, se.area, se.maximum_customer, se.cost_rent, t.name_type_service
from service se
	inner join type_service t on se.id_type_service = t.id_type_service
    inner join contract co on co.id_service = se.id_service
where year(co.contract_date = 2018) and se.id_service not in (
	select se.id_service
    from service se
	where year(co.contract_date = 2019)
);
-- *** 

/* Task 8: Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
		   Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên */
-- Cách 1: 
select distinct c.name_customer
from customer c;

-- Cách 2:
create view name_customer 
as
select name_customer
from customer
group by name_customer;

select * from  name_customer ;

-- Cách 3:  
select name_customer
from customer
UNION ALL
select name_customer
from customer;

/* Task 9: Thực hiện thống kê doanh thu theo tháng, 
		   nghĩa là tương ứng với mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng */
           
select month(contract_date) as `month` ,count(id_contract) as `num_contract`
from contract
where year(contract_date) = 2019
group by (`month`);


/* Task 10:	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
		    Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, SoLuongDichVuDiKem 
            (được tính dựa trên việc count các IDHopDongChiTiet) */
            
select co.id_contract, co.contract_date, co.contract_end_date, co.deposit_money, count(cod.id_contract_detail) as amount_service_accompanied    
from contract co
	inner join contract_detail cod on co.id_contract = cod.id_contract
group by co.id_contract;


/* Task 11:	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng có TenLoaiKhachHang là “Diamond” 
		    và có địa chỉ là “Vinh” hoặc “Quảng Ngãi” */            
select sa.id_service_accompanied, sa.name_service_accompanied, sa.price, sa.unit, sa.status_service_accompanied, t.name_type_customer, c.address_customer
from service_accompanied sa
		inner join contract_detail cod on sa.id_service_accompanied = cod.id_service_accompanied
        inner join contract co on cod.id_contract = co.id_contract
        inner join customer c on co.id_customer = c.id_customer
        inner join type_customer t on c.id_type_customer = t.id_type_customer
where t.name_type_customer = 'Diamond' and (c.address_customer = 'Vinh' or c.address_customer = 'Quang Ngãi');
            

/* Task 12:	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu,SoLuongDichVuDikem 
			(được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt 
			vào 3 tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019 */            
select co.id_contract, e.name_employee, c.name_customer, c.phone_customer, se.name_service, 
	   count(cod.id_contract_detail) as num_service_accompanied, co.deposit_money            
from contract co
       inner join employee e on e.id_employee = co.id_employee
       inner join customer c on c.id_customer = co.id_customer
       inner join service se on se.id_service = co.id_service
       inner join contract_detail cod on cod.id_contract = co.id_contract
where (month (co.contract_date) > 9 and year (co.contract_date) = 2019) 
	   and co.id_contract not in (
			month(co.contract_date) < 7 and year(co.contract_date) = 2019
);


/* Task 13:	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
		    (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau) */
select sa.id_service_accompanied, sa.name_service_accompanied, sa.price, sa.unit, count(cod.id_service_accompanied) as count
from contract_detail as cod
	inner join service_accompanied as sa on cod.id_service_accompanied = sa.id_service_accompanied
group by cod.id_service_accompanied
having count =
(select count(cod.id_service_accompanied) as count
from contract_detail as cod
inner join service_accompanied as sa on cod.id_service_accompanied = sa.id_service_accompanied
group by cod.id_service_accompanied
order by count desc
limit 1);


/* Task 14: Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
		    Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung */
select co.id_contract, se.name_service, sa.name_service_accompanied,count(cod.id_service_accompanied) as count
from service as se 
	left join contract as co on co.id_service = se.id_service
	inner join type_service as t on t.id_type_service = se.id_type_service
	inner join contract_detail as cod on co.id_contract= cod.id_contract
	inner join service_accompanied as sa on sa.id_service_accompanied = cod.id_service_accompanied
group by sa.name_service_accompanied
having count = 1;


/* Task 15:	Hiển thị thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, SoDienThoai, DiaChi 
		    mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019 */
select e.id_employee, e.name_employee, le.level_employee, de.name_department_employee, e.phone_number, e.address_employee, count(e.id_employee) as total_contract
from employee e
	inner join contract co on e.id_employee = co.id_employee
	inner join level_employee le on le.id_level_employee = e.id_level_employee
	inner join department_employee de on de.id_department_employee = e.id_department_employee
where year(contract_date) between 2018 and 2019
group by e.id_employee
having total_contract < 4;


/* Task 16:	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019 */


/* Task 17:	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
		    chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019 là lớn hơn 10.000.000 VNĐ */
 update type_customer
 set name_type_customer ='Diamond'
 where name_type_customer ='Platinium' and id_type_customer in (
 select total_payment.id_type_customer
 from (
 select type_customer.id_type_customer, sum(co.total_money*23000) as total_money
 from type_customer t
 inner join customer c on c.id_type_customer = t.id_type_customer
 inner join contract co on co.id_customer = c.id_customer
 where year(co.contract_date) = '2019'
 group by t.id_type_customer
 ) as total_payment
 where total_payment.total_money > 10000000
 );
-- ***

/* Task 18:	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng) */
delete from customer 
where id_customer = (
	select contract.id_customer 
	from contract
		-- inner join contract_detail on contract.id_contract = contract_detail.id_contract
	where year(contract_date) < 2016 and contract.id_customer not in(
		select id_customer
		from contract
		where year(contract_date) > 2016));

-- Danh sách đã xóa
select customer.id_customer ,contract_date
from customer 
	left join contract on customer.id_customer = contract.id_customer
where year(contract_date) < 2016;


/* Task 19:	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi */


/* Task 20: Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
			thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi */
select e.id_employee, e.name_employee , e.email_employee, e.phone_number, e.day_of_birth_employee, e.address_employee,
	   c.id_customer, c.name_customer, c.email_customer, c.phone_customer, c.day_of_birth_customer, c.address_customer
from customer c
	inner join contract co on co.id_customer = c.id_customer
    inner join employee e on e.id_employee = co.id_employee;
-- group by c.id_customer;

/*Task 21: Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” 
		   và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “12/12/2019” */
create view v_nhan_vien as
select e.*
from employee e
inner join contract co using(id_employee)
where e.address_employee = 'Hải Châu' and co.contract_date = '2019-12-12';     

--  Xem thông tin từ view
select *
from  v_nhan_vien ;  


/* Task 22: Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
			đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này */
update v_nhan_vien
set address_employee='Liên Chiều'
where id_employee ='Hải Châu';
-- ***

/*Task 23: Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1 */
delimiter //
drop procedure if exists Sp_1//
create procedure Sp_1(id int)
begin
delete from customer
where id_customer = id;
end;//
delimiter ;

/* Task 24: Tạo Store procedure Sp_2 Dùng để thêm mới vào bảng HopDong với yêu cầu Sp_2 phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, 
		    với nguyên tắc không được trùng khó chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan */
