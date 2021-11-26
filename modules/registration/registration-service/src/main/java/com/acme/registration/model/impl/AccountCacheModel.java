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

package com.acme.registration.model.impl;

import com.acme.registration.model.Account;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Account in entity cache.
 *
 * @author Alexandre de Souza Jr.
 * @generated
 */
public class AccountCacheModel implements CacheModel<Account>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AccountCacheModel)) {
			return false;
		}

		AccountCacheModel accountCacheModel = (AccountCacheModel)object;

		if (accountId == accountCacheModel.accountId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, accountId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{accountId=");
		sb.append(accountId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", genre=");
		sb.append(genre);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", password=");
		sb.append(password);
		sb.append(", confirmPassword=");
		sb.append(confirmPassword);
		sb.append(", homePhone=");
		sb.append(homePhone);
		sb.append(", mobilePhone=");
		sb.append(mobilePhone);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", zipCode=");
		sb.append(zipCode);
		sb.append(", securityQuestion=");
		sb.append(securityQuestion);
		sb.append(", answer=");
		sb.append(answer);
		sb.append(", termsOfUse=");
		sb.append(termsOfUse);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Account toEntityModel() {
		AccountImpl accountImpl = new AccountImpl();

		accountImpl.setAccountId(accountId);
		accountImpl.setGroupId(groupId);
		accountImpl.setCompanyId(companyId);
		accountImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			accountImpl.setCreateDate(null);
		}
		else {
			accountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			accountImpl.setModifiedDate(null);
		}
		else {
			accountImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			accountImpl.setFirstName("");
		}
		else {
			accountImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			accountImpl.setLastName("");
		}
		else {
			accountImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			accountImpl.setEmailAddress("");
		}
		else {
			accountImpl.setEmailAddress(emailAddress);
		}

		if (userName == null) {
			accountImpl.setUserName("");
		}
		else {
			accountImpl.setUserName(userName);
		}

		if (genre == null) {
			accountImpl.setGenre("");
		}
		else {
			accountImpl.setGenre(genre);
		}

		if (birthday == null) {
			accountImpl.setBirthday("");
		}
		else {
			accountImpl.setBirthday(birthday);
		}

		if (password == null) {
			accountImpl.setPassword("");
		}
		else {
			accountImpl.setPassword(password);
		}

		if (confirmPassword == null) {
			accountImpl.setConfirmPassword("");
		}
		else {
			accountImpl.setConfirmPassword(confirmPassword);
		}

		if (homePhone == null) {
			accountImpl.setHomePhone("");
		}
		else {
			accountImpl.setHomePhone(homePhone);
		}

		if (mobilePhone == null) {
			accountImpl.setMobilePhone("");
		}
		else {
			accountImpl.setMobilePhone(mobilePhone);
		}

		if (address1 == null) {
			accountImpl.setAddress1("");
		}
		else {
			accountImpl.setAddress1(address1);
		}

		if (address2 == null) {
			accountImpl.setAddress2("");
		}
		else {
			accountImpl.setAddress2(address2);
		}

		if (city == null) {
			accountImpl.setCity("");
		}
		else {
			accountImpl.setCity(city);
		}

		if (state == null) {
			accountImpl.setState("");
		}
		else {
			accountImpl.setState(state);
		}

		if (zipCode == null) {
			accountImpl.setZipCode("");
		}
		else {
			accountImpl.setZipCode(zipCode);
		}

		if (securityQuestion == null) {
			accountImpl.setSecurityQuestion("");
		}
		else {
			accountImpl.setSecurityQuestion(securityQuestion);
		}

		if (answer == null) {
			accountImpl.setAnswer("");
		}
		else {
			accountImpl.setAnswer(answer);
		}

		accountImpl.setTermsOfUse(termsOfUse);

		accountImpl.resetOriginalValues();

		return accountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		accountId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		userName = objectInput.readUTF();
		genre = objectInput.readUTF();
		birthday = objectInput.readUTF();
		password = objectInput.readUTF();
		confirmPassword = objectInput.readUTF();
		homePhone = objectInput.readUTF();
		mobilePhone = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		zipCode = objectInput.readUTF();
		securityQuestion = objectInput.readUTF();
		answer = objectInput.readUTF();

		termsOfUse = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(accountId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		if (genre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(genre);
		}

		if (birthday == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(birthday);
		}

		if (password == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(password);
		}

		if (confirmPassword == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(confirmPassword);
		}

		if (homePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(homePhone);
		}

		if (mobilePhone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mobilePhone);
		}

		if (address1 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (zipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(zipCode);
		}

		if (securityQuestion == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(securityQuestion);
		}

		if (answer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(answer);
		}

		objectOutput.writeBoolean(termsOfUse);
	}

	public long accountId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public String userName;
	public String genre;
	public String birthday;
	public String password;
	public String confirmPassword;
	public String homePhone;
	public String mobilePhone;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String zipCode;
	public String securityQuestion;
	public String answer;
	public boolean termsOfUse;

}