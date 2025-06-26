<!doctype html>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>首页</title>
    </head>
    <body>

    <#include "../common/href.ftl">
    <p>
        <form action="/demo/save" method="get">
            <p>
                <label>姓名： </label><input type="text" name="name" value=""/>
            </p>
            <p>
                <label>年龄： </label><input type="number" name="age" value=""/>
            </p>
            <p>
                <input type="submit" value="提交"/>
            </p>
        </form>
    </p>
    </body>
</html>