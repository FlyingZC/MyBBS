package entity;

import java.sql.Timestamp;

public class Content {
	private Integer id;
	private Integer cardId;
	private Integer floor;
	private Integer come;
	private Integer target;
	private Timestamp time;
	private String txt;
	private Customer customer;//一个帖子对应一个用户
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public Integer getFloor() {
		return floor;
	}
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	public Integer getCome() {
		return come;
	}
	public void setCome(Integer come) {
		this.come = come;
	}
	public Integer getTarget() {
		return target;
	}
	public void setTarget(Integer target) {
		this.target = target;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public String getTxt() {
		return txt;
	}
	public void setTxt(String txt) {
		this.txt = txt;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", cardId=" + cardId + ", floor=" + floor
				+ ", come=" + come + ", target=" + target + ", time=" + time
				+ ", txt=" + txt + ", customer=" + customer + "]";
	}
}
