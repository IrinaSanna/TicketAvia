package ru.netology;

public class AviaSouls {
    private Ticket[] tickets = new Ticket[0];

    private Ticket[] addArray(Ticket[] current, Ticket ticket) {
        Ticket[] tmp = new Ticket[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = ticket;
        return tmp;
    }

    public void add(Ticket ticket) {
        tickets = addArray(tickets, ticket);
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket[] search(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from)) {
                if (ticket.getTo().equals(to)) {
                    result = addArray(result, ticket);
                }
            }
        }
        return result;
    }
}