package telran.citizens.dao;

import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.time.LocalDate;
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
//        long t1 = System.currentTimeMillis();
        Person pattern = new Person(id, null, null, null);
        boolean index = idList.contains(pattern);
        if (!index){
            return null;
        }
        for (Person person : idList) {
            if (person.equals(pattern)){
//                long t2 = System.currentTimeMillis();
//                System.out.println(t2-t1);
                return person;
            }
        }
        return null;
    }

    // O(log(n))
    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        LocalDate now = LocalDate.now();
        TreeSet<Person> ageTree = setConvertor(ageList, ageComparator);
        Person patternMin = new Person(Integer.MIN_VALUE, null, null,  now.minusYears(minAge));
        Person patternMax = new Person(Integer.MAX_VALUE, null, null, now.minusYears(maxAge));
        return ageTree.subSet(patternMin,patternMax);
    }


    // O(log(n))
    @Override
    public Iterable<Person> find(String lastName) {
        Person patternMin = new Person(Integer.MIN_VALUE, null, lastName, null);
        TreeSet<Person> familyNameTree = setConvertor(lastNameList, lastNameComparator);
        Person patternMax = new Person(Integer.MAX_VALUE, null, lastName, null);
        return familyNameTree.subSet(patternMin, patternMax);
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedById() {
        return new TreeSet<>(idList);
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedByLastName() {
        return setConvertor(lastNameList, lastNameComparator);
    }

    // O(1)
    @Override
    public Iterable<Person> getAllPersonSortedByAge() {
        long t1 = System.currentTimeMillis();
        TreeSet<Person> ageTree = setConvertor(ageList, ageComparator);
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);
        return ageTree;
    }

    // O(1)
    @Override
    public int size() {
        return idList.size();


    }

    private TreeSet<Person> setConvertor (Set<Person> set, Comparator<Person> comparator){
        TreeSet<Person> personTreeSet = new TreeSet<>(comparator);
        personTreeSet.addAll(set);
        return personTreeSet;
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
