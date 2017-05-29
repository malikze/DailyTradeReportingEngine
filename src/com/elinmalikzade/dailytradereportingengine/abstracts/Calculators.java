package com.elinmalikzade.dailytradereportingengine.abstracts;

import com.elinmalikzade.dailytradereportingengine.classes.Instruction;

public abstract class Calculators {

	public static double calculateAmountOfATrade(Instruction instruction) {
		//if the logic of this calculator method changes in future, no need to modify any other class apart from this method
		return instruction.getPricePerUnit() * instruction.getUnits() * instruction.getAgreedFx();
	}
	
}
