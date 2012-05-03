
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
    
    
       create table `rees`.`rule_device_info`(
        `DEVICE_ID` INT not null auto_increment,
       `DEVICE_PARAM` VARCHAR(255),
       `DEVICE_TYPE_ID` VARCHAR(255),
       `DEVICE_VAR` VARCHAR(255),
       `RESULT_ID` INT,
       `threshold_Id` VARCHAR(255),
        primary key (`DEVICE_ID`)
    );
    