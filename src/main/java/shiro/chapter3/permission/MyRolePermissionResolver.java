package shiro.chapter3.permission;

import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;

import java.util.Collection;
import java.util.Collections;

/**
 * <b><code>MyRolePermissionResolver</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/8 19:25.
 *
 * @author weigs
 * @since learn 2.0.0
 */
public class MyRolePermissionResolver implements RolePermissionResolver {

    @Override
    public Collection<Permission> resolvePermissionsInRole(String s) {
        if ("role1".equals(s)) {
            return Collections.singletonList(new WildcardPermission("menu:*"));
        }
        return null;
    }
}
