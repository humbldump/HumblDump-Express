<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

class HumblDump
{
    private $mysql;
    public $DataArray = array();

    public function __construct($method = null) {

        if (method_exists($this,$method)) {
            $this->mysql = new MysqliDb ();//mysql connection info
            $this->$method();
        }
        else{
            $this::Hata("Fonksiyon bulunamadı!",1);
        }
    }   

    public function GetAdminPass($val = null)
    {
        $padd = $this->mysql->where("id", 1)->get("AdminPass",1);
        if ($padd[0]['pass']) {
            $this->DataArray['durum'] = true;
            $this->DataArray['body'] = $padd[0]['pass'];
        }
        else{
            $this::Hata("Şifre Alınamadı!",2);
        }
        
    }

    private function GetCustomCargo(){
        if (@$_REQUEST['q'] == null) $this::Hata("Query Boş!",3);

        $this->mysql->where('id', $_REQUEST['q']);
        $data = $this->mysql->get('CargoData', 1);

        if(count($data) > 0){
            $this->DataArray['durum'] = true;
            $this->DataArray['body'] = $data; 
        }
        else{
            $this::Hata("Couldn't find that shipment!!",8);
        }
    }

    private function CreateCargo(){
        if (@$_REQUEST['q'] == null) $this::Hata("Query Boş!",3);

        $data = json_decode(urldecode($_REQUEST['q']),true);

        $cargodata = Array (

            'sender' => $data['sender'],
            'receiver' => $data['receiver'],
            'Cargo_From' => $data['Cargo_From'],
            'Cargo_To' => $data['Cargo_To'],
            'Cargo_Weight' => $data['Cargo_Weight'],
            'Cargo_Type' => $data['Cargo_Type'],
            'Date' => $data['Date']
        );

        $id = $this->mysql->insert("CargoData",$cargodata);

        if ($id) {
            $this->DataArray['durum'] = true;
            $this->DataArray['body'] = $id;
        }
        else{
            $this::Hata($this->mysql->getLastError(),4);
        }
    }

    private function ChangeCargo(){
        if (@$_REQUEST['q'] == null) $this::Hata("Query Boş!",3);

        $data = json_decode(urldecode($_REQUEST['q']),true);
        $cargodata = Array (

            'sender' => $data['sender'],
            'receiver' => $data['receiver'],
            'Cargo_From' => $data['Cargo_From'],
            'Cargo_To' => $data['Cargo_To'],
            'Cargo_Weight' => $data['Cargo_Weight'],
            'Cargo_Type' => $data['Cargo_Type'],
            'Date' => $data['Date']
        );

        $this->mysql->where('id', $data['id']);

        if($this->mysql->update("CargoData", $cargodata)){
            $this->DataArray['durum'] = true;
            $this->DataArray['body'] = "ok";
        }
        else{
            $this::Hata($this->mysql->getLastError(),4);
        }
    }

    private function GetLastCargo(){
        $this->mysql->orderBy("id","desc");
        $padd = $this->mysql->get("CargoData",20);
        $this->DataArray['durum'] = true;
        $this->DataArray['body'] = array_reverse($padd);
    }

    private function RemoveCargo(){
        if (@$_REQUEST['q'] == null) $this::Hata("Query Boş!",3);


        $this->mysql->where("id", urldecode($_REQUEST['q']));

        if($this->mysql->has('CargoData')){
            
            $this->mysql->where("id", urldecode($_REQUEST['q']));
            if($this->mysql->delete('CargoData')){
                $this->DataArray['durum'] = true;
                $this->DataArray['body'] = "Deleted :D";
            }
            else{
                $this::Hata($this->mysql->getLastError(),5);
            }
        }
        else{
            $this::Hata("Bu kargo bulunamadı!",6);
        }
        
    }
    static function Hata($code = 1, $hata = null)
    {
        throw new Exception($code,$hata);
    }

}
