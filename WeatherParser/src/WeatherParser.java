import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import vo.DongInfo;


public class WeatherParser {

	public static void main(String[] args) throws Exception {
		parserDongInfo();
	}

	public static List<DongInfo> parserDongInfo() {
		List<DongInfo> dongInfos = new ArrayList<DongInfo>();
		List<DongInfo> sidoList = new ArrayList<DongInfo>();
		List<DongInfo> gugunList = new ArrayList<DongInfo>();
		List<DongInfo> dongList = new ArrayList<DongInfo>();
		String sido = "1100000000";
		String gugun = "1159000000";
		String dong ="1159068000";
		String sourceUrlString = getUrlAddress(sido, gugun, dong);
		System.out.println(sourceUrlString);
		Source source = getSource(sourceUrlString);
		sidoList = getSelectVal(source,"sido");
		for(DongInfo tempSido : sidoList){
//			if(tempSido.getSido().equals("2600000000")){
				sido = tempSido .getSido();
				sourceUrlString = getUrlAddress(sido, gugun, dong);
				source = getSource(sourceUrlString);
				gugunList = getSelectVal(source,"gugun");
				for(DongInfo tempGugun : gugunList){
					System.out.println(tempGugun.getGugun_name());
					gugun = tempGugun.getGugun();
					sourceUrlString = getUrlAddress(sido, gugun, dong);
					source = getSource(sourceUrlString);
					dongList = getSelectVal(source,"dong");
					for(DongInfo tempDong : dongList){
						tempDong.setSido(tempSido.getSido());
						tempDong.setSido_name(tempSido.getSido_name());
						tempDong.setGugun(tempGugun.getGugun());
						tempDong.setGugun_name(tempGugun.getGugun_name());
						tempDong.setDong(tempDong.getDong());
						tempDong.setDong_name(tempDong.getDong_name());
						dongInfos.add(tempDong);
//						dong = tempDong.getDong();
//						sourceUrlString = getUrlAddress(sido, gugun, dong);
//						source = getSource(sourceUrlString);
//						for(Element element : source.getAllElements("td")){
//							String td = element.getAttributeValue("width");
//							if(td !=null && td.equals("14%")){
//								DongInfo realDongInfo = new DongInfo();
//								realDongInfo.setSido(tempSido.getSido());
//								realDongInfo.setSido_name(tempSido.getSido_name());
//								realDongInfo.setGugun(tempGugun.getGugun());
//								realDongInfo.setGugun_name(tempGugun.getGugun_name());
//								realDongInfo.setDong(tempDong.getDong());
//								realDongInfo.setDong_name(tempDong.getDong_name());
//								Element aElement = element.getFirstElement("a");
//								String temp = aElement.getAttributeValue("href");
//								temp = temp.substring(temp.indexOf("gridx"));
//								String[] grids = temp.split("&");
//								for(String grid : grids){
//									if(grid.indexOf("gridx=")!=-1){
//										grid = grid.replace("gridx=", "");
//										realDongInfo.setGridx(grid);
//									}else if(grid.indexOf("gridy=")!=-1){
//										grid = grid.replace("gridy=", "");
//										realDongInfo.setGridy(grid);
//									}
//								}
//								System.out.println(realDongInfo.getSido()+" "+realDongInfo.getSido_name()+" " + realDongInfo.getGugun_name()+" "+ realDongInfo.getDong_name()+" "+ realDongInfo.getGridx()+" "+ realDongInfo.getGridy());
//								System.out.println("-");
//								dongInfos.add(realDongInfo);
//							}
//						}
//					}
				}
			}
		}
		insertDonginfo(dongInfos);
		return dongInfos;
	}
	/**
	 * sqlite 저장
	 * @param realDongInfo
	 */
	public static void insertDonginfo(List<DongInfo> realDongInfo){
		String DB_DRIVE ="org.sqlite.JDBC";
		String DB_NAME = "address.db";
		String url="jdbc:sqlite:"+DB_NAME;
		System.out.println(realDongInfo.size());
		Connection dBConnection = null;
		try {
			Class.forName(DB_DRIVE);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			dBConnection  = DriverManager.getConnection(url);
			Statement statement = dBConnection.createStatement();
			int seq = 1;
			for(DongInfo info : realDongInfo){
				String address = info.getSido_name() +" " + info.getGugun_name() + " "+ info.getDong_name();
				statement.execute("insert into address(_id,address,dong,cityval, gugunval, dongval) values(" +seq+ ",'"+ address+"','"+info.getDong_name()+"','"+info.getSido()+"','"+info.getGugun()+"','"+info.getDong()+"');");
				seq++;
				if (seq % 100 == 0) {
					System.out.println((seq++)+" 등록");
				}
			}
			System.out.println("DB 등록완료!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				dBConnection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static List<DongInfo> getSelectVal(Source source, String name){
		List<DongInfo> sidoList = new ArrayList<DongInfo>();
		List<Element> elementList=source.getAllElements("select");
		for (Element element : elementList) {
			if(element.getAttributeValue("name").equals(name)){
				for(Element sidoElement : element.getAllElements("option")){
					DongInfo info = new DongInfo();
					if(name.equals("sido")){
						info.setSido_name(sidoElement.getContent().toString());
						info.setSido(sidoElement.getAttributeValue("value"));
						sidoList.add(info);
					}else if(name.equals("gugun")){
						info.setGugun_name(sidoElement.getContent().toString());
						info.setGugun(sidoElement.getAttributeValue("value"));
						sidoList.add(info);
					}else if(name.equals("dong")){
						info.setDong_name(sidoElement.getContent().toString());
						info.setDong(sidoElement.getAttributeValue("value"));
						sidoList.add(info);
					}

				}
			}
		}
		return sidoList;
	}
	/**
	 * 웹으로부터 Source 가져옴
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
	 * 주소 가져오기
	 * @param sido
	 * @param gugun
	 * @param dong
	 * @return
	 */
	public static String getUrlAddress(String sido,String gugun,String dong){
		return "http://www.kma.go.kr/weather/lifenindustry/sevice_rss.jsp?sido="+sido+"&gugun="+gugun+"&dong="+dong+"&x=19&y=8";
	}
}
