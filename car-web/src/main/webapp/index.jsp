<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<script type="text/javascript" src="./admin/jquery/jquery-3.4.1.js"></script>
<script type="text/javascript">
    // 1. js监听文档是否加载完：

    $(function () {
        var selectEle = $("#testSelect");
        console.log(selectEle);
        var checkText = $("#testSelect").find("option").text(); //获取Select选择的
        console.log(checkText);
        var checkValue = $("#testSelect").val();//获取Select选择的Value
        console.log(checkValue);
        $("#testSelect").append("<option value='Value'>Text</option>");

        // 根据选项内容进行查询
        console.log($("#testSelect option:contains('birdd')").length);

        // $("#testSelect option:contains('birdd'):gt(0)").remove();
        // $("#testSelect option:contains('Fox'):gt(0)").remove();

        $("#testSelect").click(function () {
            console.log("开始去重");
            $("select option").each(function () {
                text = $(this).text();
                if ($("select option:contains(" + text + ")").length > 1)
                    $("select option:contains(" + text + "):gt(0)").remove();
            });
        });


    });

    function changeF()
    {
        // 从下面的赋值可以的值，你在action 中只要得到name =“ccdd” 的值就可以了。
        document.getElementById('ccdd').value=document.getElementById('aabb').options[document.getElementById('aabb').selectedIndex].value;
    }



</script>
<body>
<h2>Hello World!</h2>
<select id="testSelect">
    <option value="dog">Dog</option>
    <option value="cat" name="cat">Cat</option>
    <option value="cat" name="cat" id="fox">Fox</option>
    <option value="cat" name="cat" id="wolf">Fox</option>
    <option value="cat" name="cat" id="birdBird">birddird</option>
    <option value="cat" name="cat" id="birdBird">birddird</option>
    <option id='gf' value="goldfish" selected>Goldfish</option>
</select>

<div style="position:relative;"> 
    <span style="margin-left:100px;width:18px;overflow:hidden;"> 
<select style="width:118px;margin-left:-100px" οnchange="this.parentNode.nextSibling.value=this.value" data-options="editable:true"> 
<option value="内容01">内容01</option> 
<option value="内容02"> 内容02</option> 
<option value="内容03"> 内容03</option> 
</select></span>
</div>



<span style="absolute;margin-top:-12px;">
    <table cellspacing="0" cellpadding="0" width="100%" border="0">
        <tr>
            <td align="left">
                <span style="position:absolute;border:1pt solid #c1c1c1;width:188px;height:19px;clip:rect(-1px 190px 190px 170px);">
                    <select name="aabb" id="aabb" style="width:190px;height:20px;margin:-2px;" onChange="changeF();">
                    <option value="" style="color:#c2c2c2;">---请选择---</option>
                    <option value="闲人书库">闲人书库</option>
                    <option value="闲人BLOG">闲人BLOG</option>
                    <option value="<a href="http://www.ayinsky.com" target="_blank">闲人设计</a>"><a href="http://www.ayinsky.com" target="_blank">闲人设计</a></option>
                        <option value="闲人软件">闲人软件</option>
                    </select>
                </span>
                <span style="position:absolute;border-top:1pt solid #c1c1c1;border-left:1pt solid #c1c1c1;border-bottom:1pt solid #c1c1c1;width:170px;height:19px;">
                    <input type="text" name="ccdd" id="ccdd" value="可选择也可输入的下拉框" style="width:170px;height:15px;border:0pt;">
                </span>
            </td>
        </tr>
    </table>



</body>
</html>
