import java.util.Arrays;

public class ArrayAlgorithms {

	public int[] mergeSortedArrays(int[] first, int[] second) {

	int i = 0 , j = 0 , mergedArrayIndex = 0;
	int[] mergedArray = new int[first.length + second.length];
	while( i < first.length && j < second.length ) {
		int firstArrayElement = first[i];
		int secondArrayElement = second[j];

		if(firstArrayElement < secondArrayElement) {
			mergedArray[mergedArrayIndex] = firstArrayElement;
			i++;
		} else {
			mergedArray[mergedArrayIndex] = secondArrayElement;
			j++;
		}
		mergedArrayIndex++;
	}

	// iterate over the remainder

	while ( i < first.length) {
		mergedArray[mergedArrayIndex] = first[i];
		i++;
		mergedArrayIndex++;
	}

	while ( j < second.length) {
		mergedArray[mergedArrayIndex] = second[j];
		j++;
		mergedArrayIndex++;
	}
	return mergedArray;
}

/* https://leetcode.com/problems/is-subsequence/description/
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without i
 * disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
* Solution: Two pointers - one in the source and other in the target array.
* Iterate over the source array.
* If ther source and target character matches, increment the target array pointer to find the next match
* If the entire target array is traversed, then the subsequence match has been found
*/
    public boolean isSubsequence(String target, String source) {
        int sourceIndex = 0, targetIndex = 0;

while(targetIndex < target.length() && sourceIndex < source.length()){

char currentSourceCharacter = source.charAt(sourceIndex);
char currentTargetCharacter = target.charAt(targetIndex);

if(currentTargetCharacter == currentSourceCharacter) {
	// next char in subsequence found. increment both.
	targetIndex++;
	System.out.println("Target: found character " + currentTargetCharacter);
}
	System.out.println("source character iter " + currentSourceCharacter);

	sourceIndex++;

}

if(targetIndex == target.length()) {
	// TargetIndex has reached the end of the target due to finding subsequence
	return true;
}

return false;

    }


/*
 * O(n) algorithm to find the sorted squares of an non-decreasing array
 *https://leetcode.com/problems/squares-of-a-sorted-array/
 * */

    public int[] sortedSquares(int[] array) {

        int rightPointer = array.length - 1, leftPointer = 0, destPointer = array.length - 1;
        int[] result = new int[array.length];
        while ( leftPointer <= rightPointer) {
            int leftSquare = array[leftPointer] * array[leftPointer];
            int rightSquare = array[rightPointer] * array[rightPointer];

            if(leftSquare > rightSquare) {
                result[destPointer] = leftSquare;
                leftPointer ++;
                destPointer --;
            } else if (rightSquare > leftSquare) {
                result[destPointer] = rightSquare;
                rightPointer --;
                destPointer --;
            } else {
                // both squares are equal
                if(leftPointer == rightPointer) {
                    //both left and right pointer have reached the same point in the main array
                    result[destPointer] = leftSquare;
                    leftPointer ++;
                    destPointer --;
                } else {
                    result[destPointer] = leftSquare;
                    leftPointer ++;
                    destPointer --;


                    result[destPointer] = rightSquare;
                    rightPointer --;
                    destPointer --;
                }

            }


        }
        return result;
    }

/*Given an array and a subarray length k, find the maximum average for a subarray of length k
 * */

    public double findMaxAverage(int[] nums, int k) {

        int leftPointer = 0, rightPointer, currentSum = 0;
        double maxSum;

        for(rightPointer = 0; rightPointer < k; rightPointer++) {
            currentSum += nums[rightPointer];
        }

        maxSum = currentSum;

        for(rightPointer = k; rightPointer < nums.length; rightPointer++, leftPointer++) {
            currentSum = currentSum + nums[rightPointer] - nums[leftPointer];

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum/k;
    }

/** STEP SuM
 * Given an array of integers nums, you start with an initial positive value startValue.
 * In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
 * Return the minimum positive value of startValue such that the step by step sum is never less than 1.
 *
 */

public int minStartValue(int[] nums) {
        	int lowestStepValue, result;
	int[] prefixSum = new int[nums.length];

	prefixSum[0] = nums[0];
	lowestStepValue = prefixSum[0];

	for( int i = 1; i < nums.length; i++) {
		prefixSum[i] = prefixSum[i-1] + nums[i];
		lowestStepValue = Integer.min(lowestStepValue, prefixSum[i]);
	}

	if(lowestStepValue <= 0) {
		result = (-1 * lowestStepValue) + 1;
	}  else {
		result = 1;
	} 
	return result;
		

    }
}

public static void main(String args[]) {
	int[] sortedArray1 = {1, 5, 7, 9}, sortedArray2 = {2, 4, 8, 12};
	ArrayAlgorithms aa = new ArrayAlgorithms();
	System.out.println(Arrays.toString(aa.mergeSortedArrays(sortedArray1, sortedArray2)));
}
}
