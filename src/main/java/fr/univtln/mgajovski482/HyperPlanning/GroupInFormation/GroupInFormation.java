package fr.univtln.mgajovski482.HyperPlanning.GroupInFormation;

import fr.univtln.mgajovski482.HyperPlanning.Course.Course;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GroupInFormation {

    private static int ID = 0;

    public static Map<Integer, GroupInFormation> staticGroupInFormationMap =
            new HashMap<Integer, GroupInFormation>();

    private Map<Integer, Course> groupCoursesMap
            = new HashMap<Integer, Course>();

    public int pierre ;
    private int id;
    private String label;

    public GroupInFormation(){
        this.id = ID;
        staticGroupInFormationMap.put(id, this);
        ID++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(this.id == ID-1){
            ID--;
        }
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public GroupInFormation setLabel(String label){
        this.label = label;
        return this;
    }

    public Map<Integer, Course> getGroupCoursesMap() {
        return groupCoursesMap;
    }

    public GroupInFormation addCourses(List<Course> courses) {
        for(Course currentCourse : courses)
            groupCoursesMap.put(currentCourse.getId(), currentCourse);
        return this;
    }

        @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupInFormation)) return false;

        GroupInFormation that = (GroupInFormation) o;

        return id == that.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Intitule : " + label + "\n");
        //stringBuilder.append("Nombres de cours : " + groupCoursesMap.values().size() + "\n");
        return stringBuilder.toString();
    }
}
