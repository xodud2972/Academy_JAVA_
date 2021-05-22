create table product(
   product_id  int primary key auto_increment
 , subcategory_id	int
 , product_name varchar(40)
 , price	int  default  0
 , brand	varchar(30)
 , detail	text
 , filename varchar(40)
 , constraint fk_subproduct foreign key(subcategory_id) 
   references subcategory(subcategory_id)
) default  character set utf8;