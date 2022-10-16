package org.springframework.jdbc.learn.tx;


import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jing Tao
 * @date 2022/9/14 18:11
 * create table Person (
 *     id int primary key ,
 *     name varchar(64)
 * );
 */
public class PersonDao {

	public NamedParameterJdbcTemplate getNamedTemplate() {
		return namedTemplate;
	}
	public void setNamedTemplate(NamedParameterJdbcTemplate namedTemplate) {
		this.namedTemplate = namedTemplate;
	}
	private NamedParameterJdbcTemplate namedTemplate;

	public void insert(PersonDo personDo) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", personDo.getName());
		// 注意使用:xxx占位
		namedTemplate.update("insert into Person(name)values(:name)", map);
	}
}
