<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="${basePath}/static/common/jquery-1.9.1.min.js"></script>

    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <title>test</title>

</head>
<body>
<h4>hello</h4>
<button id="calculate" onClick="fnTest()">测试</button>
</body>
<script type="text/javascript">

    function fnTest() {
        var data = {
            "biz_content":{
                "json_str":{
                    "serviceNumber": "fw00001",
                    "valideArray": [
                        {
                            "name": "张三丰",
                            "idcard": "510521199002081323",
                            "date": "20190611",
                            "money": "1500",
                            "family": [
                                {
                                    "name": "张小丰",
                                    "idcard": "510521199002081323"
                                },
                                {
                                    "name": "王慧慧",
                                    "idcard": "510521199002081323"
                                }
                            ]
                        },
                        {
                            "name": "张三丰",
                            "idcard": "510521199002081323",
                            "date": "20190611",
                            "money": "1500",
                            "family": [
                                {
                                    "name": "张小丰",
                                    "idcard": "510521199002081323"
                                },
                                {
                                    "name": "王慧慧",
                                    "idcard": "510521199002081323"
                                }
                            ]
                        }
                    ]
                }
            },
            "access_key": "CSWEB",
            "format": "json",
            "sign": "Vcz3LdD4qv51DQ7KuuVy1wbHzZHS8sXuGB9YLx/It3M9zaKd0i0xpo8415mVdYYZ5PqIvfxGvFN8P+o1Hj77GA5Yjx7TfBZSZCDDf1O2eSL4rXu8aYS2dUbPfk9KSrpUxi07GelmSOBcoZp7CLpbK1etQ2JTsIlYovponOQia4RjW7EFfUr/4mEjAqA1Rp3atU0f8UBkmd4K4KNucNcgCOshZRpPJ16ybqeK/kHvg5HhCa69iqRlTij+GkPvPQtAmCDxKml78+qSPQTKGgFfRFl1/kVLV5CkHhCZwAudVfqYx35tvvuFjpLdBge2MktcSI6hmTW3hwp0vQBeLbSL6g==",
            "request_id": "1544151852223",
            "version": "1.0",
            "timestamp": "1544151852223",
            "mock": "0"
        };
        $.ajax({
            type: "post",
            url: "test!YAA01WC00001",
            cache: false,
            dataType: "json",
//            contentType: "application/json", //这个不能漏
            async: true,//使用同步的方式,true为异步方式
            data: {data:JSON.stringify(data)},
            beforeSend: null,
            success: null,
            complete: null,
            error: null
        });
    }

</script>
</html>
