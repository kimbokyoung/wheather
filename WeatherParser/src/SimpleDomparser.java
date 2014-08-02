import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/************************************************************************
 * @1.프로그램명  SimpleDomparser.java
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

public class SimpleDomparser<T> {
	private DocumentBuilderFactory dbFactory;
	private DocumentBuilder dBuilder;
	private Document doc;
	private SimpleDomparser() {};
	public SimpleDomparser(String url) {
		try {
			dbFactory = DocumentBuilderFactory.newInstance();
			dBuilder = dbFactory.newDocumentBuilder();
			doc = dBuilder.parse(url);
			doc.getDocumentElement().normalize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * return NodeList all ElemetnsByTagName
	 * @param class1
	 * @param rootElement
	 * @return
	 */
	public List<T> getNodeList(Class<T> class1, String rootElement) {
		List<T> list = new ArrayList<T>();
		boolean isSuccess = true;
    	NodeList nList = doc.getElementsByTagName(rootElement);
    	for (int temp = 0; temp < nList.getLength(); temp++) {
    		Node nNode = nList.item(temp);
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    			T obj = null;
    			try {
    				obj = class1.newInstance();
    			} catch (InstantiationException e1) {
    				isSuccess = false;
    				e1.printStackTrace();
    			} catch (IllegalAccessException e1) {
    				isSuccess = false;
    				e1.printStackTrace();
    			}
    			if (isSuccess == false) {
    				return null;
    			}
    			Element eElement = (Element) nNode;
    			Field[] fields = class1.getDeclaredFields();
    			for(Field field : fields) {
    				Method method = null;
					try {
						method = class1.getMethod(getSetMethodName(field.getName()), field.getType());
					} catch (NoSuchMethodException e) {
						isSuccess = false;
						e.printStackTrace();
					} catch (SecurityException e) {
						isSuccess = false;
						e.printStackTrace();
					}
					if (isSuccess == false) {
	    				return null;
	    			}
					Node node = eElement.getElementsByTagName(field.getName()).item(0);
					if (node != null) {
						String value = node.getTextContent();
	    				try {
							invoke(method, obj, field.getName(), value);
						} catch (IllegalAccessException e) {
							isSuccess = false;
							e.printStackTrace();
						} catch (IllegalArgumentException e) {
							isSuccess = false;
							e.printStackTrace();
						} catch (InvocationTargetException e) {
							isSuccess = false;
							e.printStackTrace();
						}
					}
    			}
    			if (isSuccess == false) {
    				return null;
    			}
    			list.add(obj);
    		}
    	}
		
		return list;
	}
	/**
	 * get setMethodName from fieldName
	 * @param field
	 * @return
	 */
	private String getSetMethodName(String field) {
		String set = "set";
		String first="";
		String last="";
		if (field.length() > 0) {
			first = field.substring(0, 1).toUpperCase();
		}
		if (field.length() > 1) {
			last = field.substring(1, field.length());
		}
		return set+first+last;
		
	}
	/**
	 * 
	 * @param method target method
	 * @param obj	the object the underlying method is invoked from
	 * @param member field name
	 * @param value	field value
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private void invoke(Method method, Object obj, String member, String value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Type[] types = method.getGenericParameterTypes();
		if (types.length == 1) {
			if(types[0].equals(String.class)) {
				method.invoke(obj, new String[]{value});
			}else if(types[0].equals(int.class)) {
				int val = Integer.valueOf(value);
				method.invoke(obj, new int[]{val});
			}
		}
	}
}

/***************************************************************************************************
								 				END
 ****************************************************************************************************/