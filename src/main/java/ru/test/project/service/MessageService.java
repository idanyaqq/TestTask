package ru.test.project.service;


import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;
import ru.test.project.domain.Message;

@JsonRpcService("/message")
public interface MessageService {

    String readMessage(@JsonRpcParam("data") Message value);
}
