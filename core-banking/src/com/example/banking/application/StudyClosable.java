package com.example.banking.application;

import java.io.Closeable;
import java.io.IOException;

public class StudyClosable {

	public static void main(String[] args) {
		var res1 = new PreciousResource(1);
		var res2 = new PreciousResource(2);
		var res3 = new PreciousResource(3);
		var res4 = new PreciousResource(4);
		System.err.println(res3 instanceof AutoCloseable);
		try {
			System.err.println("Hello Mars!");
		} finally {
			try {
				res1.close();
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} finally {
				try {
					res2.close();
				} catch (IOException e) {
					System.err.println(e.getMessage());
				} finally {
					try {
						res3.close();
					} catch (IOException e) {
						System.err.println(e.getMessage());
					} finally {
						try {
							res4.close();
						} catch (IOException e) {
							System.err.println(e.getMessage());
						}
					}
				}
			}
		}
	}

}

class PreciousResource implements Closeable {
	private final int id;

	public PreciousResource(int id) {
		this.id = id;
	}

	@Override
	public void close() throws IOException {
		System.err.println("Closing the resource " + id);
		throw new IllegalStateException("Opps " + id);
	}
}
