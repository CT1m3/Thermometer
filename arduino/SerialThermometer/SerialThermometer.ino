#include <DallasTemperature.h>
#include <OneWire.h>

char data; //variable to store incoming data from JAVA 

#define ONE_WIRE_BUS 0

OneWire oneWire(ONE_WIRE_BUS);

DallasTemperature sensors(&oneWire);

void setup() {
  Serial.begin(9600);
  sensors.setResolution(9);
  sensors.begin();
}

void loop() {
  sensors.requestTemperatures();
  Serial.println(sensors.getTempCByIndex(0));
}