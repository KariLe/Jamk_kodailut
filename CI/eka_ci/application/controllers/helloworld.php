<?php
	
//The Controller
	
class Helloworld extends CI_Controller{
	
	function __construct() {
	
        
        parent::__construct();
        //loading url-helper
		$this->load->helper('url');
        //loading the model
        $this->load->model('helloworld_model');
		//loading the calendar 
		$this->load->library('calendar');
         
	}   
	
	function index()
	{
		//generate the calendar
		$data['calendar'] = $this->calendar->generate();
		//generate the new page	
		$data['there'] = site_url('helloworld/another_page');
        //Create $data -array for the view
		$data['result'] = $this->helloworld_model->getData();
		$data['page_title'] = "CI Hello World App!";
		

		//loading the view
		$this->load->view('helloworld_view',$data);
	}
	
	function another_page()
	{
	//Create $data -array for the view
	$data['page_title'] = "CI Hello World App another page!";
		
	$data['text'] = "This is another page. It comes not from database, 
	only from controller!";
	//so that you can come back
	$data['back'] = site_url('helloworld/index');
		
	//loading the another view
	$this->load->view('helloworld_another_view',$data);
	}
	
}
?>