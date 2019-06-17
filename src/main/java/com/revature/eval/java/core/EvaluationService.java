package com.revature.eval.java.core;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.revature.designpatterns.Car;
import com.revature.designpatterns.Driver;
import com.revature.designpatterns.Truck;

public class EvaluationService {

	/**
	 * 1. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		String acronym = "";
		Boolean NextAdd = false;
		for(int i=0;i<phrase.length();i++) {
			if(i==0) {
				acronym = acronym + phrase.charAt(i);
			}
			if(NextAdd == true) {
				acronym = acronym + phrase.charAt(i);
				NextAdd = false;
			}
			if(phrase.charAt(i)==' '||phrase.charAt(i)=='-') {
				NextAdd = true;
			}

		}
		String cleanedAcronym = acronym.toUpperCase();
		return cleanedAcronym;
	}

	/**
	 * 2. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {
		int score = 0;
		String lowercase = string.toLowerCase();
		for(int i=0;i<lowercase.length();i++) {
			if(lowercase.charAt(i)=='a'||lowercase.charAt(i)=='e'||lowercase.charAt(i)=='i'||lowercase.charAt(i)=='o'||lowercase.charAt(i)=='u'||lowercase.charAt(i)=='l'||lowercase.charAt(i)=='n'||lowercase.charAt(i)=='r'||lowercase.charAt(i)=='s'||lowercase.charAt(i)=='t') {
				score = score + 1;
			}
			if(lowercase.charAt(i)=='d'||lowercase.charAt(i)=='g') {
				score = score + 2;
			}
			if(lowercase.charAt(i)=='b'||lowercase.charAt(i)=='c'||lowercase.charAt(i)=='m'||lowercase.charAt(i)=='p') {
				score = score + 3;
			}
			if(lowercase.charAt(i)=='f'||lowercase.charAt(i)=='h'||lowercase.charAt(i)=='v'||lowercase.charAt(i)=='w'||lowercase.charAt(i)=='y') {
				score = score + 4;
			}
			if(lowercase.charAt(i)=='k') {
				score = score + 5;
			}
			if(lowercase.charAt(i)=='j'||lowercase.charAt(i)=='x') {
				score = score + 8;
			}
			if(lowercase.charAt(i)=='q'||lowercase.charAt(i)=='z') {
				score = score + 10;
			}
		}
		return score;
	}

	/**
	 * 3. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String phonenumber = "";
		for(int i=0;i<string.length();i++) {
			if (string.charAt(i)=='0'||string.charAt(i)=='1'||string.charAt(i)=='2'||string.charAt(i)=='3'||string.charAt(i)=='4'||string.charAt(i)=='5'||string.charAt(i)=='6'||string.charAt(i)=='7'||string.charAt(i)=='8'||string.charAt(i)=='9') {
				phonenumber = phonenumber + string.charAt(i);
			}
		}
		if (phonenumber.length()>11) {
			throw new IllegalArgumentException();
		}
		if (phonenumber.length()==11 && phonenumber.charAt(0)!=1) {
			throw new IllegalArgumentException();
		}
		if (phonenumber.length()<10) {
			throw new IllegalArgumentException();
		}
		return phonenumber;
	}

	/**
	 * 4. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		
		Map<String, Integer> actualWordCount = new HashMap<>();
		
		String[] stringArray;
		
		if ( string.contains(" ")==true) {
			stringArray = string.split(" ");
		}
		else if ( string.contains(",")==true && string.contains("\n")==true) {
			stringArray = string.split(",\n");
		}
		else if ( string.contains(",")==true) {
			stringArray = string.split(",");
		}
		else {
			stringArray = string.split(" ");
		}
		
		for(int i=0;i<stringArray.length;i++) {
			int value = 0;
			for(int j=0;j<stringArray.length;j++) {
				if (stringArray[j].equals(stringArray[i])) {
					value = value+1;
				}
			}
			actualWordCount.put(stringArray[i], value);
		}
		
		return actualWordCount;
	}

	/**
	 * 5. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T> {
		private List<T> sortedList;
		
		int indexbefore;
		int indexcurrent;
		int changethis;
		public int indexOf(T t) {
//			String[] stringArray = sortedList.toArray(new String[sortedList.size()]);
//			System.out.println(Arrays.toString(stringArray));
			int size = sortedList.size();
		    int [] intArray = new int [size];
		    for(int i=0; i<size; i++) {
		    	if(sortedList.get(i) instanceof String){
		    		intArray[i] = Integer.parseInt((String) sortedList.get(i));
		    	}
		    	else {
		    		intArray[i] =(int) sortedList.get(i);
		    	}
		    }
		    int number = 2;
		    changethis = (int) Math.ceil(intArray.length/2);
			indexcurrent = (int) Math.ceil(intArray.length/2);
			int tint = 0;
			if (t instanceof String) {
				tint = Integer.parseInt((String)t);
			}else {
				tint = (int) t;
			}
			while(tint!=intArray[indexcurrent]) {
				if(tint > (int) intArray[indexcurrent]) {
					indexbefore = changethis;
					number = number*2;
					indexcurrent = indexcurrent + (int) Math.ceil( (double) intArray.length/ (double) number);
				}
				if(tint < (int) intArray[indexcurrent]){
					indexbefore = changethis;
					number = number*2;
					indexcurrent = indexcurrent - (int) Math.ceil((double) intArray.length/ (double) number);
				}
			}
			return indexcurrent;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

	}

	/**
	 * 6. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {
		String string = String.valueOf(input);
		int length = string.length();
		int total = 0;
		Boolean passed;
		for(int i=0;i<length;i++) {
			char number = string.charAt(i);
			int a=Character.getNumericValue(number);
			total= (int) (total + Math.pow(a, length));
		}
		if(input==total) {
			passed = true;
		}else {
			passed = false;
		}
		return passed;
	}

	/**
	 * 7. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		long[] factors = new long[20];
		int incriment = 0;
		for(long i=2;i<l;i++) {
			if(l%i==0) {
				factors[incriment]=i;
				++incriment;
			}else {
				//do nothing
			}
		}
		if(l == 2L) {
			factors[0]=2L;
		}
		long[] primefactors = new long[20];
		int number=0;
		int counter=0;
		while(factors[number]!=0) {
			Boolean add = true;
			for(long i=2;i<factors[number];i++) {
				if(factors[number]%i==0) {
					add = false;
				}else {
					//do nothing
				}
			}
			if(add==true) {
				primefactors[counter]=factors[number];
				++counter;
			}else {
				//do nothing
			}
			++number;
		}
		counter = 0;
		while(primefactors[counter]!=0) {
			++counter;
		}
		long[] smallerArray = new long[counter];
		for(int i=0;i<counter;i++) {
			smallerArray[i]=primefactors[i];
		}
		List<Long> list = new ArrayList<>();
		List<Long> templist = new ArrayList<>();
		for(int i=0;i<smallerArray.length;i++) {
			long thisNumber = smallerArray[i];
			counter = 1;
			if(thisNumber==l) {
				for(int k=0;k<counter;k++) {
					list.add(Long.valueOf(smallerArray[i]));
				}
				return list;
			}
			while(thisNumber<l) {
				templist = new ArrayList<>();
				long multiplier=0+thisNumber;
				for(int j=0;j<smallerArray.length;j++) {
					if(i==j) {
						//do nothing
					}else {
						multiplier = smallerArray[j]*multiplier;
						templist.add(smallerArray[j]);
						if(multiplier==l) {
							for(int k=0;k<(counter+smallerArray.length);k++) {
								if(k<templist.size()) {
									list.add(Long.valueOf(templist.get(k)));
								}
								else {
									list.add(Long.valueOf(smallerArray[i]));
									--counter;
								}
							}
							Collections.sort(list);
							return list;
						}
					}
				}
				thisNumber=thisNumber*smallerArray[i];
				++counter;
				if(thisNumber==l) {
					for(int k=0;k<counter;k++) {
						list.add(Long.valueOf(smallerArray[i]));
					}
					return list;
				}
			}
		}
		
		
		return null;
	}


	/**
	 * 8-9. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */
	static class AtbashCipher {

		/**
		 * Question 8
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String uppercasealphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String numberString = "0123456789";
			String fiveCharacters = "";
			String result = "";
			for(int i=0;i<string.length();i++) {
				int number = alphabet.indexOf(string.charAt(i));
				int capNumber = uppercasealphabet.indexOf(string.charAt(i));
				int isNumber = numberString.indexOf(string.charAt(i));
				int newNumber = -1;
				if(number>=0) {
					newNumber = (25-number);
				}else if(capNumber>=0) {
					newNumber = (25-capNumber);
				}
				if((newNumber!=-1||isNumber>=0)&&fiveCharacters.equals("")&&i!=0) {
					result = result + " ";
				}
				if(newNumber!=-1) {
					fiveCharacters = fiveCharacters + alphabet.charAt(newNumber);
				}
				if(isNumber>=0) {
					fiveCharacters = fiveCharacters + string.charAt(i);
				}
				if(fiveCharacters.length()==5) {
					result = result + fiveCharacters;
					fiveCharacters = "";
				}
				if(i==string.length()-1) {
					result = result + fiveCharacters;
				}
				number = 0;
				capNumber = 0;
				isNumber = 0;
			}
			return result;
		}

		/**
		 * Question 9
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {
			String alphabet = "abcdefghijklmnopqrstuvwxyz";
			String uppercasealphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String numberString = "0123456789";
			String result = "";
			for(int i=0;i<string.length();i++) {
				int number = alphabet.indexOf(string.charAt(i));
				int capNumber = uppercasealphabet.indexOf(string.charAt(i));
				int isNumber = numberString.indexOf(string.charAt(i));
				int newNumber = -1;
				if(number>=0) {
					newNumber = (25-number);
				}else if(capNumber>=0) {
					newNumber = (25-capNumber);
				}
				if(newNumber!=-1) {
					result = result + alphabet.charAt(newNumber);
				}
				if(isNumber>=0) {
					result = result + string.charAt(i);
				}
				number = 0;
				capNumber = 0;
				isNumber = 0;
			}
			return result;
		}
	}

	/**
	 * 10. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {
		String arg11 = "";
		String arg22 = "";
		int arg1 = 0;
		int arg2 = 0;
		String operation = "";
		String referenceString = "0123456789-";
		Boolean stringfilled = false;
		Boolean stringstarted = false;
		for(int i=0;i<string.length();i++) {
			int isUsable = referenceString.indexOf(string.charAt(i));
			if(isUsable>=0 && stringstarted == false) {
				arg11=arg11+string.charAt(i);
				stringstarted = true;
			}else if(isUsable>=0&&stringstarted==true&&stringfilled==false) {
				arg11=arg11+string.charAt(i);
			}else if(isUsable<=0&&stringstarted==true&&stringfilled==false) {
				stringfilled=true;
			}else if(isUsable>=0&&stringfilled==true) {
				arg22=arg22+string.charAt(i);
			}
		}
		arg1 = Integer.parseInt(arg11);
		arg2 = Integer.parseInt(arg22);
		if (string.contains("plus")) {
			operation = "plus";
		}
		if (string.contains("minus")) {
			operation = "minus";
		}
		if (string.contains("multiplied")) {
			operation = "multiplied";
		}
		if (string.contains("divided")) {
			operation = "divided";
		}
		int number = 0;
		switch(operation) {
		case "plus":
			number = arg1+arg2;
			break;
		case "minus":
			number = arg1-arg2;
			break;
		case "multiplied":
			number = arg1*arg2;
			break;
		case "divided":
			number = arg1/arg2;
			break;
		}
		return number;
	}

}
