package main

import (
	"fmt"
	"strconv"
	"strings"
)

// js = [1, 2, 3, 4, 5]
// go = {1, 2, 3, 4, 5}

func main() {

	GetCountByPeriod("13:31")
	GetCountByPeriod("manhã")

	
	
}

var tickets = []int{}

func GetCountByPeriod(time string) (int, error) {
	valorTotal := 0	
	switch time {
		case "madrugada":
			for _, ticket := range tickets {
				hour := strings.Split(ticket.HoraDoVoo, ":")
				hourConvertida, _ := strconv.Atoi(hour)
				if hourConvertida > 0 && hourConvertida <= 6 {
					valorTotal++
				}
			}
		case "manhã":
			for _, ticket := range tickets {
				hour := strings.Split(ticket.HoraDoVoo, ":")
				hourConvertida, _ := strconv.Atoi(hour)
				if hourConvertida >= 7 && hourConvertida <= 12 {
					valorTotal++
				}
			}
		case "tarde":
			for _, ticket := range tickets {
				hour := strings.Split(ticket.HoraDoVoo, ":")
				hourConvertida, _ := strconv.Atoi(hour)
				if hourConvertida >= 13 && hourConvertida <= 19 {
					valorTotal++
				}
			}
		case "noite":
			for _, ticket := range tickets {
				hour := strings.Split(ticket.HoraDoVoo, ":")
				hourConvertida, _ := strconv.Atoi(hour)
				if hourConvertida >= 20 && hourConvertida <= 23 {
					valorTotal++
				}
			}
	}
	return 0, nil
}

func getPeriod(horaInicial ) {
	for _, ticket := range tickets {
		hour := strings.Split(ticket.HoraDoVoo, ":")
		hourConvertida, _ := strconv.Atoi(hour)
		if hourConvertida >= 20 && hourConvertida <= 23 {
			valorTotal++
		}
	}

}