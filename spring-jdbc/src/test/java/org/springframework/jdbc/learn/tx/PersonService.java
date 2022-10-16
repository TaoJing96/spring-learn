package org.springframework.jdbc.learn.tx;

import javax.transaction.Transactional;

/**
 * @author Jing Tao
 * @date 2022/9/14 18:15
 */
public class PersonService {

	public PersonDao getPersonDao() {
		return personDao;
	}
	public void setBlogDao(PersonDao personDao) {
		this.personDao = personDao;
	}
	private PersonDao personDao;

	@Transactional
	public void addPerson() {
		PersonDo personDo = new PersonDo();
		personDo.setName("tj");
		personDao.insert(personDo);
		int a = 1 / 0;// 发生异常，导致事务回滚，所以并不会插入任何一行数据
		personDao.insert(personDo);
	}

	@Transactional
	public void normal() {
		PersonDo personDo = new PersonDo();
		personDo.setName("tj");
		personDao.insert(personDo);
	}

	//不带Transactional调用带Transactional
	public void add() {
		normal();
	}
}
