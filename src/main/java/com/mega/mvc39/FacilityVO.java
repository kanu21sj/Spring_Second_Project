package com.mega.mvc39;
//편의시설에 대한 데이터를 다룰 VO
public class FacilityVO {

	String fid;
	float flatitude;
	float flongtitude;
	String ftype;
	
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public float getFlatitude() {
		return flatitude;
	}
	public void setFlatitude(float flatitude) {
		this.flatitude = flatitude;
	}
	public float getFlongtitude() {
		return flongtitude;
	}
	public void setFlongtitude(float flongtitude) {
		this.flongtitude = flongtitude;
	}
	public String getFtype() {
		return ftype;
	}
	public void setFtype(String ftype) {
		this.ftype = ftype;
	}
}
