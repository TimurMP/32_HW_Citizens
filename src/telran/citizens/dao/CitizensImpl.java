package telran.citizens.dao;

import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.util.*;

public class CitizensImpl implements Citizens {
    private Set<Person> idList;
    private Set<Person> lastNameList;
    private Set<Person> ageList;
    private static Comparator<Person> lastNameComparator;
    private static Comparator<Person> ageComparator;

    static {
        lastNameComparator = (p1, p2) -> {
            int res = p1.getLastName().compareTo(p2.getLastName());
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
        };


        ageComparator = (p1, p2) -> {
            int res = Integer.compare(p1.getAge(), p2.getAge());
            return res != 0 ? res : Integer.compare(p1.getId(), p2.getId());
        };


    }

    public CitizensImpl() {
        idList = new HashSet<>();
        lastNameList = new HashSet<>();
        ageList = new HashSet<>();
    }

    public CitizensImpl(List<Person> citizens) {
        this();
        citizens.forEach(p -> add(p));
    }

    // O(n)
    // O(n)
    @Override
    public boolean add(Person person) {
        if (person == null) {
            return false;
        }
        return idList.add(person) && lastNameList.add(person) && ageList.add(person);
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
        boolean index = idList.contains(pattern);
        if (!index){
            return null;
        }
        for (Person person : idList) {
            if (person.equals(pattern)){
                return person;
            }

        }
        return null;
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
//        LocalDate now = LocalDate.now();
//        Person pattern = new Person(Integer.MIN_VALUE, null, null,  now.minusYears(minAge));
//        int from = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;
//        pattern = new Person(Integer.MAX_VALUE, null, null, now.minusYears(maxAge));
//        int to = -Collections.binarySearch(ageList, pattern, ageComparator) - 1;
//        return ageList.subList(from, to);
        return null;
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(String lastName) {
//        Person pattern = new Person(Integer.MIN_VALUE, null, lastName, null);
//        int from = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;
//        pattern = new Person(Integer.MAX_VALUE, null, lastName, null);
//        int to = -Collections.binarySearch(lastNameList, pattern, lastNameComparator) - 1;
//        return lastNameList.subList(from, to);
        return null;
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
