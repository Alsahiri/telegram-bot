package pro.sky.telegrambot.exception;

/**
 *  Некорректный формат команды создания напоминания
 */
public class IncorrectCreateTaskCommandException extends Exception {
    public IncorrectCreateTaskCommandException(String message) {
        super(message);
    }
}
