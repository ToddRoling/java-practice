package com.github.toddroling.java.interview.preperation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BadgeLog {

    public static final String EMPLOYEE_ACTION_ENTER = "enter";
    public static final String EMPLOYEE_ACTION_EXIT = "exit";

    public List<Set<String>> getViolations(List<String[]> badgeRecords) {

        Set<String> entriesWithoutExits = new HashSet<>();
        Set<String> exitsWithoutEntries = new HashSet<>();
        Set<String> occupants = new HashSet<>();

        for (String[] badgeRecord : badgeRecords) {

            String employeeName = badgeRecord[0];
            String employeeAction = badgeRecord[1];

            if (employeeAction.equals(EMPLOYEE_ACTION_ENTER)) {
                if (occupants.contains(employeeName))
                    entriesWithoutExits.add(employeeName);
                else
                    occupants.add(employeeName);
            } else if (employeeAction.equals(EMPLOYEE_ACTION_EXIT)) {
                if (!occupants.contains(employeeName))
                    exitsWithoutEntries.add(employeeName);
                else
                    occupants.remove(employeeName);
            }
        }
        entriesWithoutExits.addAll(occupants);
        return List.of(entriesWithoutExits, exitsWithoutEntries);
    }
}
