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
$requested_page = $_POST['page_num'];
$set_limit = (($requested_page - 1) * 12) . ",12";
//$con = mysql_connect("localhost", "root", "test");
//mysql_select_db("InnoDB");
//$result = mysql_query("select  * from scroll_images order by id asc limit $set_limit");
$html = '';
//while ($row = mysql_fetch_array($result)) {
foreach ($images as $image) {
    $html .= "<div><img src='" . $image . "' /></div>";
}
//}
echo $html;
exit;
?>
