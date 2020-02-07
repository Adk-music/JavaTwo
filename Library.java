package ru.gb.jt.chat.common;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Library {
    /*
    /auth_request±login±password
    /auth_accept±nickname
    /auth_error
    /broadcast±msg
    /msg_format_error±msg
    * */
    public static final String DELIMITER = "~";
    public static final String AUTH_REQUEST = "Запрос авторизации:";
    public static final String AUTH_ACCEPT = "Авторизация_прошла_успешно.";
    public static final String AUTH_DENIED = "Авторизация_отклонена.Не_верный_логин_или_пароль.";
    public static final String MSG_FORMAT_ERROR = "Формат_сообщения_не_поддерживается.";
    // если мы вдруг не поняли, что за сообщение и не смогли разобрать
    public static final String TYPE_BROADCAST = "Время_подключения_к_чату:";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm");
    // то есть сообщение, которое будет посылаться всем

    public static String getAuthRequest(String login, String password) {
        return AUTH_REQUEST + DELIMITER + login + DELIMITER + password;
    }

    public static String getAuthAccept(String nickname) {
        return AUTH_ACCEPT + DELIMITER + nickname;
    }

    public static String getAuthDenied() {
        return AUTH_DENIED;
    }

    public static String getMsgFormatError(String message) {
        return MSG_FORMAT_ERROR + DELIMITER + message;
    }

    public static String getTypeBroadcast(String src, String message) {
        return TYPE_BROADCAST + DELIMITER + DATE_FORMAT.format(System.currentTimeMillis()) +
                DELIMITER + src + DELIMITER + message;
    }

}
