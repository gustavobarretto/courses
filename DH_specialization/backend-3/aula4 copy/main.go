package main

import (
	"fmt"
	"strconv"
)

const MAX_SUM = 21

func main() {
	showNumbers(6)
}

func showNumbers(maxDigit int) {
	numbers := []int{}

	maxNumber := maxDigit * 1111

	for i := 1000; i <= maxNumber; i++ {
		strNumber := strconv.Itoa(i)
		if(checkIfAllNumbersAreMaxDigit(strNumber, maxDigit)) {
			numbers = append(numbers, i)
			fmt.Println(i)
		}
	}

	if len(numbers) < 1 {
		fmt.Println("null")
	}
}

func checkIfAllNumbersAreMaxDigit(numberString string, maxDigit int) bool {
	var sum int
	for _, word := range numberString {
		numberConverted, _ := strconv.Atoi(string(word))
		if(numberConverted > maxDigit) {
			return false
		}
		sum = sum + numberConverted
	}
	if(sum == 21) {
		return true
	}
	return false
}