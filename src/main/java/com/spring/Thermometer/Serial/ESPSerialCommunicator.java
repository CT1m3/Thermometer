package com.spring.Thermometer.Serial;

import arduino.Arduino;
import org.springframework.stereotype.Component;

@Component
public class ESPSerialCommunicator {
    private Arduino esp;
    public void init(String port, int baud){
        esp = new Arduino(port, baud);
        esp.openConnection();
    }
    public void transmit(char data){
        esp.serialWrite(data);
    }
    public String read(){
        return esp.serialRead();
    }
    public void close(){
        esp.closeConnection();
    }
}
