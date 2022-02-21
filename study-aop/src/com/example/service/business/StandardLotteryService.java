package com.example.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.example.service.LotteryService;

public class StandardLotteryService implements LotteryService {

	@Override
	public List<Integer> draw(int max, int size) {
		return ThreadLocalRandom.current().ints(0, max)
				         .distinct()
				         .limit(size)
				         .sorted()
				         .boxed().toList();
	}

}
