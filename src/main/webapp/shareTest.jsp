<%@page import="java.util.Map"%>
<%@page import="com.weixin.vo.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<title>注册</title>
</head>
<body>
	<%
	// 获取由OAuthServlet中传入的参数
	Map<String, String> map = (Map<String, String>) request.getAttribute("wxInfo");
%>
<%-- jsapi_ticket	<%=map.get("jsapi_ticket")%> <br>
nonce_str	<%=map.get("nonceStr")%><br>
timestamp	<%=map.get("timestamp")%><br>
signature	<%=map.get("signature")%><br> --%>

微信自定义分享测试

</body>
<script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
<script type="text/javascript">
	wx.config({
		debug : true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
		appId : "<%=map.get("appId")%>", // 必填，公众号的唯一标识
		timestamp : <%=map.get("timestamp")%>, // 必填，生成签名的时间戳
		nonceStr : "<%=map.get("nonceStr")%>", // 必填，生成签名的随机串
		signature : "<%=map.get("signature")%>",// 必填，签名，见附录1
		jsApiList : [ 'onMenuShareAppMessage', 'onMenuShareTimeline' ,'onMenuShareQQ','onMenuShareQZone']
	// 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});

	wx.ready(function() {

		// config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
		wx.onMenuShareAppMessage({
			title : '<%=map.get("title")%>',
			desc : '<%=map.get("desc")%>',
			link : '<%=map.get("link")%>',
			imgUrl : '<%=map.get("imgUrl")%>',
			success : function() {
				WeixinJSBridge.call('closeWindow');
			}
		});

		wx.onMenuShareTimeline({
			title : '<%=map.get("title")%>',
			desc : '<%=map.get("desc")%>',
			link : '<%=map.get("link")%>',
			imgUrl : '<%=map.get("imgUrl")%>',
			success : function() {
				// 用户确认分享后执行的回调函数 会关闭打开的页面
				//WeixinJSBridge.call('closeWindow');
			},
			cancel : function() {
				// 用户取消分享后执行的回调函数
			}
		});
		
		
		wx.onMenuShareQQ({
			title : '<%=map.get("title")%>',
			desc : '<%=map.get("desc")%>',
			link : '<%=map.get("link")%>',
			imgUrl : '<%=map.get("imgUrl")%>',
			success : function() {
				// 用户确认分享后执行的回调函数
			},
			cancel : function() {
				// 用户取消分享后执行的回调函数
			}
		});
		
		
		
		wx.onMenuShareQZone({
			title : '<%=map.get("title")%>',
			desc : '<%=map.get("desc")%>',
			link : '<%=map.get("link")%>',
			imgUrl : '<%=map.get("imgUrl")%>',
			success : function() {
				// 用户确认分享后执行的回调函数
			},
			cancel : function() {
				// 用户取消分享后执行的回调函数
			}
		});
		
	});

	wx.error(function(res) {

		// config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。

	});
</script>
</html>
