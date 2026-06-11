<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>用户信息页面</title>
</head>
<body>

<h2>用户信息</h2>

<p>用户名：${user.name}</p>

<p>年龄：${user.age}</p>

        <#if user.showEmail?? && user.showEmail == true>
            <p>邮箱：${user.email}</p>
        </#if>

        <#if user.role == "admin">
            <button>管理员后台入口</button>
        </#if>

</body>
</html>