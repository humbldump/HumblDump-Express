<?php
require_once $_SERVER["DOCUMENT_ROOT"]."/scriptler/mysql/mysql.php";
require_once("DataClass.php");
try {
    $test = new HumblDump(@$_REQUEST['method']);
    print_r(json_encode($test->DataArray));
} catch (Exception $e) {
    $array = array(
        'durum' => false,
        'body' => $e->getMessage()
    );
    print_r(json_encode($array));
}

