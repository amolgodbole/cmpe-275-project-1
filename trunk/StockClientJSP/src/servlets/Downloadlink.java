package servlets;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.data.business.StockProviderRemote;

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
		String downloadFile = null;
		ServletContext context = (ServletContext)getServletContext().getContext(downloadFile); 
		response.setContentType("application/force-download");
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" + downloadFile + "\"");
		byte[] buf = new byte[1024];
		
		try{
			Properties properties = new Properties();
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			Context ctx = new InitialContext(properties);
			Object ref = ctx.lookup("StockProvider/remote");
			//StockProviderRemote stock = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
			
			//result = stock.getAllData(format);
			//downloadFile = stock.getDownloadFile();
			downloadFile = "C:\\stocks.csv";
			
			//String realPath = context.getRealPath("/resources/" + downloadFile);
			 File file = new File(downloadFile);
			 long length = file.length();
			 BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
			 ServletOutputStream out = response.getOutputStream();
			 response.setContentLength((int)length);
			 while ((in != null) && ((length = in.read(buf)) != -1)) {
			   out.write(buf, 0, (int)length);
			 }
			 in.close();
			 out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
