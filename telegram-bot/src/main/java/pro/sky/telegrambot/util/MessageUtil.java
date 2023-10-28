package pro.sky.telegrambot.util;

import org.springframework.util.StringUtils;
import pro.sky.telegrambot.entity.NotificationTask;
import pro.sky.telegrambot.exception.IncorrectCreateTaskCommandException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.time.LocalDateTime.parse;

public class MessageUtil {

    private static final Pattern pattern = Pattern.compile("([0-9\\.\\:\\s]{16})(\\s)([\\W+]+)");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static NotificationTask parseCreateCommand(Long chatId, String command) throws IncorrectCreateTaskCommandException {
        if (StringUtils.hasText(command)) {
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                LocalDateTime dateTime = parse(matcher.group(1));
                String taskText = matcher.group(3);

                checkDate(dateTime);
                checkTaskText(taskText);

                return new NotificationTask(chatId, taskText, dateTime);
            }
        }
        throw new IncorrectCreateTaskCommandException("Incorrect command " + command);
    }

    private static void checkDate(LocalDateTime dateTime) throws IncorrectCreateTaskCommandException {
        if (dateTime == null) {
            throw new IncorrectCreateTaskCommandException("Incorrect task dateTime: " + dateTime);
        } else if (dateTime.isBefore(LocalDateTime.now())) {
            throw new IncorrectCreateTaskCommandException("Incorrect task dateTime: " + dateTime);
        }
    }

    private static void checkTaskText(String text) throws IncorrectCreateTaskCommandException {
        if (!StringUtils.hasText(text)) {
            throw new IncorrectCreateTaskCommandException("Incorrect task text: " + text);
        }
    }

    private static LocalDateTime parse(String dateTime) {
        try {
            return LocalDateTime.parse(dateTime, dateTimeFormatter);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

}