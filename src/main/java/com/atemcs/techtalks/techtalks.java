package com.atemcs.techtalks;

public class techtalks {
	private int techtalksid;
	private String presenteeName;
	private String topic;
	private String location;
	private String when;
	public techtalks() {
		super();
	}
	public techtalks(int techtalksid, String presenteeName, String topic, String location, String when) {
		super();
		this.techtalksid = techtalksid;
		this.presenteeName = presenteeName;
		this.topic = topic;
		this.location = location;
		this.when = when;
	}
	public int getTechtalksid() {
		return techtalksid;
	}
	public void setTechtalksid(int techtalksid) {
		this.techtalksid = techtalksid;
	}
	public String getPresenteeName() {
		return presenteeName;
	}
	public void setPresenteeName(String presenteeName) {
		this.presenteeName = presenteeName;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getWhen() {
		return when;
	}
	public void setWhen(String when) {
		this.when = when;
	}
	@Override
	public String toString() {
		return "techtalks [techtalksid=" + techtalksid + ", presenteeName=" + presenteeName + ", topic=" + topic
				+ ", location=" + location + ", when=" + when + "]";
	}
	
	

}
