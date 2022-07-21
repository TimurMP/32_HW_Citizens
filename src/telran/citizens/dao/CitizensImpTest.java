package telran.citizens.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.time.LocalDate;
import java.util.Arrays;

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
//        assertTrue(citizens.add(new Person(10, "Samus", "Aran", LocalDate.parse("1999-01-01"))));
//        assertFalse(citizens.add(null));
//        assertTrue(citizens.add(new Person(8, "Nathan", "Drake", LocalDate.parse("1970-01-01"))));
//        assertFalse(citizens.add(new Person(10, "Samus", "Aran", LocalDate.parse("1999-01-01"))));
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

//    @Test
//    void find() {
//        Person person = new Person(5, "Leon", "Kennedy", 45);
//        assertEquals(person, citizens.find(5));
//        assertNull(citizens.find(555));
//        System.out.println(citizens.find(5));
//    }

//    @Test
//    void testFindLastName() {
//        List<Object> people = Arrays.asList(
//                new Person(1, "Donkey", "Kong", 23),
//                new Person(4, "Dixie", "Kong", 19)
//
//        );
//        assertEquals(people, citizens.find("Kong"));
//        assertIterableEquals(people, citizens.find("Kong") );
//    }

    @Test
    void testFindAge() {
        Iterable<Person> res = citizens.find(33, 35);
//        List<Object> people = Arrays.asList(
//                new Person(4, "Dixie", "Kong", LocalDate.parse("1999-01-01")),
//                new Person(2, "Vault", "Boy", LocalDate.parse("1999-01-01")),
//                new Person(1, "Donkey", "Kong", LocalDate.parse("1999-01-01")));
//
//        assertEquals(people, citizens.find(19, 23));
        for (Person re : res) {
            System.out.println(re);

        }

    }

//    @Test
//    void getAllPersonSortedById() {
//        List<Object> people = Arrays.asList(
//                new Person(1, "Donkey", "Kong", 23),
//                new Person(2, "Vault", "Boy", 20),
//                new Person(3, "Pac", "Man", 25),
//                new Person(4, "Dixie", "Kong", 19),
//                new Person(5, "Leon", "Kennedy", 45));
//
//        assertEquals(people, citizens.getAllPersonSortedById());
//        System.out.println(citizens.getAllPersonSortedById());
//    }

//    @Test
//    void testGetAllPersonSortedByAge() {
//        Iterable<Person> res = citizens.getAllPersonSortedByAge();
//        LocalDate age = null;
//        for (Person person : res) {
//            if (age != null) {
//                assertTrue(person.getBirthDate() >= age);
//            }
//            age = person.getBirthDate();
//        }
    //TODO
//
//    }

//    @Test
//    void getAllPersonSortedByLastName() {
//        citizens.add(new Person(10, "Samus", "Aran", 16));
//        citizens.add(new Person(8, "Nathan", "Drake", 19));
//        List<Object> people = Arrays.asList(
//                new Person(10, "Samus", "Aran", 16),
//                new Person(2, "Vault", "Boy", 20),
//                new Person(8, "Nathan", "Drake", 19),
//                new Person(5, "Leon", "Kennedy", 45),
//                new Person(1, "Donkey", "Kong", 23),
//                new Person(4, "Dixie", "Kong", 19),
//                new Person(3, "Pac", "Man", 25)
//        );
//
//        assertEquals(people, citizens.getAllPersonSortedByLastName());
//        System.out.println(citizens.getAllPersonSortedByLastName());
//    }

//    @Test
//    void size() {
//        assertEquals(5, citizens.size());
//        citizens.add(new Person(10, "Samus", "Aran", 16));
//        citizens.add(new Person(8, "Nathan", "Drake", 19));
//        assertEquals(7, citizens.size());
//        citizens.remove(8);
//        assertEquals(6, citizens.size());
//
//    }
}