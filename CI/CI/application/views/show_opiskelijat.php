<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>CI CRUD Opiskelijat</title>

<script type="text/javascript">
    
    function show_confirm(act,gotoid)
    {
        if(act === 'edit')
        {
            var r = confirm("Do you really want to edit?"); 
            act = 'edit_form';
        }
        else if(act === 'delete')
        {
            var r = confirm("Do you really want to delete?");  
            act = 'delete_user(' + gotoid + ')';
            
        }
        else
        {
            console.log("error");    
        }
        if(r === true)
        {
            window.location="<?php echo base_url();?>index.php/opiskelijat/"+act;                
        }
        
    }
</script>

</head>

<body>

<h2> CI CRUD Application opiskelijat </h2>

<table width="600" border="1" cellpadding="5">

<tr>
<th scope="col">Id</th>
<th scope="col">Sukunimi</th>
<th scope="col">Etunimi</th>
<th scope="col">Otunnus</th>
<th scope="col">Opisteet</th>
</tr>

<?php foreach ($user_list as $u_key){ ?>

<tr>
<td><?php echo $u_key->id; ?></td>
<td><?php echo $u_key->snimi; ?></td>
<td><?php echo $u_key->enimi; ?></td>
<td><?php echo $u_key->onumero; ?></td>
<td><?php echo $u_key->opisteet; ?></td>
<td width="40" align="left" ><a href="#"
onClick="show_confirm('edit',<?php echo $u_key->id?>);">Edit</a></td>

<td width="40" align="left" ><a href="#"
onClick="show_confirm('delete',<?php echo $u_key->id?>);">Delete</a></td>

</tr>

<?php }?>

<tr>
<td colspan="7" align="right"> <a href="<?php echo base_url();?>index.php/opiskelijat/add_form">Insert New User</a></td>
</tr>

</table>

</body>

</html>
