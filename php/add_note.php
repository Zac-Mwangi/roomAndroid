<?php

$output=array();
include ('config.php');

// Takes raw data from the request
$json = file_get_contents('php://input');


//$json = '[{"description":"lewi ","id":6,"priority":9,"title":"lewy"},
	// {"description":"Description3","id":3,"priority":3,"title":"Title3"},
	// {"description":"Description3","id":3,"priority":3,"title":"Title4"},
	// {"description":"Description3","id":3,"priority":3,"title":"Title5"}]';


$json = $_POST['input'];

// Converts it into a PHP object
$data = json_decode($json,TRUE);

foreach ($data as $key => $value) {

	$description = $value["description"];
	$id = $value["id"];
	$title = $value["title"];
	$priority = $value["priority"];

   	$conn=$dbh->prepare('INSERT INTO `notes_table`(`title`, `description`, `priority`, `room_id`) VALUES (?,?,?,?)');
	$conn->bindParam(1,$title);
	$conn->bindParam(2,$description);
	$conn->bindParam(3,$priority);
	$conn->bindParam(4,$id);
	$conn->execute();
	if($conn->rowCount() == 0){
		$output['error'] = true;
		$output['message'] = "failed, Please try again";
	}else{
		$output['error'] = false;
		$output['message'] = "Saved Successfull";
	}
}
	echo json_encode($output);
?>