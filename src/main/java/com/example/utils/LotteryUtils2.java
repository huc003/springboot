package com.example.utils;

import java.util.Arrays;
import java.util.Random;


public class LotteryUtils2 {
	
	public static int[] redList = new int[33];
	public static int[] blueList = new int[16];
	
	public String getRed(){
//		for (int i = 0; i < 33; i++) {
//			int r = initRed();
//			for (int j = 0; j < redList.length; j++) {
//				if(r==redList[j]){
//					r = initRed();
//				}
//			}
//			redList[i] = r;
//		}
		initRed();
		return Arrays.toString(redList);
	}
	
	//随机初始化红色球
	public int initRed(){
		int r = new Random().nextInt(33);
		
		
		
		
//		for (int i = redList.length; i > 33; i--) {
//			int r = new Random().nextInt(33);
//			for (int j = 0; j < 33; j++) {
//				if(redList.length>0){
//					if(r==redList[j]){
//						r = initRed();
//					}
//				}
//			}
//			redList[i] = r; 
//		}
		
		return 0;
	}
	
	public String getBlue(){
		
		return "";
	}
	
	public static void main(String[] args) {
		LotteryUtils2 lottery = new LotteryUtils2();
		System.out.println(lottery.getRed());
	}
}
