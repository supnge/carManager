<html>
<script type="text/javascript" src="./admin/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    // 1. js监听文档是否加载完：

    $(function() {
        var selectEle = $("#testSelect");
        console.log(selectEle);
        var checkText=$("#testSelect").find("option:selected").text(); //获取Select选择的
        console.log(checkText);
        var checkValue=$("#testSelect").val();//获取Select选择的Value
        console.log(checkValue);
        $("#testSelect").append("<option value='Value'>Text</option>");
    });


</script>
<body>
<h2>Hello World!</h2>
<select id="testSelect">
    <option value="dog">Dog</option>
    <option value="cat" name="cat">Cat</option>
    <option value="cat" name="cat" id="fox">Fox</option>
    <option value="cat" name="cat" id="wolf">Fox</option>
    <option value="cat" name="cat" id="bird">bird</option>
    <option value="cat" name="cat" id="bird">bird</option>
    <option id ='gf' value="goldfish" selected>Goldfish</option>
</select>
</body>
</html>
