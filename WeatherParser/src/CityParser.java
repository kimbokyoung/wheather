import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import vo.bus.City;


/************************************************************************
 * @1.프로그램명  CityParser.java
 * @2.프로그램설명  
 * @3.작성일자  2014. 7. 9.
 * @4.작성자  kby
 * @5.변경사항
 * <pre>
 * --------------------------------------------------------------------------
 * 순번		변경일자		변경내용			변경자
 * --------------------------------------------------------------------------
 * </pre>
 */

public class CityParser {
	//url : http://openapi.tago.go.kr/openapi/service/BusLcInfoInqireService/getCtyCodeList?ServiceKey=g1jjwLfvXoRr5b3APSaJ8GYVZlI%2BxsSuJakHZNRhvhouDyRHEaOQBTfRnRaGv%2F%2BrEqrupyP6OLWoncR93FZa9A%3D%3D&id=1
	
	List<City> cities = new ArrayList<City>();
	static String url = "http://openapi.tago.go.kr/openapi/service/BusLcInfoInqireService/getCtyCodeList?ServiceKey=g1jjwLfvXoRr5b3APSaJ8GYVZlI%2BxsSuJakHZNRhvhouDyRHEaOQBTfRnRaGv%2F%2BrEqrupyP6OLWoncR93FZa9A%3D%3D&id=1";
	
	public static void main(String[] args) {
//		Source source = null;
//		try {
//			source = new Source(new URL(url));
//		} catch (MalformedURLException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//		}
//		CityParser parser = new CityParser();
//		parser.parserCity("");
		try {
			String serviceKey = URLEncoder.encode("부산", "UTF-8");
			System.out.println(serviceKey);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		SimpleDomparser<City> domparser = new SimpleDomparser<City>(url);
//		List<City> cities = domparser.getNodeList(City.class, "item");
//		for(City city :cities) {
//			System.out.println(city.toString());
//		}
		
	}
}

/***************************************************************************************************
								 				END
****************************************************************************************************/