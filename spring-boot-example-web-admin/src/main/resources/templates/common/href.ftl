
<p>
<h1>
    <#if session_user_info??>
        欢迎您：${session_user_info.userName!?string}&nbsp;&nbsp;<a href="/login/out">退出系统</a>
    <#else>
        请先<a href="/login/index">登录</a>
    </#if>
</h1>
</p>
<p>
导航 >>
<a href="/">系统首页</a>&nbsp;&nbsp;
<a href="/demo/list">示例/列表</a>&nbsp;&nbsp;
<a href="/demo/add">示例/添加</a>&nbsp;&nbsp;
<#if session_user_info??>
<a href="/user/list">用户/列表</a>&nbsp;&nbsp;
<a href="/user/add">用户/添加</a>&nbsp;&nbsp;
</#if>
</p>
<p>
<h3>${page_title?string}, 系统时间：${systemCurrentDateTime?datetime}</h3>
</p>