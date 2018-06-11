package problem;

public class Rearrange {

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	void fix(int[] arr) {
		int n = arr.length;
		int[] hash = new int[arr.length];
		for(int i=0;i<n;i++) {
			if(arr[i] != -1)
				hash[arr[i]] = 1; 
		}
		for(int i=0;i<n;i++) {
			if(hash[i] != 1) {
				arr[i] = -1;
			}else {
				arr[i] = i;
			}
		}
		printArr(arr);
	}
	
	public static void main(String[] args) {
		Rearrange obj = new Rearrange();
		int fix_arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
		
		obj.fix(fix_arr);
	}

}
