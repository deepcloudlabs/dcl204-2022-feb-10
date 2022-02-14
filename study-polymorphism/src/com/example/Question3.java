package com.example;

class A {
	public int x;

	public A(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}
}

class B extends A {
	public int x;

	public B(int x) {
		super(3 * x);
		this.x = x;
	}

	public int getX() {
		return x;
	}
}

class C extends B {
	public int x;

	public C(int x) {
		super(2 * x);
		this.x = x;
	}

	@Override
	public int getX() {
		return x + super.getX();
	}
}

@SuppressWarnings("unused")
public class Question3 {
	public static void main(String[] args) {
		C c = new C(2);
		A a = c;
		B b = c;
		A a1 = new B(42);
		C c1 = (C) a1;
		System.out.println(a.x);
		System.out.println(b.x);
		System.out.println(c.x);
		System.out.println(((A) c).x);
		System.out.println(((B) c).x);
		System.out.println(((A) b).x);
		System.out.println(a.getX());
		System.out.println(b.getX());
		System.out.println(c.getX());
		System.out.println(((A) c).getX());
		System.out.println(((B) c).getX());
		System.out.println(((A) b).getX());
	}
}
