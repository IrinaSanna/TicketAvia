package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    Ticket ticket1 = new Ticket("MOW", "LED", 5_000, 17, 18);
    Ticket ticket2 = new Ticket("LED", "MOW", 4_000, 12, 13);
    Ticket ticket3 = new Ticket("PTG", "SIP", 52_000, 8, 20);
    Ticket ticket4 = new Ticket("UUS", "TOF", 18_000, 13, 24);
    Ticket ticket5 = new Ticket("LED", "MOW", 3_000, 16, 17);
    Ticket ticket6 = new Ticket("UUS", "TOF", 94_000, 6, 23);
    Ticket ticket7 = new Ticket("LED", "MOW", 5_000, 17, 18);
    Ticket ticket8 = new Ticket("UUS", "TOF", 90_000, 7, 23);

    @Test
    public void shouldCompareIfTicketPriceLess() { // цена билета меньше цены другого билета
        Ticket price = new Ticket("LED", "MOW", 4_000, 12_00, 13_00);

        int expected = -1;
        int actual = price.compareTo(ticket1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareIfTicketPriceHigher() { // цена билета больше цены другого билета
        Ticket price = new Ticket("PTG", "SIP", 52_000, 8_00, 20_00);

        int expected = 1;
        int actual = price.compareTo(ticket4);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCompareIfTicketPriceSame() { // цены билетов равны
        Ticket price = new Ticket("MOW", "LED", 5_000, 17_00, 18_00);

        int expected = 0;
        int actual = price.compareTo(ticket7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchRouteAndSortPrice() { // поиск по маршруту и сортировка по цене
        AviaSouls sortPriceTicket = new AviaSouls();

        sortPriceTicket.add(ticket1);
        sortPriceTicket.add(ticket2);
        sortPriceTicket.add(ticket3);
        sortPriceTicket.add(ticket4);
        sortPriceTicket.add(ticket5);
        sortPriceTicket.add(ticket6);
        sortPriceTicket.add(ticket7);
        sortPriceTicket.add(ticket8);

        Ticket[] expected = {ticket5, ticket2, ticket7};
        Ticket[] actual = sortPriceTicket.search("LED", "MOW");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchRouteNotFound() { // искомого маршрута нет
        AviaSouls sortPriceTicket = new AviaSouls();

        sortPriceTicket.add(ticket1);
        sortPriceTicket.add(ticket2);
        sortPriceTicket.add(ticket3);
        sortPriceTicket.add(ticket4);
        sortPriceTicket.add(ticket5);
        sortPriceTicket.add(ticket6);
        sortPriceTicket.add(ticket7);
        sortPriceTicket.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = sortPriceTicket.search("VOZ", "MOW");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFlightTimeIsShorter() { // короткое время полета
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = timeComparator.compare(ticket1, ticket3);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFlightTimeIsLonger() { // долгое время полета
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = timeComparator.compare(ticket4, ticket7);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldFlightTimeEqual() { // одинаковое время полета
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        int expected = 0;
        int actual = timeComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByShorterTime() {
        AviaSouls aviaSoulsComparator = new AviaSouls();

        aviaSoulsComparator.add(ticket1);
        aviaSoulsComparator.add(ticket2);
        aviaSoulsComparator.add(ticket3);
        aviaSoulsComparator.add(ticket4);
        aviaSoulsComparator.add(ticket5);
        aviaSoulsComparator.add(ticket6);
        aviaSoulsComparator.add(ticket7);
        aviaSoulsComparator.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket5, ticket7};
        Ticket[] actual = aviaSoulsComparator.searchAndSortBy("LED", "MOW", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByLongerTime() {
        AviaSouls aviaSoulsComparator = new AviaSouls();

        aviaSoulsComparator.add(ticket1);
        aviaSoulsComparator.add(ticket2);
        aviaSoulsComparator.add(ticket3);
        aviaSoulsComparator.add(ticket4);
        aviaSoulsComparator.add(ticket5);
        aviaSoulsComparator.add(ticket6);
        aviaSoulsComparator.add(ticket7);
        aviaSoulsComparator.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket8, ticket6};
        Ticket[] actual = aviaSoulsComparator.searchAndSortBy("UUS", "TOF", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchAndSortByEqualTime() {
        AviaSouls aviaSoulsComparator = new AviaSouls();

        aviaSoulsComparator.add(ticket1);
        aviaSoulsComparator.add(ticket2);
        aviaSoulsComparator.add(ticket3);
        aviaSoulsComparator.add(ticket4);
        aviaSoulsComparator.add(ticket5);
        aviaSoulsComparator.add(ticket6);
        aviaSoulsComparator.add(ticket7);
        aviaSoulsComparator.add(ticket8);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = aviaSoulsComparator.searchAndSortBy("VOZ", "MOW", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}