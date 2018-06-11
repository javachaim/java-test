package br.com.whs.javatest;

public class SearchRangeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,5,7,7,8,8,8,10};
		int target = 3;
		int[] sr = searchRange(nums, target);
		for( int i = 0; i < sr.length; i++ ) {
			System.out.println(sr[i]);
		}
	}

	public static int[] searchRange(int[] nums, int target) {
		int upper = upperOrLower(nums, target, true);
		int lower = upperOrLower(nums, target, false);
		return new int[] { lower, upper };
	}

	private static int upperOrLower(int[] nums, int target, boolean upper) {
		int left = 0;
		int right = nums.length - 1;
		int res = -1;
		int mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				res = mid;
				if (upper) {
					left = mid + 1;
				} else
					right = mid - 1;
			} else if (nums[mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return res;
	}
}
