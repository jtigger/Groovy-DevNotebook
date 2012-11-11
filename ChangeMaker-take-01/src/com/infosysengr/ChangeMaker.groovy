package com.infosysengr

import java.util.ArrayList;

class ChangeMaker {
	ArrayList makeChangeFor(int changeLeft) {
		def coinsToDispenseOut = new int[Coin.values().size()]

		Coin.values().reverse().each() { coin ->
			if(changeLeft >= coin.value()) {
				coinsToDispenseOut[coin.ordinal()] = coin.isIn(changeLeft)
				changeLeft -= coin.value() * coin.isIn(changeLeft)
			}
		}        
		
		return coinsToDispenseOut
	}
}