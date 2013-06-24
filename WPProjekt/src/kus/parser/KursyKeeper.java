package kus.parser;

import java.math.BigDecimal;
import java.util.HashMap;

public class KursyKeeper {
	String date;
	String dateOfPublication;
	
	
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateOfPublication() {
		return dateOfPublication;
	}
	public void setDateOfPublication(String dateOfPublication) {
		this.dateOfPublication = dateOfPublication;
	}
	
	
	
	class PrizceOfMoney{
		BigDecimal sell;
		BigDecimal buy;
		
		public PrizceOfMoney() {
			super();
			this.sell = BigDecimal.ZERO;
			this.buy = BigDecimal.ZERO;
		}
		
		public PrizceOfMoney(BigDecimal sell, BigDecimal buy) {
			super();
			this.sell = sell;
			this.buy = buy;
		}
		public BigDecimal getSell() {
			return sell;
		}
		public void setSell(BigDecimal sell) {
			this.sell = sell;
		}
		public BigDecimal getBuy() {
			return buy;
		}
		public void setBuy(BigDecimal buy) {
			this.buy = buy;
		}
		
		
	}
	HashMap<String,PrizceOfMoney> a;
}
