package vo;

public class DongInfo {
	public String getSido() {
		return sido;
	}
	public void setSido(String sido) {
		this.sido = sido;
	}
	public String getSido_name() {
		return sido_name;
	}
	public void setSido_name(String sido_name) {
		this.sido_name = sido_name;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getGugun_name() {
		return gugun_name;
	}
	public void setGugun_name(String gugun_name) {
		this.gugun_name = gugun_name;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getDong_name() {
		return dong_name;
	}
	public void setDong_name(String dong_name) {
		this.dong_name = dong_name;
	}
	public String getGridx() {
		return gridx;
	}
	public void setGridx(String gridx) {
		this.gridx = gridx;
	}
	public String getGridy() {
		return gridy;
	}
	public void setGridy(String gridy) {
		this.gridy = gridy;
	}
	private String sido;
	private String sido_name;
	private String gugun;
	private String gugun_name;
	private String dong;
	private String dong_name;
	private String gridx;
	private String gridy;
	@Override
	public String toString() {
		return "DongInfo [sido=" + sido + ", sido_name=" + sido_name
				+ ", gugun=" + gugun + ", gugun_name=" + gugun_name + ", dong="
				+ dong + ", dong_name=" + dong_name + ", gridx=" + gridx
				+ ", gridy=" + gridy + "]";
	}
	
	
}
