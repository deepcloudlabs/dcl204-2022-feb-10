package com.example;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StudyMap {

	public static void main(String[] args) {
		// Map: Entry -> (Key,Value)
		//      add -> put, get(key) -> value 
		//      HashMap, LinkedHashMap, TreeMap
		Map<String,Integer> areaCodes = new TreeMap<>(Map.of(
			"istanbul", 212,
			"ankara", 312,
			"istanbul anadolu", 212
		));
		System.out.println(areaCodes.get("ankara"));
		System.out.println(areaCodes);
		// Loop #1 : Key
		for (var city : areaCodes.keySet()) {
			System.out.println(String.format("%16s: %d", city,areaCodes.get(city)));
		}
		// Loop #2 : Value
		for (var code : areaCodes.values()) {
			System.out.println(code);
		}
		// Loop #3 : Entry
		for (Map.Entry<String,Integer> entry : areaCodes.entrySet()) {
			System.out.println(String.format("%16s: %d", entry.getKey(),entry.getValue()));
		}
		// Loop #4 : Functional, Stream API
		areaCodes.forEach((city,code) ->System.out.println(String.format("%16s: %d",city,code)));
		Map<Integer,Long> counts = areaCodes.values().stream()
		                  .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		counts.forEach((value,count)->System.out.println(value+": "+count));
	}

}
