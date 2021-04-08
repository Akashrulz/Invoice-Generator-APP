<?php  
 $db_name = "record";  
 $mysql_user = "root";  
 $mysql_pass = "";  
 $server_name = "localhost";  
 $con = mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name); 
if(!$con)
{
echo "connection error".mysqli_connect_error();
}
else
{
echo "connection success";
}
?>  
