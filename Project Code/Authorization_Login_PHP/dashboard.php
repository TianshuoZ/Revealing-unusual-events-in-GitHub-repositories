<?php

    $code = $_GET['code'];

    if ($code == ""){
        header('Location: http://localhost:9000/');  ///dashboard.php     ---> chongxindenglu.php
        exit;
    }

    $CLIENT_ID = "780beb2416884df325d1";
    $CLIENT_SECRET = "c125884f9f1c204ccbddd55d3f39b55e8ead72bd";
    $URL = "https://github.com/login/oauth/access_token";


    $postParams = array(
        "client_id" => $CLIENT_ID,
        "client_secret" => $CLIENT_SECRET,
        "code" => $code
    );
    //print_r($postParams);

    $ch = curl_init();
    curl_setopt($ch, CURLOPT_URL, $URL);
    curl_setopt($ch, CURLOPT_POST, 1);
    curl_setopt($ch, CURLOPT_POSTFIELDS, $postParams);
    curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
    curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, false);
    curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
    curl_setopt($ch, CURLOPT_HTTPHEADER,array('Accept: application/json'));
    $response = curl_exec($ch);
    curl_close($ch);

    var_dump($response);

    $data = json_decode($response);
    var_dump($data);
    echo'<br/>';

    if ($data->access_token != ""){
        session_start();
        $_SESSION['my_access_token_accessToken'] = $data->access_token;
        header('Location: http://localhost:9000/api/user.php');
        exit;
    }

    //var_dump($data);

    echo $data->error_description;
?>





















