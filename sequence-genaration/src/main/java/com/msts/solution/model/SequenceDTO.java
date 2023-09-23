package com.msts.solution.model;

public class SequenceDTO {

	private String orderType;
	private String channelType;

	public SequenceDTO() {

	}

	public SequenceDTO(String orderType, String channelType) {
		super();
		this.orderType = orderType;
		this.channelType = channelType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getChannelType() {
		return channelType;
	}

	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}

}
