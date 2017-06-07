package com.example.android.reportcard;

import java.util.ArrayList;

/**
 * A custom class for report cards. This class contains 2 attributes. An attribute for the Student,
 * represented by a custom student class object, declared as an inner class below, and then an
 * ArrayList of custom Grade class objects, again declared as an inner class below. I have also
 * written custom inner classes for Modules and Teachers, with methods contained within.
 *
 * I initially wrote all the custom classes separately before realising I was only allowed submit it
 * in one class file. I then came up with this solution. Ideally the classes would be separated out
 * and the ReportCard constructor below would initialise both its attributes that would be passed as
 * parameters.
 */
public class ReportCard {

    private Student mStudent;
    private ArrayList<Grade> mGrades;

    /**
     * Instantiates a new Report card.
     * Not setting any attributes as they are inner classes and each must be instantiated first.
     * Otherwise I would have to set both to null, initially before setting them later in the pseudo
     * constructors below.
     */
    public ReportCard() {
    }

    /**
     * Gets student.
     *
     * @return the student
     */
    public Student getmStudent() {
        return mStudent;
    }

    /**
     * Sets student.
     *
     * @param mStudent the student
     */
    public void setmStudent(Student mStudent) {
        this.mStudent = mStudent;
    }

    /**
     * Gets grades.
     *
     * @return the grades
     */
    public ArrayList<Grade> getmGrades() {
        return mGrades;
    }

    /**
     * Sets grades.
     *
     * @param mGrades the grades
     */
    public void setmGrades(ArrayList<Grade> mGrades) {
        this.mGrades = mGrades;
    }

    /**
     * A method to parse the report card into a multi-line String variable.
     *
     * @return a String variable containing Student name & ID, and all the grades for each module
     * they took.
     */
    public String toString() {
        String str = "Student Name: \t\t" + this.mStudent.getmStudentName() +
                "\r\nStudent ID: \t\t\t\t" + this.mStudent.getmStudentID();

        for (Grade grade : mGrades) {
            str += "\r\nModule: " + grade.getmModule().getmModuleName() + ". \t\tMark: " + grade.getmFinalGrade() +
                    ". Grade: " + grade.getmLetterGrade().toString();
        }
        return str;
    }


    /*
     * The 5 methods below are pseudo constructors to allow the user to access the nested classes
     * when instantiating new objects of said classes.
     */

    /**
     * For creating new Grades.
     *
     * @param mStudent    the student
     * @param mModule     the module
     * @param mFinalGrade the final grade
     * @return the grade
     */
    public Grade newGrade(Student mStudent, Module mModule, int mFinalGrade) {
        return new Grade(mStudent, mModule, mFinalGrade);
    }

    /**
     * For creating new Module.
     *
     * @param mModuleID   the module id
     * @param mModuleName the module name
     * @return the module
     */
    public Module newModule(int mModuleID, String mModuleName) {
        return new Module(mModuleID, mModuleName);
    }

    /**
     * For creating new Module.
     *
     * @param mModuleID       the module id
     * @param mModuleName     the module name
     * @param mModuleLeader   the module leader
     * @param mModuleTeachers the module teachers
     * @return the module
     */
    Module newModule(int mModuleID, String mModuleName, Teacher mModuleLeader, ArrayList<Teacher> mModuleTeachers) {
        return new Module(mModuleID, mModuleName, mModuleLeader, mModuleTeachers);
    }

    /**
     * For creating new Student.
     *
     * @param mModulesTaken the modules taken
     * @return the student
     */
    Student newStudent(ArrayList<Module> mModulesTaken) {
        return new Student(4579834, "John Green", mModulesTaken);
    }

    /**
     * For creating new Teacher.
     *
     * @param mTeacherID     the teacher id
     * @param mTeacherName   the teacher name
     * @param mModulesTaught the modules taught
     * @param mModulesLead   the modules lead
     * @return the teacher
     */
    Teacher newTeacher(int mTeacherID, String mTeacherName, ArrayList<Module> mModulesTaught, ArrayList<Module> mModulesLead) {
        return new Teacher(mTeacherID, mTeacherName, mModulesTaught, mModulesLead);
    }

    /*
     * Below are 4 nested classes representing Students, Modules, Grades and their Teachers.
     * The Grade class also has a nest Enum to represent the letter grade, such as A1, C2, E, etc...
     */

    /**
     * A custom class to represent Teachers
     */
    static class Teacher {

        private int mTeacherID;
        private String mTeacherName;

        //An array of Modules that the teacher teaches.
        private ArrayList<Module> mModulesTaught;

        //An array of Modules that the teacher leads/coordinates.
        private ArrayList<Module> mModulesLead;

        /**
         * Instantiates a new Teacher.
         *
         * @param mTeacherID     the teacher id
         * @param mTeacherName   the teacher name
         * @param mModulesTaught the modules taught
         * @param mModulesLead   the modules lead
         */
        public Teacher(int mTeacherID, String mTeacherName, ArrayList<Module> mModulesTaught, ArrayList<Module> mModulesLead) {
            this.mTeacherID = mTeacherID;
            this.mTeacherName = mTeacherName;
            this.mModulesTaught = mModulesTaught;
            this.mModulesLead = mModulesLead;
        }

        /**
         * Gets teacher id.
         *
         * @return the teacher id
         */
        public int getmTeacherID() {
            return mTeacherID;
        }

        /**
         * Sets teacher id.
         *
         * @param mTeacherID the teacher id
         */
        public void setmTeacherID(int mTeacherID) {
            this.mTeacherID = mTeacherID;
        }

        /**
         * Gets teacher name.
         *
         * @return the teacher name
         */
        public String getmTeacherName() {
            return mTeacherName;
        }

        /**
         * Sets teacher name.
         *
         * @param mTeacherName the teacher name
         */
        public void setmTeacherName(String mTeacherName) {
            this.mTeacherName = mTeacherName;
        }

        /**
         * Gets modules taught.
         *
         * @return the modules taught
         */
        public ArrayList<Module> getmModulesTaught() {
            return mModulesTaught;
        }

        /**
         * Sets modules taught.
         *
         * @param mModulesTaught the modules taught
         */
        public void setmModulesTaught(ArrayList<Module> mModulesTaught) {
            this.mModulesTaught = mModulesTaught;
        }

        /**
         * Gets modules lead.
         *
         * @return the modules lead
         */
        public ArrayList<Module> getmModulesLead() {
            return mModulesLead;
        }

        /**
         * Sets modules lead.
         *
         * @param mModulesLead the m modules lead
         */
        public void setmModulesLead(ArrayList<Module> mModulesLead) {
            this.mModulesLead = mModulesLead;
        }

        /**
         * Add module taught.
         *
         * @param newModule the new module
         */
        public void addModuleTaught(Module newModule) {
            this.mModulesTaught.add(newModule);
        }

        /**
         * Drop module taught.
         *
         * @param droppedModule the dropped module
         */
        public void dropModuleTaught(Module droppedModule) {
            this.mModulesTaught.remove(droppedModule);
        }

        /**
         * Add module lead.
         *
         * @param newModule the new module
         */
        public void addModuleLead(Module newModule) {
            this.mModulesLead.add(newModule);
        }

        /**
         * Drop module lead.
         *
         * @param droppedModule the dropped module
         */
        public void dropModuleLead(Module droppedModule) {
            this.mModulesLead.remove(droppedModule);
        }
    }

    /**
     * A custom class for Students
     */
    static class Student {

        private int mStudentID;
        private String mStudentName;

        //An array of Modules that the student is taking.
        private ArrayList<Module> mModulesTaken;

        /**
         * Instantiates a new Student.
         *
         * @param mStudentID    the student id
         * @param mStudentName  the student name
         * @param mModulesTaken the modules taken
         */
        public Student(int mStudentID, String mStudentName, ArrayList<Module> mModulesTaken) {
            this.mStudentID = mStudentID;
            this.mStudentName = mStudentName;
            this.mModulesTaken = mModulesTaken;
        }

        /**
         * Gets student id.
         *
         * @return the student id
         */
        public int getmStudentID() {
            return mStudentID;
        }

        /**
         * Sets student id.
         *
         * @param mStudentID the student id
         */
        public void setmStudentID(int mStudentID) {
            this.mStudentID = mStudentID;
        }

        /**
         * Gets student name.
         *
         * @return the student name
         */
        public String getmStudentName() {
            return mStudentName;
        }

        /**
         * Sets student name.
         *
         * @param mStudentName the student name
         */
        public void setmStudentName(String mStudentName) {
            this.mStudentName = mStudentName;
        }

        /**
         * Gets modules taken.
         *
         * @return the modules taken
         */
        public ArrayList<Module> getmModulesTaken() {
            return mModulesTaken;
        }

        /**
         * Sets modules taken.
         *
         * @param mModulesTaken the modules taken
         */
        public void setmModulesTaken(ArrayList<Module> mModulesTaken) {
            this.mModulesTaken = mModulesTaken;
        }

        /**
         * A quick method to add a new module to a Student's Module list
         *
         * @param newModule takes in a parameter of type Module
         */
        public void addNewModule(Module newModule) {
            this.mModulesTaken.add(newModule);
        }

        /**
         * A quick method to remove a module from a Student's Module list, should they wish to drop one
         *
         * @param droppedModule takes in a parameter of type Module
         */
        public void dropModule(Module droppedModule) {
            this.mModulesTaken.remove(droppedModule);
        }
    }

    /**
     * A custom class for modules taken by Students and taught my Teachers
     */
    static class Module {

        private int mModuleID;
        private String mModuleName;

        //The Teacher who is the course leader
        private Teacher mModuleLeader;

        //An array of Teachers who teach the Module
        private ArrayList<Teacher> mModuleTeachers;

        /**
         * Instantiates a new Module.
         *
         * @param mModuleID       the Module ID
         * @param mModuleName     the Module Name
         * @param mModuleLeader   the Module Leader
         * @param mModuleTeachers the Module Teachers
         */
        public Module(int mModuleID, String mModuleName, Teacher mModuleLeader, ArrayList<Teacher> mModuleTeachers) {
            this.mModuleID = mModuleID;
            this.mModuleName = mModuleName;
            this.mModuleLeader = mModuleLeader;
            this.mModuleTeachers = mModuleTeachers;
        }

        public Module(int mModuleID, String mModuleName) {
            this.mModuleID = mModuleID;
            this.mModuleName = mModuleName;
        }

        /**
         * Gets module id.
         *
         * @return the module id
         */
        public int getmModuleID() {
            return mModuleID;
        }

        /**
         * Sets module id.
         *
         * @param mModuleID the Module ID
         */
        public void setmModuleID(int mModuleID) {
            this.mModuleID = mModuleID;
        }

        /**
         * Gets module name.
         *
         * @return the Module Name
         */
        public String getmModuleName() {
            return mModuleName;
        }

        /**
         * Sets module name.
         *
         * @param mModuleName the Module name
         */
        public void setmModuleName(String mModuleName) {
            this.mModuleName = mModuleName;
        }

        /**
         * Gets module leader.
         *
         * @return the module leader
         */
        public Teacher getmModuleLeader() {
            return mModuleLeader;
        }

        /**
         * Sets module leader.
         *
         * @param mModuleLeader the Module leader
         */
        public void setmModuleLeader(Teacher mModuleLeader) {
            this.mModuleLeader = mModuleLeader;
        }

        /**
         * Gets module teachers.
         *
         * @return the module teachers
         */
        public ArrayList<Teacher> getmModuleTeachers() {
            return mModuleTeachers;
        }

        /**
         * Sets module teachers.
         *
         * @param mModuleTeachers the Module teachers
         */
        public void setmModuleTeachers(ArrayList<Teacher> mModuleTeachers) {
            this.mModuleTeachers = mModuleTeachers;
        }

        /**
         * A quick method to add a new teacher to the module
         *
         * @param newTeacher Takes in a parameter of type Teacher
         */
        public void addTeacher(Teacher newTeacher) {
            this.mModuleTeachers.add(newTeacher);
        }

        /**
         * A quick method to remove a teacher from the module
         *
         * @param removedTeacher takes in a param of type teacher
         */
        public void removeTeacher(Teacher removedTeacher) {
            this.mModuleTeachers.remove(removedTeacher);
        }

    }

    /**
     * A custom class to represent grades of Students
     */
    static class Grade {

        private Student mStudent;
        private Module mModule;
        private int mFinalGrade;
        private boolean mHasPassed;
        private final Enum mLetterGrade;

        /**
         * A quick little Enum to represent the LetterGrade. Each LetterGrade constant has a minimum
         * mark and a maximum mark so you can calculate which LetterGrade based on the final
         * percentage mark.
         */

        enum LetterGrade {
            A1(90, 100), A2(85, 89), B1(80, 84), B2(75, 79), B3(70, 74), C1(65, 69), C2(60, 64), C3(55, 59),
            D1(50, 54), D2(45, 49), D3(40, 44), E(25, 39), F(10, 24), NG(0, 9);

            private final int minMark, maxMark;

            LetterGrade(int minMark, int maxMark) {
                this.minMark = minMark;
                this.maxMark = maxMark;
            }

            public static LetterGrade getGrade(int finalMark) {
                for (LetterGrade grade : values()) {
                    if (grade.minMark <= finalMark && grade.maxMark >= finalMark) {
                        return grade;
                    }
                }
                throw new IllegalArgumentException("Invalid mark");
            }


        }

        /**
         * Instantiates a new Grade.
         *
         * @param mStudent    the student
         * @param mModule     the module
         * @param mFinalGrade the final grade
         */
        public Grade(Student mStudent, Module mModule, int mFinalGrade) {
            this.mStudent = mStudent;
            this.mModule = mModule;
            this.mFinalGrade = mFinalGrade;
            this.mLetterGrade = LetterGrade.getGrade(mFinalGrade);
            this.setHasPassed();
        }

        /**
         * Gets student.
         *
         * @return the student
         */
        public Student getmStudent() {
            return mStudent;
        }

        /**
         * Sets student.
         *
         * @param mStudent the student
         */
        public void setmStudent(Student mStudent) {
            this.mStudent = mStudent;
        }

        /**
         * Gets module.
         *
         * @return the module
         */
        public Module getmModule() {
            return mModule;
        }

        /**
         * Sets module.
         *
         * @param mModule the module
         */
        public void setmModule(Module mModule) {
            this.mModule = mModule;
        }

        /**
         * Gets final grade.
         *
         * @return the final grade
         */
        public int getmFinalGrade() {
            return mFinalGrade;
        }

        /**
         * Sets final grade.
         *
         * @param mFinalGrade the final grade
         */
        public void setmFinalGrade(int mFinalGrade) {
            this.mFinalGrade = mFinalGrade;
        }

        public Enum getmLetterGrade() {
            return mLetterGrade;
        }

        /**
         * Sets whether the student has passed the module
         */
        private void setHasPassed() {
            if (this.mFinalGrade < 40) {
                this.mHasPassed = false;
            } else {
                this.mHasPassed = false;
            }
        }

        public String toString() {
            return mStudent.getmStudentName() + " scored " + this.mFinalGrade + " in " +
                    this.mModule.getmModuleName() + ". Result: " + this.mLetterGrade.toString() + ".";
        }
    }
}
