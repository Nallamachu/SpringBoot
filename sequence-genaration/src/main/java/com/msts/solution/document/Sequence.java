package com.msts.solution.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "sequence")
public class Sequence {

	@Id
	private String _id;
	private String orderType;
	private String channelType;
	private Number sequence;

	public Sequence() {

	}

	public Sequence(String _id, String orderType, String channelType, Number sequence) {
		super();
		this._id = _id;
		this.orderType = orderType;
		this.channelType = channelType;
		this.sequence = sequence;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
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

	public Number getSequence() {
		return sequence;
	}

	public void setSequence(Number sequence) {
		this.sequence = sequence;
	}

}
