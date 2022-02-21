package com.example.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilingAspect implements InvocationHandler {
	private Object target;

	public ProfilingAspect(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// Cross-cutting Concern: Profiling
		var start = System.nanoTime();
		var result = method.invoke(target, args);
		var stop = System.nanoTime();
		System.err.println(String.format("%s runs %8d ns.", method.getName(),(stop-start)));
		return result;
	}

}
