package shiro.chapter3;

import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import shiro.ShiroUtil;

/**
 * <b><code>PermissionTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/8 17:45.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class PermissionTest {
    @Test
    public void testPermitted() {
        Subject subject = ShiroUtil.login("classpath:shiro-role.ini", "wang", "123");
        Assert.assertTrue(subject.isPermitted("user:create"));
    }
}
