package tickets

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

type TicketsData struct {
	Tickets							[]Ticket
	TotalByDestination	map[string]int
	Period							Period
}

type Period struct {
	Dawn				int
	Morning			int
	Afternoon		int
	Night				int
}

type Ticket struct {
	ID          	int
	Name        	string
	Email       	string
	Destination 	string
	HourFlight  	string
	Value       	float64
}

func CreateTicketsData() (ticketsData TicketsData, err error) {
	ticketsData = TicketsData{
		Tickets: []Ticket{},
		TotalByDestination: map[string]int{},
		Period: Period{},
	}
	res, err := openFile()
	if err != nil {
		return ticketsData, fmt.Errorf("open file error: %w", err)
	}
	err = CSVTreatment(res, &ticketsData); if err != nil {
		return ticketsData, fmt.Errorf("CSV treatment error: %w", err)
	}
	return ticketsData, nil
}

func openFile() ([]byte, error) {
	csv, err := os.ReadFile("tickets.csv")
	if err != nil {
		return nil, err
	}
	return csv, nil
}

func CSVTreatment(csv []byte, ticketData *TicketsData) error {
	data := strings.Split(string(csv), "\n")
	for _, row := range data {
		info := strings.Split(row, ",")
		err := ticketData.CreateTicket(info); if err != nil {
			return err
		}
	}
	return nil
}

func (td *TicketsData) CreateTicket(info []string) error {
	ID, err := strconv.Atoi(info[0]); if err != nil {
		return fmt.Errorf("id int conversion error: %w", err)
	}

	value, err := strconv.ParseFloat(info[5], 64); if err != nil {
		return fmt.Errorf("value float conversion error: %w", err)
	}
	
	ticket := Ticket{
		ID,
		info[1],
		info[2],
		info[3],
		info[4],
		value,
	}
	td.Tickets = append(td.Tickets, ticket)
	return nil
}

func (td *TicketsData) GetTotalTickets(destination string) (int, error) {
	counter := 0
	for _, ticket := range td.Tickets {
		if ticket.Destination == destination {
			counter++
			td.TotalByDestination[destination] = counter
		}
	}
	return td.TotalByDestination[destination], nil
}

func (td *TicketsData) CalculateTotalTicketsByPeriod() (err error) {
	for _ , ticket := range td.Tickets {
		td.GetCountByPeriod(ticket.HourFlight); if err != nil {
			return fmt.Errorf("error to count by period: %w", err)
		}
	}
	return nil
}

func (td *TicketsData) GetCountByPeriod(time string) (err error) {
	hour := strings.Split(time, ":")[0]
	hourConverted, err := strconv.Atoi(hour); if err != nil {
		return fmt.Errorf("error to converter int: %w", err)
	}
	switch true {
		case hourConverted < 7: 
			td.Period.Dawn++
		case hourConverted < 13:
			td.Period.Morning++
		case hourConverted < 20:
			td.Period.Afternoon++
		case hourConverted < 24:
			td.Period.Night++
	}
	return nil
} 

func countDistinctsCountries(tickets []Ticket) (total int) {
	distinct := make(map[string]bool)
	for _, ticket := range tickets {
		distinct[ticket.Destination] = true
	}
	total = len(distinct)
	return total
}

func (td *TicketsData) AverageDestination(destination string) (average float64, err error) {
	
	total := td.TotalByDestination[destination]; if total == 0 {
		total, err = td.GetTotalTickets(destination); if err != nil {
			return 0, fmt.Errorf("error to get all tickets to average destination: %w", err)
		}
	}
	average = float64(total) / float64(countDistinctsCountries(td.Tickets))
	return average, nil
}