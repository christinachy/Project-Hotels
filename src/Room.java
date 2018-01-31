
public class Room {
	
	private int id;
	private String room_number, timh, atoma, kratID, hm_enarkshs, hm_lukshs, onoma_krat;


	public Room(int id, String room_number, String timh, String atoma, String kratID, String hm_enakshs, String hm_lukshs, String onoma_krat) {
		this.id = id;
		this.room_number = room_number;
		this.timh = timh;
		this.atoma = atoma;
		this.kratID = kratID;
		this.hm_enarkshs = hm_enakshs;
		this.hm_lukshs = hm_lukshs;
		this.onoma_krat = onoma_krat;
	}

	public int getId() {
		return this.id;
	}
	public String getNum() {
		return this.room_number;
	}
	public String getPrice() {
		return this.timh;
	}
	public String getPplCount() {
		return this.atoma;
	}

	public String getKratID() {
		return kratID;
	}

	public String getHm_enakshs() {
		return hm_enarkshs;
	}

	public String getHm_lukshs() {
		return hm_lukshs;
	}

	public String getOnoma_krat() {
		return onoma_krat;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String roomRow = id + ", " + room_number + ", " + timh + ", " + atoma;
		
		if (hm_enarkshs == null)
			return roomRow;
		else
			return roomRow + ", " + kratID + ", " + hm_enarkshs + ", " + hm_lukshs + ", " + onoma_krat;
	
	}
	
	

}
