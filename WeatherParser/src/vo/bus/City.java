
package vo.bus;
/************************************************************************
 * @1.���α׷���  City.java
 * @2.���α׷�����  
 * @3.�ۼ�����  2014. 7. 11.
 * @4.�ۼ���  kby
 * @5.�������
 * <pre>
 * --------------------------------------------------------------------------
 * ����		��������		���泻��			������
 * --------------------------------------------------------------------------
 * </pre>
 */

public class City {
	private String citycode;
	private String cityname;
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	
	@Override
	public String toString() {
		return "City [citycode=" + citycode + ", cityname=" + cityname
				+ "]";
	}
}

/***************************************************************************************************
								 				END
****************************************************************************************************/