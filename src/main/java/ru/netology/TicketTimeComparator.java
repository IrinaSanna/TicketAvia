package ru.netology;

import java.util.Arrays;
import java.util.Comparator;

public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket ticket1, Ticket ticket2) {
        int timeResultT1 = ticket1.getTimeTo() - ticket1.getTimeFrom();
        int timeResultT2 = ticket2.getTimeTo() - ticket2.getTimeFrom();
        {
            if (timeResultT1 < timeResultT2) {
                return -1;
            } else if (timeResultT1 > timeResultT2) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}