package com.epam.shop.dao.sql_query;


/**
 * all queries from user to db
 */
public interface UserSql {
    String SQL_SAVE_USER = "INSERT INTO users(account,password,role_id,registration_date) VALUES(?,?,?,?)";
    String SQL_FIND_USER_BY_ACCOUNT_NAME = "SELECT id,account,password,registration_date,role_id FROM users WHERE account=?";
    String SQL_FIND_USER_BY_ID = "SELECT id,account,password,registration_date,role_id FROM users WHERE id=?";
    String SQL_UPDATE_USER_PASSWORD = "UPDATE users SET password=? WHERE id=?";
    String SQL_DELETE_USER = "DELETE FROM users WHERE id=?";
    String SQL_FIND_ALL_USERS = "SELECT id,account,password,registration_date,role_id FROM users";


}
