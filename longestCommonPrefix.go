package longest_common_prefix

// https://leetcode.com/problems/longest-common-prefix/
func longestCommonPrefix(strs []string) string {
	shortestStringLength := lengthshortestString(strs)

	longestCommonPrefix := ""

	var index int

	for index = 0; index < shortestStringLength; index++ {

		var stringIndex int

		for stringIndex = 0; stringIndex < len(strs)-1; stringIndex++ {

			if strs[stringIndex][index] == strs[stringIndex+1][index] {
				continue
			} else {
				return longestCommonPrefix
			}
		}

		longestCommonPrefix = longestCommonPrefix + string(strs[stringIndex][index])

	}

	return longestCommonPrefix
}

func lengthshortestString(strs []string) int {
	length := 2000
	for i, _ := range strs {
		if len(strs[i]) < length {
			length = len(strs[i])
		}
	}
	return length
}
