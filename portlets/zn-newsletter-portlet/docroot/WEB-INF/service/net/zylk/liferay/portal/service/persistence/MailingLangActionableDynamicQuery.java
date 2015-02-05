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

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import net.zylk.liferay.portal.model.MailingLang;
import net.zylk.liferay.portal.service.MailingLangLocalServiceUtil;

/**
 * @author zylk.net
 * @generated
 */
public abstract class MailingLangActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public MailingLangActionableDynamicQuery() throws SystemException {
		setBaseLocalService(MailingLangLocalServiceUtil.getService());
		setClass(MailingLang.class);

		setClassLoader(net.zylk.liferay.portal.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("mailingLangId");
	}
}