/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package md.ibanc.rm.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC01017745
 */
public class MyCalendar {

    private static Map<String, String> holidays = null;
    private static MyCalendar myCalendar = null;
    private static final int WEEKEND_1 = Calendar.SATURDAY;
    private static final int WEEKEND_2 = Calendar.SUNDAY;

    private MyCalendar() {
        holidays = new HashMap<String, String>();
        holidays.put("7,4", "Independence Day");
        holidays.put("12,25", "Christmas");

        //holidays.putAll(DBUtils.readAnyDynamicHolidaysFromDB());
    }

    public static Date getPreviousWorkingDay(Date date) {

        Date previousWorkingDate = null;
        try {
            if (myCalendar == null) {
                myCalendar = new MyCalendar();
            }

            if (date != null) {
                Calendar calInstance = Calendar.getInstance();
                calInstance.setTime(date);
                int weekDay = 0;

                do {
                    calInstance.add(Calendar.DATE, -1);
                    weekDay = calInstance.get(Calendar.DAY_OF_WEEK);
                } while (weekDay == WEEKEND_1 || weekDay == WEEKEND_2
                        || holidays.get((calInstance.get(Calendar.MONTH) + 1)
                                + "," + calInstance.get(Calendar.DATE)) != null);

                previousWorkingDate = calInstance.getTime();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return previousWorkingDate;
    }
}
