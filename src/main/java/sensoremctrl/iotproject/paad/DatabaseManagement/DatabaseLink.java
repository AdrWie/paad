package sensoremctrl.iotproject.paad.DatabaseManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import sensoremctrl.iotproject.paad.Model.DateAndTimeRepository;
import sensoremctrl.iotproject.paad.Model.HumidityRepository;
import sensoremctrl.iotproject.paad.Model.TemperatureRepository;

@Component
public class DatabaseLink {

    @Autowired
    DataTransfer transmitter;

    @Autowired
    TemperatureRepository temperatureRepository;

    @Autowired
    HumidityRepository humidityRepository;

    @Autowired
    DateAndTimeRepository dateAndTimeRepository;

    @Bean
    public void sendDataToDatabase(){
        temperatureRepository.save(transmitter.getTemperatureList());
        humidityRepository.save(transmitter.getHumidityList());
        dateAndTimeRepository.save(transmitter.getDateAndTimeList());
    }


    public void getDataFromDatabase(){

    }
}
