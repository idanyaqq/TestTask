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

    public String readMessage(Message value) {
        messages.add(value);
        if (messages.size() == 100000) {
            Map<String, Map<String, Long>> aggregated = messages.parallelStream().collect(groupingBy(Message::getIdLocation, groupingBy(Message::getIdDetected, counting())));
            messages.clear();
            return aggregated.toString();
        }
        return "";
    }
}
