package servlets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class downloadlink
 */
public class Downloadlink extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Downloadlink() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String downloadFile = this.getSessionBean1().getDownloadFile();
		ServletContext context = (ServletContext)getServletContext().getContext(downloadFile); 
		response.setContentType("application/force-download");
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile + "\"");
		byte[] buf = new byte[1024];
		try{
			 String realPath = context.getRealPath("/resources/" + downloadFile);
			 File file = new File(realPath);
			 long length = file.length();
			 BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			 ServletOutputStream out = response.getOutputStream();
			 response.setContentLength((int)length);
			 while ((in != null) && ((length = in.read(buf)) != -1)) {
			   out.write(buf, 0, (int)length);
			 }
			 in.close();
			 out.close();
		}catch (Exception exc){
			exc.printStackTrace();
		}
		
	}

}
