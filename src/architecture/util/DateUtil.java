package architecture.util;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateUtil {
    //
    public String getCurrentDate(){
        //
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(new Date());
    }

    public String getCurrentDate(String pattern){
        //
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        return simpleDateFormat.format(new Date());
    }

    public String getDateOf(String date){//19930902
        //
        String formattedDate = null;
        try{
            if(date.length() != 8)
                throw new NumberFormatException("Use the right date format (20200204)");
            // ToDo
            //int dateNumber = Integer.valueOf(date);
            //LocalDate localDate = LocalDate.of(dateNumber/10000, dateNumber/100%100, dateNumber%100);
            return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd")).toString();
        }catch (NumberFormatException e){
            e.printStackTrace();
            return null;
        }
    }
}
