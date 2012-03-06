package serlets;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.http.HttpSession;

import com.data.entity.Stockdata;
import com.data.entity.StockdataPK;
import com.data.business.StockProviderRemote;

/**
 * Servlet implementation class RealTimeData
 */
public class RealTimeData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private double close;
	private double high;
	private double low;
	private double open;
	private int volume;
	private String ticker;
	private List<Stockdata> stockData;
	private String message;
	
	
	

    public double getClose() {
		return close;
	}

	public void setClose(double close) {
		this.close = close;
	}

	public double getHigh() {
		return high;
	}

	public void setHigh(double high) {
		this.high = high;
	}

	public double getLow() {
		return low;
	}

	public void setLow(double low) {
		this.low = low;
	}

	public double getOpen() {
		return open;
	}

	public void setOpen(double open) {
		this.open = open;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public List<Stockdata> getStockData() {
		return stockData;
	}

	public void setStockData(List<Stockdata> stockData) {
		this.stockData = stockData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
     * Default constructor. 
     */
    public RealTimeData() {
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
		
		try{
			Properties properties = new Properties();
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			Context ctx = new InitialContext(properties);
			Object ref = ctx.lookup("StockProvider/remote");
			StockProviderRemote stock = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
			
			this.stockData = stock.extract();
			
			request.setAttribute("stockData", this.stockData.toArray());
			RequestDispatcher view = request.getRequestDispatcher("/pages/realTime.jsp"); 
			view.forward(request, response);
			//uncomment to test
			
			/*StockData stocksA = new StockData();
			String ticker1 = "A";
			Double d1 = 12.1d;
			StockdataPK s1 = new StockdataPK();
			s1.setTicker(ticker1);
			stocksA.setId(s1);
			stocksA.setOpen(d1);
			this.stockData.add(stocksA);
			
			StockData stocksB = new StockData();
			String ticker2 = "AB";
			Double d2 = 1452d;
			StockdataPK s2 = new StockdataPK();
			s1.setTicker(ticker2);
			stocksA.setId(s2);
			stocksA.setOpen(d2);
			this.stockData.add(stocksB);*/
			
			
		}
		catch(Exception e)
		{
			this.message = e.getMessage();
		}	}

}
