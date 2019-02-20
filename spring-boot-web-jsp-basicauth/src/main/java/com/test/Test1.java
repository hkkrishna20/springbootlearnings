package com.test;

class Test1 {
	public static void main(String[] args) {
		int arr2[] = { 11, 10, 23, 16, 49, 44, 50, 36, 55, 75 }; // 2 4 5 7 11 10 44 45 50 55 75
		test(arr2);

	}

	public Test1() {
		super();
		// TODO Auto-generate,d constructor stub
	}

	static boolean test1(int[] arr2, int element, int index) {
		int beg = 0;
		int end = index;
		// Integer[] subarray = new Integer[end - beg + 1];
		if (index != 0) {
			for (int i = 0; i < (end - beg + 1); i++) {
				// subarray[i] = arr2[beg + i];
				if ((arr2[i] > arr2[index])) {
					return false;
				}
			}
		}		
		return true;
	}
	static boolean test2(int[] arr2, int element, int index) {
		
		int beg = index + 1;
		if (index != arr2.length - 1) {
			for (int i = beg; i < (arr2.length  - 1); i++) {
				// subarray[i] = arr2[beg + i];
				if ((arr2[i] < arr2[index])) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	static void test(int[] arr2) {

		for (int a = 0; a < arr2.length; a++) {	
			System.out.println();
				
			if (a != 0 && a != arr2.length - 1) {
				//boolean foundless = test1(arr2, arr2[a],a);
				//boolean foundmore = test2(arr2, arr2[a],a) ;
				if (test1(arr2, arr2[a],a) &&  test2(arr2, arr2[a],a)) {
					System.out.println("found " + arr2[a]);
					break;
				}
			} else if (a == 0) {
				if ((test2(arr2, arr2[a],a))) {
					System.out.println("found " + arr2[a]);
					break;
				}
			} else if (a == arr2.length - 1) {
				if ((test1(arr2, arr2[a],a))) {
					System.out.println("found " + arr2[a]);
					break;
				}
			}
		}
	}
}