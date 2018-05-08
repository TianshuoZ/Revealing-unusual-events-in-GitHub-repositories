<?php
    session_start();
    $accessToken = isset($_SESSION['my_access_token_accessToken']) ? $_SESSION['my_access_token_accessToken'] : '';
?>



<html>
    <head>

    </head>
    <body>
        <?php
            echo '<p>access token:</p>';
            echo '<p><code>' . $accessToken . '</code></p>';
            echo '<br />';

            if ($accessToken != ""){
                echo '<p>Logged in!</p>';
            } else {
                echo '<p><a href="https://github.com/login/oauth/authorize?client_id=780beb2416884df325d1&redirect_url=http://localhost:9000/backend/signin/dashboard&scope=repo">Sign In with GitHub</a></p>';
            }
        ?>





    </body>
</html>
















