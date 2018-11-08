package shiro.chapter3.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.PermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

/**
 * <b><code>BitAndWildPermissionResolver</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/8 18:11.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class BitAndWildPermissionResolver implements PermissionResolver {
    @Override
    public Permission resolvePermission(String s) {
        if (s.startsWith("+")) {
            return new BitPermission(s);
        }
        return new WildcardPermission(s);
    }
}
