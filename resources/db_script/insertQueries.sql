USE `food_db`;

/* Insert into user table */
insert into `food_db`.`user` (`username`, `email`, `password`, `first_name`, `last_name`, `address`) 
		values ('user1', 'user1@email.com', 'usrpwd1', 'Mike', 'Fetchner', 'address1'),  
			   ('user2', 'user2@email.com', 'usrpwd2', 'Rob', 'Straight', 'address2'),
               ('user3', 'user3@email.com', 'usrpwd3', 'Jacob', 'Rayan', 'address3'),
               ('user4', 'user4@email.com', 'usrpwd4', 'God', 'Sach', 'address4');
        
select * from `food_db`.`user`;

/* Insert into restaurant table */
INSERT into `food_db`.`restaurant` (`name`, `rating`, `address`) 
		VALUES ('Habib', 3.8, 'Park Street'),
			   ('Sajjad', 4.2, 'Oval Square'),
               ('Kolachi', 4.0, 'Midtown');

select * from `food_db`.`restaurant`;

/* Insert into owners table */
insert into `food_db`.`owner` (`username`, `email`, `password`, `first_name`, `last_name`, `address`, `restaurant_idrestaurant`) 
		values ('owner1', 'user1@email.com', 'ownerpwd1', 'Habib', 'Habib', 'Bedford', 1), 
			   ('owner2', 'user2@email.com', 'ownerpwd2', 'Sajjad', 'Saik', 'Karachi', 2),
			   ('owner3', 'user3@email.com', 'ownerpwd3', 'Kolachi', 'Kaif', 'Karachi mart', 3);

select * from `food_db`.`owner`;
               
/*Insert into food item*/
insert into `food_db`.`food_item` (`item_name`, `food_category`)
		values ('Dal Fry', 'Veg'), ('Rice', 'Veg'), ('Paneer Kadhai', 'Veg'), 
			   ('Pulao', 'Veg'), ('Chilli Paneer', 'Veg'), ('Curry', 'Veg'), ('Dal Chawal', 'Veg'), ('Veg Biryani', 'Veg'),
               
               ('Chicken Tikka', 'Non-Veg'), ('Chicken Biryani', 'Non-Veg'), ('Fish Fry', 'Non-Veg'),
               ('Chicken Kadhai', 'Non-Veg'), ('Mutton Biryani', 'Non-Veg'), ('Fish Curry', 'Non-Veg'),
               ('Egg Roll', 'Non-Veg'), ('Mutton Keema', 'Non-Veg'), ('Chicken Fried Rice', 'Non-Veg'),
               
               ('Roti', 'Bread'), ('Naan', 'Bread'), ('Paratha', 'Bread'), ('Rumali Roti', 'Bread'),
               ('Butter Naan', 'Bread'), ('Kulcha', 'Bread'), ('Tava Roti', 'Bread'), ('Stuffed Naan', 'Bread'), ('Aloo Paratha', 'Bread'),
               
               ('Lime Juice', 'Beverage'), ('Milk Juice', 'Beverage'), ('Water', 'Beverage'),
               ('Soda Lime', 'Beverage'), ('Coffee', 'Beverage'), ('Tea', 'Beverage'), 
               ('Mojito', 'Beverage'), ('Orange Juice', 'Beverage'), ('Mint Lime', 'Beverage');

select * from `food_db`.`food_item`;

/*Insert into menu table*/
/* price, food_item_idfood restaurant_idrestaurant */
insert into `food_db`.`menu` (`price`, `food_item_idfood`, `restaurant_idrestaurant`)
		values (57,1,3	),
(120,1,2	),
(80,1,1	),
(83,2,3	),
(83,2,2	),
(72,2,1	),
(84,3,3	),
(105,3,2	),
(52,3,1	),
(44,4,3	),
(57,4,2	),
(90,4,1	),
(31,5,3	),
(36,5,2	),
(76,5,1	),
(111,6,3	),
(65,6,2	),
(64,6,1	),
(70,7,3	),
(117,7,2	),
(77,7,1	),
(128,8,3	),
(129,8,2	),
(118,8,1	),
(63,9,3	),
(62,9,2	),
(113,9,1	),
(53,10,3	),
(85,10,2	),
(71,10,1	),
(81,11,3	),
(125,11,2),	
(72,11,1	),
(96,12,3	),
(117,12,2),	
(68,12,1	),	
(69,13,3	),
(71,13,2	),
(35,13,1	),
(112,14,3),	
(102,14,2),	
(72,14,1	),
(76,15,3	),
(49,15,2	),
(105,15,1),	
(36,16,3	),
(125,16,2),
(81,16,1	),
(81,17,3	),
(65,17,2	),		
(84,17,1 ),
(63,18,3	),
(104,18,2),	
(51,18,1	),	
(126,19,3),		
(67,19,2	),
(109,19,1),	
(130,20,3),	
(118,20,2),
(94,20,1	),
(82,21,3	),
(50,21,2	),
(81,21,1	),
(125,22,3),	
(110,22,2),	
(115,22,1),		
(54,23,3	),
(71,23,2	),	
(42,23,1	),
(129,24,3),	
(50,24,2	),
(110,24,1),	
(37,25,3	),	
(52,25,2	),
(81,25,1	),
(42,26,3	),
(59,26,2 ),
(68,26,1	),
(47,27,3	),
(121,27,2),	
(70,27,1	),
(50,28,3	),
(124,28,2),	
(41,28,1	),
(83,29,3	),	
(49,29,2	),
(39,29,1	),
(87,30,3	),
(67,30,2	),
(67,30,1	),
(122,31,3),	
(121,31,2),	
(101,31,1),	
(103,32,3),	
(89,32,2	),
(107,32,1),
(122,33,3),	
(106,33,2),	
(104,33,1),
(102,34,3),
(61,34,2	),
(95,34,1	),
(86,35,3	),
(128,35,2),
(113,35,1);

select * from `food_db`.`menu`;

/*Insert into offers table*/
insert into `food_db`.`offers` (`name`, `description`, `start_date`, `end_date`, `code`, `discount`, `restaurant_idrestaurant`)
	values ('no offer', 'default no offer', '2022-01-01', '2022-01-01', 'NOOFFER_1', 0, 1),
		   ('no offer', 'default no offer', '2022-01-01', '2022-01-01', 'NOOFFER_2', 0, 2),
           ('no offer', 'default no offer', '2022-01-01', '2022-01-01', 'NOOFFER_3', 0, 3);

select * from `food_db`.`offers`;




        
        
        
        
        