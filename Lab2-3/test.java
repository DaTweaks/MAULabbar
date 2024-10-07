public class test {

    public enum Fares{
        fareChild,
        fareTeen,
        fareAdult,
        fareSenior
    };

    public static Fares GetVacationdaysCool(int age){
        if(age < 13)
            return Fares.fareChild;

        if(age < 18)
            return Fares.fareTeen;

        if(age < 65)
            return Fares.fareAdult;

        return Fares.fareSenior;
    }

    public static Fares GetVacationdaysWeird(int age){
        if(age < 13)
            return Fares.fareChild;
        else if(age < 18)
            return Fares.fareTeen;
        else if(age < 65)
            return Fares.fareAdult;
        else
        return Fares.fareSenior;
    }

    public static void what(int i){
        switch(i){
            case 1:
            case 2:
            case 3:
                return; // BRO NO WAY THIS WORKS???
        }
    }
}
