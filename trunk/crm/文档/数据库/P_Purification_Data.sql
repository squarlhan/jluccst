/*净化客户数据存储过程*/
 CREATE PROCEDURE P_Purification_Data()
    BEGIN
   		 /*局部变量的定义 declare*/ 
         declare gv_table_name varchar(200) default '' ;
         declare gv_variable varchar(2550) default '' ;
         declare customer_cursor CURSOR FOR SELECT  distinct table_name as  tableName from information_schema.columns where table_schema ='crm' and table_name like 'customer_lib_info_for_%' ;
         /*游标 异常后 捕捉 并设置 循环使用 变量 tmpname 为 null 跳出循环。 */
         declare CONTINUE HANDLER FOR SQLSTATE '02000' SET gv_table_name = null;
   		 /*开游标*/ 
     	OPEN customer_cursor;
			/*游标向下走一步*/ 
         	FETCH customer_cursor INTO gv_table_name;
      		WHILE ( gv_table_name is not null) DO
      			/* 删除重复的客户信息，只保留一条*/
				set @v_del_str =  ' delete  a from ';
				set @v_del_str = CONCAT(@v_del_str , gv_table_name ) ;
				set @v_del_str = CONCAT(@v_del_str , '  a, (select c.customer_name, max(c.id) as  bid from  ' ) ;
				set @v_del_str = CONCAT(@v_del_str , gv_table_name ) ;
				set @v_del_str = CONCAT(@v_del_str , '  c  group by customer_name having count(id) >1) b where a.customer_name=b.customer_name and a.id < b.bid;  ' ) ;
				select @v_del_str ;
				prepare sqlstr from @v_del_str;
		  		execute sqlstr;
		  		commit;
          		deallocate prepare sqlstr; 
          		
          		/* 删除没有联系方式的客户信息*/
		  		set @v_table_suffix = substring_index(gv_table_name, '_', -1);
          		set @v_table_prefix='contract_person_lib_for_';  
          		set @v_table_name = CONCAT(@v_table_prefix , @v_table_suffix) ;
          		set @v_del_str = 'delete  ';
          		set @v_del_str = CONCAT(@v_del_str , gv_table_name  ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' from ' ) ;
          		set @v_del_str = CONCAT(@v_del_str , gv_table_name  ) ;
          		set @v_del_str = CONCAT(@v_del_str ,', ' ) ;
          		set @v_del_str = CONCAT(@v_del_str ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' where ' ) ;
          		set @v_del_str = CONCAT(@v_del_str ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' .customer_id= ' ) ;
          		set @v_del_str = CONCAT(@v_del_str , gv_table_name  ) ;
          		set @v_del_str = CONCAT(@v_del_str  ,' .id and ( length( ' ) ;
          		set @v_del_str = CONCAT(@v_del_str  ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' .phone) < 7  or  ' ) ;
          		set @v_del_str = CONCAT(@v_del_str ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' .phone is null or   length( ' ) ;
          		set @v_del_str = CONCAT(@v_del_str ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,'.phone ) =0)') ;
          		select @v_del_str ;

				prepare sqlstr from @v_del_str;
		  		execute sqlstr;
		  		commit;
          		deallocate prepare sqlstr; 
          		
          		/* 删除联系方式中联系人电话为空或者长度小于7的*/
          		set @v_del_str = 'delete from ';
          		set @v_del_str = CONCAT(@v_del_str ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' where ' ) ;
          		set @v_del_str = CONCAT(@v_del_str  ,' ( length( ' ) ;
          		set @v_del_str = CONCAT(@v_del_str  ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' .phone) < 7  or  ' ) ;
          		set @v_del_str = CONCAT(@v_del_str ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,' .phone is null or   length( ' ) ;
          		set @v_del_str = CONCAT(@v_del_str ,@v_table_name ) ;
          		set @v_del_str = CONCAT(@v_del_str ,'.phone ) =0)') ;
          		select @v_del_str ;
          		
          		prepare sqlstr from @v_del_str;
		  		execute sqlstr;
		  		commit;
          		deallocate prepare sqlstr; 
          		
        		/*游标向下走一步*/ 
       			FETCH customer_cursor INTO gv_table_name;
      		END WHILE;
		CLOSE customer_cursor;
END;


/*调用存储过程*/ 
call  P_Purification_Data();

