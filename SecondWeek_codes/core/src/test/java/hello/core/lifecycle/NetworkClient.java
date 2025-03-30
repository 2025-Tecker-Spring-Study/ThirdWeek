package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("url when constructing : " + url);
    }


    void setUrl(String url) {
        this.url = url;
    }


    void connect() {
        System.out.println("네트워크 연결");
    }

    void call(String message) {
        System.out.println("message : " + message + "and url :" + url);
    }


    void disconnect() {
        System.out.println("url when disconnecting: " + url);
    }


    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화메시지");

    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();


    }
}