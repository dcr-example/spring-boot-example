<!doctype html>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>详情页</title>
    </head>
    <body>
    <#include "../common/href.ftl">
    <p>
        <label>编号：</label>${dataObject.id!?c}</br>
        <label>昵称：</label>${dataObject.nickName!?string}</br>
        <label>帐号：</label>${dataObject.userName!?string}</br>
        <label>密码：</label>${dataObject.userPwd!?string}</br>
    </p>
    </body>
</html>