package com.example.lottery.service.business;

import java.util.List;
import java.util.stream.IntStream;

import com.example.lottery.service.LotteryService;
import com.example.random.service.RandomNumberGenerator;

public class StandardLotteryService implements LotteryService {

	private RandomNumberGenerator randomNumberGenerator;
	
	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return IntStream.generate( () -> randomNumberGenerator.generate(1, max))
				        .distinct()
				        .limit(size)
				        .boxed()
				        .toList();
	}

}
