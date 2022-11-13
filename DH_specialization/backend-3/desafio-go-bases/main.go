package main

import (
	"digital-house/internal/tickets"
	"fmt"
)

func main() {
	total, err := tickets.GetTotalTickets("Brazil")

	if err != nil {
		fmt.Print(err)
		return
	}

	fmt.Printf("Total of tickets: %d \n", total)

	totalByPeriod, err := tickets.GetCountByPeriod("night")

	if err != nil {
		fmt.Print(err)
		return
	}

	fmt.Printf("Total of flights by period: %d \n", totalByPeriod)

	totalByCountry, err := tickets.AverageDestination("Indonesia")

	if err != nil {
		fmt.Print(err)
		return
	}

	fmt.Printf("Average of flights by location: %0.2f \n", totalByCountry)

}
