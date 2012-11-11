package com.infosysengr;

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class ChangeMakerSpec {

	private ChangeMaker changeMaker
	
	@Before
	void GIVEN_a_ChangeMaker_instance() {
		changeMaker = new ChangeMaker()
	}
	
	@Test
	void WHEN_change_is_more_than_a_dollar_THEN_ChangeMaker_dispenses_dollar_coins() {
		def coinsToDispense = changeMaker.makeChangeFor(141)
		assert coinsToDispense[4] == 1
	}
	
	@Test
	void WHEN_change_is_less_than_100_cents_THEN_ChangeMaker_does_not_dispense_dollar_coins() {
		def coinsToDispense = changeMaker.makeChangeFor(99)
		assert coinsToDispense[4] == 0
	}
	
	@Test
	void WHEN_change_is_more_than_25_cents_THEN_ChangeMaker_dispenses_quarters() {
		def coinsToDispense = changeMaker.makeChangeFor(26)
		assert coinsToDispense[3] == 1
	}

	@Test
	void WHEN_change_is_less_than_25_cents_THEN_ChangeMaker_does_not_dispense_quarters() {
		def coinsToDispense = changeMaker.makeChangeFor(24)
		assert coinsToDispense[3] == 0
	}
	
}

class ChangeMaker {
	ArrayList makeChangeFor(int amount) {
		def coinsToDispense = [0, 0, 0, 0, 0]
		
		if(amount >= 100) {
		  coinsToDispense[4] = 1
		}
		if(amount >= 25) {
		  coinsToDispense[3] = 1
		}
		return coinsToDispense
	}
}