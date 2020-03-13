package com.kiwiplan.management;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.*;

public class ManagementTree {
    static Map<Long, Employee> employees;
    static Employee root;

    public static void main(String[] args) throws IOException {
        employees = new HashMap<Long, Employee>();
        List<Employee> employeeList = readInput();
        displayManagementTree(employeeList);

    }



    private static List<Employee> readInput(){

        final String dir = System.getProperty("user.dir");
        String path = dir.replace("/", "\\\\") + "\\src\\main\\resources\\";

        List<Employee> employeeList = new ArrayList<>();

        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(path+ "input2.json")) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            // loop array
            JSONArray array = (JSONArray) jsonObject.get("employees");
            Iterator<JSONObject> iterator = array.iterator();
            Employee employee = null;

            while (iterator.hasNext()) {
                JSONObject object = iterator.next();
                String name = (String) object.get("name");
                long empId = (Long) object.get("id");
                long mId = (Long) object.get("mId");
                employee = new Employee(empId, name, mId);
                employeeList.add(employee);
            }

        } catch (IOException e) {
            System.err.println("IOException: " + e);
        } catch (ParseException e) {
            System.err.println("ParseException: " + e);
        }

        return  employeeList;
    }

    static void displayManagementTree(List<Employee> employeeList){
        for (Employee employee: employeeList) {
            employees.put(employee.getId(), employee);
            if (employee.getManagerId() == 0) {
                root = employee;
            }
        }
        createLevels(root);
        print(root, 0);
    }


    private static void createLevels(Employee localRoot) {
        Employee employee = localRoot;
        List<Employee> subordinates = getSubordinatesById(employee.getId());
        Collections.sort(subordinates, new NameSorter());
        employee.setSubordinates(subordinates);
        if (subordinates.size() == 0) {
            return;
        }

        for (Employee e : subordinates) {
            createLevels(e);
        }
    }

    private static List<Employee> getSubordinatesById(long rid) {
        List<Employee> subordinates = new ArrayList<Employee>();
        for (Employee e : employees.values()) {
            if (e.getManagerId() == rid) {
                subordinates.add(e);
            }
        }
        return subordinates;
    }


    private static void print(Employee localRoot, int level) {

        for (int i = 0; i < level; i++) {
            System.out.print("->");
        }

        List<Employee> subordinates = localRoot.getSubordinates();
        System.out.print("->");
        System.out.println(localRoot.getName());

        for (Employee e : subordinates) {
            print(e, level + 1);
        }
    }
}
