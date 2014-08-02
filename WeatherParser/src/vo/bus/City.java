
package vo.bus;
/************************************************************************
 * @1.프로그램명  City.java
 * @2.프로그램설명  
 * @3.작성일자  2014. 7. 11.
 * @4.작성자  kby
 * @5.변경사항
 * <pre>
 * --------------------------------------------------------------------------
 * 순번		변경일자		변경내용			변경자
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