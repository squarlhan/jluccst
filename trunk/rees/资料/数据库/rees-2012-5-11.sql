	
	drop database rees;
	
	create database rees;
	
	use rees;
	
	create table `rees`.`advice_view`(
        `ADVICE_ID` INT not null auto_increment,
       `ADVICE` VARCHAR(255),
       `DEVICE_TYPE_ID` VARCHAR(255),
       `DEVICE_TYPE` VARCHAR(255),
        primary key (`ADVICE_ID`)
    );

    create table `rees`.`centerheight_and_speed`(
        `Id` INT not null auto_increment,
       `Center_Height_Expression` VARCHAR(255),
       `Speed_Expression` VARCHAR(255),
       `Threshold_Id` INT,
        primary key (`Id`)
    );
    
    create table `rees`.`device_info`(
        `id` VARCHAR(255) not null,
       `CENTER_HEIGHT` DECIMAL(19,2),
       `COMPANY_ID` VARCHAR(50),
       `CONTROL_POINT` INT,
       `CREATE_TIME` DATETIME,
       `DEVICE_FACTORY` VARCHAR(255),
       `DEVICE_MODEL` VARCHAR(255),
       `DEVICE_NAME` VARCHAR(255),
       `DEVICE_NUM` VARCHAR(255),
       `DEVICE_TYPE_ID` VARCHAR(255),
       `DEVICE_TYPE_NAME` VARCHAR(255),
       `FACTORY_ID` VARCHAR(255),
       `FILE_PATH` VARCHAR(255),
       `ISDELETE` INT,
       `POWER` DECIMAL(19,2),
       `SORT_INDEX` INT,
       `SPEED` DECIMAL(19,2),
       `WORKSHOP_ID` VARCHAR(255),
        primary key (`id`)
    );
    
     create table `rees`.`device_point_data`(
        `id` VARCHAR(255) not null,
       `CREATE_TIME` DATETIME,
       `DATA_INFO` VARCHAR(255),
       `DATA_YEAR` INT,
       `DEVICE_ID` VARCHAR(255),
       `PARAM_ID` VARCHAR(255),
       `POINT_ID` VARCHAR(255),
       `UPDATE_TIME` DATETIME,
       `USER_ID` VARCHAR(255),
       `USER_NAME` VARCHAR(255),
       `WEEK_OF_YEAR` INT,
        primary key (`id`)
    );

	create table `rees`.`device_point_info`(
        `id` VARCHAR(255) not null,
       `CONTROL_POINT_NAME` VARCHAR(255),
       `DEVICE_ID` VARCHAR(255),
       `POSITIONX` INT,
       `POSITIONY` INT,
       `STATUS` INT,
        primary key (`id`)
    );
    
    create table `rees`.`device_point_param`(
        `id` VARCHAR(255) not null,
       `DEVICE_ID` VARCHAR(255),
       `NAME` VARCHAR(255),
       `POINT_ID` VARCHAR(255),
       `SORT_INDEX` INT,
        primary key (`id`)
    );
    
    create table `rees`.`device_type`(
        `id` VARCHAR(255) not null,
       `CENTER_HEIGHT` DECIMAL(19,2),
       `POWER` DECIMAL(19,2),
       `SPEED` DECIMAL(19,2),
       `DEVICE_TYPE` VARCHAR(255),
        primary key (`id`)
    );
    
    create table `rees`.`error_log`(
        `id` VARCHAR(255) not null,
       `DEPT_NAME` VARCHAR(255),
       `DEVICE_NAME` VARCHAR(255),
       `DEVICE_NUM` VARCHAR(255),
       `ERROR_DATA` FLOAT,
       `ERROR_PHEN` VARCHAR(255),
       `ERROR_REASON` VARCHAR(255),
       `ERROR_THRESH` FLOAT,
       `ERROR_TIME` DATETIME,
       `ISREMOVE` INT,
       `OPINION` VARCHAR(255),
       `REMOVE_TIME` DATETIME,
        primary key (`id`)
    );
    
    create table `rees`.`forum_issue_info`(
        `id` VARCHAR(255) not null,
       `CREATE_TIME` DATETIME,
       `CREATOR` VARCHAR(255),
       `ISSUE_CONTENT` VARCHAR(255),
       `ISSUE_NAME` VARCHAR(255),
       `ISSUE_Status` INT,
        primary key (`id`)
    );
    
    create table `rees`.`forum_message_info`(
        `id` VARCHAR(255) not null,
       `ISSUE_ID` VARCHAR(255),
       `MESSAGE_CONTENT` VARCHAR(255),
       `MESSAGE_TIME` DATETIME,
       `PUBLISHER` VARCHAR(255),
       `PUBLISHER_DEPT` VARCHAR(255),
        primary key (`id`)
    );
    
    
     create table `rees`.`group_company`(
        `id` VARCHAR(255) not null,
       `ADDRESS` VARCHAR(255),
       `COMPANY_NAME` VARCHAR(255),
       `CREATE_TIME` DATETIME,
       `PHONE` VARCHAR(255),
       `ROOT_ID` VARCHAR(255),
       `SORT_INDEX` INT,
        primary key (`id`)
    );

	create table `rees`.`group_factory`(
        `id` VARCHAR(255) not null,
       `COMPANY_ID` VARCHAR(255),
       `CREATE_TIME` DATETIME,
       `FACTORY_NAME` VARCHAR(255),
       `PHONE` VARCHAR(255),
       `PRINCIPAL` VARCHAR(255),
       `SORT_INDEX` INT,
        primary key (`id`)
    );
    
    create table `rees`.`group_popedom_role`(
        `id` VARCHAR(255) not null,
       `KEYWORD` VARCHAR(255),
       `ROLE_ID` VARCHAR(255),
        primary key (`id`)
    );
    
    create table `rees`.`group_role`(
        `id` VARCHAR(255) not null,
       `CREATE_TIME` DATETIME,
       `ROLE_NAME` VARCHAR(255),
       `SORT_INDEX` INT,
        primary key (`id`)
    );
    
    create table `rees`.`group_user`(
        `id` VARCHAR(255) not null,
       `COMPANY_ID` VARCHAR(255),
       `CREATE_TIME` DATETIME,
       `deleteFlag` INT not null,
       `EMAIL` VARCHAR(255),
       `FACTORY_ID` VARCHAR(255),
       `OFFICE_PHONE` VARCHAR(255),
       `PASSWORD` VARCHAR(255),
       `PHONE` VARCHAR(255),
       `ROLE_ID` VARCHAR(255),
       `ROLE_NAME` VARCHAR(255),
       `SORT_INDEX` INT,
       `USERCNAME` VARCHAR(255),
       `USER_TYPE` INT,
       `USERNAME` VARCHAR(255),
       `WORKSHOP_ID` VARCHAR(255),
        primary key (`id`)
    );
    
    create table `rees`.`group_workshop`(
        `id` VARCHAR(255) not null,
       `COMPANY_ID` VARCHAR(255),
       `CREATE_TIME` DATETIME,
       `FACTORY_ID` VARCHAR(255),
       `PHONE` VARCHAR(255),
       `PRINCIPAL` VARCHAR(255),
       `SORT_INDEX` INT,
       `WORKSHOP_NAME` VARCHAR(255),
        primary key (`id`)
    );
    
     create table `rees`.`notice_info`(
        `id` VARCHAR(255) not null,
       `NOTICE_CONTENT` VARCHAR(255),
       `NOTICE_EXPIREDTIME` VARCHAR(255),
       `NOTICE_PUBLISHTIME` DATETIME,
       `NOTICE_TITLE` VARCHAR(255),
       `PUBLISHER` VARCHAR(255),
       `PUBLISHER_DEPT` VARCHAR(255),
        primary key (`id`)
    );
    
    create table `rees`.`notice_read_info`(
        `id` VARCHAR(255) not null,
       `NOTICE_ID` VARCHAR(255),
       `USER_ID` VARCHAR(255),
        primary key (`id`)
    );
	
	create table `rees`.`reason_view`(
        `REASON_ID` INT not null auto_increment,
       `DEVICE_TYPE_ID` VARCHAR(255),
       `REASON` VARCHAR(255),
       `DEVICE_TYPE` VARCHAR(255),
        primary key (`REASON_ID`)
    );
    
    create table `rees`.`report_person`(
        `id` VARCHAR(255) not null,
       `CREATE_TIME` DATETIME,
       `DEPT_ID` VARCHAR(255),
       `ISDELETE` INT,
       `REPORT_CONTENT` VARCHAR(255),
       `REPORT_DATE` DATETIME,
       `REPORT_PERSON` VARCHAR(255),
       `REPORT_STATE` INT,
       `REPORT_SUBJECT` VARCHAR(255),
       `REPORT_TYPE` VARCHAR(255),
       `TEMPLATE_ID` VARCHAR(255),
        primary key (`id`)
    );
    
    create table `rees`.`report_template`(
        `id` VARCHAR(255) not null,
       `CREATE_TIME` DATETIME,
       `REPORT_CONTENT` VARCHAR(255),
       `REPORT_DATE` DATETIME,
       `REPORT_PERSON` VARCHAR(255),
       `REPORT_SUBJECT` VARCHAR(255),
       `REPORT_TYPE` VARCHAR(255),
       `TEMPLATE_NAME` VARCHAR(255),
       `TEMPLATE_PATH` VARCHAR(255),
        primary key (`id`)
    );
    
    create table `rees`.`result_view`(
        `RESULT_ID` INT not null auto_increment,
       `DEVICE_TYPE_ID` VARCHAR(255),
       `RESULT` VARCHAR(255),
       `DEVICE_TYPE` VARCHAR(255),
        primary key (`RESULT_ID`)
    );
    
    create table `rees`.`rule_advice_info`(
        `ADVICE_ID` INT not null auto_increment,
       `ADVICE` VARCHAR(255),
       `DEVICE_TYPE_ID` VARCHAR(255),
        primary key (`ADVICE_ID`)
    );
    
    create table `rees`.`rule_device_info`(
        `DEVICE_ID` INT not null auto_increment,
       `DEVICE_TYPE_ID` VARCHAR(255),
       `RESULT_ID` INT unique,
       `DEVICE_PARAM` VARCHAR(255),
       `threshold_Id` VARCHAR(255),
       `DEVICE_VAR` VARCHAR(255),
        primary key (`DEVICE_ID`)
    );
    
     create table `rees`.`rule_info`(
        `id` INT not null auto_increment,
       `ADVICE_ID` INT,
       `DEVICE_TYPE_ID` VARCHAR(255),
       `REASON_ID` VARCHAR(255),
       `RESULT_ID` VARCHAR(255),
        primary key (`id`)
    );
    
    create table `rees`.`rule_reason_info`(
        `REASON_ID` INT not null auto_increment,
       `DEVICE_TYPE_ID` VARCHAR(255),
       `REASON` VARCHAR(255),
        primary key (`REASON_ID`)
    );
    
    create table `rees`.`rule_result_info`(
        `RESULT_ID` INT not null auto_increment,
       `DEVICE_TYPE_ID` VARCHAR(255),
       `RESULT` VARCHAR(255),
        primary key (`RESULT_ID`)
    );
    
    create table `rees`.`threshold_category`(
        `Category_Id` INT not null auto_increment,
       `Category_Name` VARCHAR(255),
       `Create_Time` DATETIME,
        primary key (`Category_Id`)
    );

	create table `rees`.`threshold_item`(
        `Threshold_Item_Id` INT not null auto_increment,
       `Create_Time` DATETIME,
       `Threshold_Sign` INT,
       `Threshold_Item_Expression` VARCHAR(255),
       `Threshold_Item_Name` VARCHAR(255),
       `Threshold_Id` INT not null,
        primary key (`Threshold_Item_Id`)
    );
    
    create table `rees`.`threshold`(
        `Threshold_Id` INT not null auto_increment,
       `Create_Time` DATETIME,
       `Threshold_Name` VARCHAR(255),
       `Threshold_Unit` VARCHAR(255),
       `Threshold_Category_Id` INT not null,
        primary key (`Threshold_Id`)
    );

    INSERT INTO `group_user` VALUES ('1', NULL, NULL, 0, NULL, NULL, NULL, 'b59c67bf196a4758191e42f76670ceba', NULL, NULL, NULL, 0, '超级管理员', 9, 'admin', NULL);
    