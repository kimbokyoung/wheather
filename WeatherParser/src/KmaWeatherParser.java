import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import vo.KMA_WEATHER_NOW;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;


public class KmaWeatherParser {
	public static void main(String[] args) {
		String sido = "2600000000";
		String gugun = "2644000000";
		String dong = "2644055000";
		getKmaWeather(sido, gugun, dong);
	}
	/**
	 * 요청동네의 현재시간을 반환합니다.
	 * @param sido
	 * @param gugun
	 * @param dong
	 * @return
	 */
	public static KMA_WEATHER_NOW getKmaWeather(String sido,String gugun,String dong){
		KMA_WEATHER_NOW weathe = null;
		String sourceUrlString = getUrlAddress(sido, gugun, dong);
		Source source = getSource(sourceUrlString);
		weathe = new KMA_WEATHER_NOW();
		//현재 시간
		Element elementThead = source.getFirstElement("thead");
		if(elementThead == null){
			return null;
		}else{
			Element elementTime = elementThead.getFirstElement("span");
			if(elementTime.getAttributeValue("class").equals("point")){
				String hour = elementTime.getContent().toString();
				weathe.setHOUR(hour);
			}
		}

		//현재 날씨
		Element elementTbody = source.getFirstElement("tbody");
		if(elementTbody == null){
			return null;
		}else{
			Element elementDl = elementTbody.getFirstElement("dl");
			Element elementExp = elementDl.getFirstElement("dt");
			
			Element elementImg = elementExp.getFirstElement("img");
			String exp = elementImg.getAttributeValue("alt");
			weathe.setEXP(exp);
			
			List<Element> elementList = elementDl.getAllElements();
			for(int i = 0 ; i<elementList.size(); i++){
				Element element = elementList.get(i);
				if(element.getName().equals("dd")){
					if(element.getAttributeValue("class") ==null){
						continue;
					}
					if(element.getAttributeValue("class").equals("hum")){
						String temp = element.getContent().toString();
						weathe.setTEMP(temp);
					}else if(element.getAttributeValue("class").equals("reh")){
						Element elementReh = element.getFirstElement("strong");
						String reh = elementReh.getContent().toString();
						weathe.setREH(reh);
					}
				}

				if(element.getName().equals("dt")){
					if(element.getContent().toString().equals("풍향")){
						Element elementWD = elementList.get(i+1);
						String temp = elementWD.getContent().toString();
						weathe.setWD(temp);
					}else if(element.getContent().toString().equals("풍속")){
						Element elementWS= elementList.get(i+1);
						String ws = elementWS.getFirstElement("strong").
								getContent().toString();
						weathe.setWS(ws);
					}else if(element.getAttributeValue("class") !=null && element.getAttributeValue("class").equals("rain")){
						Element elementRain = elementList.get(i+1);
						String rain = elementRain.getFirstElement("strong").getContent().toString();
						weathe.setRAIN(rain);
					}
				}
			}
		}

		System.out.println(weathe.getHOUR());
		System.out.println(weathe.getEXP());
		System.out.println(weathe.getTEMP());
		System.out.println(weathe.getREH());
		System.out.println(weathe.getWD());
		System.out.println(weathe.getWS());
		System.out.println(weathe.getRAIN());


		return weathe;
	}
	/**
	 * 웹으로부터 Source 획득합니다.
	 * @param sourceUrlString
	 * @return
	 */
	public static Source getSource(String sourceUrlString){
		Source source = null;
		try {
			source = new Source(new URL(sourceUrlString));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			return null;
		}
		return source;
	}
	/**
	 * 주소를 가져옵니다.
	 * @param sido
	 * @param gugun
	 * @param dong
	 * @return
	 */
	public static String getUrlAddress(String sido,String gugun,String dong){
		return "http://www.kma.go.kr/weather/forecast/timeseries2_metsky.jsp?sido="+sido+"&gugun="+gugun+"&dong="+dong+"&x=19&y=8";
	}
}
