package ru.test.project.service;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;
import ru.test.project.domain.Message;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Service
@AutoJsonRpcServiceImpl
public class MessageServiceImpl implements MessageService {

    private static List<Message> messages = new CopyOnWriteArrayList<>();

    /**
     * This method receive a message and add it to the List<Message>
     * After every message method returns empty string
     * After 100k successfully received messages method returns String of aggregated data by idLocation
     * ,idDetected with counting the last and clearing the List with messages.
     *
     * @param message
     * @return String of aggregated data
     */

    public String readMessage(Message message) {
        messages.add(message);
        if (messages.size() == 100000) {
            Map<String, Map<String, Long>> aggregated = messages.parallelStream()
                    .collect(
                            groupingBy(Message::getIdLocation,
                                    groupingBy(Message::getIdDetected, counting())));
            messages.clear();
            return aggregated.toString();
        }
        return "";
    }
}
