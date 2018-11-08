package shiro.chapter3;

import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import shiro.ShiroUtil;

/**
 * <b><code>AuthorizerTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/8 19:49.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class AuthorizerTest {

    @Test
    public void testIsPermitted() {
        Subject subject = ShiroUtil.login("classpath:shiro-authorizer.ini", "zhang", "123");
        Assert.assertTrue(subject.isAuthenticated());
        Assert.assertTrue(subject.hasRole("role2"));
        Assert.assertTrue(subject.isPermitted("menu:*"));
    }
}
