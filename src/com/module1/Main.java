package com.module1;

public class Main {
//	public static boolean isPrime(int n) {
//		for(int i = 2; i <= Math.sqrt(n); i++) {
//			if(n % i == 0) {
//				return false;
//			}
//		}
//		
//		return true;
//	}
//	private static void primeFactor() {
//		int n = 10;
//		
//		int i;
//		for(i = 1; n > 0; i++) {
//			if(factor(i)) {
//				System.out.print(i + " ");
//				n--;
//			}
//		}
//		
//		System.out.print("\n"+(i-1));
//	}
//	private static boolean factor(int n) {
//		if(n < 7) {
//			return true;
//		}
//		if(isPrime(n)) {
//			return false;
//		}
//		for(int i = 7; i <= n/2; i++) {
//			if(isPrime(i) && n%i==0) {
//				return false;
//			}
//		}
//		return true;
//	}

	public static void main(String[] args) {
//		primeFactor();
//		primeFactor1();
		
	}
//
//	private static void primeFactor1() {
//		int n = 14;
//		int count = helper(n, 0);
//		System.out.println(count);
//	}
//
//	private static int helper(int n, int i) {
//		if(n < 7) {
//			return n+i;
//		}
//				
//		if(isPrime(i)) {
//			return helper(n, i+1);
//		}
//		
//		for(int j = 7; j <= i/2; j++) {
//			if(i%j == 0 && isPrime(j)) {
//				return helper(n, i+1);
//			}
//		}
//		
//		return helper(n-1, i+1)+1;
//	}

}
