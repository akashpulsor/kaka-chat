package chat.kafka;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="MESSAGE")
public class Message {
	
	@Id
	@Column(name = "MESSAGE_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer id;
	
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
