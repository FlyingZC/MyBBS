package entity;

import java.sql.Timestamp;

public class Module {
	Integer id;
	String name;
	String imgsrc;
	Integer themeId;
	Integer cardNum;
	Timestamp lastPost;
	Integer partId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getImgsrc() {
		return imgsrc;
	}
	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	public Integer getCardNum() {
		return cardNum;
	}
	public void setCardNum(Integer cardNum) {
		this.cardNum = cardNum;
	}
	public Timestamp getLastPost() {
		return lastPost;
	}
	public void setLastPost(Timestamp lastPost) {
		this.lastPost = lastPost;
	}
	@Override
	public String toString() {
		return "Module [id=" + id + ", name=" + name + ", imgsrc=" + imgsrc
				+ ", themeId=" + themeId + ", cardNum=" + cardNum
				+ ", lastPost=" + lastPost + ", partId=" + partId + "]";
	}
}
