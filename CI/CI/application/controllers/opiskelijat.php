<?php

if ( ! defined('BASEPATH')) exit('No direct script access allowed');

class Opiskelijat extends CI_Controller 
{

	function __construct()
	{

	parent::__construct();

	
	$this->load->database('rekisteri');
	$this->load->helper('url');
	$this->load->model('opiskelijat_model');

	}
        
        //lisäys formi
        public function add_form()
        {
            $this->load->view('insert');
        }
        
        public function edit_form()
        {
            $this->load->view('edit');
        }
        
                
        //Näyttää kaikki kannan tiedot
	public function index()
	{

	$data['user_list'] = $this->opiskelijat_model->get_all_users();

	$this->load->view('show_opiskelijat', $data);

	}
        
        //lisää uuden käyttäjän
        public function insert_new_user()
        {
        $udata['snimi'] = $this->input->post('snimi');
        $udata['enimi'] = $this->input->post('enimi');
        $udata['onumero'] = $this->input->post('onumero');
        $udata['opisteet'] = $this->input->post('opisteet');

        $res = $this->opiskelijat_model->insert_users_to_db($udata);

        if($res){

        header('location:'.base_url()."index.php/opiskelijat/".$this->index());
        }
        }
        public function update()
        {
            $mdata['snimi']=$_POST['snimi'];
            $mdata['enimi']=$_POST['enimi'];
            $mdata['onumero']=$_POST['onumero'];
            $mdata['opisteet']=$_POST['opisteet'];

            $res=$this->opiskelijat_model->update_info($mdata, $_POST['id']);

            if($res)
            {
                header('location:'.base_url()."index.php/opiskelijat/".$this->index());
            }
        }
        
        public function delete_user($id)
        {                 
            $this->opiskelijat_model->delete_a_user($id);
            $this->index();            
        }
        
        public function edit_user($id)
        {          
            $this->opiskelijat_model->update_info($id);
        }

}
