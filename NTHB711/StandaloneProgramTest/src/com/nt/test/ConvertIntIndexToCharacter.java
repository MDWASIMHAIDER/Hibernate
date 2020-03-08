package com.nt.test;

public class ConvertIntIndexToCharacter {

	
	public static void main(String[] args) {
		//first program
/*		 Character[] ch=new Character[12];
		 String s="pq2w1";
		 int lastindex=0;
		 String finalvalue = "";
		
		for(int i=0;i<s.length();i++) {
			ch[i]=s.charAt(i);
		}
		
		for(int i=0;i<s.length();i++) {
		 if(Character.isLetter(ch[i])) {
				lastindex=(int)ch[i];
				//System.out.println(lastindex+" isletter "+ch[i]);
			}
		 else if(Character.isDigit(ch[i])) {
				System.out.println("isdidgit "+ch[i]);
				int a=0;
			    a=ch[i];
			    //int digit = (int)ch[i] - (int)'0';//both working same
			    int digit = Integer.parseInt(String.valueOf(ch[i]));//working same
				System.out.println(a+"aaaaaaaa"+ch[i]);
				int test=lastindex+ch[i];
				ch[i]=(char)(lastindex+digit);
				//System.out.println(lastindex+"========="+ch[i]+" ,,,,,,"+test);
			}
			
		}
		for(int i=0;i<s.length();i++) {
			finalvalue+=ch[i];
			System.out.println(ch[i]);
		}
		System.out.println(finalvalue+"  finallllllllllllllll");*/
		//==========================================================
		//Second program
		String s="a4d2v2g5";
		char lastindex=' ';
		String finalchar="";
		char[] ch=new char[10];
		for(int i=0;i<s.length();i++) {
			ch[i]=s.charAt(i);
		}
		for(int i=0;i<s.length();i++) {
			 if(Character.isLetter(ch[i])) {
					lastindex=ch[i];
					//System.out.println(lastindex+" isletter "+ch[i]);
				}
			 else if(Character.isDigit(ch[i])) {
					//System.out.println("isdidgit "+ch[i]);
					int a=0;
				    a=ch[i];
				    //int digit = (int)ch[i] - (int)'0';//both working same
				    int digit = Integer.parseInt(String.valueOf(ch[i]));//working same
					//System.out.println(a+"aaaaaaaa"+ch[i]);
				    System.out.println(digit);
					for(int k=0;k<digit;k++) {
					 finalchar+=lastindex;
					//ch[i]=(char)(lastindex+digit);
					}
					//System.out.println(lastindex+"========="+ch[i]+" ,,,,,,"+test);
				}
				
			}
		System.out.println(finalchar);
	}
}
