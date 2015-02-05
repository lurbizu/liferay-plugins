/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.asset.entry.set.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for AssetEntrySet. This utility wraps
 * {@link com.liferay.asset.entry.set.service.impl.AssetEntrySetServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see AssetEntrySetService
 * @see com.liferay.asset.entry.set.service.base.AssetEntrySetServiceBaseImpl
 * @see com.liferay.asset.entry.set.service.impl.AssetEntrySetServiceImpl
 * @generated
 */
public class AssetEntrySetServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.asset.entry.set.service.impl.AssetEntrySetServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.asset.entry.set.model.AssetEntrySet addAssetEntrySet(
		long parentAssetEntrySetId, long creatorClassNameId,
		long creatorClassPK, java.lang.String payload, java.io.File file,
		boolean privateAssetEntrySet)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAssetEntrySet(parentAssetEntrySetId, creatorClassNameId,
			creatorClassPK, payload, file, privateAssetEntrySet);
	}

	public static com.liferay.asset.entry.set.model.AssetEntrySet addAssetEntrySet(
		long parentAssetEntrySetId, java.lang.String payload,
		java.io.File file, boolean privateAssetEntrySet)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addAssetEntrySet(parentAssetEntrySetId, payload, file,
			privateAssetEntrySet);
	}

	public static com.liferay.asset.entry.set.model.AssetEntrySet addAssetEntrySet(
		java.lang.String payload, java.io.File file,
		boolean privateAssetEntrySet)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addAssetEntrySet(payload, file, privateAssetEntrySet);
	}

	public static java.util.List<com.liferay.asset.entry.set.model.AssetEntrySet> getNewAssetEntrySets(
		long createTime, long parentAssetEntrySetId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getNewAssetEntrySets(createTime, parentAssetEntrySetId,
			start, end);
	}

	public static java.util.List<com.liferay.asset.entry.set.model.AssetEntrySet> getOldAssetEntrySets(
		long createTime, long parentAssetEntrySetId, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getOldAssetEntrySets(createTime, parentAssetEntrySetId,
			start, end);
	}

	public static com.liferay.asset.entry.set.model.AssetEntrySet likeAssetEntrySet(
		long assetEntrySetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().likeAssetEntrySet(assetEntrySetId);
	}

	public static com.liferay.asset.entry.set.model.AssetEntrySet unlikeAssetEntrySet(
		long assetEntrySetId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().unlikeAssetEntrySet(assetEntrySetId);
	}

	public static void clearService() {
		_service = null;
	}

	public static AssetEntrySetService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					AssetEntrySetService.class.getName());

			if (invokableService instanceof AssetEntrySetService) {
				_service = (AssetEntrySetService)invokableService;
			}
			else {
				_service = new AssetEntrySetServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(AssetEntrySetServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(AssetEntrySetService service) {
	}

	private static AssetEntrySetService _service;
}