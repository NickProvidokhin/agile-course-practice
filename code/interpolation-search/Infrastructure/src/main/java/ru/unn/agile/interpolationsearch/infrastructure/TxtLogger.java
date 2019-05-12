package ru.unn.agile.interpolationsearch.infrastructure;

import ru.unn.agile.interpolationsearch.viewmodel.ILogger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TxtLogger implements ILogger {
    private static final String DATE_FORM = "yyyy-MM-dd HH:mm:ss";
    private BufferedWriter bufferedWriter;
    private List<String> log = new ArrayList<>();

    public TxtLogger(final String logPath) throws IOException {
        bufferedWriter = new BufferedWriter(new FileWriter(logPath));
    }
    public BufferedWriter getWriter() {
        return bufferedWriter;
    }

    private static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORM, Locale.ENGLISH);
        return sdf.format(cal.getTime());
    }

    public void log(final String str) {
        try {
            log.add(str);
            bufferedWriter.append(now() + str + "\r\n");
            bufferedWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getLog() {
        return log;
    }
}

