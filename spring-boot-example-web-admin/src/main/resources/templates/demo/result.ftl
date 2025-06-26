<!doctype html>
<html lang="zh-cn">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, viewport-fit=cover" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>结果页</title>
    </head>
    <body>
    </p>
        <p>
            <h1>操作结果：${page_result_title?string}，正在跳转，请稍候...</h1>
        </p>
        <script>
            setTimeout(function() {
                window.location.href = '/demo/list';
            }, 3000);
        </script>
    </body>
</html>