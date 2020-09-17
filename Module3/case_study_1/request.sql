use furuma;

/*Task 2: Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự */
select *
from employee
where (name_employee like 'H%' or name_employee like 'T%'or name_employee like 'K%') and length(name_employee) <= 15;
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
select count(contract.id_customer) as `count`, customer.name_customer, type_customer.name_type_customer
from customer
	left join contract on contract.id_customer = customer.id_customer
	join type_customer on type_customer.id_type_customer = customer.id_type_customer
where type_customer.name_type_customer = 'Diamond'
group by customer.id_customer
order by count(contract.id_customer);


/* Task 5: Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
(Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra) */
select c.id_customer, c.name_customer, t.name_type_customer, co.id_contract, se.name_service, contract_date, contract_end_date, total_money
from customer c
	left join type_customer t on t.id_type_customer = c.id_type_customer
    left join contract co on co.id_customer = c.id_customer
    left join service se on se.id_service_accompanied = c.id_customer
    left join service_accompanied sa on sa.id_service_accompanied = se.id_service_accompanied


/* Task 6: Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của 
tất cả các loại Dịch vụ chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3) */

select service.id_service, service.name_service, service.area, service.cost_rent, service.name_type_service
from service
where service.id_service not in (
select service.id_service
from service 
	left join contract on service.id_service = contract.id_service 
	where month(contract.contract_date) < 4 and year(contract.contract_date) = 2019);

