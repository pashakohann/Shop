package com.epam.shop.dao.sql_query;

public interface AccountSql {
    String FIND_ACCOUNT_BY_USER_ID = "SELECT id,first_name,last_name,date_of_birth,telephone_number,email,city,street,flat,amount,user_id FROM accounts WHERE user_id=?";
    String SQL_SAVE_ACCOUNT = "INSERT INTO accounts (first_name,last_name,date_of_birth,telephone_number,email,city,street,flat,amount,user_id)  VALUES(?,?,?,?,?,?,?,?,?,?)";
    String SQL_UPDATE_ACCOUNT_INFORMATION = "UPDATE accounts SET first_name=?,last_name=?,date_of_birth=?,telephone_number=?,email=?,city=?,street=?,flat=?,amount=?,user_id=? WHERE id=?";
    String SQL_DELETE_ACCOUNT = "DELETE FROM accounts WHERE id=?";
    String SQL_FIND_ALL_ACCOUNTS = "SELECT id,first_name,last_name,date_of_birth,telephone_number,email,city,street,flat,amount,user_id FROM accounts ";

}
