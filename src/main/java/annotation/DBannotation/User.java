package annotation.DBannotation;

import annotation.DBannotation.annotation.Constraints;
import annotation.DBannotation.annotation.DBTable;
import annotation.DBannotation.annotation.SQLInteger;
import annotation.DBannotation.annotation.SQLString;

/**
 * @author weigs
 * @date 2018/12/6 0006
 */
@DBTable(name = "T_USER")
public class User {
    @SQLInteger(name = "ID", constraints =
    @Constraints(primaryKey = true, allowNull = false, unique = true))
    private int userId;
    @SQLString(20)
    private String username;
    @SQLString(255)
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
