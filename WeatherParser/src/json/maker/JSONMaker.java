
package json.maker;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/************************************************************************
 * @1.프로그램명  JSONMaker.java
 * @2.프로그램설명  
 * @3.작성일자  2014. 7. 18.
 * @4.작성자  kby
 * @5.변경사항
 * <pre>
 * --------------------------------------------------------------------------
 * 순번		변경일자		변경내용			변경자
 * --------------------------------------------------------------------------
 * </pre>
 */

public class JSONMaker {
	public static void main(String[] args) {
		  Map m2 = new HashMap();
		  List  l1 = new LinkedList();
		  for(int i = 0; i <5 ; i ++) {
			  Map m1 = new LinkedHashMap();
			  m1.put("name","김복영");
			  m1.put("age","29");
			  l1.add(m1);
		  }
		  String jsonString = JSONValue.toJSONString(l1);
		  System.out.println(jsonString);
	}
}

/***************************************************************************************************
								 				END
****************************************************************************************************/