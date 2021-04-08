 <?php  
 require "init1.php";  

  
 $r_name = $_POST["r_name"];  
 $r_address = $_POST["r_address"]; 
$r_total = $_POST["r_total"]; 
$r_date = $_POST["r_date"]; 
 
 
 $sql_query = "insert into record values('$r_name','$r_address','$r_total','$r_date');";  
  
if(mysqli_query($con,$sql_query))
{
echo "connection success";
}
else
{
echo "no"; 
}

 ?>  
