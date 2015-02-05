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

package net.zylk.liferay.portal.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import net.zylk.liferay.portal.model.MailingSubscriptor;
import net.zylk.liferay.portal.model.MailingSubscriptorModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the MailingSubscriptor service. Represents a row in the &quot;ZN_MailingSubscriptor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link net.zylk.liferay.portal.model.MailingSubscriptorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MailingSubscriptorImpl}.
 * </p>
 *
 * @author zylk.net
 * @see MailingSubscriptorImpl
 * @see net.zylk.liferay.portal.model.MailingSubscriptor
 * @see net.zylk.liferay.portal.model.MailingSubscriptorModel
 * @generated
 */
public class MailingSubscriptorModelImpl extends BaseModelImpl<MailingSubscriptor>
	implements MailingSubscriptorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a mailing subscriptor model instance should use the {@link net.zylk.liferay.portal.model.MailingSubscriptor} interface instead.
	 */
	public static final String TABLE_NAME = "ZN_MailingSubscriptor";
	public static final Object[][] TABLE_COLUMNS = {
			{ "mailingSubscriptorId", Types.BIGINT },
			{ "mailingId", Types.BIGINT },
			{ "email", Types.VARCHAR },
			{ "name", Types.VARCHAR },
			{ "surname", Types.VARCHAR },
			{ "languageId", Types.VARCHAR },
			{ "emailSubject", Types.VARCHAR },
			{ "emailBody", Types.CLOB },
			{ "tokens", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table ZN_MailingSubscriptor (mailingSubscriptorId LONG not null primary key,mailingId LONG,email VARCHAR(75) null,name VARCHAR(75) null,surname VARCHAR(75) null,languageId VARCHAR(75) null,emailSubject VARCHAR(255) null,emailBody TEXT null,tokens STRING null)";
	public static final String TABLE_SQL_DROP = "drop table ZN_MailingSubscriptor";
	public static final String ORDER_BY_JPQL = " ORDER BY mailingSubscriptor.mailingSubscriptorId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY ZN_MailingSubscriptor.mailingSubscriptorId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.net.zylk.liferay.portal.model.MailingSubscriptor"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.net.zylk.liferay.portal.model.MailingSubscriptor"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = false;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.net.zylk.liferay.portal.model.MailingSubscriptor"));

	public MailingSubscriptorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _mailingSubscriptorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMailingSubscriptorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _mailingSubscriptorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return MailingSubscriptor.class;
	}

	@Override
	public String getModelClassName() {
		return MailingSubscriptor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("mailingSubscriptorId", getMailingSubscriptorId());
		attributes.put("mailingId", getMailingId());
		attributes.put("email", getEmail());
		attributes.put("name", getName());
		attributes.put("surname", getSurname());
		attributes.put("languageId", getLanguageId());
		attributes.put("emailSubject", getEmailSubject());
		attributes.put("emailBody", getEmailBody());
		attributes.put("tokens", getTokens());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long mailingSubscriptorId = (Long)attributes.get("mailingSubscriptorId");

		if (mailingSubscriptorId != null) {
			setMailingSubscriptorId(mailingSubscriptorId);
		}

		Long mailingId = (Long)attributes.get("mailingId");

		if (mailingId != null) {
			setMailingId(mailingId);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String surname = (String)attributes.get("surname");

		if (surname != null) {
			setSurname(surname);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String emailSubject = (String)attributes.get("emailSubject");

		if (emailSubject != null) {
			setEmailSubject(emailSubject);
		}

		String emailBody = (String)attributes.get("emailBody");

		if (emailBody != null) {
			setEmailBody(emailBody);
		}

		String tokens = (String)attributes.get("tokens");

		if (tokens != null) {
			setTokens(tokens);
		}
	}

	@Override
	public long getMailingSubscriptorId() {
		return _mailingSubscriptorId;
	}

	@Override
	public void setMailingSubscriptorId(long mailingSubscriptorId) {
		_mailingSubscriptorId = mailingSubscriptorId;
	}

	@Override
	public long getMailingId() {
		return _mailingId;
	}

	@Override
	public void setMailingId(long mailingId) {
		_mailingId = mailingId;
	}

	@Override
	public String getEmail() {
		if (_email == null) {
			return StringPool.BLANK;
		}
		else {
			return _email;
		}
	}

	@Override
	public void setEmail(String email) {
		_email = email;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_name = name;
	}

	@Override
	public String getSurname() {
		if (_surname == null) {
			return StringPool.BLANK;
		}
		else {
			return _surname;
		}
	}

	@Override
	public void setSurname(String surname) {
		_surname = surname;
	}

	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return StringPool.BLANK;
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	@Override
	public String getEmailSubject() {
		if (_emailSubject == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailSubject;
		}
	}

	@Override
	public void setEmailSubject(String emailSubject) {
		_emailSubject = emailSubject;
	}

	@Override
	public String getEmailBody() {
		if (_emailBody == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailBody;
		}
	}

	@Override
	public void setEmailBody(String emailBody) {
		_emailBody = emailBody;
	}

	@Override
	public String getTokens() {
		if (_tokens == null) {
			return StringPool.BLANK;
		}
		else {
			return _tokens;
		}
	}

	@Override
	public void setTokens(String tokens) {
		_tokens = tokens;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			MailingSubscriptor.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public MailingSubscriptor toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (MailingSubscriptor)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MailingSubscriptorImpl mailingSubscriptorImpl = new MailingSubscriptorImpl();

		mailingSubscriptorImpl.setMailingSubscriptorId(getMailingSubscriptorId());
		mailingSubscriptorImpl.setMailingId(getMailingId());
		mailingSubscriptorImpl.setEmail(getEmail());
		mailingSubscriptorImpl.setName(getName());
		mailingSubscriptorImpl.setSurname(getSurname());
		mailingSubscriptorImpl.setLanguageId(getLanguageId());
		mailingSubscriptorImpl.setEmailSubject(getEmailSubject());
		mailingSubscriptorImpl.setEmailBody(getEmailBody());
		mailingSubscriptorImpl.setTokens(getTokens());

		mailingSubscriptorImpl.resetOriginalValues();

		return mailingSubscriptorImpl;
	}

	@Override
	public int compareTo(MailingSubscriptor mailingSubscriptor) {
		long primaryKey = mailingSubscriptor.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MailingSubscriptor)) {
			return false;
		}

		MailingSubscriptor mailingSubscriptor = (MailingSubscriptor)obj;

		long primaryKey = mailingSubscriptor.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<MailingSubscriptor> toCacheModel() {
		MailingSubscriptorCacheModel mailingSubscriptorCacheModel = new MailingSubscriptorCacheModel();

		mailingSubscriptorCacheModel.mailingSubscriptorId = getMailingSubscriptorId();

		mailingSubscriptorCacheModel.mailingId = getMailingId();

		mailingSubscriptorCacheModel.email = getEmail();

		String email = mailingSubscriptorCacheModel.email;

		if ((email != null) && (email.length() == 0)) {
			mailingSubscriptorCacheModel.email = null;
		}

		mailingSubscriptorCacheModel.name = getName();

		String name = mailingSubscriptorCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			mailingSubscriptorCacheModel.name = null;
		}

		mailingSubscriptorCacheModel.surname = getSurname();

		String surname = mailingSubscriptorCacheModel.surname;

		if ((surname != null) && (surname.length() == 0)) {
			mailingSubscriptorCacheModel.surname = null;
		}

		mailingSubscriptorCacheModel.languageId = getLanguageId();

		String languageId = mailingSubscriptorCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			mailingSubscriptorCacheModel.languageId = null;
		}

		mailingSubscriptorCacheModel.emailSubject = getEmailSubject();

		String emailSubject = mailingSubscriptorCacheModel.emailSubject;

		if ((emailSubject != null) && (emailSubject.length() == 0)) {
			mailingSubscriptorCacheModel.emailSubject = null;
		}

		mailingSubscriptorCacheModel.emailBody = getEmailBody();

		String emailBody = mailingSubscriptorCacheModel.emailBody;

		if ((emailBody != null) && (emailBody.length() == 0)) {
			mailingSubscriptorCacheModel.emailBody = null;
		}

		mailingSubscriptorCacheModel.tokens = getTokens();

		String tokens = mailingSubscriptorCacheModel.tokens;

		if ((tokens != null) && (tokens.length() == 0)) {
			mailingSubscriptorCacheModel.tokens = null;
		}

		return mailingSubscriptorCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{mailingSubscriptorId=");
		sb.append(getMailingSubscriptorId());
		sb.append(", mailingId=");
		sb.append(getMailingId());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", surname=");
		sb.append(getSurname());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", emailSubject=");
		sb.append(getEmailSubject());
		sb.append(", emailBody=");
		sb.append(getEmailBody());
		sb.append(", tokens=");
		sb.append(getTokens());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("net.zylk.liferay.portal.model.MailingSubscriptor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>mailingSubscriptorId</column-name><column-value><![CDATA[");
		sb.append(getMailingSubscriptorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mailingId</column-name><column-value><![CDATA[");
		sb.append(getMailingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>surname</column-name><column-value><![CDATA[");
		sb.append(getSurname());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailSubject</column-name><column-value><![CDATA[");
		sb.append(getEmailSubject());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailBody</column-name><column-value><![CDATA[");
		sb.append(getEmailBody());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>tokens</column-name><column-value><![CDATA[");
		sb.append(getTokens());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = MailingSubscriptor.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			MailingSubscriptor.class
		};
	private long _mailingSubscriptorId;
	private long _mailingId;
	private String _email;
	private String _name;
	private String _surname;
	private String _languageId;
	private String _emailSubject;
	private String _emailBody;
	private String _tokens;
	private MailingSubscriptor _escapedModel;
}