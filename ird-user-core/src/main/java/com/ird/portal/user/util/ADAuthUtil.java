package com.ird.portal.user.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

/**
 * AD 驗證
 * <br/>
 * <br/>
 * <b>Date:</b>2018年4月18日<br/>
 * @author linwood
 * @version 1.0
 */
public class ADAuthUtil {
	private static final Logger log = LoggerFactory.getLogger(ADAuthUtil.class);

	private static String LDAP_URL = "ldap://192.168.200.111:389";
	private static String LDAP_DOMAIN_NAME = "@atos.net";
	/**
	 * AD 認證
	 * @param username 必須 email格式 ,也就是 AD 中的 accountName@your.domain.name
	 * @param password
	 * @return 
	 * 0-無法認證 
	 * 1-認證成功
	 * 2-用戶名或密碼為NULL 
	 * 3-LDAP_URL獲取失敗
	 * 4-LDAP_DOMAIN_NAME認證的域名獲取失敗 
	 * 5-沒有該用戶 
	 * 6-密碼錯誤
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static int auth(String username, String password,String ldap_url,String ldap_domain_name) {
		int flag = 0;
		if(StringUtils.isBlank(username)){
			return 2;//用戶名或密碼為NULL 
		}
		if(StringUtils.isBlank(password)){
			return 2;//用戶名或密碼為NULL 
		}
		Hashtable env = new Hashtable();
		// ActiveDirectory 实际提供主机位址
		if(StringUtils.isBlank(ldap_url)){
			return 3;//LDAP_URL獲取失敗
		}
		env.put(Context.PROVIDER_URL, ldap_url);
		
		//如果username 不是email 格式 需要進行轉換
		if(!(username.matches("[a-zA-Z0-9_-]+@(([a-zA-Z0-9_-]+)\\.)+([a-zA-Z0-9_-])+"))){
			if(StringUtils.isBlank(ldap_domain_name)){
				return 4;//LDAP_DOMAIN_NAME認證的域名獲取失敗 
			}else{
				username = username+"@"+ldap_domain_name;
			}
		}
		// 认证用戶，必須完整 email格式 ,也就是 AD 中的 accountName@your domain name
		env.put(Context.SECURITY_PRINCIPAL, username);
		// 认证密碼
		env.put(Context.SECURITY_CREDENTIALS, password);
		
		env.put(Context.INITIAL_CONTEXT_FACTORY,"com.sun.jndi.ldap.LdapCtxFactory");
		// 使用 username + password 进行认证
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		String autheStr = "";
		DirContext ctx = null;
		boolean success = true;
		try {
			// 若可建立目录物件，即表示完成登入
			ctx = new InitialDirContext(env);
			success = true;
		} catch (AuthenticationException authe) {
			// 授权失败
			success = false;
			log.error("AuthenticationException" + authe.getMessage(), authe);
			autheStr = authe.toString();
		} catch (Exception e) {
			success = false;
			log.error("Exception " + e.getMessage(), e);
		} finally {
			try {
				if(ctx != null){
					ctx.close();
				}
			} catch (Exception e) {
				log.error("Exception " + e.getMessage(), e);
			}
		}
		if (success) {
			// 成功
			flag = 1;
		}else{
			if (autheStr.indexOf("data 525") >= 0) {
				// 没此用户
				flag = 5;
			}
			if (autheStr.indexOf("data 52e") >= 0) {
				// 密码错误
				flag = 6;
			}
		}
		return flag;
	}

	public static String getLdapUrl() {
		return LDAP_URL;
	}

	public static void setLdapUrl(String ldapUrl) {
		LDAP_URL = ldapUrl;
	}

	public static String getLdapDomainName() {
		return LDAP_DOMAIN_NAME;
	}

	public static void setLdapDomainName(String ldapDomainName) {
		LDAP_DOMAIN_NAME = ldapDomainName;
	}

	public static void main(String[] args) {
//		System.out.println(ADAuthUtil.auth("administrator", "P@ssw0rd"),null,null);
//		System.out.println("12132@132@atos.net".matches("[a-zA-Z0-9_-]+@(([a-zA-Z0-9_-]+)\\.)+([a-zA-Z0-9_-])+"));
	}
	
}
