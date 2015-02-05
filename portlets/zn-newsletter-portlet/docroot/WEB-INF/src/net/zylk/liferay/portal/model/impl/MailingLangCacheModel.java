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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import net.zylk.liferay.portal.model.MailingLang;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MailingLang in entity cache.
 *
 * @author zylk.net
 * @see MailingLang
 * @generated
 */
public class MailingLangCacheModel implements CacheModel<MailingLang>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{mailingLangId=");
		sb.append(mailingLangId);
		sb.append(", mailingId=");
		sb.append(mailingId);
		sb.append(", languageId=");
		sb.append(languageId);
		sb.append(", emailSubjectPre=");
		sb.append(emailSubjectPre);
		sb.append(", emailBodyPre=");
		sb.append(emailBodyPre);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MailingLang toEntityModel() {
		MailingLangImpl mailingLangImpl = new MailingLangImpl();

		mailingLangImpl.setMailingLangId(mailingLangId);
		mailingLangImpl.setMailingId(mailingId);

		if (languageId == null) {
			mailingLangImpl.setLanguageId(StringPool.BLANK);
		}
		else {
			mailingLangImpl.setLanguageId(languageId);
		}

		if (emailSubjectPre == null) {
			mailingLangImpl.setEmailSubjectPre(StringPool.BLANK);
		}
		else {
			mailingLangImpl.setEmailSubjectPre(emailSubjectPre);
		}

		if (emailBodyPre == null) {
			mailingLangImpl.setEmailBodyPre(StringPool.BLANK);
		}
		else {
			mailingLangImpl.setEmailBodyPre(emailBodyPre);
		}

		mailingLangImpl.resetOriginalValues();

		return mailingLangImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mailingLangId = objectInput.readLong();
		mailingId = objectInput.readLong();
		languageId = objectInput.readUTF();
		emailSubjectPre = objectInput.readUTF();
		emailBodyPre = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mailingLangId);
		objectOutput.writeLong(mailingId);

		if (languageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageId);
		}

		if (emailSubjectPre == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailSubjectPre);
		}

		if (emailBodyPre == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailBodyPre);
		}
	}

	public long mailingLangId;
	public long mailingId;
	public String languageId;
	public String emailSubjectPre;
	public String emailBodyPre;
}