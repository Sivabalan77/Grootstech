package Groot;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(name="FileUploadServlet",urlPatterns={"/FileUploadServlet"})

@MultipartConfig
public class FileUploadServlet extends HttpServlet {
	 @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse reap) throws ServletException, IOException {
		PrintWriter out = reap.getWriter();
	    String path = req.getParameter("txtPath");
	    Part part = req.getPart("file1");
	    
	    String fileName = part.getSubmittedFileName();
	    String finalLocation = path + File.separator + fileName;
	    part.write(finalLocation);
	    
	    out.print("File Uploaded Successfully At "+ finalLocation);
	}

}