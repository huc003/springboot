package com.example.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class LotteryUtils {
	
	public static void main(String[] args) {
		chromosphere();
//		lotto();
	}
	
	public static void chromosphere(){
		for (int n = 0; n < 10; n++) {
			List<Integer> blue = new ArrayList<Integer>();
			List<Integer> red = new ArrayList<Integer>();
			for (int i = 1; i <= 33; i++) {
				blue.add(i);
			}
			for (int i = 1; i <= 16; i++) {
				red.add(i);
			}
//			System.out.println(blue);
//			System.out.println(red);
			StringBuffer sb = new StringBuffer("红：");
			for (int i = 0; i < 6; i++) {
				int r = new Random().nextInt(blue.size());
				int b = blue.get(r);
				sb.append(b+" ");
				blue.remove(r);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			sb.append("蓝：");
			for (int i = 0; i < 1; i++) {
				int r = new Random().nextInt(red.size());
				int b = red.get(r);
				sb.append(b);
				red.remove(r);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(sb.toString());
		}
	}
	
	public static void lotto(){
		for (int n = 0; n < 5; n++) {
			List<Integer> blue = new ArrayList<Integer>();
			List<Integer> red = new ArrayList<Integer>();
			for (int i = 1; i <= 35; i++) {
				blue.add(i);
			}
			for (int i = 1; i <= 12; i++) {
				red.add(i);
			}
//			System.out.println(blue);
//			System.out.println(red);
			StringBuffer sb = new StringBuffer("红：");
			for (int i = 0; i < 5; i++) {
				int r = new Random().nextInt(blue.size());
				int b = blue.get(r);
				sb.append(b+" ");
				blue.remove(r);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			sb.append("蓝：");
			for (int i = 0; i < 2; i++) {
				int r = new Random().nextInt(red.size());
				int b = red.get(r);
				sb.append(b+" ");
				red.remove(r);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(sb.toString());
		}
	}
}
