package org.spring.mock.Model;

public class Student {
    private String fullname;
    private Integer yearGraduated;

    public Student() {
    }

    public Student(String fullname, Integer yearGraduated) {
        this.fullname = fullname;
        this.yearGraduated = yearGraduated;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getYearGraduated() {
        return yearGraduated;
    }

    public void setYearGraduated(Integer yearGraduated) {
        this.yearGraduated = yearGraduated;
    }

    @Override
    public String toString() {
        return "Student{" +
                "fullname='" + fullname + '\'' +
                ", yearGraduated=" + yearGraduated +
                '}';
    }
}
