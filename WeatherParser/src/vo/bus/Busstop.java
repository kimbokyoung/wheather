
package vo.bus;
/************************************************************************
 * @1.���α׷���  Busstop.java
 * @2.���α׷�����  
 * @3.�ۼ�����  2014. 7. 14.
 * @4.�ۼ���  kby
 * @5.�������
 * <pre>
 * --------------------------------------------------------------------------
 * ����		��������		���泻��			������
 * --------------------------------------------------------------------------
 * </pre>
 */

public class Busstop {
	/**
	 * ������ ID
	 */
	private String nodeId;
	/**
	 * ������ ��
	 */
	private String nodeNm;
	/**
	 * ������ x ��ǥ
	 */
	private double gpsLati;
	/**
	 * ������ y ��ǥ
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