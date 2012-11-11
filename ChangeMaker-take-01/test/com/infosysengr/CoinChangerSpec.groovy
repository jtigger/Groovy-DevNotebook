package com.infosysengr

import static org.junit.Assert.*

import org.junit.Test
import org.junit.Before

class CoinChangerSpec {	
	private changeMaker
	
	@Before
	void GIVEN_a_ChangeMaker_instance() {
		changeMaker = new ChangeMaker()
	}
	
	@Test
	void WHEN_there_is_less_than_five_cents_left_THEN_ChangeMaker_gives_pennies() {
		def coinsToDispense = changeMaker.makeChangeFor(4)
		assert coinsToDispense[Coin.penny.ordinal()] == 4
	}
	
	@Test
	void WHEN_there_is_less_than_ten_cents_left_THEN_ChangeMaker_gives_nickles() {
		def coinsToDispense = changeMaker.makeChangeFor(9)
		assert coinsToDispense[Coin.nickel.ordinal()] == 1
	}
	
	@Test
	void WHEN_there_is_less_than_twenty_five_cents_left_THEN_ChangeMaker_gives_dimes() {
		def coinsToDispense = changeMaker.makeChangeFor(24)
		assert coinsToDispense[Coin.dime.ordinal()] == 2
	}
	
	@Test
	void WHEN_there_is_less_than_a_dollar_left_THEN_ChangeMaker_gives_quarters() {
		def coinsToDispense = changeMaker.makeChangeFor(99)
		assert coinsToDispense[Coin.quarter.ordinal()] == 3
	}

	@Test
	void WHEN_there_is_a_dollar_or_more_THEN_ChangeMaker_gives_dollar_coins() {
		def coinsToDispense = changeMaker.makeChangeFor(240)
		assert coinsToDispense[Coin.dollar.ordinal()] == 2
	}
	
	@Test
	void EXAMPLE_40_cents_is_1_nickel_1_dime_and_1_quarter() {
		def coinsToDispense = changeMaker.makeChangeFor(40)
		assert coinsToDispense == [0,1,1,1,0]
	}
	
	@Test
	void EXAMPLE_141_cents_is_1_of_each_coin() {
		def coinsToDispense = changeMaker.makeChangeFor(141)
		assert coinsToDispense == [1,1,1,1,1]
	}

}