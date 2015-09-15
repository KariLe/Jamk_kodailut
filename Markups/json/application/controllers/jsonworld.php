<?php
	
//The Controller
	
class Jsonworld extends CI_Controller{
	
	function __construct() {
        
        parent::__construct();  
      
        //loading the model
        $this->load->model('json_model');
         
	}   
	
	function index()
	{
               
        //Create $data -array for the view
		$data['result'] = $this->json_model->getData();
		$data['page_title'] = "CI Hello World App!";

		//loading the view
		$this->load->view('json_view',$data);
	}
        //Tehtävä 7
        function jsonina()
        {
            //pistetään json muodoksi
            //$data = $this->output->get_output();

            $data = $this->json_model->getData();
            $jdata = array('json' => $data);

            //$this->load->view('json_view',$data);
            $this->output
                    ->set_content_type('application/json')
                    ->set_output(json_encode($jdata));
                    
        }
}
?>