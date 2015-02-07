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
foreach($json_dec as $json) {
	$images[] = $json['image'];
}
// $image = $json_dec[0]['image'];
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
<title>Infinite Scroll</title>
<script src="jquery-1.7.2.js" type="text/javascript"></script>
<style>
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
<div id='more' >Loading More Content</div>
<div id='no-more' >No More Content</div>
<div id='result'>
<?php
//while ($row = mysql_fetch_array($result)) {
foreach ($images as $image) {
	echo "<div><img src='" . $image . "' height=400 width=300 /></div>";
}
//echo "<div><img src='".$image."' height=300 width=300 /></div>";
//}
?>
</div>


</body>
</html>

