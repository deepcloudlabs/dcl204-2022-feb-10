package com.example.service.business;

import com.example.service.Calculator;

public class StandardCalculator implements Calculator {
	private Calculator self;
	
	public void setProxy(Calculator self) {
		this.self = self;
	}

	@Override
	public double add(double x, double y) {
		System.err.println("StandardCalculator::add");
		return x + y;
	}

	@Override
	public double sub(double x, double y) {
		return x - y;
	}

	@Override
	public double mul(double x, double y) {
		double sum = 0;
		for (var i=0.0;i<y;i++)
			sum = self.add(sum,x);
		return sum;
	}

	@Override
	public double div(double x, double y) {
		return x / y;
	}

}
