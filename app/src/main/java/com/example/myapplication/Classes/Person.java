package com.example.myapplication.Classes;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;

import com.example.myapplication.A;

import java.util.ArrayList;

import static com.example.myapplication.Classes.DataBase.TABLE_PERSONS;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public static final String
            KEY_ID = "person_id",
            KEY_FIRST_NAME = "first_name",
            KEY_LAST_NAME = "last_name",
            KEY_USERNAME = "user_name",
            KEY_PASSWORD = "password";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NonNull
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    public void addPerson(ContentValues person) {
        SQLiteDatabase sqdb = new DataBase().getWritableDatabase();
        sqdb.insert(TABLE_PERSONS, null, person);
    }

    public int removePerson(int person_id) {
        SQLiteDatabase sqdb = new DataBase().getWritableDatabase();
        return sqdb.delete(TABLE_PERSONS, Person.KEY_ID + "=" + person_id, null);
    }

    public Person idToPerson(int person_id) {
        SQLiteDatabase sqdb = new DataBase().getWritableDatabase();
        Cursor person_cursor = sqdb.query(TABLE_PERSONS, null,
                Person.KEY_ID + "=" + person_id, null, null, null, null);
        person_cursor.moveToFirst();
        return cursorToPerson(person_cursor);
    }

    public Person cursorToPerson(Cursor person_cursor) {
        Person person = new Person();
        if (person_cursor == null || person_cursor.getCount() == 0) {
            return person;
        }
        person.setId(person_cursor.getInt(person_cursor.getColumnIndex(Person.KEY_ID)));
        person.setFirstName(person_cursor.getString(person_cursor.getColumnIndex(Person.KEY_FIRST_NAME)));
        person.setLastName(person_cursor.getString(person_cursor.getColumnIndex(Person.KEY_LAST_NAME)));
        person.setUserName(person_cursor.getString(person_cursor.getColumnIndex(Person.KEY_USERNAME)));
        person.setPassword(person_cursor.getString(person_cursor.getColumnIndex(Person.KEY_PASSWORD)));
        return person;
    }

    public ArrayList<Person> getPeople(String where, String sortBy) {
        SQLiteDatabase sqdb = new DataBase().getWritableDatabase();
        Cursor person_cursor = sqdb.query(TABLE_PERSONS, null,
                where, null, null, null, Person.KEY_ID);

        ArrayList<Person> people = new ArrayList<>(person_cursor.getCount() + 1);
        if (person_cursor.moveToFirst()) {
            do {
                people.add(cursorToPerson(person_cursor));
            } while (person_cursor.moveToNext());
        }

        person_cursor.close();
        return people;
    }

}
