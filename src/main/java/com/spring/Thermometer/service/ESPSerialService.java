package com.spring.Thermometer.service;

import com.spring.Thermometer.Serial.ESPSerialCommunicator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return espSerialCommunicator.read();
    }
    public void close(){
        espSerialCommunicator.close();
    }
}
