import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import com.mysql.jdbc.StringUtils;


public class Mysql {

	private Connection conn;
	
	public Mysql(String server, String dbName, String username, String password) throws Exception {
		this.conn = connectToDB(server, dbName, username, password);
	}
	
	public Connection connectToDB(String server, String dbName, String username, String password) throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();					//xekina ton jdbc driver
			String connectionURL="jdbc:mysql://"+ server +":3306/" + dbName;		//3306 default port, protokollo jdbc gia MySQL					
			return DriverManager.getConnection(connectionURL,username,password);		//Import java.sql -> import java.sql.DriverManager;
		} catch (Exception e) {
			throw new Exception(e);
		}		
	}
	

	public static boolean convIntToBoolean(int value) {
		if ( value == 1 ) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean addRoom(String roomNumber, String timh, String atoma) {
		try{		
			Statement stmt = this.conn.createStatement();		
			String query = "insert into rooms (room_number, timh, atoma) values ('" + roomNumber + "','" + timh + "','" + atoma + "')";
			int rs = stmt.executeUpdate(query);
			
			return convIntToBoolean(rs);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}


	public boolean kaneKratisi(String room_id, String hm_enarksis, String hm_lhkshs, String onoma_krathshs) {
		try{
			hm_enarksis+=" 00:00:00";
			hm_lhkshs+=" 00:00:00";
			Statement stmt = this.conn.createStatement();		
			String query = "insert into Krathseis (room_id, hm_enarksis, hm_lhkshs, onoma_krathshs) values ('" + room_id + "','" + hm_enarksis + "','" + hm_lhkshs + "','" + onoma_krathshs + "')";
			int rs = stmt.executeUpdate(query);
			
			return convIntToBoolean(rs);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	public ArrayList<Room> getRooms() {
		ArrayList<Room> roomList = new ArrayList<Room>();
		try{		
			Statement stmt = conn.createStatement();		
			String query = "select * from rooms";
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()){							
				int id = rs.getInt("id");					
				String room_number = rs.getString("room_number");			
				String timh = rs.getString("timh");
				String atoma = rs.getString("atoma");
				
				roomList.add(new Room(id, room_number, timh, atoma, null, null, null, null));
				
				JOptionPane.showMessageDialog(null, id + " " + room_number + " " + timh + " " + atoma  
						, "Room", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
			
			return roomList;
		} catch (Exception e) {
	
		}
		return null;
	}
	
	public ArrayList<Room> getRoomsByDate(String hm_enarksis, String hm_lhkshs) {
		ArrayList<Room> roomList = new ArrayList<Room>();
		try{
			hm_enarksis+=" 00:00:00";
			hm_lhkshs+=" 00:00:00";
			Statement stmt = conn.createStatement();		
			String query = "select * from rooms LEFT JOIN "
					+ "(SELECT id as KratID, room_id, hm_enarksis, hm_lhkshs, onoma_krathshs FROM Krathseis WHERE "
						+ "(('" + hm_enarksis + "' <= Krathseis.hm_lhkshs) AND ('" + hm_lhkshs + "' >= Krathseis.hm_enarksis)) OR "
						+ "('" + hm_enarksis + "' >= Krathseis.hm_enarksis AND '" + hm_enarksis + "' <= Krathseis.hm_lhkshs) OR "
						+ "('" + hm_lhkshs + "' >= Krathseis.hm_enarksis AND '" + hm_lhkshs + "' <= Krathseis.hm_lhkshs)"
					+ ") Krat ON Krat.room_id = rooms.id";

			System.out.printf(query + "%n");
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()){							
				int id = rs.getInt("id");					
				String room_number = rs.getString("room_number");			
				String timh = rs.getString("timh");
				String atoma = rs.getString("atoma");
				String KratID = rs.getString("KratID");

				String hm_enarksisRoom = rs.getString("hm_enarksis");
				String hm_lhkshsRoom = rs.getString("hm_lhkshs");
				String onoma_krathshs = rs.getString("onoma_krathshs");
				
				
				//System.out.println(rs.getString("*"));//rs.getMetaData().getColumnCount());
				roomList.add(new Room(id, room_number, timh, atoma, KratID, hm_enarksisRoom, hm_lhkshsRoom, onoma_krathshs ));
				/*
				int columnCount = rs.getMetaData().getColumnCount();

				
			    for(int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
			        Object object = rs.getObject(columnIndex);
			        System.out.printf("%s, ", object == null ? "NULL" : object.toString());
			    }
			
				System.out.printf("%n");
				*/
			}
			
			return roomList;
		} catch (Exception e) {
			System.out.printf("%n" + e.getMessage());
		}
		return null;
	}
	
	public boolean changePrice(String room_id, String newPrice) {
		try{		
			Statement stmt = this.conn.createStatement();		
			String query = "UPDATE rooms SET timh='"+newPrice+"' WHERE id='"+room_id+"'";
			int rs = stmt.executeUpdate(query);
			return convIntToBoolean(rs);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	
	public double getReceipt(String onoma_krathshs) {
		try{		
			Statement stmt = conn.createStatement();		
			String query = "SELECT Krathseis.hm_enarksis, Krathseis.hm_lhkshs, rooms.timh FROM Krathseis INNER JOIN rooms ON rooms.id = Krathseis.room_id WHERE onoma_krathshs = '" + onoma_krathshs + "'";
						
			ResultSet rs = stmt.executeQuery(query);
			
			rs.next();
			
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date startDate = sdf.parse(rs.getString("hm_enarksis").substring(0, 10));
			java.util.Date endDate = sdf.parse(rs.getString("hm_lhkshs").substring(0, 10));
			
			long diffInMillis = Math.abs(startDate.getTime() - endDate.getTime());
			long diff = TimeUnit.DAYS.convert(diffInMillis, TimeUnit.MILLISECONDS);
			
			return Double.valueOf(diff * Double.valueOf(rs.getString("timh")));
		} catch (Exception e) {
			System.out.printf("%n" + e.getMessage());
		}
		return Double.valueOf(0);
	}
	
	
	public String getStatistics(String hm_enarksis, String hm_lhkshs) {
		
		try{
			hm_enarksis+=" 00:00:00";
			hm_lhkshs+=" 00:00:00";
			Statement stmt = conn.createStatement();		
			String query = "SELECT COUNT(CASE WHEN hm_lhkshs is NULL THEN 1 END) as eleuthera, COUNT(CASE WHEN hm_lhkshs is not NULL THEN 1 END) as kleismena FROM (" + 
					"select * from rooms LEFT JOIN "
					+ "(SELECT id as KratID, room_id, hm_enarksis, hm_lhkshs, onoma_krathshs FROM Krathseis WHERE "
						+ "(('" + hm_enarksis + "' <= Krathseis.hm_lhkshs) AND ('" + hm_lhkshs + "' >= Krathseis.hm_enarksis)) OR "
						+ "('" + hm_enarksis + "' >= Krathseis.hm_enarksis AND '" + hm_enarksis + "' <= Krathseis.hm_lhkshs) OR "
						+ "('" + hm_lhkshs + "' >= Krathseis.hm_enarksis AND '" + hm_lhkshs + "' <= Krathseis.hm_lhkshs)"
					+ ") Krat ON Krat.room_id = rooms.id"
				+ ") RoomStats ";

			ResultSet rs = stmt.executeQuery(query);
			
			
			rs.next();
			
			int eleuthera = Integer.parseInt(rs.getString("eleuthera") );
			int kleismena = Integer.parseInt(rs.getString("kleismena") );
			
			
			System.out.printf("Eleuthera: " + String.valueOf(eleuthera));
			System.out.printf("%n");
			System.out.printf("Kleismena: " + String.valueOf(kleismena));
			System.out.printf("%n");
			
			int plhrothta = (eleuthera + kleismena)*kleismena;
			System.out.printf("Plhrothta: " + String.valueOf(plhrothta) + "%%");
			
			return "Eleuthera: " + String.valueOf(eleuthera) + ", " + "Kleismena: " + String.valueOf(kleismena) + ", " + "Plhrothta: " + String.valueOf(plhrothta) + "%";
		} catch (Exception e) {
			System.out.printf("%n" + e.getMessage());
		}
		return null;
	}
}
