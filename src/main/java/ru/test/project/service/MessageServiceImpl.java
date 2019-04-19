package ru.test.project.service;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;
import ru.test.project.domain.Message;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
@AutoJsonRpcServiceImpl
public class MessageServiceImpl implements MessageService {

    private List<Message> arr = new CopyOnWriteArrayList<>();

    public String  read(Message value) {
        arr.add(value);
        if(arr.size()==10000){
            System.out.println("DAMN BOOOOOOOOOOOOOOOY "+arr.size());
//            arr.parallelStream().collect(Collectors.groupingByConcurrent(Function.<String>identity(),))
            arr.clear();
        }
        return "1";
    }
}
