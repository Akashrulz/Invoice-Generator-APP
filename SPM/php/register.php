 <?php  
 require "init.php";  

  
 $user_name = $_POST["user_name"];  
 $user_pass = $_POST["user_pass"]; 
$user_email = $_POST["user_email"]; 
$user_address = $_POST["user_address"]; 
$user_mobile = $_POST["user_mobile"]; 
 
 $sql_query = "insert into user_info values('$user_name','$user_pass','$user_email','$user_address','$user_mobile');";  
  
if(mysqli_query($con,$sql_query))
{
echo "connection success";
}
else
{
echo "no"; 
}

 ?>  
