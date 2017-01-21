<%-- 
    Document   : p_signup
    Created on : Jan 11, 2017, 12:35:23 PM
    Author     : SAHEB GUCHHAIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>From </title>
<style type="text/css">
            body{
                background-image: url(Drug.jpg);
                background-size: cover;
            } 
            .log input[type="submit"]{
                width: 120px;
                height: 30px;
                border: 0;
                border-radius: 5px;
                -webkit-border-radius: 5px;
                background-color: skyblue;
                font-weight: bolder;
                color: navy;
            }
            .log input[type="reset"]{
                width: 100px;
                height: 30px;
                border: 0;
                border-radius: 5px;
                -webkit-border-radius: 5px;
                background-color: skyblue;
                font-weight: bolder;
            }
            
</style>            
</head>
<body>
    <div class="log">
<form method="post" action="p_signup"> 

<table style="width:100%; height:100%" cellpadding="0" cellspacing="0" >
<tr>
<td style="width: 30%; height: 50px;" ></td>
<td style="width: 40%; height: 50px;" bgcolor="#808080">
    
    <table style= "width:100%; height:100%; border:0">
<tr>
    <td><center><h2><font color="yellow">Pharmacist Registration Form</font></h2></center></td>
 </tr>
<tr>
    <td style="width: 100%; height: 5%;"><center><h3><b>Account Information</b></h3></center></td>
</tr>
<tr>
<td style="width: 100%; height: 95%;">
<table style="width:100%; height:100%">
    <font color="#4d0000"> Note:The fields marked with * are mandatory.</font>
<tr>
    <td>Login ID:<font color="red">*</font></td>
<td><input type="email" name="p1" placeholder="Enter your valid Email id" required ></td>

</tr>
<tr>
<td>Password:<font color="red">*</font></td>
<td><input type="password" name="p2" placeholder="Please enter your password"></td>
</tr>
<tr>
<td>Pharmacist Name:</td>
<td><input type="text" name="p3" placeholder="" required ></td>
</tr>
<tr>
<td>Email ID:<font color="red">*</font></td>
<td><input type="text" name="p4" placeholder="" required ></td>
</tr>
<tr>
<td>Mobile No:<font color="red">*</font></td>
<td><input type="text" name="p5" placeholder="Enter your mobile no." required ></td>
</tr>
<tr>
<td>Address:<font color="red">*</font></td>
<td><textarea rows="4" cols="25" name="p8"></textarea></td>
</tr>
<td>Security Question:<font color="red">*</font></td>
<td>
<select name="p9">
<option value="Null">Please Specify</option>
<option value="petname">What is your pet name?</option>
<option value="book">What is your favorite book? </option>
<option value="teacher">Who is your first Teacher?</option>
</select>
</td>
</tr>
<tr>
<td>Answer:<font color="red">*</font></td>
<td><input type="text" name="p10"></td>
</tr>
<hr>
<tr>
<td><input type="submit" value="Create Account"></td>
<td><input type="reset" value="Refresh"></td>
</tr>
</table>

</td>
</tr>
</table>
</td>
<td style="width: 30%; height: 50px;" ></td>
</tr>
</table>
</form>
    </div>        
</body>
</html>