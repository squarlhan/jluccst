TRUNCATE TABLE `group_user`;

INSERT INTO `group_user` (`id`, `CREATE_TIME`, `PASSWORD`, `SORT_INDEX`, `USERCNAME`, `USER_TYPE`, `USERNAME`,`LUNAR_SOLAR_FLAG`) VALUES ('1', '2012-6-1 00:00:00', 'b59c67bf196a4758191e42f76670ceba', 0, '超级管理员', 9, 'admin',1);

 alter table group_user alter column deleteFlag set default 0;
 
 update GROUP_USER set LUNAR_SOLAR_FLAG = 0
 
 select   
referenced_table_name,table_name,
    concat(table_name, '.', column_name) as 'foreign key',    
    concat(referenced_table_name, '.', referenced_column_name) as 'references'  
from  
    information_schema.key_column_usage  
where  
    table_schema='crm' and  
    referenced_table_name is not null;  
    
    
    
--需要外键
--ALTER TABLE sms_info DROP FOREIGN KEY FK2A40AFF46D4294D0;  