<?php
$json_string = file_get_contents('apis.json');

$data = json_decode($json_string, true);

session_start();
$accessToken = isset($_SESSION['my_access_token_accessToken']) ? $_SESSION['my_access_token_accessToken'] : '';
//---------
//  echo $accessToken;

if ($accessToken == ""){
    die(error('Error: Invalid access token'));
}

//$URL = "https://api.github.com/repos/XiyuZhang/Revealing-unusual-events-in-GitHub-repositories/git/refs";
$URL = "https://api.github.com/user/repos";
$authHeader = "Authorization: token " . $accessToken;
$userAgentHeader = "User-Agent: authorizationGitHub";

$ch = curl_init();
curl_setopt($ch, CURLOPT_URL, $URL);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, false);
curl_setopt($ch, CURLOPT_HTTPHEADER,array('Accept: application/json', $authHeader, $userAgentHeader));
$response = curl_exec($ch);

$data = json_decode($response);
var_dump($data);


?>