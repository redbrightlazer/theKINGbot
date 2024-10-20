package org.example.kinggg;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
import org.w3c.dom.Text;

public class kingBot extends TelegramLongPollingBot {

    private static final String BOT_USERNAME="urnotthekingimthekingbot";
    private static final String BOT_TOKEN="7770099021:AAG_QskfBg8AOBTPW37B8v1zQ9PSH29-xh0";

    @Override
    public String getBotUsername() {
        return BOT_USERNAME;
    }

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = GetChatID(update);
        SendMessage(chatId,"AAAAAAAAAAAAAa");
    }
    private SendMessage createMessage(String text){
        SendMessage message=new SendMessage();
        message.setText(text);
        return message;
    }

    private void SendMessage(Long chatID, String text){
        SendMessage message = createMessage(text);
        message.setChatId(chatID);
        sendApiMethodAsync(message);
    }

    private Long GetChatID(Update update){
        if(update.hasMessage()){
            return update.getMessage().getChatId();
        }
        if(update.hasCallbackQuery()){
            return update.getCallbackQuery().getFrom().getId();
        }
        return null;
    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi tbpi = new TelegramBotsApi(DefaultBotSession.class);
        tbpi.registerBot(new kingBot());
    }
}
