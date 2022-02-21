package com.example.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CachingAspect implements InvocationHandler {
	private Object target;
	private Map<Method,Map<Integer,Object>> caches = new HashMap<>();
	
	public CachingAspect(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// Cross-cutting Concern: Caching -> Object Pooling
		Map<Integer,Object> methodCache = caches.get(method);
		if (Objects.isNull(methodCache)) {
			methodCache = new HashMap<Integer,Object>();
			caches.put(method, methodCache);
		}
		int hash = Objects.hash(args);
		Object result = methodCache.get(hash);
		if (Objects.isNull(result)) {
			result = method.invoke(target, args);
			methodCache.put(hash, result);
		}
		return result;
	}

}
