
package vo.bus;
/************************************************************************
 * @1.프로그램명  Busstop.java
 * @2.프로그램설명  
 * @3.작성일자  2014. 7. 14.
 * @4.작성자  kby
 * @5.변경사항
 * <pre>
 * --------------------------------------------------------------------------
 * 순번		변경일자		변경내용			변경자
 * --------------------------------------------------------------------------
 * </pre>
 */

public class Busstop {
	/**
	 * 정류소 ID
	 */
	private String nodeId;
	/**
	 * 정류소 명
	 */
	private String nodeNm;
	/**
	 * 정류소 x 좌표
	 */
	private double gpsLati;
	/**
	 * 정류소 y 좌표
	 */
	private double gpsLong;
	public String getNodeId() {
		return nodeId;
	}
	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	public String getNodeNm() {
		return nodeNm;
	}
	public void setNodeNm(String nodeNm) {
		this.nodeNm = nodeNm;
	}
	public double getGpsLati() {
		return gpsLati;
	}
	public void setGpsLati(double gpsLati) {
		this.gpsLati = gpsLati;
	}
	public double getGpsLong() {
		return gpsLong;
	}
	public void setGpsLong(double gpsLong) {
		this.gpsLong = gpsLong;
	}
	@Override
	public String toString() {
		return "Busstop [nodeId=" + nodeId + ", nodeNm=" + nodeNm
				+ ", gpsLati=" + gpsLati + ", gpsLong=" + gpsLong + "]";
	}
}

/***************************************************************************************************
								 				END
****************************************************************************************************/