
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
 * @1.���α׷���  JSONMaker.java
 * @2.���α׷�����  
 * @3.�ۼ�����  2014. 7. 18.
 * @4.�ۼ���  kby
 * @5.�������
 * <pre>
 * --------------------------------------------------------------------------
 * ����		��������		���泻��			������
 * --------------------------------------------------------------------------
 * </pre>
 */

public class JSONMaker {
	public static void main(String[] args) {
		  Map m2 = new HashMap();
		  List  l1 = new LinkedList();
		  for(int i = 0; i <5 ; i ++) {
			  Map m1 = new LinkedHashMap();
			  m1.put("name","�躹��");
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