/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package net.zylk.liferay.portal.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for UserSubscription. This utility wraps
 * {@link net.zylk.liferay.portal.service.impl.UserSubscriptionLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author zylk.net
 * @see UserSubscriptionLocalService
 * @see net.zylk.liferay.portal.service.base.UserSubscriptionLocalServiceBaseImpl
 * @see net.zylk.liferay.portal.service.impl.UserSubscriptionLocalServiceImpl
 * @generated
 */
public class UserSubscriptionLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link net.zylk.liferay.portal.service.impl.UserSubscriptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static void requestSubscription(long companyId, long groupId,
		java.lang.String name, java.lang.String surname,
		java.lang.String email, java.lang.String languageId, long[] categoryIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService()
			.requestSubscription(companyId, groupId, name, surname, email,
			languageId, categoryIds);
	}

	public static net.zylk.liferay.portal.model.Subscriptor confirmSubscription(
		java.lang.String ticketKey)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().confirmSubscription(ticketKey);
	}

	public static net.zylk.liferay.portal.model.Subscriptor confirmUnsubscription(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().confirmUnsubscription(uuid);
	}

	public static java.lang.String generateUnsubscriptionUrl(long companyId,
		long groupId, java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().generateUnsubscriptionUrl(companyId, groupId, uuid);
	}

	public static com.liferay.portal.model.Ticket validateTicket(
		java.lang.String ticketKey) {
		return getService().validateTicket(ticketKey);
	}

	public static void clearService() {
		_service = null;
	}

	public static UserSubscriptionLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					UserSubscriptionLocalService.class.getName());

			if (invokableLocalService instanceof UserSubscriptionLocalService) {
				_service = (UserSubscriptionLocalService)invokableLocalService;
			}
			else {
				_service = new UserSubscriptionLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(UserSubscriptionLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(UserSubscriptionLocalService service) {
	}

	private static UserSubscriptionLocalService _service;
}