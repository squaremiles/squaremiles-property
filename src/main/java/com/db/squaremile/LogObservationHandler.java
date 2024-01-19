package com.db.squaremile;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;

@Component
@Order(999)
@Slf4j
public class LogObservationHandler implements ObservationHandler<Observation.Context> {

    

    @Override
    public void onStart(Observation.Context context) {
        log.info("LogObservationHandler::onStart: {}", context.getName());
    }

    @Override
    public void onStop(Observation.Context context) {
        log.info("LogObservationHandler::onStop: {}", context.getName());
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }
}
