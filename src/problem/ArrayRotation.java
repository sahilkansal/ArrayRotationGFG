package problem;

public class ArrayRotation {

	static int GCD(int n, int d) {
		int count = 1;
		int temp_d = d;
		for (int i = 2; i < temp_d;) {
			if (n == 1 || d == 1) {
				return count;
			}
			if (n % i == 0 && d % i == 0) {
				count *= i;
				n /= i;
				d /= i;
			} else {
				i++;
			}
		}
		return count;
	}

	static int GCD2(int a, int b) {
		// System.out.println(a + " " + b);
		if (a == 0) {
			return b;
		}
		if (a == b) {
			return a;
		}
		return GCD2(b % a, a);
	}

	static int binarySearch(int[] arr, int low, int high, int val) {
		System.out.println(low + "   " + high);
		int mid = (low + high) / 2;
		if (low > high) {
			return -1;
		}
		if (val == arr[mid]) {
			return mid;
		}
		if (arr[mid] > val) {
			return binarySearch(arr, low, mid - 1, val);
		} else {
			return binarySearch(arr, mid + 1, high, val);
		}
	}

	static void searchRotateSortArr(int[] arr) {
		int pivot = findPivot(arr, 0, arr.length - 1);
		System.out.println(binarySearch(arr, 0, pivot, 3));
		System.out.println(binarySearch(arr, pivot + 1, arr.length - 1, 3));
	}

	private static int findPivot(int[] arr, int low, int high) {
		// System.out.println(low+" "+high);
		int mid = (low + high) / 2;
		if (low == high) {
			return low;
		}
		if (arr[mid] > arr[low]) {
			return findPivot(arr, mid + 1, high);
		} else {
			return findPivot(arr, low, mid);
		}

		// return 0;
	}

	static boolean pairInSortedRotated(int[] arr, int sum) {
		int pivot = findPivot(arr, 0, arr.length - 1);
		int l = pivot;
		int r = pivot + 1;
		int n = arr.length;
		while (l != r) {
			System.out.println(l + " " + r);
			if ((arr[l] + arr[r] == sum)) {
				System.out.println(l + "  " + r);
				return true;
			}

			if (arr[l] + arr[r] < sum) {
				r = (r + 1) % n;
			} else if (arr[l] + arr[r] > sum) {
				l = (n + r - 1) % n;
			}
		}
		return false;
	}

	static int maxSum(int[] arr) {
		int n = arr.length, prev_sum = 0, sum = 0;
		for (int j = 0; j < n; j++) {
			leftRotate(arr, j);
			for (int i = 0; i < n; i++) {
				sum += arr[i] * i;
			}
			// System.out.println(sum);
			if (prev_sum < sum)
				prev_sum = sum;
			sum = 0;
		}
		return prev_sum;
	}

	static int maxSumOptimized(int[] arr) {
		int n = arr.length, sum = 0, arraySum = 0;
		for (int i = 0; i < n; i++) {
			arraySum += arr[i];
			sum += arr[i] * i;
		}
		int val = sum, max_val = Integer.MIN_VALUE;
		for (int num_rot = 0; num_rot < n; num_rot++) {
			val += arraySum - (n * arr[n - num_rot - 1]);
			// System.out.println(val);
			if (val > max_val) {
				max_val = val;
			}
		}
		return max_val;
	}

	static void printArr(int[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	private static void leftRotate(int[] arr, int d) {
		if (d > arr.length) {
			d = d % arr.length;
		}
		int gcd = GCD2(arr.length, d);
		for (int i = 0; i < gcd; i++) {
			int val = arr[i];
			int j = i;
			// arr[0] = arr[0+d];
			while (true) {
				int k = j + d;
				if (k >= arr.length) {
					k = k - arr.length;
				}
				if (k == i)
					break;
				arr[j] = arr[k];
				j = k;
			}
			arr[j] = val;
		}
	}

	static int[] copyArr(int []arr) {
		int temp[] = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			temp[i] = arr[i];
		}
		return temp;
	}
	
	static int maxHamming(int[] arr) {
		int n = arr.length, val = 0;
		int []temp = arr.clone();
			        
		while(  ) {
			for (int i = 0; i < n; i++) {
			   	temp[i] = temp[i + 1];
			}
			arr[n - 1] = val;
		}
		return 0;
	}

	static void reverseArray(int[] arr, int l, int h) {
		System.out.println(l + "  " + h);
		while (l < h) {
			int temp = arr[l];
			arr[l] = arr[h];
			arr[h] = temp;
			l++;
			h--;
			System.out.println("****************************");
			printArr(arr);
			System.out.println("****************************");
		}

	}

	static void rightReverse(int arr[]) {
		int pivot = findPivot(arr, 0, arr.length);
		System.out.println("reverse:  " + pivot);
		reverseArray(arr, 0, pivot);
		printArr(arr);
		reverseArray(arr, pivot + 1, arr.length - 1);
		reverseArray(arr, 0, arr.length - 1);
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		// leftRotate(arr,3);
		// System.out.println(findPivot(arr, 0, arr.length));
		int sortArr[] = { 10, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] test_arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		// System.out.println(pairInSortedRotated(sortArr,14));
		// searchRotateSortArr(sortArr);

		//leftRotate(test_arr, 14);
		//System.out.println(maxSumOptimized(test_arr));
		//rightReverse(test_arr);
		//printArr(test_arr);
		maxHamming(arr);
	}
}
