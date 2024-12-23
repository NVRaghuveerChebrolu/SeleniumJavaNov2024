package SwapnaAssignments;

public class FindMissingNumberINArray {

	public static void main(String[] args) {
		// aaray shld not hv duplicates
		// it can be ain any order
		// values shld be in range
		// we need to find sum of the elements
		// SUM2=1+3+4+6=12
		// also find sum of the range
		// SUM2-1+2+3+4+5=15
		// SUM2-SUM1=MISSING NUMBER
		int[] a = { 1, 3, 4, 5,6,8,9,10 };
		int Sum1 = 0;
		int Sum2=0;
		for (int x : a) {
			Sum1 = Sum1 + x;
		}
		System.out.println("Sum of all elements ina rray : " + Sum1);

		for(int i=1;i<=10;i++) {
			Sum2 = Sum2+i;
		}
		System.out.println("Sum of elements in range:"+ Sum2);
		System.out.println("Missing number:"+(Sum2-Sum1));
	}

}
