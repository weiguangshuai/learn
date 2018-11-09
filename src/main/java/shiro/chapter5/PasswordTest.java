package shiro.chapter5;

import org.apache.shiro.subject.Subject;
import org.junit.Test;
import shiro.ShiroUtil;

/**
 * <b><code>PasswordTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/9 14:35.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class PasswordTest {

    @Test
    public void testPasswordServiceWithMyRealm() {
        Subject subject = ShiroUtil.login("classpath:shiro-passwordservice.ini",
            "weigs", "123");
    }


    @Test
    public void testPasswordServiceWithJdbcRealm() {

    }

}
