package com.sunny.pojo.bo;

import lombok.Data;

/*
*Author:zhangxin_an
*Description:id和name
*Data:Created in 10:20 2018/5/3
*/
@Data
public class IdAndNameBo {
	//基本类型不要用，要用包装类型 ，因为包装类型可以赋值为null
	private Long id;
	private String name;
	public IdAndNameBo(){
	
	}
	
	public IdAndNameBo(Long id, String name) {
		this.id = id;
		this.name = name;
	}
}
