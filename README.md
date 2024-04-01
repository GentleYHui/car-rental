# car-rental
用户登陆系统后可以查看车辆信息并选择心仪车辆进行租赁，后台会管理汽车相关数据（车况、租赁情况等）、用户信息以及业务员销售情况，可以对以上信息进行增删改查。
使用Spring和Mybaits实现对bean注入和数据库操作，使用SpringMVC和layui完成对前端页面的操作
## 基础功能

1. 用户登录
   实现信息校验以及页面跳转
   note:使用hutool包实现随机验证码
3. 用户管理
   根据CURD需求实现对数据库的单个操作和批量操作
   note:遍历数组实现批量删除（不用重写sql语言）
4. 车辆管理
   根据CURD需求实现对数据库的单个操作和批量操作
   上传车辆图片，可以查看缩略图和大图。
## 业务管理
1. 出租列表
  根据身份证查询名下汽车数量及出租情况
2. 更改出租信息
   在出租订单页面提交后，需额外改变汽车出租状态信息
