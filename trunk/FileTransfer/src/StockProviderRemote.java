
import javax.ejb.Remote;

@Remote
public interface StockProviderRemote {
	public String getAllData(String format);
}
