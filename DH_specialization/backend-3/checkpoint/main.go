package main

import (
	"digital-house/internal/tickets"
	"fmt"
)

func main() {
	ticketsData, err := tickets.CreateTicketsData(); if err != nil {
		fmt.Print(err)
		return
	}
	total, err := ticketsData.GetTotalTickets("Japan")

	if err != nil {
		fmt.Print(err)
		return
	}

	fmt.Printf("Total of tickets: %d \n", total)

	err = ticketsData.CalculateTotalTicketsByPeriod()
	if err != nil {
		fmt.Print(err)
		return
	}

	fmt.Printf("Total of flights by dawn: %d \n", ticketsData.Period.Dawn)

	totalByCountry, err := ticketsData.AverageDestination("Brazil")
	if err != nil {
		fmt.Print(err)
		return
	}

	fmt.Printf("Average of flights by location: %0.2f \n", totalByCountry)
}
