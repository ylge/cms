package com.ehu.shiro;

import com.ehu.bean.ShiroUser;
import com.ehu.bean.entity.system.SysUser;
import com.ehu.service.ShiroFactory;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Mr.Yangxiufeng on 2017/6/20.
 * Time:15:48
 * ProjectName:Common-admin
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    private ShiroFactory shiroFactory;

    /***
     * <p>授权</p>
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        ShiroUser user = (ShiroUser)principalCollection.getPrimaryPrincipal();

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRoles(user.getRoleValues());
        info.addStringPermissions(user.getPermissionValues());
        return info;
    }

    /**
     * <p>登录</p>
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        SysUser user = shiroFactory.user(token.getUsername());
        ShiroUser shiroUser = shiroFactory.shiroUser(user);
        SimpleAuthenticationInfo info = shiroFactory.buildAuthenticationInfo(shiroUser,user,super.getName());
        return info;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);
        hashedCredentialsMatcher.setHashIterations(ShiroKit.hashIterations);
        super.setCredentialsMatcher(hashedCredentialsMatcher);
    }
}
