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
        <label>姓名：</label>${dataObject.name!?string}</br>
        <label>年龄：</label>${dataObject.age!?c}</br>
    </p>
    </body>
</html>