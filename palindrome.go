package palindrome

import "strconv"

// https://leetcode.com/problems/palindrome-number/
func isPalindrome(x int) bool {
	stringRepresentation := []rune(strconv.Itoa(x))

	len := len(stringRepresentation)

	for i := 0; i <= len/2; i++ {
		if stringRepresentation[i] != stringRepresentation[len-i-1] {
			return false
		}
	}

	return true

}
