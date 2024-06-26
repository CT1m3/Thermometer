package com.spring.Thermometer.service;

import com.spring.Thermometer.Serial.ESPSerialCommunicator;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.lang.Double.parseDouble;

@Service
public class ESPSerialService {
    private final ESPSerialCommunicator espSerialCommunicator;

    @Autowired
    public ESPSerialService(ESPSerialCommunicator espSerialCommunicator) {
        this.espSerialCommunicator = espSerialCommunicator;
    }
    public void transmit(char data){
        espSerialCommunicator.transmit(data);
    }

    public String read(){
        String[] split = espSerialCommunicator.read().split("\n");
        return split[1];
    }
    public void close(){
        espSerialCommunicator.close();
    }
    public void open(){espSerialCommunicator.open();}
}
