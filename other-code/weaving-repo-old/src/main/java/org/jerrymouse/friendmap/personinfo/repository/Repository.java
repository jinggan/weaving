package org.jerrymouse.friendmap.personinfo.repository;

import org.jerrymouse.friendmap.personinfo.repository.bean.PersonBean;
import org.jerrymouse.friendmap.personinfo.repository.bean.WebSiteBean;
import org.jerrymouse.weaving.bean.Person;
import org.jerrymouse.weaving.bean.WebSite;

public interface Repository {
	/**
	 * 删除一个人，删除原因可能是出于要将两个人合并之类的
	 * 
	 * @param personId
	 */
	void deletePerson(String personId);

	/**
	 * 
	 * @param personId
	 */
	void deleteWebSite(String webSiteId);

	/**
	 * 获取一个人，只是获取而已
	 * 
	 * @param personId
	 */
	PersonBean getPerson(String personId);

	/**
	 * 
	 * @param personId
	 */
	WebSiteBean getWebSite(String webSiteId);

	/**
	 * 保存或添加一个人，注意<b>不包括</b>其旗下网页<br/>
	 */
	PersonBean putPerson(Person person);

	/**
	 * 保存或添加一个个人网页<br/>
	 */
	WebSiteBean putWebSite(WebSite webSite);
}
