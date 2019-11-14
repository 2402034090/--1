1.阳光进销存
  1.1  pojo 研发
  1.2  dao接口和Mapper的研发
  1.3  关于返回结果的定制
2.编程重要的思想就是约定优于配置
pojo
  po
    User
  vo
    UserVo
  dto
    UserDto
  Bo
    UserBo
dao
  UserMapper
service
  UserService
  impl
    UserServiceImpl

common
  ServerResponse
  PageModel
exception
  NotFoundException
  IllegalException
resources
  mapper
    UserMapper.xml

1xx：100临时响应
2XX: 200成功响应
3XX: 302：暂时重定向    303永久重定向
4XX: 404 请求资源未找到  客户端  406 Springmvc  请求组织的格式不对
5XX: 500 服务器内部错误  程序员代码有问题


请求跳转方式：
转发还是重定向
转发与重定向的五点区别
1.请求次数  重定向：2次  转发1次
2.url地址栏 重定向：最终页面  转发：中间的处理页面
3.位置：客户端VS服务器  重定向：客户端主动发起  转发：服务器内部
4.速度： 重定向速度慢     转发：快
5.能否跨站跳转：重定向是可以的   转发是不可以的

3.客户档案定义模块
  数据表结：构customer
  id：客户编号
  customer_name：客户名称
  customer_store_name：客户店铺名称
  customer_phone: 客户电话
  customer_email: 客户邮箱
  customer_score: 客户积分(每次消费取整)
  customer_level: vip级别 0->5 默认0
  customer_address: 客户地址
  remarks：备注   一般任何企业级项目中，都有备注列  备用字段
  operator：操作员
  create_time：创建日期  企业中项目：
  update_time：更改日期  企业中项目：
  delete_status：状态    0不启用，1用
  store_id：所属商店Id

更新数据库错误
 Error updating database.
引发原因：数据库异常             ：store_id字段没有默认值
Cause: java.sql.SQLException: Field 'store_id' doesn't have a default value\r\n###
错误引发的场所是Mapper文件中的insertSelective方法
The error may involve(涉及到了) com.sunny.dao.CustomerMapper.insertSelective-Inline\r\n###
这个错误引发的时机是设置参数值的时候
 The error occurred while setting parameters\r\n###
 SQL: INSERT INTO customer  ( id,customer_name,customer_store_name,customer_phone,customer_address )
  VALUES( ?,?,?,?,? )\r\n### Cause: java.sql.SQLException: Field 'store_id' doesn't have a default value\n; ];
  Field 'store_id' doesn't have a default value;
  nested exception is java.sql.SQLException: Field 'store_id' doesn't have a default value



















