<?php

include 'init.php';
 $con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name); 
$email = $_POST['login_name'];
$password= $_POST['login_pass'];

$Sql_Query = "select * from user_info where user_email= '$email' and user_pass = '$password' ";

$check = mysqli_fetch_array(mysqli_query($con,$Sql_Query));

if(isset($check)){

echo "Data Matched";
}
else{
echo "Invalid Username or Password Please Try Again !";
}

mysqli_close($con);

?>
