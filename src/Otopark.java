import java.util.ArrayList;
import java.util.Date;

public class Otopark {
	Date now;
	ArrayList<Araba> arabalar;
	int idCounter=0;
	public Otopark() {
		arabalar = new ArrayList<Araba>();
	}
	
	public boolean ArabaGiris(String plaka,String marka,Date girisTarihi) {
		
		boolean onay=true;
		Araba araba = new Araba();
		araba.setPlaka(plaka);
		
		for (int i = 0; i < arabalar.size(); i++) {
			if(arabalar.get(i).getPlaka().equals(plaka)) {
				onay = false;
				break;
			}
			else {
				onay = true;
			}
		}
		if(onay == true) {
			araba.setId(idCounter);
			idCounter++;
			araba.setMarka(marka);
			araba.setGirisTarihi(girisTarihi);
			arabalar.add(araba);
		}
		return onay;
	}
	
	public long ArabaCikis(Object plaka) {
		for (int i = 0; i < arabalar.size(); i++) {
			if(arabalar.get(i).getPlaka().equals(plaka)) {
				long odenecekFiyat = FiyatHesaplama(arabalar.get(i));
				arabalar.remove(i);
				return odenecekFiyat;
			}
		}
		return 0 ;
	}
	public long FiyatHesaplama(Araba a) {
		now = new Date();
		int bolen=6000;// /100 ==> saniye cinsinden 		/6000==>dakika cinsinden        /360000 ==> saat cinsinden
		long fark = ((now.getTime() - a.getGirisTarihi().getTime())/bolen);
		return fark;
	}
	
}
