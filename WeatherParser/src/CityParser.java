import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import vo.bus.City;


/************************************************************************
 * @1.���α׷���  CityParser.java
 * @2.���α׷�����  
 * @3.�ۼ�����  2014. 7. 9.
 * @4.�ۼ���  kby
 * @5.�������
 * <pre>
 * --------------------------------------------------------------------------
 * ����		��������		���泻��			������
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
			String serviceKey = URLEncoder.encode("�λ�", "UTF-8");
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