package ru.netology.manager;

import ru.netology.domain.Ticket;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTravelTimeMinutes() - o2.getTravelTimeMinutes();
    }
}
