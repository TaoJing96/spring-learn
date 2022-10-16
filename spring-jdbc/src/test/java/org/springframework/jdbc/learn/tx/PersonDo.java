package org.springframework.jdbc.learn.tx;

/**
 * @author Jing Tao
 * @date 2022/9/14 18:13
 */
public class PersonDo {

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private Integer id;
	private String name;
}
