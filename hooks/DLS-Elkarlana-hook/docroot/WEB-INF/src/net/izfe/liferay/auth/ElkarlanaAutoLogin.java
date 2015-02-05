package net.izfe.liferay.auth;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AutoLogin;
import com.liferay.portal.security.auth.AutoLoginException;
import com.liferay.portal.security.ldap.PortalLDAPImporterUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionCheckerFactoryUtil;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.OmniadminControlPanelEntry;

public class ElkarlanaAutoLogin implements AutoLogin {

	@Override
	public String[] handleException(HttpServletRequest arg0,
			HttpServletResponse arg1, Exception arg2) throws AutoLoginException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] login(HttpServletRequest arg0, HttpServletResponse arg1)
			throws AutoLoginException {

		String login = arg0.getParameter("_58_login");
		String password = arg0.getParameter("_58_password");
		
		
		if(login==null)
			login = (String)arg0.getSession().getAttribute("login");
		else
			arg0.getSession().setAttribute("login", login);
		
		if(password==null)
			password = (String)arg0.getSession().getAttribute("password");
		else
			arg0.getSession().setAttribute("password", password);
		
		
		long companyId = 0;

		try {
			companyId = PortalUtil.getCompany(arg0).getCompanyId();

			User u = null;
			if (login == null) {
				return null;
			} else if (login.indexOf("@") != -1) {
				_log.debug("Loging in with email.");

				String[] creds = getOmniadminCredentialsWithEmailAddress(
						companyId, login, password);
				if (creds != null)
					return creds;

				_log.debug("User is not omniadmin");
				int result = authenticateByEmailAddress(companyId, login,
						password);
				try {
					u = UserLocalServiceUtil.getUserByEmailAddress(companyId,
							login);
					if (result == 1 && false) {
						return getCredentials(u);
					} else{// if (result == -1) {
						_log.debug("Did not pass LDAP auth");
						if (validateLocal(u, password)) {
							return getCredentials(u);
						} else {
							_log.debug("Did not pass LOCAL auth");
							return null;
						}
					}
				} catch (Exception e) {
					_log.debug("User does not exist and has not been imported");
					return null;
				}

			} else {
				_log.debug("Loging in with screenName.");

				String[] creds = getOmniadminCredentialsWithScreenName(
						companyId, login, password);
				if (creds != null)
					return creds;
				
				_log.debug("User is not omniadmin");
				int result = authenticateByScreenName(companyId, login,
						password);
				try {
					u = UserLocalServiceUtil.getUserByScreenName(companyId,
							login);
					if (result == 1 && false) {
						return getCredentials(u);
					} else{// if (result == -1) {
						_log.debug("Did not pass LDAP auth");
						if (validateLocal(u, password)) {
							return getCredentials(u);
						} else {
							_log.debug("Did not pass LOCAL auth");
							return null;
						}
					}
				} catch (Exception e) {
					_log.debug("User does not exist and has not been imported");
					return null;
				}

			}

		} catch (NoSuchUserException nsue) {
			_log.debug("Trying to log with a nonexistent user");
		} catch (OmniAdminLoginException e) {
			_log.error("Error loging in with omniadmin?", e);
		} catch (Exception e) {
			_log.error("Unknown  error", e);
		}

		return null;
	}

	private String[] getOmniadminCredentialsWithScreenName(long companyId,
			String login, String password) throws Exception {
		User u = null;
		PermissionChecker pc = null;
		try {
			u = UserLocalServiceUtil.getUserByScreenName(companyId, login);
			pc = PermissionCheckerFactoryUtil.create(u);
		} catch (Exception e) {
			return null;
		}
		
		if (pc.isOmniadmin()) {
			if (validateLocal(u, password)) {
				return getCredentials(u);
			} else {
				_log.debug("Omni Did not pass LOCAL auth");
				throw new OmniAdminLoginException();
			}
		} else {
			return null;
		}
	}

	private String[] getOmniadminCredentialsWithEmailAddress(long companyId,
			String login, String password) throws Exception {
		
		User u = null;
		PermissionChecker pc = null;
		try {
			u = UserLocalServiceUtil.getUserByEmailAddress(companyId, login);
			pc = PermissionCheckerFactoryUtil.create(u);
		} catch (Exception e) {
			return null;
		}
		
		if (pc.isOmniadmin()) {
			if (validateLocal(u, password)) {
				return getCredentials(u);
			} else {
				_log.debug("Omni Did not pass LOCAL auth");
				throw new OmniAdminLoginException();
			}
		} else {
			return null;
		}

	}

	private User doOmniadminLoginWithEmailAddress(long companyId, String login) {
		// TODO Auto-generated method stub
		return null;
	}

	private int authenticateByEmailAddress(long companyId, String login,
			String password) {
		return authenticate("authenticateByEmailAddress", companyId, login,
				password);
	}

	private int authenticateByScreenName(long companyId, String login,
			String password) {
		return authenticate("authenticateByScreenName", companyId, login,
				password);
	}

	private int authenticate(String methodName, long companyId, String login,
			String password) {
		ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
		try {

			Class<?> ldapAuth = cl
					.loadClass("com.liferay.portal.security.auth.LDAPAuth");
			Object ldapAuthInstance = ldapAuth.newInstance();
			java.lang.reflect.Method authenticateMethod = ldapAuth
					.getDeclaredMethod(methodName, long.class, String.class,
							String.class, Map.class, Map.class);

			return (Integer) authenticateMethod.invoke(ldapAuthInstance,
					companyId, login, password, null, null);
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	private boolean validateLocal(User u, String password) {
		try {
			ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
			Class<?> pwdAuthenticator = cl
					.loadClass("com.liferay.portal.security.pwd.PwdAuthenticator");
			Object pwdAuthenticatorInstance = pwdAuthenticator.newInstance();
			java.lang.reflect.Method authenticate = pwdAuthenticator
					.getDeclaredMethod("authenticate", String.class,
							String.class, String.class);
			boolean validated = (Boolean) authenticate.invoke(
					pwdAuthenticatorInstance, String.valueOf(u.getUserId()),
					password, u.getPassword());
			return validated;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private String[] getCredentials(User u) {
		String[] credentials = new String[3];
		credentials[0] = String.valueOf(u.getUserId());
		credentials[1] = u.getPassword();
		credentials[2] = Boolean.TRUE.toString();
		return credentials;
	}
	

	private static Log _log = LogFactoryUtil.getLog(ElkarlanaAutoLogin.class);

}
