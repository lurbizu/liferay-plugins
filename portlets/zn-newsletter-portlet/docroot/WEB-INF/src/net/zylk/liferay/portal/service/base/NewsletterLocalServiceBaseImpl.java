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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.CompanyPersistence;
import com.liferay.portal.service.persistence.GroupPersistence;
import com.liferay.portal.service.persistence.UserPersistence;

import net.zylk.liferay.portal.model.Newsletter;
import net.zylk.liferay.portal.service.NewsletterLocalService;
import net.zylk.liferay.portal.service.persistence.CategoryPersistence;
import net.zylk.liferay.portal.service.persistence.MailingLangPersistence;
import net.zylk.liferay.portal.service.persistence.MailingPersistence;
import net.zylk.liferay.portal.service.persistence.MailingSubscriptorPersistence;
import net.zylk.liferay.portal.service.persistence.NewsletterPersistence;
import net.zylk.liferay.portal.service.persistence.SubscriptorCategoryPersistence;
import net.zylk.liferay.portal.service.persistence.SubscriptorFinder;
import net.zylk.liferay.portal.service.persistence.SubscriptorPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the newsletter local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link net.zylk.liferay.portal.service.impl.NewsletterLocalServiceImpl}.
 * </p>
 *
 * @author zylk.net
 * @see net.zylk.liferay.portal.service.impl.NewsletterLocalServiceImpl
 * @see net.zylk.liferay.portal.service.NewsletterLocalServiceUtil
 * @generated
 */
public abstract class NewsletterLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements NewsletterLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link net.zylk.liferay.portal.service.NewsletterLocalServiceUtil} to access the newsletter local service.
	 */

	/**
	 * Adds the newsletter to the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletter the newsletter
	 * @return the newsletter that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Newsletter addNewsletter(Newsletter newsletter)
		throws SystemException {
		newsletter.setNew(true);

		return newsletterPersistence.update(newsletter);
	}

	/**
	 * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
	 *
	 * @param newsletterId the primary key for the new newsletter
	 * @return the new newsletter
	 */
	@Override
	public Newsletter createNewsletter(long newsletterId) {
		return newsletterPersistence.create(newsletterId);
	}

	/**
	 * Deletes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter that was removed
	 * @throws PortalException if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Newsletter deleteNewsletter(long newsletterId)
		throws PortalException, SystemException {
		return newsletterPersistence.remove(newsletterId);
	}

	/**
	 * Deletes the newsletter from the database. Also notifies the appropriate model listeners.
	 *
	 * @param newsletter the newsletter
	 * @return the newsletter that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Newsletter deleteNewsletter(Newsletter newsletter)
		throws SystemException {
		return newsletterPersistence.remove(newsletter);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(Newsletter.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return newsletterPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return newsletterPersistence.findWithDynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return newsletterPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return newsletterPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return newsletterPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public Newsletter fetchNewsletter(long newsletterId)
		throws SystemException {
		return newsletterPersistence.fetchByPrimaryKey(newsletterId);
	}

	/**
	 * Returns the newsletter with the primary key.
	 *
	 * @param newsletterId the primary key of the newsletter
	 * @return the newsletter
	 * @throws PortalException if a newsletter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Newsletter getNewsletter(long newsletterId)
		throws PortalException, SystemException {
		return newsletterPersistence.findByPrimaryKey(newsletterId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return newsletterPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the newsletters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link net.zylk.liferay.portal.model.impl.NewsletterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of newsletters
	 * @param end the upper bound of the range of newsletters (not inclusive)
	 * @return the range of newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Newsletter> getNewsletters(int start, int end)
		throws SystemException {
		return newsletterPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of newsletters.
	 *
	 * @return the number of newsletters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getNewslettersCount() throws SystemException {
		return newsletterPersistence.countAll();
	}

	/**
	 * Updates the newsletter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param newsletter the newsletter
	 * @return the newsletter that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Newsletter updateNewsletter(Newsletter newsletter)
		throws SystemException {
		return newsletterPersistence.update(newsletter);
	}

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

		PersistedModelLocalServiceRegistryUtil.register("net.zylk.liferay.portal.model.Newsletter",
			newsletterLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"net.zylk.liferay.portal.model.Newsletter");
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

	protected Class<?> getModelClass() {
		return Newsletter.class;
	}

	protected String getModelClassName() {
		return Newsletter.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = newsletterPersistence.getDataSource();

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
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private NewsletterLocalServiceClpInvoker _clpInvoker = new NewsletterLocalServiceClpInvoker();
}