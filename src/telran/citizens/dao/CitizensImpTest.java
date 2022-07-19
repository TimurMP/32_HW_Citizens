package telran.citizens.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.util.Arrays;

class CitizensImpTest {
    Citizens citizens;

    @BeforeEach
    void setUp() {
        citizens = new CitizensImp(Arrays.asList(
                new Person(1, "Donkey", "Kong", 23),
                new Person(2, "Vault", "Boy", 20),
                new Person(4, "Dixie", "Kong", 20),
                new Person(3, "Pac", "Man", 25),
                new Person(5, "Leon", "Kennedy", 45),
                new Person(5, "AAA", "BBB", 4555)
        ));

    }


    @Test
    void CitizensImpListPerson() {
        citizens.add(new Person(10, "Samus", "Aran", 16 ));
        citizens.add(new Person(8, "Nathan", "Drake", 19));
        citizens.printPeople();

    }
    @Test
    void add() {
        citizens.add(new Person(10, "Samus", "Aran", 16 ));
        citizens.add(new Person(8, "Nathan", "Drake", 19));
        citizens.printPeople();

    }

    @Test
    void remove() {
    }

    @Test
    void find() {
        System.out.println(citizens.find(5));
    }

    @Test
    void testFind() {
    }

    @Test
    void testFind1() {
    }

    @Test
    void getAllPersonSortedById() {
    }

    @Test
    void getAllPersonSortedByAge() {
    }

    @Test
    void getAllPersonSortedByLastName() {
    }

    @Test
    void size() {
    }
}