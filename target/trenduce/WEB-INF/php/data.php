<?php
$requested_page = $_POST['page_num'];
$set_limit = (($requested_page - 1) * 12) . ",12";
$html = '';
$url = "http://ec2-54-69-50-109.us-west-2.compute.amazonaws.com:9000/trenduce/styles?pageNumber=".$requested_page;
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
// $image = $json_dec[0]['image'];
$images = array();
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
foreach ($images as $image) {
	$html .= "<div class='col-lg-4'>";
	$html .= "<img id='modal_trigger' href='#modal' 
			class='img-circle'
			src='" . $image. "' 
			alt='Generic placeholder image'
			style='width:140px; height:140px;'>";
	$html .= "<p>Donec sed odio dui. Etiam porta sem malesuada magna mollis euismod. Nullam id dolor id nibh ultricies vehicula ut id elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros. Praesent commodo cursus magna.</p>";
	$html .= "<p><a class='btn btn-default' href='#' role='button'>View details</a></p>";
	$html .= "</div>";
}
echo $html;
exit;
?>
