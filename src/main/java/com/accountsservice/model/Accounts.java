package com.accountsservice.model;

public class Accounts {
	
	private Long id;
	private String number;
	private String name;	
	private Boolean creditcard;
	private Boolean synthetic;
	private Double balance;
	
	public Accounts() {

    }

    public Accounts(Long id, String number, String name, Boolean creditcard, Boolean synthetic, Double balance) {
        this.id = id;
        this.number = number;
        this.name = name;
        this.creditcard = creditcard;
        this.synthetic = synthetic;
        this.balance = balance;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Boolean getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(Boolean creditcard) {
		this.creditcard = creditcard;
	}

	public Boolean getSynthetic() {
		return synthetic;
	}

	public void setSynthetic(Boolean synthetic) {
		this.synthetic = synthetic;
	}

}
