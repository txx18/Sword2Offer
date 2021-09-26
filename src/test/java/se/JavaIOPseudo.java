package se;

import java.io.File;

/**
 * @author ShaneTang
 * @create 2021-05-31 9:49
 */
public class JavaIOPseudo {

    Selector selector;
    Event event;
    Channel channel;

    void nonBlockingIO() {
        // 把代表客户端连接的Channel注册到Selector中
        // 注意：可能有很多Channel建立，每个都表示一个Socket连接
        registChannalToSelector(channel);
        while (true) {
            // 检查 Selector （的 Channel）有没有事件
            event = checkEventInSelector(selector);
            // 如果事件是 Channel 可以读
            if (event == Event.CAN_READ) {
                // 从产生事件的Channel中读数据
                File file = readFromEventChannel(channel);
            }
            if (event == Event.CAN_WRITE) {
                // 向产生事件的 Channel中写数据
                writeToEventChannel(channel);
            }
            // doSth ...
        }
    }

    private void writeToEventChannel(Channel channel) {

    }

    private File readFromEventChannel(Channel channel) {

        return null;
    }

    private Event checkEventInSelector(Selector selector) {
        return null;
    }

    private Channel registChannalToSelector(Channel channel) {
        return null;
    }

    enum Event {

        CAN_READ,
        CAN_WRITE;
    }

    private class Channel {
    }

    private class Selector {
    }
}
