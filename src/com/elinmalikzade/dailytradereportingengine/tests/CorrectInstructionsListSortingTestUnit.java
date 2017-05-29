package com.elinmalikzade.dailytradereportingengine.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

import com.elinmalikzade.dailytradereportingengine.classes.Instruction;

public class CorrectInstructionsListSortingTestUnit {
	
	
	@Test
	public void testSortBySettlementDateIfTheRestIsEqual() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		ArrayList<Instruction> sortedInstructions = new ArrayList<>();
		try {
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "01 Jan 2016", 200, 90.25));
			
			for(int i = 0; i < instructions.size(); i++) {
				sortedInstructions.add(instructions.get(i));
			}
			
			Collections.sort(sortedInstructions);
			
			assertEquals(sortedInstructions.get(0), instructions.get(1));
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSortByBuySellIfTheRestIsEqual() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		ArrayList<Instruction> sortedInstructions = new ArrayList<>();
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "01 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "01 Jan 2016", 200, 90.25));
			
			for(int i = 0; i < instructions.size(); i++) {
				sortedInstructions.add(instructions.get(i));
			}
			
			Collections.sort(sortedInstructions);
			
			assertEquals(sortedInstructions.get(0), instructions.get(1));		
		} catch(Exception e) {
			fail();
		}
	}
	
	
	@Test
	public void testSortByAmountOfTradeIfTheRestIsEqual() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		ArrayList<Instruction> sortedInstructions = new ArrayList<>();
		try {
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "01 Jan 2016", 100, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "01 Jan 2016", 200, 90.25));
			
			for(int i = 0; i < instructions.size(); i++) {
				sortedInstructions.add(instructions.get(i));
			}
			
			Collections.sort(sortedInstructions);
			
			assertEquals(sortedInstructions.get(0), instructions.get(1));
		} catch(Exception e) {
			fail();
		}
	}
	
	
	@Test
	public void testSortByCurrencyOnFridaySettlementDateIfTheRestIsEqual() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		ArrayList<Instruction> sortedInstructions = new ArrayList<>();
		try {
			//01 Jan 2016 Friday
			instructions.add(new Instruction("foo", "B", 0.50, "AED", "01 Jan 2016", "01 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SAR", "01 Jan 2016", "01 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "01 Jan 2016", 200, 90.25));
			
			for(int i = 0; i < instructions.size(); i++) {
				sortedInstructions.add(instructions.get(i));
			}
			
			Collections.sort(sortedInstructions);
			
			assertEquals(sortedInstructions.get(0), instructions.get(2));
			assertEquals(sortedInstructions.get(1), instructions.get(0));
			assertEquals(sortedInstructions.get(2), instructions.get(1));			
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSortByCurrencyOnSaturdaySettlementDateIfTheRestIsEqual() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		ArrayList<Instruction> sortedInstructions = new ArrayList<>();
		try {
			//02 Jan 2016 Saturday
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "AED", "01 Jan 2016", "02 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SAR", "01 Jan 2016", "02 Jan 2016", 200, 90.25));
			
			for(int i = 0; i < instructions.size(); i++) {
				sortedInstructions.add(instructions.get(i));
			}
			
			Collections.sort(sortedInstructions);
			
			assertEquals(sortedInstructions.get(0), instructions.get(1));
			assertEquals(sortedInstructions.get(1), instructions.get(2));
			assertEquals(sortedInstructions.get(2), instructions.get(0));			
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testSortByCurrencyOnSundaySettlementDateIfTheRestIsEqual() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		ArrayList<Instruction> sortedInstructions = new ArrayList<>();
		try {
			//03 Jan 2016 Sunday
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "03 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "AED", "01 Jan 2016", "03 Jan 2016", 200, 90.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SAR", "01 Jan 2016", "03 Jan 2016", 200, 90.25));
			
			for(int i = 0; i < instructions.size(); i++) {
				sortedInstructions.add(instructions.get(i));
			}
			
			Collections.sort(sortedInstructions);
			
			assertEquals(sortedInstructions.get(0), instructions.get(1));
			assertEquals(sortedInstructions.get(1), instructions.get(2));
			assertEquals(sortedInstructions.get(2), instructions.get(0));
		} catch(Exception e) {
			fail();
		}
	}
}
