<?php
$url = "http://ec2-54-69-50-109.us-west-2.compute.amazonaws.com/trenduce/styles";
$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_FOLLOWLOCATION, 1);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
if(!empty($post)) {
	curl_setopt($ch, CURLOPT_POST, true);
	curl_setopt($ch, CURLOPT_POSTFIELDS, $post);
} 
$result = curl_exec($ch);
curl_close($ch);
$malformed_json = $result;
$s = str_replace("'", '"', $malformed_json);
$valid_json = preg_replace('/([{\[,])\s*([a-zA-Z0-9_]+?):/', '$1"$2":', $s);
$json_dec = json_decode($valid_json, true);
$images = array();
$texts = array();
$count = 0;
foreach($json_dec as $json) {
	$images[] = $json['image'];
}
switch (json_last_error()) {
	case JSON_ERROR_NONE:
		//echo ' - No errors';
		break;
	case JSON_ERROR_DEPTH:
		echo ' - Maximum stack depth exceeded';
		break;
	case JSON_ERROR_STATE_MISMATCH:
		echo ' - Underflow or the modes mismatch';
		break;
	case JSON_ERROR_CTRL_CHAR:
		echo ' - Unexpected control character found';
		break;
	case JSON_ERROR_SYNTAX:
		echo ' - Syntax error, malformed JSON';
		break;
	case JSON_ERROR_UTF8:
		echo ' - Malformed UTF-8 characters, possibly incorrectly encoded';
		break;
	default:
		echo ' - Unknown error';
		break;
}
$actual_row_count = count($images);
?>
<html lang='en'>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="ID=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Trenduce Engineering">
<link rel="icon" href="../../favicon.ico">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="../../assets/js/ie-emulation-modes-warning.js"></script>
<!-- Custom styles for this template -->
<link href="css/custom.css" rel="stylesheet">
<title>Trenduce</title>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.leanModal.min.js"></script>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<style>
.topcorner {
	position:absolute;
	top:10;
	right:50;
}
#result div{
border: 10px solid #EEEEEE;
float: left;
height: 300px;
margin: 20px;
outline: 1px solid #CFCFCF;
width: 300px;

}
#more{
background: none repeat scroll 0 0 #EEEEEE;
border: 1px solid #CFCFCF;
color: #000000;
display: none;
		 font-weight: bold;
left: 1100px;
padding: 5px;
position: fixed;
top: 100px;

}
#no-more{
background: none repeat scroll 0 0 #EEEEEE;
border: 1px solid #CFCFCF;
color: #000000;
display: none;
		 font-weight: bold;
left: 1100px;
padding: 5px;
position: fixed;
top: 100px;

}
#result{

}
</style>
<script type="text/javascript">
var page = 1;
$(window).scroll(function () {
	$('#more').hide();
	$('#no-more').hide();

	if($(window).scrollTop() + $(window).height() > $(document).height() - 200) {
		$('#more').css("top","400");
		$('#more').show();
	}
	if($(window).scrollTop() + $(window).height() == $(document).height()) {
		$('#more').hide();
		$('#no-more').hide();
		page++;
		var data = {
			page_num: page
		};
		var actual_count = "<?php echo $actual_row_count; ?>";
		if((page-1)* 12 > actual_count){
			$('#no-more').css("top","400");
			$('#no-more').show();
		}else{
			$.ajax({
				type: "POST",
				url: "data.php",
				data:data,
				success: function(res) {
					$("#result").append(res);
					console.log(res);
				}
			});
		}
	}
});
</script>
</head>
<body>
<div class="navbar-wrapper">
	<div class="container">
		<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
					<a class="navbar-bran" href="#">TRENDUCE</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<form class="navbar-form" role="search" style="margin-top: 105px">
					<input type="text" class="form-control" size="150" placeholder="Search...">
				</form>
			</div>
		</div>
	</div>
</div>
<div id="modal" class="popupContainer" style="display:none;">
	<header class="popupHeader">
		<span class="header_title">Login</span>
		<span class="modal_close"><i class="fa fa-times"></i></span>
	</header>
	<section class="popupBody">
		<!-- Social Login -->
		<div class="social_login">
			<div class="">
				<a href="#" class="social_box fb">
					<span class="icon"><i class="fa fa-facebook"></i></span>
					<span class="icon_title">Connect with Facebook</span>
				</a>
				<a href="#" class="social_box google">
					<span class="icon"><i class="fa fa-google-plus"></i></span>
					<span class="icon_title">Connect with Google</span>
				</a>
			</div>
			<div class="centeredText">
				<span>Or use your Email address</span>
			</div>
			<div class="action_btns">
				<div class="one_half"><a href="#" id="login_form" class="btn">Login</a></div>
				<div class="one_half last"><a href="#" id="register_form" class="btn">Sign up</a></div>
			</div>
		</div>
		<!-- Username & Password Login form -->
		<div class="user_login">
			<form>
				<label>Email / Username</label>
				<input type="text" />
				<br />
				<label>Password</label>
				<input type="password" />
				<br />
				<div class="checkbox">
					<input id="remember" type="checkbox" />
					<label for="remember">Remember me on this computer</label>
				</div>
				<div class="action_btns">
					<div class="one_half"><a href="#" class="btn back_btn"><i class="fa fa-angle-double-left"></i> Back</a></div>
					<div class="one_half last"><a href="#" class="btn btn_red">Login</a></div>
				</div>
			</form>
			<a href="#" class="forgot_password">Forgot password?</a>
		</div>
		<!-- Register Form -->
		<div class="user_register">
			<form>
				<label>Full Name</label>
				<input type="text" />
				<br />
				<label>Email Address</label>
				<input type="email" />
				<br />
				<label>Password</label>
				<input type="password" />
				<br />
				<div class="checkbox">
					<input id="send_updates" type="checkbox" />
					<label for="send_updates">Send me occasional email updates</label>
				</div>
				<div class="action_btns">
					<div class="one_half"><a href="#" class="btn back_btn"><i class="fa fa-angle-double-left"></i> Back</a></div>
					<div class="one_half last"><a href="#" class="btn btn_red">Register</a></div>
				</div>
			</form>
		</div>
	</section>
</div>
<div class="container" style="margin-top:200px">
<div class="row">
<?php
foreach ($images as $image) {
	echo "<div class='col-lg-4'>";
	echo "<img id='modal_trigger' href='#modal' 
			class='img-circle'
			src='" . $image. "' 
			alt='Generic placeholder image'
			style='width:140px; height:140px;'/>";
	echo "<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>";
	echo "<p><a class='btn btn-default' href='#' role='button'>View details</a></p>";
	echo "</div>";
}
?>
</div>
</div>
<script type="text/javascript">
$("#modal_trigger").leanModal({top:200, overlay:0.6, closeButton:".modal_close"});
$(function(){
	// Calling login form
	$("#login_form").click(function(){
		$(".social_login").hide();
		$(".user_login").show();
		return false;
	});

	// Callign Register form
	$("#register_form").click(function(){
		$(".social_login").hide();
		$(".user_register").show();
		$(".header_title").text('Register');
		return false;
	});

	// Going back to Social forms
	$(".back_btn").click(function(){
		$(".user_login").hide();
		$(".user_register").hide();
		$(".social_login").show();
		$(".header_title").text('Login');
		return false;
	});
});
</script>
</body>
</html>
