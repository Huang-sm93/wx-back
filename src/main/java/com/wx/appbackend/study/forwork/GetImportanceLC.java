package com.wx.appbackend.study.forwork;

import java.util.*;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/12/21
 */
public class GetImportanceLC {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee();
        employee1.id = 1;
        employee1.importance = 5;
        List<Integer> subordinates1 = new ArrayList<>();
        subordinates1.add(2);
        subordinates1.add(3);
        employee1.subordinates = subordinates1;
        employees.add(employee1);
        Employee employee2 = new Employee();
        employee2.id = 2;
        employee2.importance = 3;
        List<Integer> subordinates2 = new ArrayList<>();
        employees.add(employee2);
        Employee employee3 = new Employee();
        employee3.id = 3;
        employee3.importance = 3;
        List<Integer> subordinates3 = new ArrayList<>();
        employees.add(employee3);
        Solution solution = new Solution();
        int result = solution.getImportance(employees, 1);
        System.out.println(result);
    }

    static class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    static class Solution {
        Map<Integer, Employee> employeeMap = new HashMap<>();
        public int getImportance(List<Employee> employees, int id) {
            for (Employee employee : employees) {
                employeeMap.put(employee.id, employee);
            }
            List<Integer> subordinates = employeeMap.get(id).subordinates;
            return employeeMap.get(id).importance+addImportance(subordinates);
        }

        private int addImportance(List<Integer> subordinates) {
            if (subordinates == null || subordinates.size() == 0){
                return 0;
            }
            int count = 0;
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < subordinates.size(); i++) {
                count += employeeMap.get(subordinates.get(i)).importance;
                if (employeeMap.get(subordinates.get(i)).subordinates != null && employeeMap.get(subordinates.get(i)).subordinates.size() > 0){
                    temp.addAll(employeeMap.get(subordinates.get(i)).subordinates);
                }
            }
            return count+addImportance(temp);
        }
    }
}

