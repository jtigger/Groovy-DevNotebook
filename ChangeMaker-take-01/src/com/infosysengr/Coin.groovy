package com.infosysengr

import java.util.concurrent.ConcurrentHashMap.Values;

enum Coin {
    penny(1), nickel(5), dime(10), quarter(25), dollar(100)
    Coin(int value) { this.value = value }
    private final int value
    public int value() { return value }
	public int isIn(int totalAmount) {
		return (int) totalAmount / value
	}
}