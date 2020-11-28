# DAO层和Service层使用说明

##### Gitee链接:

https链接:https://gitee.com/li-jiaxv/conference.git

ssh链接:git@gitee.com:li-jiaxv/conference.git

#### Java代码项目结构

1. ​	**entity**

2. ​    **controller**

3. ​     **service**

4. ​     **dao**

5. ​     **utils**

6. ​     **enumValue**

   

#### 需要使用的包

​	**entity,service,utils和enumValue**

- ​		entity是实体类,里面的类需要实例化使用,整个java部分都依赖此传递数据
- ​		service是依赖SpringBootJPA自动注入的service类,使用时请加上SpringBoot注解使用
- ​		utils是工具类,我写了时间转换的工具,如果想要加入新的工具也可以想里面加入
- ​		enumValue是自定义的枚举类型,entity中的类都使用到了这些枚举类型

#### Entity

​		**部分对应数据库中的表,不完全对应**

​		使用时请对照数据库使用

​		**service中包含了大部分的调用方法**

- user 用户
- userInfo 用户附加信息, 用于存放以后可能新增加的字段
- journey 行程
- userJourney 用户行程, 用于描述用户和行程的映射关系
- driver 司机
- driverPickUp 司机接送, 用于描述司机和用户行程的映射关系
- conference 会议
- conferenceInfo 会议附加信息, 用于存放以后可能新增加的字段
- conferenceUser 参会人员, 用于描述会议和用户的映射关系
- hotel 酒店
- hotelRoom 酒店房间
- hotelOrder 酒店订单,用于描述酒店房间的详细信息
- hotelAccommodation 酒店住宿 用于描述酒店订单和参会人员的映射关系



#### enumValue

​		**自定义的枚举类**

​		每个枚举类型都对应一个int值 , **请在枚举类中查找对应的数字**

- position 用于描述某个用户在会议中的身份 , ******请和user中的字段position区分*****
- sex 用于描述用户性别
- invitationStatus 用于描述邀请的接受状态
- orderStatus 用于描述大多数的状态

#### Service

- ​		service定义了entity的调用方法
- ​		下面是详细说明

​		

```java
save(T){
    
}
```

- ​		save方法用来新增或修改数据库中的数据
- ​		 **取决于ID** 
- ​		当ID已存在进行修改操作
- ​		当ID不存在时则进行新增操作

```
deleteByID(int ID){

}
```

​		deleteByID方法用来进行删除操作,参数为ID

```
queryBy(){

}
```

- ​		service里的大部分的方法都是queryBy方法
- ​		使用时请根据queryBy方法的名字进行使用	
- ​		query后面跟着的属性是返回的entity类型
- ​		By后面跟着的属性是查询需要的参数

**需要特别说明的是**

```
queryForCountTotal(){

}
```

- ​		所有的service中都带有这个方法
- ​		这个方法返回当前entity记录的数量
- ​		即数据库中存放多少条该条记录

```
queryForPageItems(int begin,int pageSize){

}
```

- ​		所有的service中都带有这个方法
- ​		这个方法用于分页操作
- ​		参数begin是起始位置
- ​		参数pageSize是页面长度

​		**注意:begin从0开始**

#### DAO

- ​		不要使用DAO里的方法
- ​		有新的需求提交给我
- ​		我来更新service的调用方法

#### 数据库

​		联合唯一 ( unique )  :  多个属性的组合是唯一的

​				 举例        :       userJourney中的属性 user 和 journey 存放了 ( 1 , 1 ) 后,不能再插入 ( 1 , 1 ),可以插入 ( 1 , 2 ) , ( 2 , 1 ) 等

​		除了外键约束和主键约束外,使用时应注意以下联合唯一约束:

- userJourney                             user 和 journey 联合唯一
- driverPickUp                            dirver和userJourney 联合唯一
- user                                           username唯一 , email唯一 , phone唯一
- conferenceUser                       conference和user 联合唯一 
- hotelRomm                              hotel和roomID联合唯一
- hotelAccommodation             hotel和hotelOrder联合唯一

**同时要注意外键的使用**





#### Utils

​		我写了一个LocalDateTime和Date 的转换工具

​		有新的工具也可以自己加进去