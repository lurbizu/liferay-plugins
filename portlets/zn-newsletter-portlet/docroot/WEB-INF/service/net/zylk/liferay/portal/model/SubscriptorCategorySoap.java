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

package net.zylk.liferay.portal.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author zylk.net
 * @generated
 */
public class SubscriptorCategorySoap implements Serializable {
	public static SubscriptorCategorySoap toSoapModel(SubscriptorCategory model) {
		SubscriptorCategorySoap soapModel = new SubscriptorCategorySoap();

		soapModel.setSubscriptorCategoryId(model.getSubscriptorCategoryId());
		soapModel.setSubscriptorId(model.getSubscriptorId());
		soapModel.setCategoryId(model.getCategoryId());

		return soapModel;
	}

	public static SubscriptorCategorySoap[] toSoapModels(
		SubscriptorCategory[] models) {
		SubscriptorCategorySoap[] soapModels = new SubscriptorCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SubscriptorCategorySoap[][] toSoapModels(
		SubscriptorCategory[][] models) {
		SubscriptorCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SubscriptorCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SubscriptorCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SubscriptorCategorySoap[] toSoapModels(
		List<SubscriptorCategory> models) {
		List<SubscriptorCategorySoap> soapModels = new ArrayList<SubscriptorCategorySoap>(models.size());

		for (SubscriptorCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SubscriptorCategorySoap[soapModels.size()]);
	}

	public SubscriptorCategorySoap() {
	}

	public long getPrimaryKey() {
		return _subscriptorCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setSubscriptorCategoryId(pk);
	}

	public long getSubscriptorCategoryId() {
		return _subscriptorCategoryId;
	}

	public void setSubscriptorCategoryId(long subscriptorCategoryId) {
		_subscriptorCategoryId = subscriptorCategoryId;
	}

	public long getSubscriptorId() {
		return _subscriptorId;
	}

	public void setSubscriptorId(long subscriptorId) {
		_subscriptorId = subscriptorId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	private long _subscriptorCategoryId;
	private long _subscriptorId;
	private long _categoryId;
}