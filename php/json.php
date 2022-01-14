<?php


$json = '[{"description":"lewi ","id":6,"priority":9,"title":"lewy"},
	{"description":"Description3","id":3,"priority":3,"title":"Title3"},
	{"description":"Description3","id":3,"priority":3,"title":"Title4"},
	{"description":"Description3","id":3,"priority":3,"title":"Title5"}]';

//or use from file
//$json = file_get_contents('results.json');

$someArray = json_decode($json, true);

foreach ($someArray as $key => $value) {

	$description = $value["description"];
	$id = $value["id"];
	$title = $value["title"];

    //echo $value["description"] . ", " . $value["id"] . ", " . $value["title"] . "<br>";

    echo $title;
    echo "<br>";
}

?>