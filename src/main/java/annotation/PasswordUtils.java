package annotation;

import java.util.List;

/**
 * @author weigs
 * @date 2018/12/5 0005
 */
public class PasswordUtils {
    @UseCase(id = 47, desc = "Password")
    public boolean validatePassowrd(String password) {
        return password.matches("\\w*\\d\\w*");
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, desc = "new password")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
