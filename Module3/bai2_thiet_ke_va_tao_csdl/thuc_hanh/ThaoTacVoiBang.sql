use ho_thi_quynh_mai_c0620g1;

CREATE TABLE contacts
( contact_id INT NOT NULL AUTO_INCREMENT,
  last_name VARCHAR(30) NOT NULL,
  first_name VARCHAR(25),
  birthday DATE,
  CONSTRAINT contacts_pk PRIMARY KEY (contact_id)
);

-- Sử dụng từ khóa DEFAULT để gán giá trị cho 1 cột
CREATE TABLE suppliers
( supplier_id INT NOT NULL AUTO_INCREMENT,
  supplier_name VARCHAR(50) NOT NULL,
  account_rep VARCHAR(30) NOT NULL DEFAULT 'TBD',
  CONSTRAINT suppliers_pk PRIMARY KEY (supplier_id)
); 
DROP TABLE contacts;
DROP TABLE suppliers;
DROP TABLE contacts, suppliers;

-- Tạo thêm
ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id;
    
-- Tạo thêm nhiều cột 1 lúc
ALTER TABLE contacts
  ADD last_name varchar(40) NOT NULL
    AFTER contact_id,
  ADD first_name varchar(35) NULL
    AFTER last_name; 
    
-- Chỉnh sửa
ALTER TABLE contacts
  MODIFY last_name varchar(50) NULL;
    
--  Xoá cột contact_type trong bảng contacts
ALTER TABLE contacts
  DROP COLUMN contact_type; 

-- Thay đổi tên cột 
ALTER TABLE contacts
  CHANGE COLUMN contact_type ctype
    varchar(20) NOT NULL; 
    
-- Thay đổi tên bảng
ALTER TABLE contacts
  RENAME TO people; 
  
DROP TABLE people;