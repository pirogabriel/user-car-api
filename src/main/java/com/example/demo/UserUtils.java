package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;

public class UserUtils {
    public static List<User> findByName(List<User> input, String name){
        return input.stream()
                .filter(u -> name.equalsIgnoreCase(u.getName()))
                .toList();
    }
    public static Set<String> getUniqueNames(List<User> input){
        return input.stream()
                .map(User::getName)
                .collect(Collectors.toSet());
    }
    public static Map<String, Long> countUsersByName(List<User> input){
        return input.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.counting()));
    }
    public static Map<String, User> oldestUserPerName(List<User> input){
        return input.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(User::getAge)), opt -> opt.orElse(null))));
    }
    public static Map<String, Double> averageAgePerName(List<User> input){
        return input.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.averagingInt(User::getAge)));
    }
    public static List<User> top3Oldest(List<User> input){
        return input.stream()
                .sorted(Comparator.comparingInt(User::getAge).reversed())
                .limit(3)
                .toList();
    }
    public static List<User> complexFilter(List<User> users, int age, String firstLetter){
        return users.stream()
                .filter(u -> u.getAge() >= age)
                .filter(u -> u.getName().startsWith(firstLetter))
                .sorted(Comparator.comparingInt(User::getAge))
                .toList();
    }
    public static List<String> userDescriptions(List<User> users){
        return users.stream()
                .map(u -> u.getName() + " - " + u.getAge())
                .toList();
    }
    public static Map<Integer, List<String>> namesGroupedByAge(List<User> users){
        return users.stream()
                .collect(Collectors.groupingBy(User::getAge, Collectors.mapping(User::getName, Collectors.toList())));
    }
    public static String mostCommonNameStream(List<User> input){
        return input.stream()
                .collect(Collectors.groupingBy(User::getName, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
    public static Map<String, Long> countAdultsByName(List<User> input){
        return input.stream()
                .filter(u -> u.getAge() >= 18)
                .collect(Collectors.groupingBy(User::getName, Collectors.counting()));
    }
    public static List<UserDTO> toDTO(List<User> users){
        return users.stream()
                .map(u -> new UserDTO(u.getName(), u.getAge()))
                .toList();
    }
    public static boolean hasAdult(List<User> users){
        return users.stream()
                .anyMatch(u -> u.getAge() >= 18);
    }
    public static List<User> validUsers(List<User> users){
        return users.stream()
                .filter(u -> u.getName() != null && u.getAge()>0)
                .toList();
    }
    public static List<String> onlyAdultsNames(List<User> input){
        return input.stream()
                .filter(u -> u.getAge()>=18)
                .map(User::getName)
                .toList();
    }
    public static List<User> onlyAdults(List<User> input){
        return input.stream().filter(u -> u.getAge() >= 18).toList();
    }
    public static Map<String, Object> userSummary(List<User> users){
        Map<String, Object> summary = new HashMap<>();

        summary.put("totalUsers", users.size());
        summary.put("uniqueNames", getUniqueNames(users).size());
        summary.put("mostCommonName", mostCommonNameStream(users));
        summary.put("averageAge", users.stream().mapToInt(User::getAge).average().orElse(0.0));

        return summary;
    }
    public static User findById(List<User> input, int id){
        return input.stream().filter(u -> u.getId() == id).findFirst().orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
