<?php
    function error($msg){
        $response = [];
        $response['success'] = FALSE;
        $response['message'] = $msg;
        return json_encode($response);
    }

    session_start();
    $accessToken = isset($_SESSION['my_access_token_accessToken']) ? $_SESSION['my_access_token_accessToken'] : '';
//---------
  //  echo $accessToken;

    if ($accessToken == ""){
        die(error('Error: Invalid access token'));
    }

    $URL = "https://api.github.com/user?access_token=$accessToken";
    $authHeader = "Authorization: token " . $accessToken;
    $userAgentHeader = "User-Agent: authorizationGitHub";
//---------
//    echo $authHeader;
//    echo "<br />";
//    echo $URL;

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $URL);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
    curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, false);
    curl_setopt($ch, CURLOPT_HTTPHEADER,array('Accept: application/json', $authHeader, $userAgentHeader));
    $response = curl_exec($ch);

  //  echo $response;
  //  print_r($response);

    curl_close($ch);
    $data = json_decode($response,true);
    $json_string = json_encode($data);

    $_SESSION['payload'] = $data;
    file_put_contents('apis.json', $json_string);
?>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>dashboard</title>
</head>
<body>
<div>
    <?php var_dump($_SESSION['payload']) ?>

</div>

</body>
</html>



