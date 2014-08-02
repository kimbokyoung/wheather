package vo;

public class KMA_WEATHER_NOW {
	public String getHOUR() {
		return HOUR;
	}
	public void setHOUR(String hOUR) {
		HOUR = hOUR;
	}
	public String getTEMP() {
		return TEMP;
	}
	public void setTEMP(String tEMP) {
		TEMP = tEMP;
	}
	public String getWD() {
		return WD;
	}
	public void setWD(String wD) {
		WD = wD;
	}
	public String getREH() {
		return REH;
	}
	public void setREH(String rEH) {
		REH = rEH;
	}
	public String getWS() {
		return WS;
	}
	public void setWS(String wS) {
		WS = wS;
	}
	public String getEXP() {
		return EXP;
	}
	public void setEXP(String eXP) {
		EXP = eXP;
	}
	public String getRAIN() {
		return RAIN;
	}
	public void setRAIN(String rAIN) {
		RAIN = rAIN;
	}
	private String HOUR;	//시간
	private String TEMP;	//현재온도
	private String WD;		//풍향
	private String REH;		//습도
	private String WS;		//풍속
	private String EXP;		//설명
	private String RAIN; 	//강수량
}
