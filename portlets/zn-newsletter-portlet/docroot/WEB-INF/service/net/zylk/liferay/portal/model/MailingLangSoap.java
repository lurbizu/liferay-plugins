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
public class MailingLangSoap implements Serializable {
	public static MailingLangSoap toSoapModel(MailingLang model) {
		MailingLangSoap soapModel = new MailingLangSoap();

		soapModel.setMailingLangId(model.getMailingLangId());
		soapModel.setMailingId(model.getMailingId());
		soapModel.setLanguageId(model.getLanguageId());
		soapModel.setEmailSubjectPre(model.getEmailSubjectPre());
		soapModel.setEmailBodyPre(model.getEmailBodyPre());

		return soapModel;
	}

	public static MailingLangSoap[] toSoapModels(MailingLang[] models) {
		MailingLangSoap[] soapModels = new MailingLangSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MailingLangSoap[][] toSoapModels(MailingLang[][] models) {
		MailingLangSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MailingLangSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MailingLangSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MailingLangSoap[] toSoapModels(List<MailingLang> models) {
		List<MailingLangSoap> soapModels = new ArrayList<MailingLangSoap>(models.size());

		for (MailingLang model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MailingLangSoap[soapModels.size()]);
	}

	public MailingLangSoap() {
	}

	public long getPrimaryKey() {
		return _mailingLangId;
	}

	public void setPrimaryKey(long pk) {
		setMailingLangId(pk);
	}

	public long getMailingLangId() {
		return _mailingLangId;
	}

	public void setMailingLangId(long mailingLangId) {
		_mailingLangId = mailingLangId;
	}

	public long getMailingId() {
		return _mailingId;
	}

	public void setMailingId(long mailingId) {
		_mailingId = mailingId;
	}

	public String getLanguageId() {
		return _languageId;
	}

	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	public String getEmailSubjectPre() {
		return _emailSubjectPre;
	}

	public void setEmailSubjectPre(String emailSubjectPre) {
		_emailSubjectPre = emailSubjectPre;
	}

	public String getEmailBodyPre() {
		return _emailBodyPre;
	}

	public void setEmailBodyPre(String emailBodyPre) {
		_emailBodyPre = emailBodyPre;
	}

	private long _mailingLangId;
	private long _mailingId;
	private String _languageId;
	private String _emailSubjectPre;
	private String _emailBodyPre;
}