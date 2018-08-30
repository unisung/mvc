package com.member.model;

import java.sql.Date;

public class MemberBean {
	 private String member_id;
	 private String member_pass;
	 private String member_name;
	 private String member_nickname;
	 private String member_zip1;
	 private String member_zip2;
	 private String member_addr1;
	 private String member_addr2;
	 private String member_profilename;
	 private Date member_regdate;
	 private int member_state;
	 private String member_delcont;
	 private Date member_deldate;
	 
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pass() {
		return member_pass;
	}
	public void setMember_pass(String member_pass) {
		this.member_pass = member_pass;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_nickname() {
		return member_nickname;
	}
	public void setMember_nickname(String member_nickname) {
		this.member_nickname = member_nickname;
	}
	public String getMember_zip1() {
		return member_zip1;
	}
	public void setMember_zip1(String member_zip1) {
		this.member_zip1 = member_zip1;
	}
	public String getMember_zip2() {
		return member_zip2;
	}
	public void setMember_zip2(String member_zip2) {
		this.member_zip2 = member_zip2;
	}
	public String getMember_addr1() {
		return member_addr1;
	}
	public void setMember_addr1(String member_addr1) {
		this.member_addr1 = member_addr1;
	}
	public String getMember_addr2() {
		return member_addr2;
	}
	public void setMember_addr2(String member_addr2) {
		this.member_addr2 = member_addr2;
	}
	public String getMember_profilename() {
		return member_profilename;
	}
	public void setMember_profilename(String member_profilename) {
		this.member_profilename = member_profilename;
	}
	public Date getMember_regdate() {
		return member_regdate;
	}
	public void setMember_regdate(Date member_regdate) {
		this.member_regdate = member_regdate;
	}
	public int getMember_state() {
		return member_state;
	}
	public void setMember_state(int member_state) {
		this.member_state = member_state;
	}
	public String getMember_delcont() {
		return member_delcont;
	}
	public void setMember_delcont(String member_delcont) {
		this.member_delcont = member_delcont;
	}
	public Date getMember_deldate() {
		return member_deldate;
	}
	public void setMember_deldate(Date member_deldate) {
		this.member_deldate = member_deldate;
	}
	 
	 

}
