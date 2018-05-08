<?php

$connect = mysqli_connect('localhost:3306', 'root', '','unusualevents');

$filename = "apis.json";
$data = file_get_contents($filename);
$array = json_decode($data, true);

//print_r($data);
foreach ($array as $row => $val) {
        $sql = "insert into account(user_id,username) values('".$row["id"]."', '".$row["login"]."')";
        mysqli_query($connect, $sql);

}
echo "user info inserted";
?>
























