package com.gyf.bos.web.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.gyf.bos.dao.IFunctionDao;
import com.gyf.bos.dao.IUserDao;
import com.gyf.bos.domain.Function;
import com.gyf.bos.domain.User;

public class BOSRealm extends AuthorizingRealm{
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IFunctionDao functionDao;
	//认证方法
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		UsernamePasswordToken upToken = (UsernamePasswordToken) token;
		String username = upToken.getUsername();
		User user = userDao.findByUsername(username);
		if(user == null){
			//用户不存在
		}else{
			//获取密码
			String pwd = user.getPassword();
			/*返回简单认证信息对象
			 * principal the 'primary' principal associated with the specified realm
			 * .credentials the credentials that verify the given principal
			 * .realmName the realm from where the principal and credentials were acquired
			 * 参数1：与指定realm关联的主体(用户)
			 * 参数2：密码
			 * 参数3：当前类名
			 * */
			SimpleAuthenticationInfo info = new SimpleAuthenticationInfo
					(user, pwd, this.getClass().getSimpleName());
			return info;//返回后，由安全管理器比较密码是否正确
		}
		System.out.println("AuthenticatingRealm-doGetAuthenticationInfo");
		return null;
	}
	
	//授权方法
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("doGetAuthorizationInfo...");
		User user = (User) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		List<Function> funs = null;
		if(user.getUsername().equals("admin")){
			//管理员拥有所有权限
			funs = functionDao.findAll();
		}else{
			funs = functionDao.findListByUserId(user.getId());
		}
		
		//授权
		for(Function f : funs){
			info.addStringPermission(f.getCode());
		}
		return info;
	}
}
