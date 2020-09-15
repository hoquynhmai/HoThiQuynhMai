use ho_thi_quynh_mai_c0620g1;

-- Bảng khách hàng 
CREATE TABLE customers (
customer_number int NOT NULL,
full_name varchar(255) NOT NULL,
address varchar(255) NOT NULL,
email varchar (255) DEFAULT NULL,
phone varchar (20) NOT NULL,
PRIMARY KEY(customer_number)
);

-- Bảng tài khoản 
CREATE TABLE accounts (
customer_number int NOT NULL,
account_number int NOT NULL,
account_type varchar(50) NOT NULL,
`date` date NOT NULL,
balance int (10),
PRIMARY KEY (account_number),
FOREIGN KEY (customer_number) references customers(customer_number)
);

-- Bảng giao dịch 
CREATE TABLE transactions (
customer_number int NOT NULL,
tran_number int NOT NULL, -- Mã giao dịch
account_number int (20) NOT NULL,
`date` date NOT NULL,
amounts int NOT NULL,
descriptions varchar (50) DEFAULT NULL,
PRIMARY KEY (tran_number),
FOREIGN KEY (customer_number) references customers(customer_number)
);

DROP TABLE customers, accounts, transactions;