package telran.citizens.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CitizensImpTest {
    Citizens citizens;

    @BeforeEach
    void setUp() {
        citizens = new CitizensImp(Arrays.asList(
                new Person(1, "AAA", "AA", 23),
                new Person(2, "BBB", "BB", 20),
                new Person(3, "CCC", "AA", 20),
                new Person(4, "DDD", "DD", 25)

        ));
    }

    @Test
    void add() {
    }

    @Test
    void remove() {
    }

    @Test
    void find() {
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