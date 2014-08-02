import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;


public class BusanCityhall {
	public static void main(String[] args) {
		String sourceUrlString = "http://teen.busan.go.kr/05community/01_01.jsp";
		Source source = null;
		try {
			source = new Source(new URL(sourceUrlString));
			System.out.println(source.toString());
			List<Element> elementList =  source.getAllElements();
			for(Element element : elementList){
				System.out.println(element.getName());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
		}
	}
}
