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

package net.zylk.liferay.portal.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.InfrastructureUtil;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.TicketPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import net.zylk.liferay.portal.service.UserSubscriptionLocalService;
import net.zylk.liferay.portal.service.persistence.CategoryPersistence;
import net.zylk.liferay.portal.service.persistence.MailingLangPersistence;
import net.zylk.liferay.portal.service.persistence.MailingPersistence;
import net.zylk.liferay.portal.service.persistence.MailingSubscriptorPersistence;
import net.zylk.liferay.portal.service.persistence.NewsletterPersistence;
import net.zylk.liferay.portal.service.persistence.SubscriptorCategoryPersistence;
import net.zylk.liferay.portal.service.persistence.SubscriptorFinder;
import net.zylk.liferay.portal.service.persistence.SubscriptorPersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the user subscription local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.zylk.liferay.portal.service.impl.UserSubscriptionLocalServiceImpl}.
 * </p>
 *
 * @author zylk.net
 * @see net.zylk.liferay.portal.service.impl.UserSubscriptionLocalServiceImpl
 * @see net.zylk.liferay.portal.service.UserSubscriptionLocalServiceUtil
 * @generated
 */
public abstract class UserSubscriptionLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements UserSubscriptionLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link net.zylk.liferay.portal.service.UserSubscriptionLocalServiceUtil} to access the user subscription local service.
	 */

	/**
	 * Returns the category local service.
	 *
	 * @return the category local service
	 */
	public net.zylk.liferay.portal.service.CategoryLocalService getCategoryLocalService() {
		return categoryLocalService;
	}

	/**
	 * Sets the category local service.
	 *
	 * @param categoryLocalService the category local service
	 */
	public void setCategoryLocalService(
		net.zylk.liferay.portal.service.CategoryLocalService categoryLocalService) {
		this.categoryLocalService = categoryLocalService;
	}

	/**
	 * Returns the category persistence.
	 *
	 * @return the category persistence
	 */
	public CategoryPersistence getCategoryPersistence() {
		return categoryPersistence;
	}

	/**
	 * Sets the category persistence.
	 *
	 * @param categoryPersistence the category persistence
	 */
	public void setCategoryPersistence(CategoryPersistence categoryPersistence) {
		this.categoryPersistence = categoryPersistence;
	}

	/**
	 * Returns the mailing local service.
	 *
	 * @return the mailing local service
	 */
	public net.zylk.liferay.portal.service.MailingLocalService getMailingLocalService() {
		return mailingLocalService;
	}

	/**
	 * Sets the mailing local service.
	 *
	 * @param mailingLocalService the mailing local service
	 */
	public void setMailingLocalService(
		net.zylk.liferay.portal.service.MailingLocalService mailingLocalService) {
		this.mailingLocalService = mailingLocalService;
	}

	/**
	 * Returns the mailing persistence.
	 *
	 * @return the mailing persistence
	 */
	public MailingPersistence getMailingPersistence() {
		return mailingPersistence;
	}

	/**
	 * Sets the mailing persistence.
	 *
	 * @param mailingPersistence the mailing persistence
	 */
	public void setMailingPersistence(MailingPersistence mailingPersistence) {
		this.mailingPersistence = mailingPersistence;
	}

	/**
	 * Returns the mailing lang local service.
	 *
	 * @return the mailing lang local service
	 */
	public net.zylk.liferay.portal.service.MailingLangLocalService getMailingLangLocalService() {
		return mailingLangLocalService;
	}

	/**
	 * Sets the mailing lang local service.
	 *
	 * @param mailingLangLocalService the mailing lang local service
	 */
	public void setMailingLangLocalService(
		net.zylk.liferay.portal.service.MailingLangLocalService mailingLangLocalService) {
		this.mailingLangLocalService = mailingLangLocalService;
	}

	/**
	 * Returns the mailing lang persistence.
	 *
	 * @return the mailing lang persistence
	 */
	public MailingLangPersistence getMailingLangPersistence() {
		return mailingLangPersistence;
	}

	/**
	 * Sets the mailing lang persistence.
	 *
	 * @param mailingLangPersistence the mailing lang persistence
	 */
	public void setMailingLangPersistence(
		MailingLangPersistence mailingLangPersistence) {
		this.mailingLangPersistence = mailingLangPersistence;
	}

	/**
	 * Returns the mailing subscriptor local service.
	 *
	 * @return the mailing subscriptor local service
	 */
	public net.zylk.liferay.portal.service.MailingSubscriptorLocalService getMailingSubscriptorLocalService() {
		return mailingSubscriptorLocalService;
	}

	/**
	 * Sets the mailing subscriptor local service.
	 *
	 * @param mailingSubscriptorLocalService the mailing subscriptor local service
	 */
	public void setMailingSubscriptorLocalService(
		net.zylk.liferay.portal.service.MailingSubscriptorLocalService mailingSubscriptorLocalService) {
		this.mailingSubscriptorLocalService = mailingSubscriptorLocalService;
	}

	/**
	 * Returns the mailing subscriptor persistence.
	 *
	 * @return the mailing subscriptor persistence
	 */
	public MailingSubscriptorPersistence getMailingSubscriptorPersistence() {
		return mailingSubscriptorPersistence;
	}

	/**
	 * Sets the mailing subscriptor persistence.
	 *
	 * @param mailingSubscriptorPersistence the mailing subscriptor persistence
	 */
	public void setMailingSubscriptorPersistence(
		MailingSubscriptorPersistence mailingSubscriptorPersistence) {
		this.mailingSubscriptorPersistence = mailingSubscriptorPersistence;
	}

	/**
	 * Returns the newsletter local service.
	 *
	 * @return the newsletter local service
	 */
	public net.zylk.liferay.portal.service.NewsletterLocalService getNewsletterLocalService() {
		return newsletterLocalService;
	}

	/**
	 * Sets the newsletter local service.
	 *
	 * @param newsletterLocalService the newsletter local service
	 */
	public void setNewsletterLocalService(
		net.zylk.liferay.portal.service.NewsletterLocalService newsletterLocalService) {
		this.newsletterLocalService = newsletterLocalService;
	}

	/**
	 * Returns the newsletter persistence.
	 *
	 * @return the newsletter persistence
	 */
	public NewsletterPersistence getNewsletterPersistence() {
		return newsletterPersistence;
	}

	/**
	 * Sets the newsletter persistence.
	 *
	 * @param newsletterPersistence the newsletter persistence
	 */
	public void setNewsletterPersistence(
		NewsletterPersistence newsletterPersistence) {
		this.newsletterPersistence = newsletterPersistence;
	}

	/**
	 * Returns the subscriptor local service.
	 *
	 * @return the subscriptor local service
	 */
	public net.zylk.liferay.portal.service.SubscriptorLocalService getSubscriptorLocalService() {
		return subscriptorLocalService;
	}

	/**
	 * Sets the subscriptor local service.
	 *
	 * @param subscriptorLocalService the subscriptor local service
	 */
	public void setSubscriptorLocalService(
		net.zylk.liferay.portal.service.SubscriptorLocalService subscriptorLocalService) {
		this.subscriptorLocalService = subscriptorLocalService;
	}

	/**
	 * Returns the subscriptor persistence.
	 *
	 * @return the subscriptor persistence
	 */
	public SubscriptorPersistence getSubscriptorPersistence() {
		return subscriptorPersistence;
	}

	/**
	 * Sets the subscriptor persistence.
	 *
	 * @param subscriptorPersistence the subscriptor persistence
	 */
	public void setSubscriptorPersistence(
		SubscriptorPersistence subscriptorPersistence) {
		this.subscriptorPersistence = subscriptorPersistence;
	}

	/**
	 * Returns the subscriptor finder.
	 *
	 * @return the subscriptor finder
	 */
	public SubscriptorFinder getSubscriptorFinder() {
		return subscriptorFinder;
	}

	/**
	 * Sets the subscriptor finder.
	 *
	 * @param subscriptorFinder the subscriptor finder
	 */
	public void setSubscriptorFinder(SubscriptorFinder subscriptorFinder) {
		this.subscriptorFinder = subscriptorFinder;
	}

	/**
	 * Returns the subscriptor category local service.
	 *
	 * @return the subscriptor category local service
	 */
	public net.zylk.liferay.portal.service.SubscriptorCategoryLocalService getSubscriptorCategoryLocalService() {
		return subscriptorCategoryLocalService;
	}

	/**
	 * Sets the subscriptor category local service.
	 *
	 * @param subscriptorCategoryLocalService the subscriptor category local service
	 */
	public void setSubscriptorCategoryLocalService(
		net.zylk.liferay.portal.service.SubscriptorCategoryLocalService subscriptorCategoryLocalService) {
		this.subscriptorCategoryLocalService = subscriptorCategoryLocalService;
	}

	/**
	 * Returns the subscriptor category persistence.
	 *
	 * @return the subscriptor category persistence
	 */
	public SubscriptorCategoryPersistence getSubscriptorCategoryPersistence() {
		return subscriptorCategoryPersistence;
	}

	/**
	 * Sets the subscriptor category persistence.
	 *
	 * @param subscriptorCategoryPersistence the subscriptor category persistence
	 */
	public void setSubscriptorCategoryPersistence(
		SubscriptorCategoryPersistence subscriptorCategoryPersistence) {
		this.subscriptorCategoryPersistence = subscriptorCategoryPersistence;
	}

	/**
	 * Returns the user subscription local service.
	 *
	 * @return the user subscription local service
	 */
	public net.zylk.liferay.portal.service.UserSubscriptionLocalService getUserSubscriptionLocalService() {
		return userSubscriptionLocalService;
	}

	/**
	 * Sets the user subscription local service.
	 *
	 * @param userSubscriptionLocalService the user subscription local service
	 */
	public void setUserSubscriptionLocalService(
		net.zylk.liferay.portal.service.UserSubscriptionLocalService userSubscriptionLocalService) {
		this.userSubscriptionLocalService = userSubscriptionLocalService;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the company local service.
	 *
	 * @return the company local service
	 */
	public com.liferay.portal.service.CompanyLocalService getCompanyLocalService() {
		return companyLocalService;
	}

	/**
	 * Sets the company local service.
	 *
	 * @param companyLocalService the company local service
	 */
	public void setCompanyLocalService(
		com.liferay.portal.service.CompanyLocalService companyLocalService) {
		this.companyLocalService = companyLocalService;
	}

	/**
	 * Returns the company remote service.
	 *
	 * @return the company remote service
	 */
	public com.liferay.portal.service.CompanyService getCompanyService() {
		return companyService;
	}

	/**
	 * Sets the company remote service.
	 *
	 * @param companyService the company remote service
	 */
	public void setCompanyService(
		com.liferay.portal.service.CompanyService companyService) {
		this.companyService = companyService;
	}

	/**
	 * Returns the company persistence.
	 *
	 * @return the company persistence
	 */
	public CompanyPersistence getCompanyPersistence() {
		return companyPersistence;
	}

	/**
	 * Sets the company persistence.
	 *
	 * @param companyPersistence the company persistence
	 */
	public void setCompanyPersistence(CompanyPersistence companyPersistence) {
		this.companyPersistence = companyPersistence;
	}

	/**
	 * Returns the group local service.
	 *
	 * @return the group local service
	 */
	public com.liferay.portal.service.GroupLocalService getGroupLocalService() {
		return groupLocalService;
	}

	/**
	 * Sets the group local service.
	 *
	 * @param groupLocalService the group local service
	 */
	public void setGroupLocalService(
		com.liferay.portal.service.GroupLocalService groupLocalService) {
		this.groupLocalService = groupLocalService;
	}

	/**
	 * Returns the group remote service.
	 *
	 * @return the group remote service
	 */
	public com.liferay.portal.service.GroupService getGroupService() {
		return groupService;
	}

	/**
	 * Sets the group remote service.
	 *
	 * @param groupService the group remote service
	 */
	public void setGroupService(
		com.liferay.portal.service.GroupService groupService) {
		this.groupService = groupService;
	}

	/**
	 * Returns the group persistence.
	 *
	 * @return the group persistence
	 */
	public GroupPersistence getGroupPersistence() {
		return groupPersistence;
	}

	/**
	 * Sets the group persistence.
	 *
	 * @param groupPersistence the group persistence
	 */
	public void setGroupPersistence(GroupPersistence groupPersistence) {
		this.groupPersistence = groupPersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the ticket local service.
	 *
	 * @return the ticket local service
	 */
	public com.liferay.portal.service.TicketLocalService getTicketLocalService() {
		return ticketLocalService;
	}

	/**
	 * Sets the ticket local service.
	 *
	 * @param ticketLocalService the ticket local service
	 */
	public void setTicketLocalService(
		com.liferay.portal.service.TicketLocalService ticketLocalService) {
		this.ticketLocalService = ticketLocalService;
	}

	/**
	 * Returns the ticket persistence.
	 *
	 * @return the ticket persistence
	 */
	public TicketPersistence getTicketPersistence() {
		return ticketPersistence;
	}

	/**
	 * Sets the ticket persistence.
	 *
	 * @param ticketPersistence the ticket persistence
	 */
	public void setTicketPersistence(TicketPersistence ticketPersistence) {
		this.ticketPersistence = ticketPersistence;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = InfrastructureUtil.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = net.zylk.liferay.portal.service.CategoryLocalService.class)
	protected net.zylk.liferay.portal.service.CategoryLocalService categoryLocalService;
	@BeanReference(type = CategoryPersistence.class)
	protected CategoryPersistence categoryPersistence;
	@BeanReference(type = net.zylk.liferay.portal.service.MailingLocalService.class)
	protected net.zylk.liferay.portal.service.MailingLocalService mailingLocalService;
	@BeanReference(type = MailingPersistence.class)
	protected MailingPersistence mailingPersistence;
	@BeanReference(type = net.zylk.liferay.portal.service.MailingLangLocalService.class)
	protected net.zylk.liferay.portal.service.MailingLangLocalService mailingLangLocalService;
	@BeanReference(type = MailingLangPersistence.class)
	protected MailingLangPersistence mailingLangPersistence;
	@BeanReference(type = net.zylk.liferay.portal.service.MailingSubscriptorLocalService.class)
	protected net.zylk.liferay.portal.service.MailingSubscriptorLocalService mailingSubscriptorLocalService;
	@BeanReference(type = MailingSubscriptorPersistence.class)
	protected MailingSubscriptorPersistence mailingSubscriptorPersistence;
	@BeanReference(type = net.zylk.liferay.portal.service.NewsletterLocalService.class)
	protected net.zylk.liferay.portal.service.NewsletterLocalService newsletterLocalService;
	@BeanReference(type = NewsletterPersistence.class)
	protected NewsletterPersistence newsletterPersistence;
	@BeanReference(type = net.zylk.liferay.portal.service.SubscriptorLocalService.class)
	protected net.zylk.liferay.portal.service.SubscriptorLocalService subscriptorLocalService;
	@BeanReference(type = SubscriptorPersistence.class)
	protected SubscriptorPersistence subscriptorPersistence;
	@BeanReference(type = SubscriptorFinder.class)
	protected SubscriptorFinder subscriptorFinder;
	@BeanReference(type = net.zylk.liferay.portal.service.SubscriptorCategoryLocalService.class)
	protected net.zylk.liferay.portal.service.SubscriptorCategoryLocalService subscriptorCategoryLocalService;
	@BeanReference(type = SubscriptorCategoryPersistence.class)
	protected SubscriptorCategoryPersistence subscriptorCategoryPersistence;
	@BeanReference(type = net.zylk.liferay.portal.service.UserSubscriptionLocalService.class)
	protected net.zylk.liferay.portal.service.UserSubscriptionLocalService userSubscriptionLocalService;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.CompanyLocalService.class)
	protected com.liferay.portal.service.CompanyLocalService companyLocalService;
	@BeanReference(type = com.liferay.portal.service.CompanyService.class)
	protected com.liferay.portal.service.CompanyService companyService;
	@BeanReference(type = CompanyPersistence.class)
	protected CompanyPersistence companyPersistence;
	@BeanReference(type = com.liferay.portal.service.GroupLocalService.class)
	protected com.liferay.portal.service.GroupLocalService groupLocalService;
	@BeanReference(type = com.liferay.portal.service.GroupService.class)
	protected com.liferay.portal.service.GroupService groupService;
	@BeanReference(type = GroupPersistence.class)
	protected GroupPersistence groupPersistence;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.TicketLocalService.class)
	protected com.liferay.portal.service.TicketLocalService ticketLocalService;
	@BeanReference(type = TicketPersistence.class)
	protected TicketPersistence ticketPersistence;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private UserSubscriptionLocalServiceClpInvoker _clpInvoker = new UserSubscriptionLocalServiceClpInvoker();
}