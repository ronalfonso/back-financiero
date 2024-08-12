package com.devsu.servicio.cuentas.application;

@FunctionalInterface
public interface ServiceSupplier<T> {
    T get();
}
