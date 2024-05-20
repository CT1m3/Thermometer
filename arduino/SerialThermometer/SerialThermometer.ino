#define LED_PIN (int8_t) 2 //pin number LED is connected to

#include <DallasTemperature.h>
#include <OneWire.h>

char data; //variable to store incoming data from JAVA 

#define ONE_WIRE_BUS 0

OneWire oneWire(ONE_WIRE_BUS);

DallasTemperature sensors(&oneWire);

void setup() {
  pinMode(LED_PIN, OUTPUT);
  Serial.begin(9600);
  sensors.setResolution(9);
  sensors.begin();
}

void loop() {
  if(Serial.available()>0){
    data=Serial.read();
  
    if(data == '1') 
      digitalWrite(LED_PIN,HIGH);
    if(data == '0') 
      digitalWrite(LED_PIN,LOW);
  }

  sensors.requestTemperatures();
  Serial.println(sensors.getTempCByIndex(0));
}