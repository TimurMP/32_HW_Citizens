package telran.citizens.dao;

import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.util.Comparator;
import java.util.List;

public class CitizensImp implements Citizens {
    List<Person> idList;
    List<Person> lastNameList;
    List<Person> ageList;
    static Comparator<Person> lastNameComparator;
    static Comparator<Person> ageComparator;

    public CitizensImp() {
        //TODO:
    }

    public CitizensImp(List<Person> citizens) {
        //TODO:
    }

    @Override
    public boolean add(Person person) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public Person find(int id) {
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        return null;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonSortedById() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByAge() {
        return null;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByLastName() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
