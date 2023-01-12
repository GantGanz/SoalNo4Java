package com.example.profile.dto;

import java.util.List;

public class ProfilesDto {
	private List<ProfileDto> data;
	private Integer size;
	
	public List<ProfileDto> getData() {
		return data;
	}
	public void setData(List<ProfileDto> data) {
		this.data = data;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
}
