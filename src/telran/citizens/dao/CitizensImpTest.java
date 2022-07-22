package telran.citizens.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class CitizensImpTest {
    Citizens citizens;

    @BeforeEach
    void setUp() {
        citizens = new CitizensImpl(Arrays.asList(
                new Person(1, "Donkey", "Kong", LocalDate.parse("1987-01-01")),
                new Person(2, "Vault", "Boy", LocalDate.parse("1988-01-01")),
                new Person(4, "Dixie", "Kong", LocalDate.parse("1990-01-01")),
                new Person(3, "Pac", "Man", LocalDate.parse("1989-02-01")),
                new Person(5, "Leon", "Kennedy", LocalDate.parse("1989-01-01")),
                new Person(5, "AAA", "BBB", LocalDate.parse("1987-01-01"))
        ));


    }


    @Test
    void CitizensImpListPerson() {
        Citizens citizensConstr;
        citizensConstr = new CitizensImpl(Arrays.asList(
                new Person(1, "Donkey", "Kong", LocalDate.parse("1987-02-08")),
                new Person(1, "Donkey", "Kong", LocalDate.parse("1987-12-22")),
                new Person(3, "Pac", "Man", LocalDate.parse("1989-02-15")),
                new Person(3, "Pac", "Man", LocalDate.parse("1989-11-25")),
                new Person(5, "Leon", "Kennedy", LocalDate.parse("1989-06-07")),
                new Person(5, "AAA", "BBB", LocalDate.parse("1989-08-07"))
        ));
        assertEquals(3, citizensConstr.size());


    }

    @Test
    void add() {
        assertTrue(citizens.add(new Person(10, "Samus", "Aran", LocalDate.parse("1999-01-01"))));
        assertFalse(citizens.add(null));
        assertTrue(citizens.add(new Person(8, "Nathan", "Drake", LocalDate.parse("1970-01-01"))));
        assertFalse(citizens.add(new Person(10, "Samus", "Aran", LocalDate.parse("1999-01-01"))));
        citizens.printPeople();
    }

    @Test
    void remove() {
        citizens.remove(2);
        assertEquals(4, citizens.size());
        citizens.remove(25);
        assertEquals(4, citizens.size());

        citizens.printPeople();
    }


    @Test
    void testFindInt() {
        Person person = citizens.find(1);
        assertEquals(1, person.getId());
        assertEquals("Donkey", person.getFirstName());
        assertEquals("Kong", person.getLastName());
        assertEquals(35, person.getAge());
        assertNull(citizens.find(55));
    }

    @Test
    void testFindString() {
        Iterable<Person> res = citizens.find("Kong");
        Iterable<Person> expected = Arrays.asList(new Person(1, "Donkey", "Kong", LocalDate.parse("1987-01-01")),
                new Person(4, "Dixie", "Kong", LocalDate.parse("1990-01-01")));
        ArrayList<Person> actual = new ArrayList<>();
        res.forEach(p -> actual.add(p));
        Collections.sort(actual);
        assertIterableEquals(expected, actual);
    }


    @Test
    void testFindAge() {
        citizens.add(new Person(10, "Samus", "Aran", LocalDate.parse("1999-01-01")));
        citizens.add(new Person(8, "Nathan", "Drake", LocalDate.parse("1970-01-01")));
        Iterable<Person> res = citizens.find(23, 32);
        List<Object> people = Arrays.asList(
                new Person(10, "Samus", "Aran", LocalDate.parse("1999-01-01")),
                new Person(4, "Dixie", "Kong", LocalDate.parse("1990-01-01"))
        );

        assertIterableEquals(people, res);

        for (Person re : res) {
            System.out.println(re);

        }

    }

    @Test
    void testGetAllPersonSortedById() {
        Iterable<Person> res = citizens.getAllPersonSortedById();
        int id = 0;
        for (Person person : res) {
            assertTrue(person.getId() > id);
            id = person.getId();
        }
    }

    @Test
    void testGetAllPersonSortedByAge() {
        Iterable<Person> res = citizens.getAllPersonSortedByAge();
        LocalDate age = null;

        for (Person person : res) {
            if (age != null) {
                assertTrue(person.getBirthDate().isBefore(age) || person.getBirthDate().isEqual(age));
            }
            age = person.getBirthDate();
            System.out.println(age);
        }

    }

    @Test
    void testGetAllPersonSortedByLastName() {
        Iterable<Person> res = citizens.getAllPersonSortedByLastName();
        String lastName = "";
        for (Person person : res) {
            assertTrue(person.getLastName().compareTo(lastName) >= 0);
            lastName = person.getLastName();
        }
    }

    @Test
    void size() {
        assertEquals(5, citizens.size());


    }
}