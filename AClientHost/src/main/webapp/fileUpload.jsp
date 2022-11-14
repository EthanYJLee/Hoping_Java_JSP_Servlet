<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.io.*"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>


<%

	request.setCharacterEncoding("utf-8");
	String realFolder = "";

	String saveFolder = "images"; // out폴더에 fileSave 폴더 생성
	String encType = "utf-8";
	int maxSize = 5*1024*1024; // 최대 업로드 5mb

	ServletContext context = request.getServletContext();
	//실제로 서버에 저장되는 path 
	realFolder = application.getRealPath(saveFolder);
	
	/* String filePath = application.getRealPath(fileName); */
	
	out.println("the realpath is: " + realFolder + "<br>");
	
	//cos.jar라이브러리 클래스를 가지고 실제 파일을 업로드하는 과정
	try {
		// defaultFileRenamePolicy 처리는 중복된 이름이 존재할 경우 처리할 때
    	//request, 파일저장경로, 용량, 인코딩타입, 중복파일명에 대한 정책
	    MultipartRequest multi = null;

	    multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());

	  //전송한 전체 파일이름들을 가져온다. 
	    Enumeration params = multi.getParameterNames();

	    while(params.hasMoreElements()) {
	        String name = (String) params.nextElement();
	        String value = multi.getParameter(name);
	        out.println(name + " = " + value + "<br>");
	    }

	    out.println("-------------------<br>");

	    Enumeration files = multi.getFileNames();

	    while(files.hasMoreElements()) {
	    	//파일명 중복이 발생했을 때 정책에 의해 뒤에 1,2,3 처럼 숫자가 붙어 고유 파일명을 생성한다.
	    	//이때 생성된 이름을 FilesystemName이라고 하여 그 이름 정보를 가져온다. (중복처리)
	        String name = (String)files.nextElement();
	        String filename = multi.getFilesystemName(name);
	      //실제 파일 이름을 가져온다. 
	        String original = multi.getOriginalFileName(name);
	        String type = multi.getContentType(name);
	        File file = multi.getFile(name);


	        out.println("파라미터 이름" + name + "<br>");
	        out.println("실제 파일 이름" + original + "<br>");
	        out.println("저장된 파일 이름" + filename + "<br>");
	        out.println("파일 타입 이름" + type + "<br>");

		    if(file!= null) {
		        out.println("크기: " + file.length() + "<br>");
		    }
		    
		    request.setAttribute("FILENAME", filename);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("fileUp.do");
		    dispatcher.forward(request, response);
		    
	    }
	    

	}catch (IOException ioe) {
		System.out.println(ioe);
	} catch (Exception ex) {
		System.out.println(ex);
	}
%>