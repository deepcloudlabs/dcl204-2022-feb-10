package com.example;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Locale;

public class CompareExercise6 {

	public static void main(String[] args) throws ParseException {
		String name1 = "müller";
		String name2 = "mueller";
//		System.out.println(name1==name2);
		System.out.println(name1.equals(name2));
		
		String name3 = "şule";
		String name4 = "schule";
//		System.out.println(name3==name4);
		System.out.println(name3.equals(name4));
		
		String name5 = "şima";
		String name6 = "shema";
//		System.out.println(name5==name6);
		System.out.println(name5.equals(name6));
		
		// Collation
		String basicRules=  "< a < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < z ";	
		String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
                "& c ; ç & o ; ö & ğ ; g & ü ; ue" ;
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(new Locale("tr","TR"));
		collator.setStrength(Collator.PRIMARY);		
		System.out.println(collator.equals(name1,name2));
		System.out.println(collator.equals(name3,name4));
		System.out.println(collator.equals(name5,name6));
	}

}
