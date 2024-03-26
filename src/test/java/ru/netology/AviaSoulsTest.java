package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("MOW", "LED", 5_000, 17_00, 18_00);
    Ticket ticket2 = new Ticket("LED", "MOW", 4_000, 12_00, 13_00);
    Ticket ticket3 = new Ticket("PTG", "SIP", 52_000, 8_00, 20_00);
    Ticket ticket4 = new Ticket("SCW", "MOW", 18_000, 22_00, 11_00);
    Ticket ticket5 = new Ticket("UUS", "TOF", 94_000, 6_00, 23_00);

    @Test
    public void shouldCompareTicketPrice() {
        Ticket price = new Ticket("LED", "MOW", 4_000, 12_00, 13_00);

        int expected = -1;
        int actual = price.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }
}