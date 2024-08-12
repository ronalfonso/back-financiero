package com.devsu.servicio.cuentas.infrastructure;

import com.devsu.servicio.cuentas.application.ServiceSupplier;
import org.springframework.context.ApplicationContext;

public class ServiceLocator {
    private static ApplicationContext context;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        context = applicationContext;
    }

    public static <T> ServiceSupplier<T> getServiceSupplier(Class<T> serviceClass) {
        return () -> context.getBean(serviceClass);
    }
}
