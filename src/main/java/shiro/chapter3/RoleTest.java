package shiro.chapter3;

import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import shiro.ShiroUtil;

/**
 * <b><code>RoleTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/8 17:33.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class RoleTest {

    @Test
    public void testHasRole() {
        Subject subject = ShiroUtil.login("classpath:shiro-role.ini", "wang", "123");
        Assert.assertTrue(subject.isAuthenticated());
        Assert.assertTrue(subject.hasRole("role1"));
    }

}
