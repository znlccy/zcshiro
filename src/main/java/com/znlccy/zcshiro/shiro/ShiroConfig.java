package com.znlccy.zcshiro.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * author: TRS信息技术有限公司
 * date: 2019/2/27-12:44
 * version: 1.0.0
 * comment: Shiro配置文件
 */

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //Shiro内置过滤器，可以实现权限相关的拦截器
        /**
         * 常用的过滤器：
         * anon: 无需认证(登录)可以访问
         * authc：必须认证才可以访问
         * user: 如过使用了rememberMe的功能可以直接访问
         * perms: 该资源必须得到资源权限才可以访问
         * role: 该资源必须得到角色权限才可以访问
         */
        Map<String, String> filterMap = new LinkedHashMap<String, String>();
        /*filterMap.put("/user/add", "authc");
        filterMap.put("/user/edit", "authc");*/
        filterMap.put("/user/register", "anon");
        filterMap.put("/user/doLogin", "anon");
        /*filterMap.put("/user/*", "authc");*/
        filterMap.put("/user/add", "perms[user:add]");
        filterMap.put("/user/edit", "perms[user:edit]");

        //修改调整的登录页面
        shiroFilterFactoryBean.setLoginUrl("/user/login");
        //设置未授权提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/unAuth");

        //授权过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;

    }

    /**
     * 创建DefaultWebSecurityManager
     * @return
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联Realm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建Realm
     */
    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }

    /**
     * 配置ShiroDialect，用于Thymeleaf和Shiro标签配合使用
     */
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
