package client;

import common.Chat;

/**
 * This Class
 *
 * @author Zhizhuo Song
 * @version 2020/3/8
 */
public interface ChatEventHandler {
    public void onChatC2S(Chat chat);
}
