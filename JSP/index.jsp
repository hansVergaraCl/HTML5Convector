<%@ page language="java" import="java.util.*"  %>
<% 
	String desconexion = "";
	if(request.getParameter("Desconectado")==null){
		desconexion = "0";
	}else{
		desconexion = "1";
	}
	if(request.getParameter("session") != null){
	   if(Integer.parseInt(request.getParameter("session")) ==0){
	      session.setAttribute("Session_Conectado","null");
	   }
	}
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="menu_head.jsp"></jsp:include>
<head>
<title>Poder Judicial: Centro de Notificaciones</title>
<style type="text/css">
	
	#contenedor {
		margin: 10px auto auto auto;
		border: 1px solid #999999; 
		width:1024px;
	}
	
	#izquierda {
		/*			
		position: relative;	
		height:440px;
		width: 20%;
		background-color: #f1f3f5;
		float: left; 
		clear: both; 
		border: 1px solid #000;
		*/
		position:relative; float:left; width: 200px;		
		background-color: #f1f3f5;
	
	} 
	#derecha {
		/*		
		position: relative;	 
		left:0; 
		top:0;
		width: 200px; 
		float: left; 
		clear: both; 
		border: 1px solid #000;
		*/
		position:relative; float:left; width: 820px;		
		
	}
.logintxt{
	font-family:Arial;
	font-size:10px;
	foreground: #ddaaee;
	}	
th{
	background: #bdbdbd;
	font-size:12px;
	font-family:Arial;
	}	
	
.btnlogin{

	background: #bdbdbd;
	font-size:12px;
	font-family:Arial;

}	
	
</style>
<link href="css/master.css" rel="stylesheet" type="text/css" />
<link href="css/template.css" rel="stylesheet" type="text/css">
<link href="css/theme.css" rel="stylesheet" type="text/css">
<SCRIPT language="JavaScript" src="js/NuevoAjax.js"></SCRIPT>
<SCRIPT language="JavaScript" src="js/AjaxCallAll.js"></SCRIPT>
<SCRIPT language="JavaScript">
	function Ingreso(u,p){
		zxLoFnGCP('ajaxPages/object/showSelectSeg.jsp',u,p);		
	}
</SCRIPT>
</head>
<body onload="">
	<div id="contenedor">
		<div id="arriba" class="texto_titulos">
		  <a><img src="img/banner.png" alt="Text" align="middle" /></a> 
		</div>
		<div id="div_grilla"></div>
	</div>
</body>
<script>
var descon = <%out.print(desconexion);%>;

if(descon == 1){
	alert("Se ha desconectado por inactividad");
}

showListObjectL();


</script>
</html>
