package net.izfe.liferay.auth;

import java.util.Map;

import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.security.auth.Authenticator;

public class ElkarlanaLDAPAuth implements Authenticator {

	@Override
	public int authenticateByEmailAddress(long companyId, String emailAddress,
			String password, Map<String, String[]> arg3,
			Map<String, String[]> arg4) throws AuthException {

		if (emailAddress.indexOf("@") == -1)
			return authenticateByScreenName(companyId, emailAddress, password,
					arg3, arg4);

		System.out.println("authenticateByEmailAddress");
		
		try {
			ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
			Class ldapAuth = cl
					.loadClass("com.liferay.portal.security.auth.LDAPAuth");
			Object ldapAuthInstance = ldapAuth.newInstance();
			java.lang.reflect.Method authenticateByEmailAddress = ldapAuth
					.getDeclaredMethod("authenticateByEmailAddress",
							long.class, String.class, String.class, Map.class,
							Map.class);

			int result = 0;
			result = (Integer) authenticateByEmailAddress.invoke(
					ldapAuthInstance, companyId, emailAddress, password, arg3,
					arg4);
			System.out.println("\tResult " + result);
			
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Authenticator.FAILURE;
	}

	@Override
	public int authenticateByScreenName(long companyId, String screenName,
			String password, Map<String, String[]> arg3,
			Map<String, String[]> arg4) throws AuthException {

		if (screenName.indexOf("@") != -1)
			return authenticateByEmailAddress(companyId, screenName, password,
					arg3, arg4);
		System.out.println("authenticateByScreenName");
		try {
			ClassLoader cl = PortalClassLoaderUtil.getClassLoader();
			Class ldapAuth = cl
					.loadClass("com.liferay.portal.security.auth.LDAPAuth");
			Object ldapAuthInstance = ldapAuth.newInstance();
			java.lang.reflect.Method authenticateByScreenName = ldapAuth
					.getDeclaredMethod("authenticateByScreenName",
							long.class, String.class, String.class, Map.class,
							Map.class);

			int result = 0;
			result = (Integer) authenticateByScreenName.invoke(
					ldapAuthInstance, companyId, screenName, password, arg3,
					arg4);
			System.out.println("\tResult " + result);
			
			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Authenticator.FAILURE;
	}

	@Override
	public int authenticateByUserId(long arg0, long arg1, String arg2,
			Map<String, String[]> arg3, Map<String, String[]> arg4)
			throws AuthException {
		// TODO Auto-generated method stub
		System.out.println("authenticateByUserId " + arg1);
		return Authenticator.SKIP_LIFERAY_CHECK;
	}

}
