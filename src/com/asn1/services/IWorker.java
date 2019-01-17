package com.asn1.services;

/**
 * Interfaz funcional para el manejo de eventos
 * @author ewhite
 * @version 1.0
 */
@FunctionalInterface
public interface IWorker {
    public void ejecutar() throws Exception;
}
