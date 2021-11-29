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

package com.acme.registration.service.persistence;

import com.acme.registration.exception.NoSuchAccountException;
import com.acme.registration.model.Account;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the account service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Alexandre de Souza Jr.
 * @see AccountUtil
 * @generated
 */
@ProviderType
public interface AccountPersistence extends BasePersistence<Account> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AccountUtil} to access the account persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the accounts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByCompanyId(long companyId);

	/**
	 * Returns a range of all the accounts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public java.util.List<Account> findByCompanyId(
		long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the accounts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns an ordered range of all the accounts where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByCompanyId_First(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByCompanyId_Last(
			long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where companyId = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByCompanyId_PrevAndNext(
			long accountId, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 */
	public void removeByCompanyId(long companyId);

	/**
	 * Returns the number of accounts where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching accounts
	 */
	public int countByCompanyId(long companyId);

	/**
	 * Returns all the accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGroupId(long groupId);

	/**
	 * Returns a range of all the accounts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public java.util.List<Account> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByGroupId_PrevAndNext(
			long accountId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of accounts where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching accounts
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the accounts where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByUserName(String userName);

	/**
	 * Returns a range of all the accounts where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public java.util.List<Account> findByUserName(
		String userName, int start, int end);

	/**
	 * Returns an ordered range of all the accounts where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByUserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns an ordered range of all the accounts where userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param userName the user name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByUserName(
		String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByUserName_First(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByUserName_First(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByUserName_Last(
			String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where userName = &#63;.
	 *
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByUserName_Last(
		String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where userName = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByUserName_PrevAndNext(
			long accountId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where userName = &#63; from the database.
	 *
	 * @param userName the user name
	 */
	public void removeByUserName(String userName);

	/**
	 * Returns the number of accounts where userName = &#63;.
	 *
	 * @param userName the user name
	 * @return the number of matching accounts
	 */
	public int countByUserName(String userName);

	/**
	 * Returns all the accounts where groupId = &#63; and userName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @return the matching accounts
	 */
	public java.util.List<Account> findByGroupIdAndUserName(
		long groupId, String userName);

	/**
	 * Returns a range of all the accounts where groupId = &#63; and userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of matching accounts
	 */
	public java.util.List<Account> findByGroupIdAndUserName(
		long groupId, String userName, int start, int end);

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByGroupIdAndUserName(
		long groupId, String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns an ordered range of all the accounts where groupId = &#63; and userName = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching accounts
	 */
	public java.util.List<Account> findByGroupIdAndUserName(
		long groupId, String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and userName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGroupIdAndUserName_First(
			long groupId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the first account in the ordered set where groupId = &#63; and userName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGroupIdAndUserName_First(
		long groupId, String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and userName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account
	 * @throws NoSuchAccountException if a matching account could not be found
	 */
	public Account findByGroupIdAndUserName_Last(
			long groupId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Returns the last account in the ordered set where groupId = &#63; and userName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching account, or <code>null</code> if a matching account could not be found
	 */
	public Account fetchByGroupIdAndUserName_Last(
		long groupId, String userName,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns the accounts before and after the current account in the ordered set where groupId = &#63; and userName = &#63;.
	 *
	 * @param accountId the primary key of the current account
	 * @param groupId the group ID
	 * @param userName the user name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account[] findByGroupIdAndUserName_PrevAndNext(
			long accountId, long groupId, String userName,
			com.liferay.portal.kernel.util.OrderByComparator<Account>
				orderByComparator)
		throws NoSuchAccountException;

	/**
	 * Removes all the accounts where groupId = &#63; and userName = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 */
	public void removeByGroupIdAndUserName(long groupId, String userName);

	/**
	 * Returns the number of accounts where groupId = &#63; and userName = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userName the user name
	 * @return the number of matching accounts
	 */
	public int countByGroupIdAndUserName(long groupId, String userName);

	/**
	 * Caches the account in the entity cache if it is enabled.
	 *
	 * @param account the account
	 */
	public void cacheResult(Account account);

	/**
	 * Caches the accounts in the entity cache if it is enabled.
	 *
	 * @param accounts the accounts
	 */
	public void cacheResult(java.util.List<Account> accounts);

	/**
	 * Creates a new account with the primary key. Does not add the account to the database.
	 *
	 * @param accountId the primary key for the new account
	 * @return the new account
	 */
	public Account create(long accountId);

	/**
	 * Removes the account with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param accountId the primary key of the account
	 * @return the account that was removed
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account remove(long accountId) throws NoSuchAccountException;

	public Account updateImpl(Account account);

	/**
	 * Returns the account with the primary key or throws a <code>NoSuchAccountException</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account
	 * @throws NoSuchAccountException if a account with the primary key could not be found
	 */
	public Account findByPrimaryKey(long accountId)
		throws NoSuchAccountException;

	/**
	 * Returns the account with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param accountId the primary key of the account
	 * @return the account, or <code>null</code> if a account with the primary key could not be found
	 */
	public Account fetchByPrimaryKey(long accountId);

	/**
	 * Returns all the accounts.
	 *
	 * @return the accounts
	 */
	public java.util.List<Account> findAll();

	/**
	 * Returns a range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @return the range of accounts
	 */
	public java.util.List<Account> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of accounts
	 */
	public java.util.List<Account> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator);

	/**
	 * Returns an ordered range of all the accounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AccountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of accounts
	 * @param end the upper bound of the range of accounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of accounts
	 */
	public java.util.List<Account> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Account>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the accounts from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of accounts.
	 *
	 * @return the number of accounts
	 */
	public int countAll();

}