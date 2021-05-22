create  table  sub_image(
    sub_image_id	int primary key auto_increment
  , product_id	int
  , img_name varchar(40)
  , constraint fk_productimg foreign key(product_id) 
     references  product(product_id)
);