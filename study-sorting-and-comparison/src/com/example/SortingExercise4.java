package com.example;

import java.text.Collator;
import java.text.ParseException;
import java.text.RuleBasedCollator;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SortingExercise4 {

	public static void main(String[] args) throws ParseException {
		String basicRules=  "< z < b < c < ç < d < e < f < g < ğ < h "+
		        "< ı < i < j < k < l < m < n < o < ö < p "+
		       "< r < s < ş < t < u < ü < v < y < a ";	
		String trExpension= "& şi ; she & ş ; sch & s ; ş & u ; ü & i ; ı " + 
                "& c ; ç & o ; ö & ğ ; g & ü ; ue" ;
		final Collator collator= new RuleBasedCollator(basicRules + trExpension);
		Collator.getInstance(new Locale("tr","TR"));
		collator.setStrength(Collator.PRIMARY);				
		
		List<String> names= List.of(
			"şule",
			"şima",
			"ayşegül",
			"ali",
			"zehra",
			"mehmet",
			"sema"	
		);
		System.out.println(collator.compare("şima", "shema"));
		System.out.println(collator.compare("ali", "veli"));
		System.out.println(collator.compare("şule", "şima"));
		System.out.println(collator.equals("şima", "shema"));
		System.out.println(names);
		Comparator<String> dictionaryOrder =  collator::compare;
	    var sortedNames = names.stream().sorted(dictionaryOrder).toList();
		System.out.println(sortedNames);
	}

}
