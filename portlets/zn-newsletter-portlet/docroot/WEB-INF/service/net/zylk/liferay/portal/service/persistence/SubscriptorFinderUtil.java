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

package net.zylk.liferay.portal.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author zylk.net
 */
public class SubscriptorFinderUtil {
	public static java.util.List<net.zylk.liferay.portal.model.Subscriptor> findByCategoryId(
		long categoryId, int begin, int end) {
		return getFinder().findByCategoryId(categoryId, begin, end);
	}

	public static SubscriptorFinder getFinder() {
		if (_finder == null) {
			_finder = (SubscriptorFinder)PortletBeanLocatorUtil.locate(net.zylk.liferay.portal.service.ClpSerializer.getServletContextName(),
					SubscriptorFinder.class.getName());

			ReferenceRegistry.registerReference(SubscriptorFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SubscriptorFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SubscriptorFinderUtil.class,
			"_finder");
	}

	private static SubscriptorFinder _finder;
}