package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {

    private TicketRepository repository = new TicketRepository();
    private Ticket ticket1 = new Ticket(111, 7000, "MOW", "POV", 155);
    private Ticket ticket2 = new Ticket(222, 6000, "VKO", "POV", 236);
    private Ticket ticket3 = new Ticket(333, 2300, "KZN", "SDV", 340);
    private Ticket ticket4 = new Ticket(444, 3400, "MOW", "POV", 190);
    private Ticket ticket5 = new Ticket(555, 3400, "POV", "KZN", 150);
    private Ticket ticket6 = new Ticket(666, 4600, "SDV", "POV", 230);
    private Ticket ticket7 = new Ticket(777, 5200, "MOW", "POV", 240);
    private Ticket ticket8 = new Ticket(888, 7100, "MOW", "POV", 280);

    @Test
    public void shouldAddAllTickets() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);
        repository.add(ticket7);
        repository.add(ticket8);

        Ticket[] expected = new Ticket[] {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSomeTickets() {
        repository.add(ticket1);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket6);

        Ticket[] expected = new Ticket[] {ticket1, ticket3, ticket4, ticket6};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddAnything() {
        Ticket[] expected = new Ticket[] {};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);
        repository.add(ticket7);

        repository.removeById(222);
        repository.removeById(444);
        repository.removeById(777);
        repository.removeById(111);

        Ticket[] expected = new Ticket[] {ticket3, ticket5, ticket6};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdAllTickets() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);
        repository.add(ticket7);

        repository.removeById(222);
        repository.removeById(444);
        repository.removeById(777);
        repository.removeById(111);
        repository.removeById(333);
        repository.removeById(555);
        repository.removeById(666);

        Ticket[] expected = new Ticket[] {};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdOneTicket() {
        repository.add(ticket1);
        repository.add(ticket2);
        repository.add(ticket3);
        repository.add(ticket4);
        repository.add(ticket5);
        repository.add(ticket6);
        repository.add(ticket7);

        repository.removeById(222);

        Ticket[] expected = new Ticket[] {ticket1, ticket3, ticket4, ticket5, ticket6, ticket7};
        Ticket[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

}
