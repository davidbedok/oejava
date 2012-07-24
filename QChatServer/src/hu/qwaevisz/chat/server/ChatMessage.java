package hu.qwaevisz.chat.server;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatMessage {

	private String message;
	private String username;
	private Date createDate;
	private Integer order;
	private static SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "[" + this.getOrder() + "] " + this.getUsername() + " : " + this.getMessage() + " (" + ChatMessage.FORMATTER.format(this.getCreateDate()) + ")";
	}
}
