package core;

import java.io.*;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class core {

	@SuppressWarnings("deprecation")
	
	public static void main(String[] args) throws IOException {
		
		//Archivo de origen	
		File file = new File("JSP/index.jsp");
		//archivos destino:
		File newHtmlFile = new File("JSP/JSP/html5.jsp");
		File newJsFile = new File("JSP/JS/script.js");
		File newCssFile = new File("JSP/CSS/style.css");
		
		String archivoOrigen = FileUtils.readFileToString(file); // from commons io
		
		
		/*################ JSP IMPORTS ##############*/
		String JAVAIMPORTSO = "<%@";
		String JAVAIMPORTSC = "%>";
		
		String JAVAPUROO = "<% ";
		String JAVAPUROC = "%>";
		
		/*################ JAVASCRIPT CONTENT ##############*/
		
		
		/*################ HTML5 TAG ##############*/
		String DOCTYPEHTML5 = "<!DOCTYPE HTML>";
		
		String HTMLO = "<html>";
		String JSPINCLUDEO = "<jsp:include";
		String JSPINCLUDEC = "</jsp:include>";
		
		String HEADO ="<head>";
		String STYLEO ="<style";
		String STYLEC ="</style>";
		String HEADC ="</head>";
		
		//String META = "<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />";
		
//		String TITLEO = "<title>";
	//	String TITLEC = "</title>";
		
		String BODYO = "<body";
		String BODYC = "</body>";
		
		
		String HTMLC = "</html>";
		
		//FORMAT: 
		String sln = "\n";
		
		try{


		StringBuilder sb = new StringBuilder();
		StringBuilder sbjs = new StringBuilder();
		StringBuilder sbcss = new StringBuilder();
		

		//1° JSP IMPORTS:
		String JavaImports1 = StringUtils.substringBetween(archivoOrigen, JAVAIMPORTSO, JAVAIMPORTSC);
		String JavaImports1F =  JAVAIMPORTSO+JavaImports1+JAVAIMPORTSC;
		
		String JavaImports2 = StringUtils.substringBetween(archivoOrigen, JAVAPUROO, JAVAPUROC);
		String JavaImports2F =  JAVAPUROO+JavaImports2+JAVAPUROC;
		
		//2° JSP INCLUDE:
		String JspInclude 	= StringUtils.substringBetween(archivoOrigen, JSPINCLUDEO, JSPINCLUDEC);
		String JspIncludeF 	=  JSPINCLUDEO+JspInclude+JSPINCLUDEC;
		
		//3° HEAD: 
		String JspHead 	= StringUtils.substringBetween(archivoOrigen, HEADO, STYLEO);
		String JspHeadF 	=  HEADO+JspHead;
		
		String JspHead2 	= StringUtils.substringBetween(archivoOrigen, STYLEC, HEADC);
		String JspHead2F 	=  JspHead2+HEADC;
		
		//4° BODY: 
		String JspBody 	= StringUtils.substringBetween(archivoOrigen, BODYO, BODYC);
		String JspBodyF 	=  BODYO+JspBody+BODYC;
									
		//imports:
		sb.append(JavaImports1F+sln);
		sb.append(JavaImports2F+sln);
		
		//html5 tag:
		sb.append(DOCTYPEHTML5+sln);
		sb.append(HTMLO+sln);
		
		//jsp include:
		sb.append(JspIncludeF+sln);
		
		//Head:
		sb.append(JspHeadF+sln);
		//sb.append("<link href=\""+newCssFile.toString()+"\" rel=\"stylesheet\" type=\"text/css\">");
		
		sb.append(JspHead2F+sln);
		
		//Body:
		sb.append(JspBodyF+sln);
		
		sb.append(HTMLC+sln);
		
		//Obtenemos los Script: 
		String javaScript 	= StringUtils.substringBetween(archivoOrigen, "<SCRIPT language=\"JavaScript\">", "</SCRIPT>");
		String javaScriptF 	=  javaScript;
		
		String javaScript2 	= StringUtils.substringBetween(archivoOrigen, "<script>", "</script>");
		String javaScript2F 	=  javaScript2;
		
		sbjs.append(javaScriptF+sln);
		sbjs.append(javaScript2F+sln);
		
		//obtenemos los CSS
		String css 	= StringUtils.substringBetween(archivoOrigen, "<style type=\"text/css\">", "</style>");
		String cssF	=  css;
		
		sbcss.append(cssF);
		

		
	
		
		FileUtils.writeStringToFile(newHtmlFile, sb.toString());
		FileUtils.writeStringToFile(newJsFile, sbjs.toString());
		FileUtils.writeStringToFile(newCssFile, sbcss.toString());
		
		
				
		System.out.println("¡Transformación correcta!");
		
		}catch(Exception e)
		{
			   e.printStackTrace();
			//out.println(e);
			}

	}

}
