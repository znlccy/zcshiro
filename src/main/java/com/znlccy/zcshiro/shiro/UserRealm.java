package com.znlccy.zcshiro.shiro;

import com.znlccy.zcshiro.domain.User;
import com.znlccy.zcshiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * author: TRS信息技术有限公司
 * date: 2019/2/27-12:54
 * version: 1.0.0
 * comment: 自定义Realm
 */
public class UserRealm extends AuthorizingRealm {

    /**
     * 自动依赖注入UserService
     */
    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");
        //给资源授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        //添加资源的授权字符串
        //info.addStringPermission("user:add");
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        User dbUser = userService.findById(user.getId());
        info.addStringPermission(dbUser.getPerms());
        return info;
    }

    /**
     * 执行认证逻辑
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        /*System.out.println("执行认证逻辑");*/

        //假设数据库的用户名和密码
        /*String username = "admin";
        String password = "123456";*/

        //编写Shiro判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;

        User user = userService.findByUsername(token.getUsername().toString());

        /*if (!token.getUsername().equals(username)) {
            return null;//shiro底层会抛出UnknownAccountException
        }*/
        if (user == null) {
            return null;//shiro底层会抛出UnknownAccountException
        }

        //2.判断密码
        return new SimpleAuthenticationInfo(user, user.getPassword(), "");
    }
}
