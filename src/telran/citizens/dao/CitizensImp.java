package telran.citizens.dao;

import telran.citizens.interfaces.Citizens;
import telran.citizens.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CitizensImp implements Citizens {
    List<Person> idList;
    List<Person> lastNameList;
    List<Person> ageList;
    static Comparator<Person> lastNameComparator = (p1, p2) -> p1.getLastName().compareTo(p2.getLastName());
    static Comparator<Person> ageComparator = (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge());

    public CitizensImp() {
        idList = new ArrayList<Person>();
        lastNameList = new ArrayList<Person>();
        ageList = new ArrayList<Person>();
        Collections.sort(idList, Person::compareTo);
        Collections.sort(lastNameList, lastNameComparator);
        Collections.sort(ageList, ageComparator);
    }


    public CitizensImp(List<Person> citizens) {

        idList = new ArrayList<Person>();
        lastNameList = new ArrayList<Person>();
        ageList = new ArrayList<Person>();

        for (Person citizen : citizens) {
            if (!idList.contains(citizen)) {
                idList.add(citizen);
                lastNameList.add(citizen);
                ageList.add(citizen);
            }
        }
        Collections.sort(idList, (p1, p2) -> p1.compareTo(p2));
        Collections.sort(lastNameList, lastNameComparator);
        Collections.sort(ageList, ageComparator);

    }

    @Override
    public boolean add(Person person) {
        if (person == null || idList.contains(person)) {
            return false;
        }

        int index = Collections.binarySearch(idList, person);
        idList.add(-index - 1, person);

        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        if (index > 0) {
            lastNameList.add(index, person);
        } else {
            lastNameList.add((-index) - 1, person);
        }

        index = Collections.binarySearch(ageList, person, ageComparator);
        if (index > 0) {
            ageList.add(index, person);
        } else {
            ageList.add(-index - 1, person);
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        Person toRemove = find(id);
        if (toRemove == null) {
            return false;
        }
        idList.remove(toRemove);
        lastNameList.remove(toRemove);
        ageList.remove(toRemove);
        return true;
    }

    @Override
    public Person find(int id) {
        Person template = new Person(id, null, null, 0);
        int index = Collections.binarySearch(idList, template);
        if (index > 0) {
            return idList.get(index);
        }
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        Person template1 = new Person(0, null, null, minAge);
        Person template2 = new Person(0, null, null, maxAge);
        int indexMin = Collections.binarySearch(ageList, template1, ageComparator);
        int indexMax = Collections.binarySearch(ageList, template2, ageComparator);
        if (indexMin < 0 || indexMax < 0 || indexMax < indexMin) {
            ArrayList<Person> res = new ArrayList<Person>();
            return res;
        }
        ArrayList<Person> res = new ArrayList<>(ageList.subList(indexMin, indexMax + 1));
        for (Person re : res) {
            System.out.println(re);
        }
        return res;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        List<Person> res = new ArrayList<>();

//        Person template = new Person(0, null, lastName, 0);
//        int index = Collections.binarySearch(lastNameList, template, lastNameComparator);

//
//        res.add(lastNameList.get(index));
        for (Person person : lastNameList) {
            if (person.getLastName().equals(lastName)) {
                res.add(person);
            }
        }
        for (Person re : res) {
            System.out.println(re);

        }
        return res;

    }

    @Override
    public Iterable<Person> getAllPersonSortedById() {
        return idList;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByAge() {
        return ageList;
    }

    @Override
    public Iterable<Person> getAllPersonSortedByLastName() {
        return lastNameList;
    }

    @Override
    public int size() {
        if (idList.size() == lastNameList.size() && idList.size() == ageList.size()) {
            return idList.size();
        }
        return -1;
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
