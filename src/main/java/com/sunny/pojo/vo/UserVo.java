package com.sunny.pojo.vo;

import lombok.Data;
/**
 * jpa的注解  jpa是一种思想    hibernate是实现
 */
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/*
*Author:
*Description:登陆后返回用户一切信息（登录后，返回的json数据信息）
*
*/
@Data
public class UserVo {
	/**
	 * 主键
	 */
	@Id
	private Long id;
	
	/**
	 * 登录账号
	 */
	@Column(name = "user_name")
	private String userName;
	

	/**
	 * 密保问题
	 */
	@Column(name = "pass_problem")
	private String passProblem;
	

	/**
	 * 昵称
	 */
	@Column(name = "user_nick")
	private String userNick;
	
	/**
	 * 头像
	 */
	@Column(name = "user_avatar")
	private String userAvatar;
	
	/**
	 * 邮箱
	 */
	@Column(name = "user_email")
	private String userEmail;
	
	/**
	 * 性别
	 */
	@Column(name = "user_sex")
	private String userSex;
	
	/**
	 * 生日
	 */
	@Column(name = "user_birthday")
	private Date userBirthday;
	
	
	
	/**
	 * 状态 0废除，1激活
	 */
	@Column(name = "delete_status")
	private Integer deleteStatus;
	
	/**
	 * 操作者
	 */
	private Long operator;

    /**
     * 所属商店Id
     */
    @Column(name = "store_id")
    private Long storeId;
	
	/*private List<Role> roleList;*/

//	private List<Permission> permissionList;
	
	private String token;
}
