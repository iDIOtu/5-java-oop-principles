package com.example.task01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Logger
{
    private static final HashMap<String, Logger> loggers = new HashMap<>();
    private final String name;
    private Level currentLevel = Level.DEBUG;

    private Logger(String name) {
        this.name = name;
    }

    public static Logger getLogger(String name) {
        if (!loggers.containsKey(name)) {
            loggers.put(name, new Logger(name));
        }
        return loggers.get(name);
    }

    public String getName() {
        return name;
    }

    public void setLevel(Level level) {
        currentLevel = level;
    }

    public Level getLevel() {
        return currentLevel;
    }

    public void debug(String message) {
        log(Level.DEBUG, message);
    }

    public void info(String message) {
        log(Level.INFO, message);
    }

    public void warning(String message) {
        log(Level.WARNING, message);
    }

    public void error(String message) {
        log(Level.ERROR, message);
    }

    public void debug(String format, Object... args) {
        log(Level.DEBUG, format, args);
    }

    public void info(String format, Object... args) {
        log(Level.INFO, format, args);
    }

    public void warning(String format, Object... args) {
        log(Level.WARNING, format, args);
    }

    public void error(String format, Object... args) {
        log(Level.ERROR, format, args);
    }

    private void log(Level level, String message) {
        if (level.ordinal() >= currentLevel.ordinal()) {
            System.out.println(formatMessage(level, message));
        }
    }

    private void log(Level level, String format, Object... args) {
        if (level.ordinal() >= currentLevel.ordinal()) {
            System.out.println(formatMessage(level, String.format(format, args)));
        }
    }

    private String formatMessage(Level level, String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String timestamp = dateFormat.format(new Date());
        return String.format("[%s] %s %s - %s", level.name(), timestamp, name, message);
    }
}
