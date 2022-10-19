package exercise;

import java.util.ArrayList;
import java.util.Arrays;


// BEGIN
class Kennel {
    public static ArrayList<String[]> kennel = new ArrayList<>();
    public static void addPuppy(String[] puppy) {
        kennel.add(puppy);
    }
    public static void addSomePuppies(String[][] puppies) {
        for(String[] puppy : puppies) {
            kennel.add(puppy);
        }
    }
    public static int getPuppyCount() {
        return kennel.size();
    }
    public static boolean isContainPuppy(String name) {
        for(String[] puppy : kennel) {
            if(puppy[0].equals(name)) return true;
        }
        return false;
    }
    public static String[][] getAllPuppies() {
        String[][] allPuppies = new String[kennel.size()][2];
        for(int i = 0; i < kennel.size(); i++) {
            allPuppies[i] = kennel.get(i);
        }
        return allPuppies;
    }
    public static String[] getNamesByBreed(String breed) {
        ArrayList<String> names = new ArrayList<>();
        for(String[] puppy : kennel) {
            if(puppy[1].equals(breed)) names.add(puppy[0]);
        }
        String[] listOfNames = new String[names.size()];
        for(int i = 0; i < names.size(); i++) {
            listOfNames[i] = names.get(i);
        }
        return listOfNames;
    }
    public static void resetKennel() {
        kennel.clear();
    }



    // Самостоятельная работа
    public static boolean removePuppy(String puppyName) {
        for(String[] puppy : kennel) {
            if(puppy[0].equals(puppyName)) {
                kennel.remove(puppy);
                return true;
            }
        }
        return false;
    }
}
// END
