import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

public class AviaSoulsTest {

    private AviaSouls manager;
    private Ticket ticket1;
    private Ticket ticket2;
    private Ticket ticket3;

    @BeforeEach
    public void setup() {
        manager = new AviaSouls();

        ticket1 = new Ticket("JFK", "LAX", 300, 500, 900);
        ticket2 = new Ticket("JFK", "LAX", 200, 600, 1000);
        ticket3 = new Ticket("JFK", "SFO", 400, 700, 1100);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
    }

    @Test
    public void testSearchMultipleTickets() {
        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = manager.search("JFK", "LAX");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSingleTicket() {
        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.search("JFK", "SFO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchNoTickets() {
        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.search("JFK", "ORD");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchAndSortByTime() {
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = manager.searchAndSortBy("JFK", "LAX", comparator);

        // Assuming TicketTimeComparator compares based on the flight time (timeTo - timeFrom)
        Assertions.assertArrayEquals(expected, actual);
    }
}
