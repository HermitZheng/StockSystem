## 超市订货系统——StockSystem

### 一、功能
    1.多个超市能够通过各自的账号密码登录系统。
    2.系统中显示超市需要的商品信息。
    3.对商品或者供货商检索，列出可以进货的商品列表。
    4.对选定商品进行添加购物车以及购买。
    5.对已购买的商品进行库存记录
    ...
   
### 二、数据库组成
| MarketCom Table |  Market Table  | StockCommodity Table  | Stock Table    |
| :-------------: | :------------: | :-------------------: | :------------: |
| Commodity ID    |  Market ID     | Stock ID              | Stock ID       |
| Commodity Name  |  Market Name   | Com ID                | Stock Name     |
| Storage         |  Password      | Price                 |                |
| Market ID       |  Address       | Quantity              |                |

### 三、用户界面
    1.登录界面
    2.商店商品界面 ：显示此商店的出售商品列表，并且可以选择按照商品或者供货商进行检索
    3.按商品检索界面：显示一种商品在不同供货商的价格，并提供购买选项
    4.按供货商检索界面：显示一家供货商的所有商品信息，并提供购买选项
    5.购物车：显示已选择的商品，并提供删除选项
    
### 四、实体类
    1、超市信息
    2、超市库存（商品、供货商信息）
    3、商品
    4、购物车（订单）
    
    
    