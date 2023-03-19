package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;


public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    Ticket ticket1 = new Ticket(123, 43580, "SPB", "VLD", 1080);
    Ticket ticket2 = new Ticket(456, 6750, "SPB", "MSK", 120);
    Ticket ticket3 = new Ticket(789, 127800, "MSK", "SDN", 1500);
    Ticket ticket4 = new Ticket(321, 9200, "SPB", "MSK", 240);
    Ticket ticket5 = new Ticket(654, 61100, "MGD", "SIM", 1260);
    Ticket ticket6 = new Ticket(987, 3500, "SPB", "MSK", 360);
    Ticket ticket7 = new Ticket(741, 18300, "ADL", "PER", 420);
    Ticket ticket8 = new Ticket(856, 1200, "ADL", "PER", 500);
    Ticket ticket9 = new Ticket(357, 4150, "SPB", "MSK", 300);
    Ticket ticket10 = new Ticket(492, 4150, "SPB", "MSK", 300);

    @BeforeEach
    public void SetUp() {
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

    }

    @Test
    public void findTicketsWithSorting() {

        Ticket[] expected = {ticket6, ticket9, ticket10, ticket2, ticket4};
        Ticket[] actual = manager.findAll("SPB", "MSK");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void findOnlyOneTicket() {

        Ticket[] expected = {ticket5};
        Ticket[] actual = manager.findAll("MGD", "SIM");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void notFindAnyTicket() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("RIG", "FLO");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    void removeTicketFromListWithoutSorting() {

        repo.removeTicket(741);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket8, ticket9, ticket10};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }
}