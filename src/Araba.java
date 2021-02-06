import java.util.Date;

public class Araba {

	int Id;
	String Plaka;
	String Marka;
	Date GirisTarihi;
	
	public int getId() {
		return Id;
	}

	public void setId(int idCounter) {
		Id = idCounter;
	}

	public String getPlaka() {
		return Plaka;
	}
	public void setPlaka(String plaka) {
		Plaka = plaka;
	}
	public String getMarka() {
		return Marka;
	}
	public void setMarka(String marka) {
		Marka = marka;
	}
	public Date getGirisTarihi() {
		return GirisTarihi;
	}
	public void setGirisTarihi(Date girisTarihi) {
		GirisTarihi = girisTarihi;
	}
	
	
}
