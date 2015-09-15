<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">

<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<title>CI Insert Form</title>

</head>

<body>
<!--Lähettää tiedot post metodilla modeliin, opiskelijat_model -->
<form method="post" action="<?php echo base_url();?>index.php/opiskelijat/update">

<table width="400" border="0" cellpadding="5">    
    
<tr>
<th width="213" align="right" scope="row">ID:</th>
<td width="161"><input type="text" name="id" size="20" /></td>
</tr>

<tr>
<th width="213" align="right" scope="row">Sukunimi:</th>
<td width="161"><input type="text" name="snimi" size="20" /></td>
</tr>

<tr>
<th align="right" scope="row">Etunimi:</th>
<td><input type="text" name="enimi" size="20" /></td>
</tr>

<tr>
<th align="right" scope="row">Otunnus:</th>
<td><input type="text" name="onumero" size="20" /></td>
</tr>

<tr>
<th align="right" scope="row">Opisteet:</th>
<td><input type="text" name="opisteet" size="20" /></td>
</tr>

<tr>
<th align="right" scope="row">&nbsp;</th>
<td><input type="submit" name="submit" value="Muokkaa" /></td>
</tr>
</table>
</form>
</body>
</html>