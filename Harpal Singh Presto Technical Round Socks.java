import java.util.Arrays;
import java.util.Comparator;

public class Socks {

    private static String[][] SOCKS_METRICS;
    private static String SOCKS_DATA[];
    private static String[][] ARRAY_TO_SORT;
    private static int COUNT = 0;


    public static void main(String[] args) {
        String SOCKS_STRING = "1/blue/right,2/blue/right,3/red/right,4/blue/left,5/purple/left,6/red/left,7/green/left,8/red/left,9/blue/left";
        String DELIMITER = ",";
        SOCKS_DATA = SOCKS_STRING.split(DELIMITER);
        SOCKS_METRICS = new String[SOCKS_DATA.length][3];
        ARRAY_TO_SORT = new String [30][3];

        createSocksArrayFromString();
        getMatchedSocks();
        getUnMatchedSocks();
        displaySortedUnMatchedSocksArray();
    }

    private static void createSocksArrayFromString() {
        for (int i = 0; i < SOCKS_METRICS.length; i++) {
            for (int j = 0; j <= 2; j++) {
                String SLASH = "/";
                String split[] = SOCKS_DATA[i].split(SLASH);
                SOCKS_METRICS[i][j] = split[j];
            }
        }

        System.out.println("1). Bellow is socks data \n");
        int serialNumber = 1;
        for (String[] SOCKS_METRIC : SOCKS_METRICS){
            System.out.println(serialNumber+". Socks id: " + SOCKS_METRIC[0] + "; color: " + SOCKS_METRIC[1] + ";  Socks position: " + SOCKS_METRIC[2]);
        serialNumber++;}
        
        System.out.println(" \n");
    }

    private static void getMatchedSocks() {
        int serialNumber = 1;
        System.out.println("2). Bellow is matrix of Socks id's that can be combined to make a wearable socks pair\n");

        for (int i = 0; i < SOCKS_METRICS.length; i++) {
            for (int j = 0; j < SOCKS_METRICS.length; j++) {

                if (SOCKS_METRICS[i][1].equals(SOCKS_METRICS[j][1])
                        & !SOCKS_METRICS[i][2].equals(SOCKS_METRICS[j][2])
                        & !SOCKS_METRICS[i][0].equals(SOCKS_METRICS[j][0])
                        & i != j) {
                    System.out.println(serialNumber +". Socks Color: " + SOCKS_METRICS[i][1].toUpperCase() + "; Right Socks id: " + SOCKS_METRICS[i][0] + "; Left Socks id: " + SOCKS_METRICS[j][0]);
                    serialNumber++;
                }
            }
        }
    }

    private static void getUnMatchedSocks() {

        for (int i = 0; i < SOCKS_METRICS.length; i++) {
            for (int j = SOCKS_METRICS.length - 1; j >= 0; j--) {
                if (!SOCKS_METRICS[i][1].equals(SOCKS_METRICS[j][1])
                        & SOCKS_METRICS[i][2].equals(SOCKS_METRICS[j][2])
                        & !SOCKS_METRICS[i][0].equals(SOCKS_METRICS[j][0])
                        & i != j) {
                    ARRAY_TO_SORT[COUNT][0] = SOCKS_METRICS[i][1].toUpperCase();
                    ARRAY_TO_SORT[COUNT][1] = SOCKS_METRICS[i][0];
                    ARRAY_TO_SORT[COUNT][2] = SOCKS_METRICS[j][0];
                    COUNT++;
                }
            }
        }
    }

    private static void displaySortedUnMatchedSocksArray() {
       int count = 1;
        System.out.println("\n3). Bellow is sorted matrix of unmatched socks id's that can be combined to make a wired wearable socks pair totally un-matching colors :/ \n");
        
        Arrays.sort(ARRAY_TO_SORT, new Comparator<String[]>() {
            @Override
            public int compare(final String[] temp_one, final String[] temp_two) {
                final String tempOne = temp_one[0];
                final String tempTwo = temp_two[0];
                return tempOne.compareTo(tempTwo);
            }
        });

        for (final String[] sortedArray : ARRAY_TO_SORT) {
             System.out.println(count + ". Socks color: " + sortedArray[0] + "; Right Socks id: " + sortedArray[1] +"; Left Socks id: "+sortedArray[2]);
            count++;
        }
    }
}




