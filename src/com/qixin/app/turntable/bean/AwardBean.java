package com.qixin.app.turntable.bean;

import java.io.Serializable;

public class AwardBean implements Serializable {
	    private int id;
	    private int min;
	    private int max;
	    private int isPrize;
	    private String name;
	    private String prompt;
	    private int v;
	    private int num; 
	    private String giftid;
	    private String giftName;
	    
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		public int getIsPrize() {
			return isPrize;
		}
		public void setIsPrize(int isPrize) {
			this.isPrize = isPrize;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPrompt() {
			return prompt;
		}
		public void setPrompt(String prompt) {
			this.prompt = prompt;
		}
		public int getV() {
			return v;
		}
		public void setV(int v) {
			this.v = v;
		}
		public int getNum() {
			return num;
		}
		public void setNum(int num) {
			this.num = num;
		}
		public String getGiftid() {
			return giftid;
		}
		public void setGiftid(String giftid) {
			this.giftid = giftid;
		}
		public String getGiftName() {
			return giftName;
		}
		public void setGiftName(String giftName) {
			this.giftName = giftName;
		}
	    
}
