package com.devsu.servicio.cuentas.configuration;

import com.devsu.servicio.cuentas.infrastructure.ServiceLocator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ServiceLocatorConfigurer implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        ServiceLocator.setApplicationContext(applicationContext);
    }
}