package fr.univtln.mgajovski482.HyperPlanning.GroupInFormation.GroupInFormationGenerator;

import fr.univtln.mgajovski482.HyperPlanning.Class.Course;
import fr.univtln.mgajovski482.HyperPlanning.Consts;
import fr.univtln.mgajovski482.HyperPlanning.GroupInFormation.GroupInFormation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Maxime on 06/11/2015.
 */
public class GroupInFormationGenerator {

    private static Random random
            = new Random();

    private static Course[] courses =
            Course.staticClassMap.values().toArray(new Course[0]);


    private static final char[] letters;
    private static final char[] numbers;

    static{
        StringBuilder lettersTemp = new StringBuilder();
        StringBuilder numbersTemp= new StringBuilder();

        for(char ch = 'A'; ch <= 'Z'; ch++)
            lettersTemp.append(ch);

        for(char ch = '0'; ch <= '9'; ch++)
            numbersTemp.append(ch);

        letters = lettersTemp.toString().toCharArray();
        numbers = numbersTemp.toString().toCharArray();
    }

    public static void generateGroups(int nbOfGroups){
        for(int i = 0; i < nbOfGroups; i++)generateCourses();
    }

    public static GroupInFormation generateGroup(){

        int randomCourse = random.nextInt(courses.length);
        return new GroupInFormation()
                .setLabel("GROUP " + getRandomLabel())
                .addCourses(generateCourses());
    }


    private static String getRandomLabel(){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(letters[random.nextInt(letters.length)]);
        for(int i = 0; i < Consts.GROUP_NAME_LENGTH - 1; i++)
            stringBuilder.append(numbers[random.nextInt(numbers.length)]);

        return stringBuilder.toString();
    }

    private static int getRandomNumber (int min, int max){
        if (min < max)
            return min + new Random().nextInt(Math.abs(max - min));
        return min - new Random().nextInt(Math.abs(max - min));
    }

    private static List<Course> generateCourses(){
        List<Course> randomCourses = new ArrayList<Course>();

        int randomNumberOfCourses = getRandomNumber (
                Consts.GROUP_MIN_COURSES, Consts.GROUP_MAX_COURSES);
        int randomCourseIndex;
        for(int i = 0; i < randomNumberOfCourses; i++){
            randomCourseIndex  = random.nextInt(courses.length);
            randomCourses.add(courses[randomCourseIndex]);
        }

        return randomCourses;
    }


}
