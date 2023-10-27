import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {
    @Test
    void testAddAndFindAll() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("JFK", "LAX", 500, 900, 1300);
        manager.add(ticket1);

        Ticket[] expected = {ticket1};
        Ticket[] actual = manager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("JFK", "LAX", 500, 900, 1300);
        Ticket ticket2 = new Ticket("JFK", "LAX", 400, 800, 1200);

        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = manager.search("JFK", "LAX");

        assertArrayEquals(expected, actual);
    }

    @Test
    void testSearchAndSortBy() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("JFK", "LAX", 500, 900, 1300);
        Ticket ticket2 = new Ticket("JFK", "LAX", 400, 700, 1100);

        manager.add(ticket1);
        manager.add(ticket2);

        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2, ticket1};
        Ticket[] actual = manager.searchAndSortBy("JFK", "LAX", comparator);

        assertArrayEquals(expected, actual);
    }
}
