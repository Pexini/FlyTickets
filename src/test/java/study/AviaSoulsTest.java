package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    @Test
    public void FindAllTickets() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("LA", "MSK", 115_000, 15, 4);
        Ticket ticket2 = new Ticket("HR", "SK", 65_000, 14, 7);
        Ticket ticket3 = new Ticket("RF", "FK", 11_000, 1, 21);
        Ticket ticket4 = new Ticket("CVD", "MSK", 85_000, 5, 10);
        Ticket ticket5 = new Ticket("LFE", "KZN", 11_000, 15, 2);
        Ticket ticket6 = new Ticket("FA", "MWE", 146_000, 23, 17);
        Ticket ticket7 = new Ticket("FEWD", "DW", 141_000, 11, 12);


        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] actual = manager.findAll();
        Ticket[] expented = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};

        Assertions.assertArrayEquals(actual, expented);
    }

    @Test
    public void SearchTicketsAndFoundFour() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("LA", "MSK", 115_000, 15, 4);
        Ticket ticket2 = new Ticket("RF", "SK", 65_000, 14, 7);
        Ticket ticket3 = new Ticket("RF", "SK", 11_000, 1, 21);

        Ticket ticket4 = new Ticket("LA", "MSK", 85_000, 5, 10);
        Ticket ticket5 = new Ticket("RF", "SK", 11_000, 15, 2);
        Ticket ticket6 = new Ticket("FA", "MWE", 16_000, 23, 17);

        Ticket ticket7 = new Ticket("LA", "MSK", 41_000, 11, 2);
        Ticket ticket8 = new Ticket("RTG", "FDS", 13_000, 13, 3);

        Ticket ticket9 = new Ticket("LA", "MSK", 45_000, 1, 1);
        Ticket ticket10 = new Ticket("RF", "SK", 34_000, 15, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("LA", "MSK");
        Ticket[] expented = {ticket7, ticket9, ticket4, ticket1};

        Assertions.assertArrayEquals(expented, actual);
    }

    @Test
    public void SearchAndFoundZeroTickets() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("LA", "MSK", 115_000, 15, 4);
        Ticket ticket2 = new Ticket("RF", "SK", 65_000, 14, 7);
        Ticket ticket3 = new Ticket("RF", "SK", 11_000, 1, 21);

        Ticket ticket4 = new Ticket("LA", "MSK", 85_000, 5, 10);
        Ticket ticket5 = new Ticket("RF", "SK", 11_000, 15, 2);
        Ticket ticket6 = new Ticket("FA", "MWE", 16_000, 23, 17);

        Ticket ticket7 = new Ticket("LA", "MSK", 41_000, 11, 2);
        Ticket ticket8 = new Ticket("RTG", "FDS", 13_000, 13, 3);

        Ticket ticket9 = new Ticket("LA", "MSK", 45_000, 1, 1);
        Ticket ticket10 = new Ticket("RF", "SK", 34_000, 15, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("FD", "DS");
        Ticket[] expented = {};

        Assertions.assertArrayEquals(expented, actual);
    }

    @Test
    public void SearchAndFoundOneTickets() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("LA", "MSK", 115_000, 15, 4);
        Ticket ticket2 = new Ticket("RF", "SK", 65_000, 14, 7);
        Ticket ticket3 = new Ticket("RF", "SK", 11_000, 1, 21);

        Ticket ticket4 = new Ticket("LA", "MSK", 85_000, 5, 10);
        Ticket ticket5 = new Ticket("RF", "SK", 11_000, 15, 2);
        Ticket ticket6 = new Ticket("FA", "MWE", 16_000, 23, 17);

        Ticket ticket7 = new Ticket("LA", "MSK", 41_000, 11, 2);
        Ticket ticket8 = new Ticket("RTG", "FDS", 13_000, 13, 3);

        Ticket ticket9 = new Ticket("LA", "MSK", 45_000, 1, 1);
        Ticket ticket10 = new Ticket("RF", "SK", 34_000, 15, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Ticket[] actual = manager.search("RTG", "FDS");
        Ticket[] expented = {ticket8};

        Assertions.assertArrayEquals(expented, actual);
    }

    @Test
    public void SearchAndFoundFourTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("LA", "MSK", 115_000, 5, 11); //6
        Ticket ticket2 = new Ticket("RF", "SK", 65_000, 14, 7);
        Ticket ticket3 = new Ticket("RF", "SK", 11_000, 1, 21);

        Ticket ticket4 = new Ticket("LA", "MSK", 85_000, 5, 10);  //5
        Ticket ticket5 = new Ticket("RF", "SK", 11_000, 14, 7);
        Ticket ticket6 = new Ticket("FA", "MWE", 16_000, 23, 17);

        Ticket ticket7 = new Ticket("LA", "MSK", 41_000, 1, 2);   //1
        Ticket ticket8 = new Ticket("RTG", "FDS", 13_000, 14, 7);

        Ticket ticket9 = new Ticket("LA", "MSK", 45_000, 1, 5);  //4
        Ticket ticket10 = new Ticket("RF", "SK", 34_000, 14, 7);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("LA", "MSK", comparator);
        Ticket[] expented = {ticket7, ticket9, ticket4, ticket1};

        Assertions.assertArrayEquals(expented, actual);
    }

    @Test
    public void SearchAndFoundZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("LA", "MSK", 115_000, 15, 4);
        Ticket ticket2 = new Ticket("RF", "SK", 65_000, 14, 7);
        Ticket ticket3 = new Ticket("RF", "SK", 11_000, 1, 21);

        Ticket ticket4 = new Ticket("LA", "MSK", 85_000, 5, 10);
        Ticket ticket5 = new Ticket("RF", "SK", 11_000, 15, 2);
        Ticket ticket6 = new Ticket("FA", "MWE", 16_000, 23, 17);

        Ticket ticket7 = new Ticket("LA", "MSK", 41_000, 11, 2);
        Ticket ticket8 = new Ticket("RTG", "FDS", 13_000, 13, 3);

        Ticket ticket9 = new Ticket("LA", "MSK", 45_000, 1, 1);
        Ticket ticket10 = new Ticket("RF", "SK", 34_000, 15, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("FD", "DS", comparator);
        Ticket[] expented = {};

        Assertions.assertArrayEquals(expented, actual);
    }

    @Test
    public void SearchTicketsAndOneFourWithComparator() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("LA", "MSK", 115_000, 15, 4);
        Ticket ticket2 = new Ticket("RF", "SK", 65_000, 14, 7);
        Ticket ticket3 = new Ticket("RF", "SK", 11_000, 1, 21);
        Ticket ticket4 = new Ticket("LA", "MSK", 85_000, 5, 10);
        Ticket ticket5 = new Ticket("RF", "SK", 11_000, 15, 2);
        Ticket ticket6 = new Ticket("FA", "MWE", 16_000, 23, 17);
        Ticket ticket7 = new Ticket("LA", "MSK", 41_000, 11, 2);
        Ticket ticket8 = new Ticket("RTG", "FDS", 13_000, 13, 3);
        Ticket ticket9 = new Ticket("LA", "MSK", 45_000, 1, 1);
        Ticket ticket10 = new Ticket("RF", "SK", 34_000, 15, 15);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.search("RTG", "FDS", comparator);
        Ticket[] expented = {ticket8};

        Assertions.assertArrayEquals(expented, actual);
    }
}