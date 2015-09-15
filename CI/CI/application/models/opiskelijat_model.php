<?php 
class Opiskelijat_model extends CI_MODEL
{
	function __construct()
	{

	parent::__construct();

	$this->load->database("rekisteri");
	}
	
	public function get_all_users()
	{
	 $query = $this->db->get('opiskelijat');	 
	 return $query->result();
	}
        
        public function insert_users_to_db($data)
        {

        return $this->db->insert('opiskelijat', $data);

        }
        //edit tiedot
        public function update_info($data,$id)
        {

        $this->db->where('opiskelijat.id',$id);
        return $this->db->update('opiskelijat', $data);

        }
        public function delete_a_user($id)
        {

        $this->db->where('opiskelijat.id',$id);
        return $this->db->delete('opiskelijat');

        }
    
        
        
}
?>