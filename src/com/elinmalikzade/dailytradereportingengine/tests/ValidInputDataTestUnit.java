package com.elinmalikzade.dailytradereportingengine.tests;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.junit.Test;

import com.elinmalikzade.dailytradereportingengine.classes.Instruction;

public class ValidInputDataTestUnit {

	@Test
	public void testValidEntityValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "Entity has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testNullEntityValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction(null, "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Entity has a wrong value");
		} catch(Exception e) {
			fail();
		}	
	}
	
	@Test
	public void testEmptyStringEntityValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Entity has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidBuySellValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("foo", "B", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "Entity has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testNullBuySellValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", null, 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "BuySell has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testEmptyStringBuySellValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "BuySell has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testInvalidBuySellValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "X", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "BuySell has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testPositiveAgreedFxValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "AgreedFx has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testZeroAgreedFxValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "AgreedFx has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testNegativeAgreedFxValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", -0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "AgreedFx has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidInstructionDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "InstructionDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testInvalidInstructionDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01/01/2016", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "InstructionDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testNullInstructionDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", null, "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "InstructionDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testEmptyStringInstructionDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "", "02 Jan 2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "InstructionDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testValidSettlementDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "SettlementDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testInvalidSettlementDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02/01/2016", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "SettlementDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testNullSettlementDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", null, 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "SettlementDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testEmptyStringSettlementDateValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "", 200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "SettlementDate has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testPositiveUnitsValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "Units has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testZeroUnitsValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 0, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "Units has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testNegativeUnitsValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", -200, 100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "Units has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testPositivePricePerUnitValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "PricePerUnit has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testZeroPricePerUnitValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 0, 0));			
		} catch(IllegalArgumentException e) {
			assertNotEquals(e.getMessage(), "PricePerUnit has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testNegativePricePerUnitValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, -100.25));
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "PricePerUnit has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testActualSettlementDate() {
		ArrayList<Instruction> instructions = new ArrayList<>();
		try {
			//01 Jan 2016 - Friday
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "01 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("bar", "S", 0.50, "AED", "01 Jan 2016", "01 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("xyz", "S", 0.50, "SAR", "01 Jan 2016", "01 Jan 2016", 200, 100.25));
			
			//02 Jan 2016 - Saturday
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("bar", "S", 0.50, "AED", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("xyz", "S", 0.50, "SAR", "01 Jan 2016", "02 Jan 2016", 200, 100.25));

			//03 Jan 2016 - Sunday
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "03 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("bar", "S", 0.50, "AED", "01 Jan 2016", "03 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("xyz", "S", 0.50, "SAR", "01 Jan 2016", "03 Jan 2016", 200, 100.25));
			
			//04 Jan 2016 - Monday
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "04 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("bar", "S", 0.50, "AED", "01 Jan 2016", "04 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("xyz", "S", 0.50, "SAR", "01 Jan 2016", "04 Jan 2016", 200, 100.25));
			
			//05 Jan 2016 - Tuesday
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "05 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("bar", "S", 0.50, "AED", "01 Jan 2016", "05 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("xyz", "S", 0.50, "SAR", "01 Jan 2016", "05 Jan 2016", 200, 100.25));
			
			//05 Jan 2016 - Wednesday
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "06 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("bar", "S", 0.50, "AED", "01 Jan 2016", "06 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("xyz", "S", 0.50, "SAR", "01 Jan 2016", "06 Jan 2016", 200, 100.25));
			
			//05 Jan 2016 - Thursday
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "07 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("bar", "S", 0.50, "AED", "01 Jan 2016", "07 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("xyz", "S", 0.50, "SAR", "01 Jan 2016", "07 Jan 2016", 200, 100.25));
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
			assertEquals(sdf.format(instructions.get(0).getActualSettlementDate()), "01 Jan 2016");
			assertEquals(sdf.format(instructions.get(1).getActualSettlementDate()), "03 Jan 2016");
			assertEquals(sdf.format(instructions.get(2).getActualSettlementDate()), "03 Jan 2016");
			
			assertEquals(sdf.format(instructions.get(3).getActualSettlementDate()), "04 Jan 2016");
			assertEquals(sdf.format(instructions.get(4).getActualSettlementDate()), "03 Jan 2016");
			assertEquals(sdf.format(instructions.get(5).getActualSettlementDate()), "03 Jan 2016");
			
			assertEquals(sdf.format(instructions.get(6).getActualSettlementDate()), "04 Jan 2016");
			assertEquals(sdf.format(instructions.get(7).getActualSettlementDate()), "03 Jan 2016");
			assertEquals(sdf.format(instructions.get(8).getActualSettlementDate()), "03 Jan 2016");
			
			assertEquals(sdf.format(instructions.get(9).getActualSettlementDate()), "04 Jan 2016");
			assertEquals(sdf.format(instructions.get(10).getActualSettlementDate()), "04 Jan 2016");
			assertEquals(sdf.format(instructions.get(11).getActualSettlementDate()), "04 Jan 2016");
			
			assertEquals(sdf.format(instructions.get(12).getActualSettlementDate()), "05 Jan 2016");
			assertEquals(sdf.format(instructions.get(13).getActualSettlementDate()), "05 Jan 2016");
			assertEquals(sdf.format(instructions.get(14).getActualSettlementDate()), "05 Jan 2016");
			
			assertEquals(sdf.format(instructions.get(15).getActualSettlementDate()), "06 Jan 2016");
			assertEquals(sdf.format(instructions.get(16).getActualSettlementDate()), "06 Jan 2016");
			assertEquals(sdf.format(instructions.get(17).getActualSettlementDate()), "06 Jan 2016");
			
			assertEquals(sdf.format(instructions.get(18).getActualSettlementDate()), "07 Jan 2016");
			assertEquals(sdf.format(instructions.get(19).getActualSettlementDate()), "07 Jan 2016");
			assertEquals(sdf.format(instructions.get(20).getActualSettlementDate()), "07 Jan 2016");
		} catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void testAmountOfTradeValue() {
		ArrayList<Instruction> instructions = new ArrayList<>();		
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));			
			assertEquals(instructions.get(0).getAmountOfTrade(), 10025, 0);
		} catch(IllegalArgumentException e) {
			assertEquals(e.getMessage(), "PricePerUnit has a wrong value");
		} catch(Exception e) {
			fail();
		}
	}
	
}
