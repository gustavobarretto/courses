package tickets

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Ticket struct {
	id          int
	name        string
	email       string
	destination string
	flightHour  int
	price       float64
}

func startFile() ([]byte, error) {
	data, err := os.ReadFile("tickets.csv")

	if err != nil {
		return nil, err
	}
	return data, nil
}

func getAllTicketsInformation() ([]Ticket, error) {
	var tickets []Ticket

	res, err := startFile()
	if err != nil {
		return nil, err
	}

	data := strings.Split(string(res), "\n")

	for i := 0; i < len(data); i++ {
		column := strings.Split(data[i], ",")

		if i != 0 {
			id, err := strconv.Atoi(column[0])

			if err != nil {
				return nil, fmt.Errorf("it was not possible to convert the ID")
			}

			name := column[1]

			email := column[2]

			destination := column[3]

			flightHour, err := strconv.Atoi(strings.Split(column[4], ":")[0])

			if err != nil {
				return nil, fmt.Errorf("it was not possible to convert the time")
			}

			price, err := strconv.ParseFloat(column[5], 64)

			if err != nil {
				return nil, fmt.Errorf("it was not possible to convert the amount")
			}

			ticket := Ticket{
				id, name, email, destination, flightHour, price,
			}
			tickets = append(tickets, ticket)
		}
	}
	return tickets, nil
}

func GetTotalTickets(destination string) (int, error) {
	totalTickets := 0
	tickets, err := getAllTicketsInformation()
	if err != nil {
		return 0, err
	}

	for _, ticket := range tickets {
		if ticket.destination == destination {
			totalTickets++
		}
	}
	return totalTickets, nil
}

func getQuantityByHourInterval(startHour int, endHour int) (total int, err error) {
	tickets, err := getAllTicketsInformation()
	if err != nil {
		return 0, err
	}

	for _, ticket := range tickets {
		if ticket.flightHour >= startHour && ticket.flightHour <= endHour {
			total++
		}
	}
	return total, nil
}

func GetCountByPeriod(time string) (totalPeopleFlighting int, err error) {
	const (
		DAWN      = "dawn"
		MORNING   = "morning"
		AFTERNOON = "afternoon"
		NIGHT     = "night"
	)

	switch time {
	case DAWN:
		totalPeopleFlighting, err = getQuantityByHourInterval(0, 6)
		if err != nil {
			return 0, err
		}

	case MORNING:
		totalPeopleFlighting, err = getQuantityByHourInterval(7, 12)
		if err != nil {
			return 0, err
		}
	case AFTERNOON:
		totalPeopleFlighting, err = getQuantityByHourInterval(13, 19)
		if err != nil {
			return 0, err
		}
	case NIGHT:
		totalPeopleFlighting, err = getQuantityByHourInterval(20, 23)
		if err != nil {
			return 0, err
		}
	}
	return totalPeopleFlighting, nil
}

func countDistinctsCountries(tickets []Ticket) (total int) {
	distinct := make(map[string]bool)

	for _, ticket := range tickets {
		distinct[ticket.destination] = true
	}
	total = len(distinct)

	return total
}

func AverageDestination(destination string) (average float64, err error) {
	totalDestination := 0

	tickets, err := getAllTicketsInformation()
	if err != nil {
		return 0, err
	}

	for _, ticket := range tickets {
		if ticket.destination == destination {
			totalDestination++
		}
	}
	average = float64(totalDestination) / float64(countDistinctsCountries(tickets))

	return average, nil
}
