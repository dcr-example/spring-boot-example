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
        <form action="/user/save" method="get">
            <p>
                <label>昵称： </label><input type="text" name="nick_name" value=""/>
            </p>
            <p>
                <label>帐号： </label><input type="text" name="user_name" value=""/>
            </p>
            <p>
                <label>密码： </label><input type="password" name="user_pwd" value=""/>
            </p>
            <p>
                <input type="submit" value="提交"/>
            </p>
        </form>
    </p>
    </body>
</html>