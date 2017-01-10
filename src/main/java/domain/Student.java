package domain;

import json.*;

import java.util.HashMap;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private HashMap<String, Json> innerStudent;
    private JsonPair[] studentData;
    public String name, surname;
    public Integer year;
    public Tuple<String, Integer>[] exams;


    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams = exams;
        toJsonObject();

    }

    @Override
    public JsonObject toJsonObject() {

        studentData = new JsonPair[4];
        studentData[0] = new JsonPair("name", new JsonString(name));
        studentData[1] = new JsonPair("surname", new JsonString(surname));
        studentData[2] = new JsonPair("year", new JsonNumber(year));
        JsonObject[] tmp = new JsonObject[exams.length];
        for (int i = 0; i < exams.length; ++i) {
            JsonPair course = new JsonPair("course", new JsonString(exams[i].key));
            JsonPair mark = new JsonPair("mark", new JsonNumber(exams[i].value));
            JsonPair status;
            if (exams[i].value >= 3) {
                status = new JsonPair("passed", new JsonBoolean(true));
            } else {
                status = new JsonPair("passed", new JsonBoolean(false));
            }
            tmp[i] = new JsonObject(course, mark, status);
        }
        studentData[3] = new JsonPair("exams", new JsonArray(tmp));
        return new JsonObject(studentData);
    }
}