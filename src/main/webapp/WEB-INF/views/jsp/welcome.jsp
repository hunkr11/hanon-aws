<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %> --%>
<!DOCTYPE HTML>
<!-- <html xmlns:th="http://www.thymeleaf.org"> -->

<html>
<head>
<meta charset="utf-8">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<title>Hanon Systems</title>

<link href="${pageContext.request.contextPath}/css/common.css"
	rel="stylesheet" />

<link
	href="${pageContext.request.contextPath}/css/easy-responsive-tabs.css"
	rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet" />
	
<!-- 	
	Bootstrap styles
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!-- Generic page styles -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<!-- blueimp Gallery styles -->
<link rel="stylesheet" href="https://blueimp.github.io/Gallery/css/blueimp-gallery.min.css">
<!-- CSS to style the file input field as button and adjust the Bootstrap progress bars -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload-ui.css">
<!-- CSS adjustments for browsers with JavaScript disabled -->
<noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload-noscript.css"></noscript>
<noscript><link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.fileupload-ui-noscript.css"></noscript>



<!--[if IE 7]>         
<link href="/Eng/Content/common.css" rel="stylesheet"> 
<![endif]-->
<!--[if lt IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<script src="/Scripts/js/modernizr-2.6.2.js"></script>

<![endif]-->
<!-- ëª¨ë°ì¼ ì£¼ìíìì¤ ê°ì¶ê¸° -->
<script type="text/javascript">
	if (window.addEventListener) {
		window.addEventListener('load', function() {
			setTimeout(scrollTo, 0, 0, 1);
		}, false);
	}
</script>
<script type="text/javascript">
    var csrfParameter = '${_csrf.parameterName}';
    var csrfToken = '${_csrf.token}';
</script>
<!-- <script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- <script
  src="https://code.jquery.com/jquery-2.2.4.min.js"
  integrity="sha256-BbhdlvQf/xTY9gja0Dq3HiwQF8LaCRTXxZKRutelT44="
  crossorigin="anonymous"></script> -->
<%-- <script src="${pageContext.request.contextPath}/js/jquery-1.10.2.min.js"></script> --%>

<%-- <script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script> --%>

<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>

<script
	src="${pageContext.request.contextPath}/js/jquery.dotdotdot.min.js"></script>

<script
	src="${pageContext.request.contextPath}/js/easyResponsiveTabs.js"></script>

<script
	src="${pageContext.request.contextPath}/js/jcarousellite_1.0.1.min.js"></script>

<script src="${pageContext.request.contextPath}/js/ui.js"></script>

<script src="${pageContext.request.contextPath}/js/otf.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>


<meta property="og:type" content="website" />
<script src="${pageContext.request.contextPath}/js/common.js"></script>



<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', '//www.google-analytics.com/analytics.js',
			'ga');

	ga('create', 'UA-67423294-1', 'auto');
	ga('send', 'pageview');
</script>

</head>
<body>
<sec:csrfMetaTags />
	<!-- Facebook -->
	<div id="fb-root"></div>
	<script>
		(function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0];
			if (d.getElementById(id))
				return;
			js = d.createElement(s);
			js.id = id;
			js.src = "//connect.facebook.net/en_US/all.js#xfbml=1";
			fjs.parentNode.insertBefore(js, fjs);
		}(document, 'script', 'facebook-jssdk'));
	</script>
	<!-- //Facebook -->
	<!-- Google+ -->
	<script type="text/javascript">
		(function() {
			var po = document.createElement('script');
			po.type = 'text/javascript';
			po.async = true;
			po.src = 'https://apis.google.com/js/plusone.js';
			var s = document.getElementsByTagName('script')[0];
			s.parentNode.insertBefore(po, s);
		})();
	</script>
	<!-- //Google+ -->
	<!-- Twitter -->
	<script>
		!function(d, s, id) {
			var js, fjs = d.getElementsByTagName(s)[0], p = /^http:/
					.test(d.location) ? 'http' : 'https';
			if (!d.getElementById(id)) {
				js = d.createElement(s);
				js.id = id;
				js.src = p + '://platform.twitter.com/widgets.js';
				fjs.parentNode.insertBefore(js, fjs);
			}
		}(document, 'script', 'twitter-wjs');
	</script>
	<!-- //Twitter -->
	<!-- skip navigation -->
	<div id="skip">
		<dl>
			<dt class="blind">direct menu</dt>
			<dd>
				<a href="#nav">go to the menu</a>
			</dd>
			<dd>
				<a href="#main">go to the main contents</a>
			</dd>
		</dl>
	</div>
	<!-- //skip navigation -->
	<div id="wrap">
		<!--careers header-->

		<!--  S : header-->
		<header>
			<h1 class="logo">
				<a href="#">HVCC Logo</a>
			</h1>

			<!-- <div class="util_menu">
			<a href="/En/Main/Careers">Careers</a>
			<a href="http://www.hanonsystems.com/" class="last">Korean</a>
			<a href="/Kr/" class="last">Korean</a>
		</div> -->


			<nav id="nav">
				<ul class="gnb depth1">
					<form method="POST" enctype="multipart/form-data" id="fileinfo" name="fileinfo"
						action="uploadStocksFile">
						<div class="row">							
							
								<input type="file" id="uploadFileBtn" 
								name="uploadFile" class="pull-right" />
						</div>

					</form>
    
					<!-- 				<li class="m6 "><a href="/En/Suppliers" class="depth1_m current">SUPPLIERS<span class="icon_m_open"></span></a> -->
					<!-- 					<ul class="depth2"> -->
					<!-- 						<li class=""><a href="/En/Suppliers">Supplier Partnership</a></li> -->
					<!-- 					</ul> -->
					<!-- 				</li> -->


				</ul>
			</nav>

		</header>
		<!--  E : header-->

		<!--  S : main-->
		<div id="main">



			<section class="main_banner">
				<article class="main_view">
					<div class="flexslider">
						<ul class="slides">
							<li class="slide01"><a href="#"><img
									src="${pageContext.request.contextPath}/images/main_banner4.jpg"
									alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
									<div class="main_view_txt">
										<h2>
											Automotive Thermal Energy<br />Management Solutions
										</h2>
										<p>
											We have a differentiated solution<br />around system
											integration
										</p>
									</div> </a></li>
							<li class="slide02"><a href="#"><img
									src="${pageContext.request.contextPath}/images/main_banner1.jpg"
									alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
									<div class="main_view_txt">
										<h2>Deep R&D Expertise</h2>
										<p>
											Is one of the critical factors that allows
											<!-- 150721 ì­ì HVCC-->
											to deliver Innovative climate control solutions to vehicle
											manufactures.
										</p>
									</div> </a></li>
							<li class="slide03"><a href="#"><img
									src="${pageContext.request.contextPath}/images/main_banner3.jpg"
									alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
									<div class="main_view_txt">
										<h2>Eco-Friendly Products</h2>
										<p>
											We seek to deliver eco-friendly solutions <br>that
											benefit customers and communities <br>around the world
										</p>
									</div> </a></li>
							<!-- 20140902 ì­ì 
						<li class="slide03"><a href="/En/Company/Way"><img src="/Eng/Images/main/main_banner2.jpg" alt="Create a Happy Nature. A New Wind is Blowing in Climate Control. We are your neighbor. We are a corporate citizen." />
						<div class="main_view_txt">
							<h2>One Global Vision for<br>Future Growth</h2>
							<p>People, customers and technology - our core values <br />that underpin the HVCC Way and how we conduct <br />business </p>
						</div>
						</a></li>-->
						</ul>
					</div>
				</article>
			</section>

			<script type="text/javascript">
				$("#uploadFileBtn").on("change", function(e) {
 		//		function fileUpload(e) {
		//			 event.preventDefault();
		
		 formdata = new FormData();
    if($(this).prop('files').length > 0)
    {
    	
    
        file =$(this).prop('files')[0];
        console.log('.prop files length > 0',file);
        formdata.append("file", file);
    }
					
				//	 var fileSelect = $(this).val();
				//	 console.log('on change:: '+fileSelect);
					// console.log('on e files:: ' +JSON.stringify(e.target.files[0]);
					// console.log('on e:: ' +JSON.stringify(e.target));
					// $('#uploadFile').val(e.target.files);
					
/* 					var form = document.forms[0];
    var formData = new FormData(form); */
    
					/*  var fd = new FormData($('form')[0]);
					 console.log('fd ::',e) */
				
					$.ajax({
						url : '${pageContext.request.contextPath}/uploadStocksFile',
						type : 'POST',
						data : formdata,						
						processData : false, // tell jQuery not to process the data
						contentType : false, // tell jQuery not to set contentType
						 enctype: 'multipart/form-data',
						success : function(data) {
						
						console.log(data);
						var jsonVal = JSON.parse(data);
							console.log(jsonVal.files[0].newFilename);
					//		 window.location.href='${pageContext.request.contextPath}/folder/'+jsonVal.files[0].newFilename;
							 window.location.href='https://s3.us-east-2.amazonaws.com/elasticbeanstalk-us-east-2-968470451838/'+jsonVal.files[0].newFilename;
						//	location. reload(true);
						//	alert(data);
						}
					});
				}
 				);
			</script>

			<script type="text/javascript"
				src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
			<script type="text/javascript">
				// ì¿ í¤ ìì±  
				function setCookie(cName, cValue, cDay) {
					var expire = new Date();
					expire.setDate(expire.getDate() + cDay);
					cookies = cName + '=' + escape(cValue) + '; path=/ '; // íê¸ ê¹¨ì§ì ë§ê¸°ìí´ escape(cValue)ë¥¼ í©ëë¤.
					if (typeof cDay != 'undefined')
						cookies += ';expires=' + expire.toGMTString() + ';';
					document.cookie = cookies;
				}

				// ì¿ í¤ ê°ì ¸ì¤ê¸°
				function getCookie(cName) {
					cName = cName + '=';
					var cookieData = document.cookie;
					var start = cookieData.indexOf(cName);
					var cValue = '';
					if (start != -1) {
						start += cName.length;
						var end = cookieData.indexOf(';', start);
						if (end == -1)
							end = cookieData.length;
						cValue = cookieData.substring(start, end);
					}
					return unescape(cValue);
				}

				/*function jsPopup(){
				 if($.browser.msie==true){
				 if($.browser.version <= 7.0){
				 var popup = window.open('/En/Main/PopupTemp','pop','width=400,height=2567')
				 popup.focus();
				 }
				 }
				 }*/

				/* s:20160923 ê²ì
				 function jsPopup(){
				 var popup = window.open('/En/Main/PopupTemp','pop','width=400,height=256, left=0,top=50')
				 popup.focus();
				 }

				 var isShow = getCookie('popuphidden02')=='true'?true:false;
				 if (!isShow){
				 jsPopup();
				 }*/

				/* s:20161011 ì­ì 
				 function jsPopup2(){
				 var popup2 = window.open('/En/Main/PopupTemp02','pop2','width=400,height=256,left=0,top=50')
				 popup2.focus();
				 }

				 var isShow = getCookie('popuphidden')=='true'?true:false;
				 if (!isShow){
				 jsPopup2();
				 }*/
			</script>

		</div>
		<!--  E : main-->

		<!--  S : footer-->
		<footer>
			<div class="copyright">COPYRIGHT&copy;2018 Hanon Systems ALL
				RIGHTS RESERVED.</div>
			<nav>
				<a href="#">Sitemap</a> <a href="#">Privacy Policy</a> <a href="#">Contact
					Us</a> <a href="#" class="last copy_Ethics">Ethics and Integrity</a>
			</nav>
			<!--<div class="sns">
			<a href="#"><img src="/Eng/Images/facebook.png" alt="facebook"></a>
			<a href="#"><img src="/Eng/Images/twitter.png" alt="twitter"></a>
			<a href="#" class="last"><img src="/Eng/Images/google.png" alt="google+"></a>
		</div>-->
			<div class="career_top">
				<a href="#">Careers</a> <a href="#" class="last">TOP â²</a>
			</div>
		</footer>
		<!--  E : footer-->

	</div>
	
	
</body>
</html>