<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>返回结果</title>
</head>
<style type="text/css">
	body,ul{
		margin: 0px;
		padding: 0px;
	}
	.warp{
	width:100%;
	height:100%;
	  text-align: center;
	  margin:0 auto;
	}
	.content{	
	width: 30%;
    border: solid 1px #dfdfdf;
    margin: auto;
    padding: 0px;
    margin-top: 7%;
    border-radius: 7px;
	}
	.top{
		width:100%;
		height: 31px;
		border-bottom: solid 1px  #dfdfdf;
		background-color: rgba(105, 98, 98, 0.09);
        border-top-left-radius: 7px;
    	border-top-right-radius: 7px;
	}
	.title{
			text-align: left;margin: 5px 0px 5px 10px;display: block;
	}
    a{
    	text-decoration:none;
    }
</style>
<body>
<div class="warp">
		<div class="content">
			<div class="top">
				<div style="float: left;margin: 5px 0px 5px 10px;">返回结果：</div>
            	<div style="float: right; margin-top: 5px; margin-right: 15px;">
                    <a href="#" onclick="window.history.back();" title="Close"><strong>X</strong></a>
                </div>	
			</div>
			<div class="con">
				<p>${eeor}</p>
			</div>
			
		</div>
</div>
</body>
</html>