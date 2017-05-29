package com.elinmalikzade.dailytradereportingengine;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import com.elinmalikzade.dailytradereportingengine.classes.Instruction;

public class DailyTradeReportingEngine {	
	
	static ArrayList<Instruction> instructions = new ArrayList<>();
	
	public static void main(String[] args) {
		
		//Populate array of instructions
		try {
			instructions.add(new Instruction("foo", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 200, 100.25));
			instructions.add(new Instruction("abc", "S", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 300, 100.25));
			instructions.add(new Instruction("xyz", "B", 0.50, "SGP", "01 Jan 2016", "02 Jan 2016", 300, 100.25));
			instructions.add(new Instruction("bar", "S", 0.22, "AED", "05 Jan 2016", "07 Jan 2016", 450, 150.50));
			//...add more
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		
		Collections.sort(instructions);		
		printSortedListOfIntructions();		
	}
	
	public static void printSortedListOfIntructions() {
		SimpleDateFormat sdf = new SimpleDateFormat("EEE, dd MMM yyyy");
		Date tempDate = new Date(Long.MIN_VALUE);		
		String tempBuySell = "";
		
		int rank = 0;
		for(int i = 0; i < instructions.size(); i++) {
			if(instructions.get(i).getSettlementDate().after(tempDate)) {
				tempDate = instructions.get(i).getSettlementDate();
				System.out.println();
				System.out.println("================================================================================================================================");
				System.out.println();
				System.out.println(sdf.format(instructions.get(i).getActualSettlementDate()));
				System.out.println();
				
				if(instructions.get(i).getBuySell().equals("B")) {
					System.out.println("Incoming:");			
					tempBuySell = "B";
					rank = 1;
				} else {
					System.out.println("Outgoing:");
					tempBuySell = "S";
					rank = 1;
				}
			}			
			
			if(!instructions.get(i).getBuySell().equals(tempBuySell)) {
				if(instructions.get(i).getBuySell().equals("B")) {
					System.out.println();
					System.out.println("Incoming:");			
					tempBuySell = "B";
					rank = 1;
				} else {
					System.out.println();
					System.out.println("Outgoing:");
					tempBuySell = "S";
					rank = 1;
				}
			}
			
			System.out.println("rank " + rank + ":\t\t" + instructions.get(i).toString());
			rank++;
		}
	}
}
