package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    private Ticket ticket1 = new Ticket(111, 7000, "MOW", "POV", 155);
    private Ticket ticket2 = new Ticket(222, 6000, "VKO", "POV", 236);
    private Ticket ticket3 = new Ticket(333,2300, "VKO", "POV", 340);
    private Ticket ticket4 = new Ticket(444, 3400, "MOW", "POV", 190);
    private Ticket ticket5 = new Ticket(555, 3400, "POV", "KZN", 150);
    private Ticket ticket6 = new Ticket(666, 6000, "VKO", "POV", 230);
    private Ticket ticket7 = new Ticket(777, 5200, "MOW", "POV", 240);
    private Ticket ticket8 = new Ticket(888, 8000, "MOW", "POV", 280);

    @BeforeEach
    public void setUp() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
    }

    @Test
    public void shouldFindByDepartureAirportAndArrivalAirport() {

        Ticket[] expected = new Ticket[] {ticket5};
        Ticket[] actual = manager.findAll("POV", "KZN");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldNotFindAnything() {

        Ticket[] expected = new Ticket[] {};
        Ticket[] actual = manager.findAll("POV", "POV");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSortByPrice() {

        Ticket[] expected = new Ticket[] {ticket4, ticket7, ticket1, ticket8};
        Ticket[] actual = manager.findAll("MOW", "POV");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSortByPriceWithTheSamePrice() {

        Ticket[] expected = new Ticket[] {ticket3, ticket2, ticket6};
        Ticket[] actual = manager.findAll("VKO", "POV");

        Assertions.assertArrayEquals(expected, actual);
    }

}
