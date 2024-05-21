package com.spring.Thermometer.Serial;

import com.spring.Thermometer.library.Arduino;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

public class ESPSerialCommunicator {
    private Arduino esp;
    private String port;
    private int baud;

    public ESPSerialCommunicator(String port, int baud) {
        this.port = port;
        this.baud = baud;
        init(port, baud);
    }

    public void init(String port, int baud) {
        esp = new Arduino(port, baud);
        esp.openConnection();
    }

    public void transmit(char data) {
        esp.serialWrite(data);
    }

    public String read() {
        return esp.serialRead();
    }

    public void close() {
        esp.closeConnection();
    }
}
