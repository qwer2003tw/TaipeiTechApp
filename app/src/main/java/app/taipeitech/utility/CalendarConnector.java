package app.taipeitech.utility;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import app.taipeitech.model.YearCalendar;

import org.json.JSONObject;

public class CalendarConnector {

    private final static String CALENDAR_URI = "https://raw.githubusercontent.com/s911415/TaipeiTechApp/master/crawler/out/calendar.json";

    public static YearCalendar getEventList() throws Exception {
        try {
            String result = Connector.getDataByGet(CALENDAR_URI, "utf-8");
            JSONObject jObject = new JSONObject(result);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            YearCalendar yearCalendar = gson.fromJson(jObject
                    .toString(), YearCalendar.class);
            return yearCalendar;
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("行事曆讀取時發生錯誤");
        }
    }
}
