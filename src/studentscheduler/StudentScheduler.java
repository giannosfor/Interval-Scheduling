package studentscheduler;

import java.util.ArrayList;

public class StudentScheduler {

    private static boolean[][] schedules = {
        {false, true, true, true, false, false, false, false, false, false, false},
        {false, false, false, true, true, false, false, false, false, false, false},
        {true, true, true, true, true, true, false, false, false, false, false},
        {false, false, false, false, true, true, true, false, false, false, false},
        {false, false, false, true, true, true, true, true, false, false, false},
        {false, false, false, false, false, true, true, true, true, false, false},
        {false, false, false, false, false, false, true, true, true, true, false},
        {false, false, false, false, false, false, false, false, true, true, true},};
    private static int[] gravity = {0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] during = {0, 0, 0, 0, 0, 0, 0, 0};
    private static boolean[] deleted = {false, false, false, false, false, false, false, false};
    private static ArrayList<Integer> inCharges = new <Integer> ArrayList();

    public static void main(String[] args) {

        for (int i = 0; i < schedules.length; i++) {
            getGravityAndDuring(schedules[i], i);
        }      

        setIncharge();

        printInspectors();


    }

    private static void printInspectors() {
        System.out.print("The inspectors ");
        for (Integer inspector : inCharges) {
            System.out.print(inspector + " ");
        }
    }

    private static void setIncharge() {
        for (int i = 0; i < schedules.length && i < 8; i++) {
            if (deleted[i]) {
                continue;
            }
            findCollision(schedules[i], i);
        }
    }

    private static void findCollision(boolean[] schedule, int j) {

        int dring = during[j];
        int grv = gravity[j];

        for (int l = 0; l < schedule.length; l++) {
            if (schedule[l]) {


                for (int i = 0; i < schedules.length; i++) {

                    if (i != j && !deleted[i]) {

                        int s = l;

                        while (s < l + dring) {

                            if (schedules[i][s]) {
                                if (grv < gravity[i]) {
                                    deleted[j] = true;
                                    j = i;
                                    grv = gravity[i];

                                } else {
                                    deleted[i] = true;

                                }
                                break;
                            }

                            s++;
                        }
                    }
                }
                break;
            }
        }

        if (!inCharges.contains(j)) {
            inCharges.add(j);
        }

    }

    private static void getGravityAndDuring(boolean[] schedule, int j) {
        for (int l = 0; l < schedule.length; l++) {

            if (schedule[l]) {
                int count = 1;
                int templ = l;

                while (templ + 1 < schedule.length) {
                    if (schedule[++templ]) {
                        count++;
                    } else {
                        break;
                    }
                }
                during[j] = count;
                for (int i = 0; i < schedules.length; i++) {
                    if (i != j) {
                        int s = l;
                        while (s < l + count) {
                            if (schedules[i][s]) {
                                gravity[j]++;
                                break;
                            }
                            s++;
                        }
                    }
                }
                break;
            }
        }
    }
}
