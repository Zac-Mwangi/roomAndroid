 
<?php
try{
$host="mysql:host=localhost;dbname=androidroom";
$user_name="root";
$user_password="";
$dbh=new PDO($host,$user_name,$user_password);
date_default_timezone_set('Africa/Nairobi');
}
 
catch(Exception $e){
exit("Connection Error".$e->getMessage());
}
$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION); 
?>
 