package shiro.chapter2;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <b><code>LoginLogoutTest</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/8 15:49.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class LoginLogoutTest {
    private final static Logger log = LoggerFactory.getLogger(LoginLogoutTest.class);

    @Test
    public void testHelloWorld() {
        //获取securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //得到securityManager实例，并绑定到securityUtils
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            //登录，验证用户信息
            subject.login(token);
        } catch (AuthenticationException e) {
            //登录失败
            log.error("登录失败", e);
        }
        Assert.assertTrue(subject.isAuthenticated());
        //退出
        subject.logout();

    }

    @Test
    public void testCustomRealm() {
        Factory<SecurityManager> factory =
            new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            log.error("登录失败", e);
        }
        Assert.assertTrue(subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testCustomMultiRealm() {
        Factory<SecurityManager> factory =
            new IniSecurityManagerFactory("classpath:shiro-multi-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            log.error("登录失败", e);
        }
        Assert.assertTrue(subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testJDBCRealm() {
        Factory<SecurityManager> factory =
            new IniSecurityManagerFactory("classpath:shiro-jdbc-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");

        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            log.error("登录失败", e);
        }
        Assert.assertTrue(subject.isAuthenticated());
        subject.logout();
    }

    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }


}
