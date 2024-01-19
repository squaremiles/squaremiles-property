package com.db.squaremile.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import io.micrometer.core.annotation.Timed;
import io.micrometer.observation.annotation.Observed;

@Service
public class SleepService {
	//@Timed(value = "do.sleep.method.timed")
//	@NewSpan(value = "do-sleep-method-span")
	@Observed(name = "do.sleep.method.timed", contextualName = "do-sleep-method-span", lowCardinalityKeyValues = {"doSleep", "doSleep"})
	public Long doSleep(Long ms) {
		try {
			TimeUnit.MILLISECONDS.sleep(ms);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		return ms;
	}

}
