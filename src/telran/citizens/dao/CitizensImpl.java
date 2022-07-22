package telran.citizens.dao;

import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitizensImpl implements Citizens {
    private List<Person> idList;
    private List<Person> lastNameList;
    private List<Person> ageList;
    private static Comparator<Person> lastNameComparator;
    private static Comparator<Person> ageComparator;

    static {
        lastNameComparator = (p1, p2) -> {
            int res = p1.getLastName().compareTo(p2.getLastName());
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
        };


        ageComparator = (p1, p2) -> {
            int res = p2.getBirthDate().compareTo(p1.getBirthDate());
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
        };


    }

    public CitizensImpl() {
        idList = new ArrayList<>();
        lastNameList = new ArrayList<>();
        ageList = new ArrayList<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        citizens.forEach(p -> add(p));
    }

    // O(n)
    @Override
    public boolean add(Person person) {
        if (person == null) {
            return false;
        }
        int index = Collections.binarySearch(idList, person);
        if (index >= 0) {
            return false;
        }
        index = -index - 1;
        idList.add(index, person);
        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        index = index >= 0 ? index : -index - 1;
        lastNameList.add(index, person);
        index = Collections.binarySearch(ageList, person, ageComparator);
        index = index >= 0 ? index : -index - 1;
        ageList.add(index, person);
        return true;
    }

    // O(n)
    @Override
    public boolean remove(int id) {
        Person victim = new Person(id, null, null, null);
        return idList.remove(victim) && lastNameList.remove(victim) && ageList.remove(victim);
    }

    // O(log(n))
    @Override
    public Person find(int id) {
        Person pattern = new Person(id, null, null, null);
        int index = Collections.binarySearch(idList, pattern);
        return index < 0 ? null : idList.get(index);
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        Comparator<Person> yearComparator = (p1, p2) -> {
            int res = Integer.compare(p2.getBirthDate().getYear(), p1.getBirthDate().getYear());
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
        };
        int today = LocalDate.now().getYear();
        LocalDate dateMin = LocalDate.of(today - minAge, 1, 1);
        LocalDate dateMax = LocalDate.of(today - maxAge, 12, 12);
        Person pattern = new Person(Integer.MIN_VALUE, null, null, dateMin);
        int from = -Collections.binarySearch(ageList, pattern, yearComparator) - 1;
        System.out.println(from);
        pattern = new Person(Integer.MAX_VALUE, null, null, dateMax);
        int to = -Collections.binarySearch(ageList, pattern, yearComparator) - 1;
        System.out.println(to);
        return ageList.subList(from, to);
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(String lastName) {
        Person pattern = new Person(Integer.MIN_VALUE, null, lastName, null);
        int from = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;
        pattern = new Person(Integer.MAX_VALUE, null, lastName, null);
        int to = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;
        return lastNameList.subList(from, to);
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedById() {
        return idList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedByLastName() {
        return lastNameList;
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedByAge() {
        return ageList;
    }

    // O(1)
    @Override
    public int size() {
        return idList.size();


    }

    private int ageCalculator(LocalDate birthDay) {
        int today = LocalDate.now().getYear();
        return today - birthDay.getYear();
    }

    private LocalDate ageToDatCalculator(int age) {
        int today = LocalDate.now().getYear();
        LocalDate date = LocalDate.of(today - age, 1, 1);
        return date;
    }


    @Override
    public void printPeople() {
        System.out.println("idLIST: ");
        for (Person person : idList) {
            System.out.println(person);

        }


        System.out.println("lastNameList: ");
        for (Person person : lastNameList) {
            System.out.println(person);

        }

        System.out.println("ageList: ");
        for (Person person : ageList) {
            System.out.println(person);

        }

    }
}
