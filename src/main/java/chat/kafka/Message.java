package chat.kafka;

public class Message {
	private String senderid;
	private String receiverid;
	
	private String msg;
	private Long time;
	
	/**
	 * @return the senderid
	 */
	public String getSenderid() {
		return senderid;
	}
	/**
	 * @param senderid the senderid to set
	 */
	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}
	/**
	 * @return the receiverid
	 */
	public String getReceiverid() {
		return receiverid;
	}
	/**
	 * @param receiverid the receiverid to set
	 */
	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the time
	 */
	public Long getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Long time) {
		this.time = time;
	}
	
}
