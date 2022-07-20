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
    }



    public CitizensImp(List<Person> citizens) {

        idList = new ArrayList<Person>();
        lastNameList = new ArrayList<Person>();
        ageList = new ArrayList<Person>();

        for (Person citizen : citizens) {
            if (!idList.contains(citizen)){
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
        if (person == null || idList.contains(person)){
            return false;
        }

        int index = Collections.binarySearch(idList, person);
        idList.add(-index-1, person);

        index = Collections.binarySearch(lastNameList, person, lastNameComparator);
        if (index>0){
            lastNameList.add(index,person);
        }else {
            lastNameList.add((-index)-1,person);
        }

        index = Collections.binarySearch(ageList, person, ageComparator);
        if (index>0){
            ageList.add(index,person);
        }else {
            ageList.add(-index-1,person);
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        //TODO:
        return false;
    }

    @Override
    public Person find(int id) {
        Person template = new Person(id, null, null, 0);
        int index = Collections.binarySearch(idList, template);
        if (index>0){
            return idList.get(index);
        }
        return null;
    }

    @Override
    public Iterable<Person> find(int minAge, int maxAge) {
        //TODO
        return null;
    }

    @Override
    public Iterable<Person> find(String lastName) {
        //TODO
        return null;
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
