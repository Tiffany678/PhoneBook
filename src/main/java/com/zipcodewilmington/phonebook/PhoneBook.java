package com.zipcodewilmington.phonebook;

import java.util.*;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private Map<String, List<String>> phonebook;
    //private ArrayList<String> phoneNumber = new ArrayList<>();

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        phonebook = new HashMap<>();
    }

    public void add(String name, String phoneNumber) {
        if(phonebook.get(name)==null){
            phonebook.put(name, new ArrayList<String>());
        }
        phonebook.get(name).add(phoneNumber);
    }

    public void addAll(String name, String... phoneNumbers) {

        if(phonebook.get(name) == null){
            phonebook.put(name,new ArrayList<>(Arrays.asList(phoneNumbers)));

        }else {
            for (int i = 0; i < phoneNumbers.length; i++) {
                phonebook.get(name).add(phoneNumbers[i]);
            }
        }
    }

    public void remove(String name) {

        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
       // System.out.println(phonebook.containsKey(name));
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        for (Map.Entry<String, List<String>> entry : phonebook.entrySet()) {
            if (entry.getValue().contains(phoneNumber)) {

                return entry.getKey();
            }
        }
     return " ";
    }

    public List<String> getAllContactNames() {
        ArrayList<String> result = new ArrayList<>();
        for(String key: phonebook.keySet()){
            result.add(key);
        }
        return result;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
