package pro.sky.telegrambot.service;

/**
 * Сервис для обработки команд
 */
public interface CommandHandlerService {
    /**
     * Обработать команду
     *
     * @param chatId  идентификатор чата
     * @param command текст команды
     * @return ответ на команду
     */
    String handleCommand(Long chatId, String command);
}
