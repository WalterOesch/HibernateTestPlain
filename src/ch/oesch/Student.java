package ch.oesch;

import javax.persistence.*;

/**
 * Created by Walter Oesch on 14.05.2017.
 */
@Entity
@Table
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstName;
    private Integer age;

    public Student() {};

    public Student(Integer id, String firstName, Integer age) {
        this.setId(id);
        this.setFirstName(firstName);
        this.setAge(age);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
