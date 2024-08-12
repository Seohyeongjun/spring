package com.example.bookTest.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoffeDto {

	private int coffeId;
	private String coffeTitle;
	private int coffePrice;
	private int coffeDecaffeine;
	public int getCoffeId() {
		return coffeId;
	}
	public void setCoffeId(int coffeId) {
		this.coffeId = coffeId;
	}
	public String getCoffeTitle() {
		return coffeTitle;
	}
	public void setCoffeTitle(String coffeTitle) {
		this.coffeTitle = coffeTitle;
	}
	public int getCoffePrice() {
		return coffePrice;
	}
	public void setCoffePrice(int coffePrice) {
		this.coffePrice = coffePrice;
	}
	public int getCoffeDecaffeine() {
		return coffeDecaffeine;
	}
	public void setCoffeDecaffeine(int coffeDecaffeine) {
		this.coffeDecaffeine = coffeDecaffeine;
	}
}
