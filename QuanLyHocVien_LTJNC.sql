create database db_qlhv

go

use db_qlhv 
go
create table hoc_vien
(
	ma_hoc_vien varchar(7) NOT NULL primary key,
	ho_ten nvarchar(50),
	ten_lop_hoc varchar(50),
	ngay_sinh date ,
	gioi_tinh bit NOT NULL,
	so_dien_thoai varchar(11),
	dia_chi varchar(100),
	tinh_trang bit
)
go

create table khoa_hoc
(
	ma_khoa_hoc varchar(7) NOT NULL primary key,
	ten_khoa_hoc nvarchar(50),
	mo_ta nvarchar(255) ,
	ngay_bat_dau date ,
	ngay_ket_thuc date,
	tinh_trang bit
)
go
create table lop_hoc
(
	ma_lop_hoc varchar(7) NOT NULL primary key,
	ten_lop_hoc nvarchar(50),
	ma_hoc_vien varchar(7),
	ma_khoa_hoc varchar(7),
	ngay_dang_ky date,
	tinh_trang bit
	
)
go 
create table tai_khoan
(
	 ma_tai_khoan int NOT NULL primary key,
	ten_dang_nhap varchar(255) ,
    mat_khau varchar(255),
    tinh_trang bit 
)

go
alter table lop_hoc 
	add  constraint fk_LH_MHV foreign key (ma_hoc_vien) references hoc_vien(ma_hoc_vien),
		 constraint fk_lh_MKH foreign key (ma_khoa_hoc) references khoa_hoc(ma_khoa_hoc)
go
alter table hoc_vien
add constraint CK_SDT_hoc_vien check(so_dien_thoai LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
		OR	so_dien_thoai LIKE '[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]'
	)
go
alter table khoa_hoc
add constraint CK_Date_khoa_hoc CHECK(ngay_bat_dau < ngay_ket_thuc )


go 

INSERT INTO hoc_vien 
	values('1896251',N'Võ Lê Nhật Huy','20T1','03/16/2002','1','0858998155','Da Nang','1'),
		  ('1896252',N'Hồ Nguyễn Gia Bảo','20T2','02/14/2002','1','0851451212','Da Nang','1')

GO
INSERT INTO khoa_hoc
	values('KH00001','FONT-END',N'Thiết kế giao diện website','04/23/2022','07/23/2022','1'),
			('KH00002','BACK-END',N'Thiết kế cơ sở dữ liệu','07/23/2022','12/23/2022','0')
go
INSERT INTO lop_hoc
	values ('LH00001','20T1','1896251','KH00001','04/20/2022','1'),
			('LH00002','20T2','1896252','KH00002','06/29/2022','0')
			
go 
INSERT INTO tai_khoan
	values('16032002','nhathuy1630','nhathuy1603','1')

select *
from tai_khoan