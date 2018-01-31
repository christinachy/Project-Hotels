import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	static MainFrame mainWindow;
	public static Mysql MSC;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		mainWindow = new MainFrame();
		
		
		
		
		
		try{//"127.0.0.1"
			MSC = new Mysql("127.0.0.1", "hotels_db", "diana", "CMie@)swr35");
			
			//prosthetei kainouria rooms (leitourgia υπαλληλου)
			//MSC.addRoom("3","50","3");
			
			//δημιουργια νεας κρατησης (λειτουργια υπαλληλου)
			//MSC.kaneKratisi("2", "2018-1-31", "2018-2-1", "diana" );
			
			//Αναζήτηση δωματίων (πελάτης, υπάλληλος)
			//MSC.getRooms();
		
			//Αναζήτηση διαθεσιμότητας δωματίων (πελάτης, υπάλληλος)
			//Mas dinei dwmatia me krathseis (Oi krathseis twn dwmatiwn fenontai mono ean simpiptoun me tis hmerominies pou deinoume)
			//MSC.getRoomsByDate("2018-2-4", "2018-2-10");
			
			//Διαχείριση προσφορών (ιδιοκτήτης)
			//MSC.changePrice("5", "1000");
			
			//Λίστα εξόδων / Εκτύπωση απόδειξης 
			//System.out.println(MSC.getReceipt("Spiros") + "€");
			
			//Στατιστικά (ιδιοκτήτης) 
			//MSC.getStatistics("2018-2-4", "2018-2-10");
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "DB Connection Fail\n\n" +
					"Error:\n" + e.getMessage(), "DB Fail", JOptionPane.INFORMATION_MESSAGE);
			
			
		}
		
		
	}
}
