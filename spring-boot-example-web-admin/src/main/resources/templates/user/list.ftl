<!doctype html>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>列表页</title>
    </head>
    <body>
    <#include "../common/href.ftl">
    <p>
        <table>
        <thead>
            <tr>
                <td>编号</td>
                <td>昵称</td>
                <td>帐号</td>
                <td>操作</td>
            </tr>
        </thead>
        <tbody>
        <#if dataList?? && dataList?size gt 0>
            <#list dataList as item>
            <tr>
                <td>${item.id!?c}</td>
                <td>${item.nickName!?string}</td>
                <td>${item.userName!}</td>
                <td>
                    <a href="/user/detail/${item.id!}">详情</a>&nbsp;&nbsp;
                    <a href="/user/remove/${item.id!}">删除</a>&nbsp;&nbsp;
                </td>
            </tr>
            </#list>
        <#else>
            <tr>
                <td colspan="4">暂无数据！</td>
            </tr>
        </#if>
        </tbody>
        </table>
    </p>
    </body>
</html>