# API文档
***
## 1.查询号码接口
### 接口功能
>根据移动端用户在王卡申请界面选择的省、市显示随机可用号码90个
### URL
>http://localhost:8090/app/numlist/{province}/{city}
### 支持格式
>JSON
### HTTP请求方式
>GET
### 请求参数
>参数{province}:省名 不带“省”字  
>参数{city}：地市名 不带“市”
### 返回字段

  
| 参数  | 类型 | 说明
|-----|-----|------|
| svcId  | int  | 号码id |
| svcNum  |  String | 号码 |
| province  | String  | 归属省 |
| city  | String  | 归属市 |
| status  | int  | 号码状态，0：可用，1：预占，2：在用 |

### 接口示例
>地址:[http://localhost:8090/app/numlist/浙江/杭州]
>
>[{"svcId":2128,"svcNum":"13023684732","province":"浙江","city":"杭州","status":0},{"svcId":65259,"svcNum":"18657109787","province":"浙江","city":"杭州","status":0},{"svcId":31489,"svcNum":"14532129032","province":"浙江","city":"杭州","status":0},{"svcId":49485,"svcNum":"15657129029","province":"浙江","city":"杭州","status":0},{"svcId":24562,"svcNum":"13255711206","province":"浙江","city":"杭州","status":0},{"svcId":14243,"svcNum":"13148466520","province":"浙江","city":"杭州","status":0}]

## 2.订单提交接口
### 接口功能
用于响应移动端用户提交事件，于数据库中的记录插入
### URL
>http://localhost:8090/app/insert
### 支持格式
>JSON
### HTTP请求方式
>POST
### 请求参数

| 参数  | 必填| 类型 | 说明
|-----|-----|------|----|
| svcId  | true| int  | 号码id |
| customerName  | true| String  | 用户姓名 |
| certNum  | true| String  | 身份证号 |
| contactPhone  | String| int  | 用户现有联系方式 |
| address  | true| String  | 用户地址 |
 
### 返回字段  
>{
    "msg": "增加成功！",
    "code": 1
}  
>{
    "msg": "增加失败！",
    "code": 0
}




### 接口示例
>地址:[localhost:8090/app/insert?svcId=13&customerName=刘兵辉2&certNum=3894849328422&contactPhone=15657175987&address=中河北路]  
>
>success返回
>
>{
    "msg": "增加成功！",
    "code": 1
}

## 3.查询订单接口
### 接口功能
>根据移动端用户查询订单状态
### URL
>http://localhost:8090/app/getOrder/{value}
### 支持格式
>JSON
### HTTP请求方式
>GET
### 请求参数
>参数{value}:订单提交时用户联系方式或者新选号（联通号码）
### 返回字段  

| 参数  | 类型 | 说明
|-----|-----|------|
| orderId  | int  | 订单ID |
| customerName  |  String | 用户姓名 |
| svcNum  | String  | 新选号码 |
| createTime  | date  | 订单提交事件 |
| status  | int  | 订单状态,0:在途 1:成功 2:不再办理|

### 接口示例
>地址:[http://localhost:8090/app/getOrder/15657175987]
>
>{"orderId":5311,"customerName":"刘兵辉2","svcNum":"13001123222","createTime":"2018-10-22 14:28","status":"0"}