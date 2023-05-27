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


public static void main(String args[]) {
	int[] sortedArray1 = {1, 5, 7, 9}, sortedArray2 = {2, 4, 8, 12};
	ArrayAlgorithms aa = new ArrayAlgorithms();
	System.out.println(Arrays.toString(aa.mergeSortedArrays(sortedArray1, sortedArray2)));
}
}
