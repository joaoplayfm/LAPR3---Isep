
package app.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DEI-ESINF
 */
public class Utils {

    private Utils() {
    }

    /**
     *
     * @author Paulo Maio <pam@isep.ipp.pt>
     */
    public static String readLineFromConsole(String prompt)
    {
        try
        {
            System.out.println("\n" + prompt);

            InputStreamReader converter = new InputStreamReader(System.in);
            BufferedReader in = new BufferedReader(converter);

            return in.readLine();
        } catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static int readIntegerFromConsole(String prompt)
    {
        do
        {
            try
            {
                String input = readLineFromConsole(prompt);

                return Integer.parseInt(input);

            } catch (NumberFormatException ex)
            {
                System.out.println("Invalid. Please type again.");
            }
        } while (true);
    }

    public static double readDoubleFromConsole(String prompt)
    {
        do
        {
            try
            {
                String input = readLineFromConsole(prompt);

                return Double.parseDouble(input);

            } catch (NumberFormatException ex)
            {
                Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (true);
    }
    /*
        public static Date readDateFromConsole(String prompt)
        {
            do
            {
                try
                {
                    String strDate = readLineFromConsole(prompt);

                    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                    return df.parse(strDate);

                } catch (ParseException ex)
                {
                    Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
                }
            } while (true);
        }

        public static boolean confirm(String message) {
            String input;
            do {
                input = Utils.readLineFromConsole("\n" + message + "\n");
            } while (!input.equalsIgnoreCase("s") && !input.equalsIgnoreCase("n"));

            return input.equalsIgnoreCase("s");
        }
    */
    public static Object showAndSelectOne(List list, String header)
    {
        showList(list,header);
        return selectsObject(list);
    }
    public static int showAndSelectIndex(List list, String header)
    {
        showList(list,header);
        return selectsIndex(list);
    }
    public static void showList(List list, String header)
    {
        System.out.println(header);

        int index = 0;
        for (Object o : list)
        {
            index++;

            System.out.println(index + ". " + o.toString());
        }
        System.out.println("");
        System.out.println("0 - Cancel");
    }

    public static Object selectsObject(List list)
    {
        String input;
        Integer value;
        do
        {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        if (value == 0)
        {
            return null;
        } else
        {
            return list.get(value - 1);
        }
    }

    public static int selectsIndex(List list)
    {
        String input;
        Integer value;
        do
        {
            input = Utils.readLineFromConsole("Type your option: ");
            value =  Integer.valueOf(input);
        } while (value < 0 || value > list.size());

        return value - 1;
    }
}
