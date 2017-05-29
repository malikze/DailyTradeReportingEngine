package com.elinmalikzade.dailytradereportingengine.classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.elinmalikzade.dailytradereportingengine.abstracts.Calculators;

public class Instruction implements Comparable<Instruction> {
	String Entity;
	String BuySell;
	double AgreedFx;
	String Currency;
	Date InstructionDate;
	Date SettlementDate;
	Date ActualSettlementDate;
	long Units;
	double PricePerUnit;
	
	double AmountOfTrade;
	
	public Instruction(String Entity, String BuySell, double AgreedFx, String Currency, String InstructionDate, String SetllementDate,
			long Units, double PricePerUnit) throws Exception {
		
		if(Entity == null || Entity.trim().equals(""))
			throw new IllegalArgumentException("Entity has a wrong value");
		else			
			this.Entity = Entity;
		
		if(BuySell != null && (BuySell.equals("B") || BuySell.equals("S")))
			this.BuySell = BuySell;
		else
			throw new IllegalArgumentException("BuySell has a wrong value");
		
		if(AgreedFx >= 0)
			this.AgreedFx = AgreedFx;
		else
			throw new IllegalArgumentException("AgreedFx has a wrong value");
		
		if(Currency == null || Currency.trim().equals(""))
			throw new IllegalArgumentException("Currency has a wrong value");
		else
			this.Currency = Currency;
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        try {
            this.InstructionDate = formatter.parse(InstructionDate);    
        } catch (NullPointerException | ParseException e) {
            throw new IllegalArgumentException("InstructionDate has a wrong value");
        }
        
        try {
            this.SettlementDate = formatter.parse(SetllementDate);
            this.ActualSettlementDate = this.SettlementDate;
            
            //Check if SettlementDate is a working date, and update if not
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(this.SettlementDate);
        	int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        	
            if(Currency.equals("AED") || Currency.equals("SAR")) {
            	//if SettlementDate is a weekend (i.e. Friday or Saturday), set it to next Sunday
            	if(dayOfWeek == Calendar.FRIDAY) {
            		calendar.setTime(this.SettlementDate);
            		calendar.add(Calendar.DATE, 2);
            		this.ActualSettlementDate = calendar.getTime();
            	} else if (dayOfWeek == Calendar.SATURDAY) {
            		calendar.setTime(this.SettlementDate);
            		calendar.add(Calendar.DATE, 1);
            		this.ActualSettlementDate = calendar.getTime();
            	}
            } else {
            	//if SettlementDate is a weekend (i.e. Saturday or Sunday), set it to next Monday
            	if(dayOfWeek == Calendar.SATURDAY) {
            		calendar.setTime(this.SettlementDate);
            		calendar.add(Calendar.DATE, 2);
            		this.ActualSettlementDate = calendar.getTime();
            	} else if(dayOfWeek == Calendar.SUNDAY) {
            		calendar.setTime(this.SettlementDate);
            		calendar.add(Calendar.DATE, 1);
            		this.ActualSettlementDate = calendar.getTime();
            	}
            }          
        } catch (NullPointerException | ParseException e) {
        	throw new IllegalArgumentException("SettlementDate has a wrong value");
        }
        
        if(Units >= 0)
        	this.Units = Units;
        else
        	throw new IllegalArgumentException("Units has a wrong value");
        
        if(PricePerUnit >= 0)
        	this.PricePerUnit = PricePerUnit;
        else
        	throw new IllegalArgumentException("PricePerUnit has a wrong value");
        
		this.AmountOfTrade = Calculators.calculateAmountOfATrade(this);
	}

	public String getEntity() {
		return Entity;
	}

	public String getBuySell() {
		return BuySell;
	}

	public double getAgreedFx() {
		return AgreedFx;
	}

	public String getCurrency() {
		return Currency;
	}

	public Date getInstructionDate() {
		return InstructionDate;
	}

	public Date getSettlementDate() {
		return SettlementDate;
	}

	public Date getActualSettlementDate() {
		return ActualSettlementDate;
	}
	
	public long getUnits() {
		return Units;
	}

	public double getPricePerUnit() {
		return PricePerUnit;
	}
	
	public double getAmountOfTrade() {
		return AmountOfTrade;
	}
	
	public String toString() {	
		SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
		
		return
		Entity + "\t" +
		BuySell + "\t" +
		AgreedFx + "\t" +
		Currency + "\t" +
		sdf.format(InstructionDate) + "\t" +
		sdf.format(SettlementDate) + "\t" +
		Units + "\t" +
		PricePerUnit + "\t\t" +
		"Amount (USD): " + AmountOfTrade;
	}

	@Override
	public int compareTo(Instruction instruction) {
		//First sort by ActualSettlementDate, then sort by BuySell field (this will group buy and sell instructions within one day to separate groups
		//and finally sort by AmountOfTrade field.
		//Eventually, if we sort an ArrayList of instructions we will have instructions 
		//sorted by ActualSettlementDate from earlier date to later date. Then the list will be sorted by BuySell field, hence for any particular
		//day buy instructions will come before sell instructions. And finally the group of buy instructions and sell instructions for a
		//particular day will be sorted by AmountOfTrade, hence the first buy instruction of the day will be rank 1 outgoing for that day,
		// and the first sell instruction will be rank 1 incoming for that day.
		
		
		if(this.ActualSettlementDate.before(instruction.ActualSettlementDate)) {
			return -1;
		} else {
			if(this.ActualSettlementDate.after(instruction.ActualSettlementDate))
				return 1;
			else {
				if(this.BuySell.equals("B") && instruction.BuySell.equals("S"))
					return -1;
				else if(this.BuySell.equals("S") && instruction.BuySell.equals("B"))
					return 1;
				else {
					if(this.AmountOfTrade > instruction.AmountOfTrade)
						return -1;
					else if(this.AmountOfTrade < instruction.AmountOfTrade)
						return 1;
					else
						return 0;
				}
			}			
		}		
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof Instruction))
			return false;
		else {
			Instruction instruction = (Instruction) object;
			if(this.getEntity().equals(instruction.getEntity()) &&
					this.getBuySell().equals(instruction.getBuySell()) &&
					this.getAgreedFx() == instruction.getAgreedFx() &&
					this.getCurrency().equals(instruction.getCurrency()) &&
					this.getInstructionDate().equals(instruction.getInstructionDate()) &&
					this.getSettlementDate().equals(instruction.getSettlementDate()) &&
					this.getUnits() == instruction.getUnits() &&
					this.getPricePerUnit() == instruction.getPricePerUnit())
				return true;
			else
				return false;			
		}			
	}
	
}
