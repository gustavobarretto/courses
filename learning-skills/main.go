package main
import "fmt"
import "strconv"

func main() {
    //Enter your code here. Read input from STDIN. Print output to STDOUT
    
		func getNumbers(maxDigit int) []int{
			var maxDigit int
			fmt.Scan(&maxDigit)

			numbers:= make([]int,0)
			const sum =21
			maxNumber := maxDigit*1111
			
			for i:= 1111; i<=maxNumber;i++{
					numberToString := strconv.Itoa(i)
					number1, _ := strconv.Atoi(numberToString[:1])
					number2, _ := strconv.Atoi(numberToString[1:2])
					number3, _ := strconv.Atoi(numberToString[2:3])
					number4, _ := strconv.Atoi(numberToString[3:4])
					
					if number1+number2+number3+number4 == sum{
							if number1 <= maxDigit && number2 <= maxDigit && number3 <= maxDigit && number4 <= maxDigit{
									numbers = append(numbers,i)
							}
					}
			}
			if maxDigit == 1{
				fmt.Println(string null)
			}else{
				fmt.Println(numbers)
			}
	}

	
    
    
    
}

