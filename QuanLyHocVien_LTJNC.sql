create database db_qlhv1

go

use db_qlhv1
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
	ngay_ket_thuc datetime,
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
create table lop_sinh_hoat
(
	ma_lop_hoc varchar(7) NOT NULL primary key,
	ten_lop_hoc nvarchar(50),
	giao_vien_chu_nhiem nvarchar(50),
	so_luong_sinh_vien int
)
go

create table bang_diem
(
	ma_hoc_vien varchar(7) ,
	ho_ten_hoc_vien nvarchar(50),
	hoc_ki varchar(3),
	diem_TBCHT varchar(3),
	xep_loai nvarchar(10)
)
go

create table thoi_khoa_bieu
(
	ma_hoc_vien varchar(7),
	ten_lop_hoc_phan varchar(50),
	ten_mon_hoc nvarchar(50),
	thu varchar(3) ,
	tu_tiet varchar(3),
	den_tiet varchar(3),
	ten_giang_vien nvarchar(50),
	phong varchar(10)
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

INSERT INTO hoc_vien 
	values('1896251',N'Võ Lê Nhật Huy','20T2','03/16/2002','1','0858998155','Da Nang','1'),
		  ('1896252',N'Hồ Nguyễn Gia Bảo','20T1','02/14/2002','1','0851451212','Da Nang','1'),
		 ('1896253',N'Huỳnh Đức An','20T2','05/05/2002','1','0858995235','Quang Nam','1'),
		  ('1896254',N'Huỳnh Ngọc Đạt','20T1','10/2/2002','1','0851451212','Da Nang','0'),
		  ('1896255',N'Võ Lê Nhật Linh','20T3','03/26/2002','0','0856566335','Thua Thien Hue','1'),
		  ('1896256',N'Hồ Thùy Tiên','20T3','02/14/2002','0','0851451412','Gia Lai','1')


GO
INSERT INTO khoa_hoc
	values('KH00001','FONT-END',N'Thiết kế giao diện website','04/23/2022','07/23/2022','1'),
		('KH00002','BACK-END',N'Thiết kế cơ sở dữ liệu','07/23/2022','12/23/2022','0'),
		('KH00003','BACKGROND',N'Phác họa và vẽ hình nền','05/20/2022','5/27/2022','2');
go
INSERT INTO lop_hoc
	values ('LH00001','20T1','1896251','KH00001','04/20/2022','1'),
		('LH00002','20T2','1896252','KH00002','06/29/2022','0')
			
go 
INSERT INTO tai_khoan
	values('16032002','nhathuy1630','nhathuy1603','1')
go
INSERT INTO lop_sinh_hoat
	values('1011001','20T1',N'Nguyễn Văn Phát','63'),
		  ('1011002','20T2',N'Nguyễn Thị Quên','62'),
		  ('1011003','20T3',N'Đỗ Nhật Duy','61')
go
INSERT INTO bang_diem
	values('1896251',N'Võ Lê Nhật Huy','IV','3.2',N'Giỏi'),
		  ('1896252',N'Hồ Nguyễn Gia Bảo','IV','3.3',N'Giỏi'),
		  ('1896253',N'Huỳnh Ngọc Đạt','IV','2.6',N'Khá'),
		  ('1896254',N'Huỳnh Đức An','IV','2.9',N'Khá'),
		  ('1896255',N'Huỳnh Văn Tài','IV','2.3',N'Trung Bình')
GO

INSERT INTO thoi_khoa_bieu
	values('1896251','221LTJNC03',N'Java nâng cao','6','1','2',N'Đỗ Phú Huy','212'),
		  ('1896251','221DHPC02',N'Đồ hoạ máy tính','6','3','4',N'Phan Thanh Tao','202'),
		  ('1896252','221DHPC02',N'Đồ hoạ máy tính','6','3','4',N'Phan Thanh Tao','202'),
		  ('1896253','221LTJNC03',N'Java nâng cao','6','1','2',N'Đỗ Phú Huy','212'),
		  ('1896252','221LTTQ01',N'Lập trình trực quan','5','1','2',N'Hoàng Thị Mỹ Lệ','214'),
		  ('1896254','221LTTQ01',N'Lập trình trực quan','5','1','2',N'Hoàng Thị Mỹ Lệ','214')
GO

