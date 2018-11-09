package shiro.chapter4;


import org.apache.shiro.subject.Subject;
import org.junit.Assert;
import org.junit.Test;
import shiro.ShiroUtil;

/**
 * <b><code>ConfigurationCreateTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/9 11:28.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class ConfigurationCreateTest {
    @Test
    public void test() {
        Subject subject = ShiroUtil.login("classpath:shiro-config.ini",
            "zhang", "123");
        Assert.assertTrue(subject.isAuthenticated());
    }
}
