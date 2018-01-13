package entity;

import java.sql.Timestamp;
/**
 * @author 
 *帖子
 */
public class Card {
	private Integer id;
	private Integer themeId;
	private Integer editorId;
	private String name;
	private Timestamp time;
	private Integer replayNum;
	private Integer watchNum;
	private Integer moduleId;
	//数据库中不含该字段,作者名
	private String editorName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getThemeId() {
		return themeId;
	}
	public void setThemeId(Integer themeId) {
		this.themeId = themeId;
	}
	public Integer getEditorId() {
		return editorId;
	}
	public void setEditorId(Integer editorId) {
		this.editorId = editorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	public Integer getReplayNum() {
		return replayNum;
	}
	public void setReplayNum(Integer replayNum) {
		this.replayNum = replayNum;
	}
	public Integer getWatchNum() {
		return watchNum;
	}
	public void setWatchNum(Integer watchNum) {
		this.watchNum = watchNum;
	}
	public String getEditorName() {
		return editorName;
	}
	public void setEditorName(String editorName) {
		this.editorName = editorName;
	}
	public Integer getModuleId() {
		return moduleId;
	}
	public void setModuleId(Integer moduleId) {
		this.moduleId = moduleId;
	}
	@Override
	public String toString() {
		return "Card [id=" + id + ", themeId=" + themeId + ", editorId="
				+ editorId + ", name=" + name + ", time=" + time
				+ ", replayNum=" + replayNum + ", watchNum=" + watchNum + "]";
	}
}
