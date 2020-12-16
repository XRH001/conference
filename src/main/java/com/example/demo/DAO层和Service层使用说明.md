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

- user 用户 这是一个基本类

  ```
      
       /**
       * @param ID 用户编号
       * @param name 用户真实姓名
       * @param username 用户名
       * @param password 密码
       * @param sex 性别
       * @param birth 出生日期
       * @param email 电子邮箱
       * @param phone 电话号码
       * @param imgPath 头像图片存放路径
       
      private int ID;
      private String name;
      private String username;
      private String password;
      private Sex sex;
      private LocalDate birth;
      private String email;
      private String imgPath;
      private String phone;
  ```

  

- userInfo 用户附加信息, 用于存放以后可能新增加的字段

  ```
  	/**
  	* @param ID 编号
  	* @param user 用户
  	* @param image_path 图片存放路径
  	*/
      private int ID;
      private User user;
      private String image_path;
  ```

  

- journey 行程 用于描述开始时间,出发地,目的地

  ```
      /**
       * 基本类:行程信息
       * 这个类用来说明一次行程的基本信息
       * @param ID 行程编号
       * @param time 出发时间
       * @param origin 出发地点
       * @param target 目的地
       */
      private int ID;
      private LocalDateTime time;
      private String origin;
      private String target;
  ```

  

- userJourney 用户行程, 用于描述用户和行程的映射关系

  ```
      /**
       * @param ID 用户出行ID
       * @param user 用户;
       * @param journey 行程基本信息
       */
      private int ID;
      private User user;
      private Journey journey;
  ```

  

- driver 司机

  ```
       /**
       * 基本类:司机和车辆
       * 在本工程中,每个司机对应唯一一个汽车
       * @param ID 编号
       * @param name 姓名
       * @param phone 电话
       * @param type 车的类型
       * @param maxNum 车承载的最大人数
       * @param carNum 车牌号
       * @param username 用户名
       * @param password 密码
       * @param email 电子邮箱
       * @param imgPath 头像图片存放路径
       */  
      private int ID;
      private String name;
      private String phone;
      private String type;
      private int maxNum;
      private String carNum;
      private String username;
      private String password;
      private String email;
      private String imgPath;
  
  ```

  

- driverPickUp 司机接送, 用于描述司机和用户行程的映射关系

  ```
      /**
       * 基本类,对应的司机接送表
       * @param ID 司机接送ID
       * @param driver 司机
       * @param userJourney 用户出行
       * @param orderStatus 接送状态
       */
      private int ID;
      private Driver driver;
      private UserJourney userJourney;
      private OrderStatus orderStatus;
  ```

  

- conference 会议

  ```
      /**
       * 基本类:会议信息,对应数据库中的会议表
       * 这个类用来说明会议信息
       * 对于用int存储的boolean值,0代表true,1代表false
       * @param ID 会议编号
       * @param name 会议名称
       * @param address 会议地点
       * @param oderStatus 会议结束状态
       * @param num 参会人数
       * @param createTime 会议创建时间
       * @param beginTime 会议开始时间
       * @param endTime 会议结束时间
       * @param isPrivate 是否为内部会议
       */
      private int ID;
      private String name;
      private String address;
      private OrderStatus orderStatus;
      private int num;
      private LocalDateTime createTime;
      private LocalDateTime beginTime;
      private LocalDateTime endTime;
      private boolean isPrivate;
  ```

  

- conferenceInfo 会议附加信息, 用于存放以后可能新增加的字段

  ```
      /**
       *会议附加信息,这是一个备用类
       * @param ID 编号
       * @param conference 会议
       * @param info 会议备注
       */
      private int ID;
      private Conference conference;
      private String info;
  ```

  

- conferenceUser 参会人员, 用于描述会议和用户的映射关系

  ```
      /**
       * 基本类:参会人员
       * @param ID 编号
       * @param user 用户
       * @param conference 会议
       * @param position 职位
       * @param invitationStatus 邀请状态
       * @param orderStatus 申请状态
       * @param info 备注
       */
      private int ID;
      private User user;
      private Conference conference;
      private Position position;
      private InvitationStatus invitationStatus;
      private OrderStatus orderStatus;
      private String info;
  ```

  

- hotel 酒店

  ```
      /**
       * @author 李嘉旭
       * 基本类:酒店,对应数据库的酒店表
       * 这个类用来说明酒店信息
       * @param ID 酒店编号
       * @param name 酒店名字
       * @param phone 练习电话
       * @param address 详细地址
       * @param username 用户名
       * @param password 密码
       * @param email 电子邮箱
       * @param imgPath 头像图片存放路径
       */
      private int ID;
      private String name;
      private String phone;
      private String address;
      private String username;
      private String password;
      private String email;
      private String imgPath;
  ```

  

- hotelRoom 酒店房间

  ```
      /**
       * @author 李嘉旭
       * 基本类:酒店房间
       * 这个类用来说明酒店有哪些房间
       * @param ID 房间编号
       * @param type 用来说明房间类型,例如单人间和双人间
       * @param roomID 房间号
       * @param price 价格
       * @param hotelID 房间所属的酒店编号
       * @param isUsed 房间是否已经被使用
       * @param maxNum 房间最大人数限制
       */
      private int ID;
      private String type;
      private String roomID;
      private Hotel hotel;
      private double price;
      private boolean isUsed;
      private int maxNum;
  ```

  

- hotelOrder 酒店订单,用于描述酒店房间的详细信息

  ```
      /**
       * @author 李嘉旭
       * 基本类:酒店订单信息
       * 这个类用来说明酒店订单的基本信息
       * @param ID 订单编号
       * @param hotelRoom 酒店房间ID
       * @param createTime 下单时间
       * @param num 入住人数
       * @param orderStatus 订单状态
       * @param beginTime 入住时间
       * @param endTime 退房时间
       */
      private int ID;
      private HotelRoom hotelRoom;
      private LocalDateTime createTime;
      private int num;
      private OrderStatus orderStatus;
      private LocalDateTime beginTime;
      private LocalDateTime endTime;
  ```

  

- hotelAccommodation 酒店住宿 用于描述酒店订单和参会人员的映射关系

  ```
      /**
       * @author 李嘉旭
       * 基本类:酒店住宿类
       * @param ID 住宿ID
       * @param conferenceUser 参会人员
       * @param hotelOrder 酒店订单
       */
  ```

  



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

- ​		**当ID已存在进行修改操作**

- ​		**当ID不存在时则进行新增操作**

  - *举例*

    ```
        public Conference saveConference(Conference conference){
            if (conference!=null){
                return toConference(conferenceDAO.save(toConferenceDO(conference)));
            }else {
                return null;
            }
        }
    ```

    - 这个方法的意思是将一条会议记录插入数据库
    - 参数是要插入的会议对象
    - 如果参数为null, 返回 null, 表示插入失败
    - 否则返回给定的参数,表示成功

```
deleteByID(int ID){

}
```

- ​		deleteByID方法用来进行删除操作,参数为ID

  - *举例*

    ```
        public int deleteConference(int conferenceID){
            try {
                conferenceDAO.deleteById(conferenceID);
                return 1;
            }catch (EmptyResultDataAccessException e){
                return -1;
            }
        }
    ```

    - 这个方法的意思是删除一条会议记录
    - 参数是会议记录的ID
    - 如果返回1, 表示删除成功
    - 返回-1, 表示删除失败

```
queryBy(){

}
```

- ​		service里的大部分的方法都是queryBy方法

- ​		使用时请根据queryBy方法的名字进行使用	

- ​		query后面跟着的属性是返回的entity类型

- ​		By后面跟着的属性是查询需要的参数

  - *举例*1 查询多条记录

    ```
        public List<Conference> queryConferences(){
            list.clear();
            List<ConferenceDO> conferenceDOList=conferenceDAO.findAll();
            if (conferenceDOList.size()!=0){
                for(ConferenceDO c:conferenceDOList){
                    list.add(toConference(c));
                }
                return list;
            }else {
                return null;
            }
        }
    ```
    - 这个方法的意思是查询所有的会议记录
    - 没有参数
    - 如果返回null, 表示查询失败
    - 否则返回一个会议的列表, 表示查询成功的结果

  - *举例*2 查询单条记录

    ```
        public Conference queryConferenceByID(int conferenceID){
            try {
                return toConference(conferenceDAO.findById(conferenceID).get());
            }catch (NoSuchElementException e){
                return null;
            }
        }
    ```

    - 这个方法的意思是查询一条会议记录

    - 参数是这条会议记录的编号(ID)

    - 如果返回null, 表示查询失败

    - 否则返回一条会议记录, 表示查询成功的结果

      

**需要特别说明的是**

```
queryForCountTotal(){

}
```

- ​		所有的service中都带有这个方法

- ​		这个方法返回当前entity记录的数量

- ​		即数据库中存放多少条该条记录

  - *举例*

    ```
        public int queryForPageCountTotal(){
            Number count=conferenceDAO.count();
            return count.intValue();
        }
    ```

    - 这个方法的意思是查询总共有多少条会议记录
    - 没有参数
    - 返回会议记录的条数

```
queryForPageItems(int begin,int pageSize){

}
```

- ​		所有的service中都带有这个方法

- ​		这个方法用于分页操作

- ​		参数begin是起始位置

- ​		参数pageSize是页面长度

  - *举例*

    ```
        public List<Conference> queryForPageItems(int begin,int pageSize){
            try {
                list.clear();
                List<ConferenceDO> conferenceDOList=conferenceDAO.queryForPageItems(begin,pageSize);
                if (conferenceDOList.size()!=0){
                    for(ConferenceDO c:conferenceDOList){
                        list.add(toConference(c));
                    }
                    return list;
                }else {
                    return null;
                }
            }catch (Exception e){
                return null;
            }
        }
    ```

    - 这个方法的意思是查询从begin开始的,长度为pageSize的会议记录列表
    - 参数begin是起点, pageSize是每页的长度
    - 如果返回null, 表示查询失败
    - 否则一个会议的列表, 表示查询成功的结果

​		**注意:begin从0开始**

```
	containing(String key){
	
	}
```

- 这个方法用于数据库的模糊查询

- 使用sql语句实现的, 所以查询的精度有限

- 不是所有service都有这个方法

- 只有四个基本类有这个模糊查找的方法

- 以后可能会添加

  - *举例*

  ```
      public List<Conference> queryConferenceDOSByNameContaining(String name){
          list.clear();
          List<ConferenceDO> conferenceDOList=conferenceDAO.queryConferenceDOSByNameContaining(name);
          if (conferenceDOList.size()!=0){
              for(ConferenceDO c:conferenceDOList){
                  list.add(toConference(c));
              }
              return list;
          }else {
              return null;
          }
      }
  ```

  - 这个方法的意思是根据会议的名字进行模糊查找
  - 参数是名字的关键词
  - 如果返回null, 表示查询失败
  - 否则返回一个符合模糊查找结果的会议列表, 表示查询成功

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