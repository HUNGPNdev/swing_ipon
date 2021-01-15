use ipon;
create table category(
	id int primary key auto_increment,
    name varchar(255) not null unique
);
create table employee(
	id int primary key auto_increment,
    fullname varchar(255) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    status tinyint(1)
);
create table role(
	id int primary key auto_increment,
    name varchar(255) not null
);
create table em_role(
	em_id int,
    role_id int,
    constraint Pk_EM_Role foreign key(em_id) references employee(id),
    constraint Pk_Role foreign key(role_id) references role(id)
);
create table coupon (
	id varchar(50) primary key,
    em_id int,
    supplier_name varchar(255),
    total_price double,
    date_create date,
    constraint Pk_Cou_Employee foreign key(em_id) references employee(id)
);
create table product (
	id int primary key auto_increment,
    name varchar(255),
    cate_id int,
    old_count int,
    now_count int,
    price double,
    cou_id varchar(50) not null,
    constraint Pk_cou_pro foreign key(cou_id) references coupon(id),
    constraint Pk_pro_cate foreign key(cate_id) references category(id)
);
create table bill (
	id int primary key auto_increment,
    em_id int not null,
    client_name varchar(255),
    total_price double,
    date_create date,
    constraint Pk_Bill_Em foreign key(em_id) references employee(id)
);
create table pro_bill (
	id int primary key auto_increment,
	pro_id int,
    bill_id int,
    count int,
    constraint Pk_pro_bill_pro foreign key(pro_id) references product(id),
    constraint Pk_bill_pro_bill foreign key(bill_id) references bill(id)
);


































