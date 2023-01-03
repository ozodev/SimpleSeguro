package com.simple.seguros.core.entidades.tipos;
/*
 * Mensajes de informacion utilizados en toda la apliacion
 */
public interface Mensajes {
    public interface Persona{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de persona por id={}";
            public static final String ALL="Iniciamos Busqueda de personas";
        }
    }
    public interface Vehiculo{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de vehiculo por valor={}";
            public static final String ALL="Iniciamos Busqueda de vehiculos";
        }
    }
    public interface Varios{
        public static final String LOAD_HEADERS="Procesando headers en busqueda de filtros, Headers={}";
    }

    public interface Poliza{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de poliza por valor={}";
            public static final String ALL="Iniciamos Busqueda de poliza";
        }
    }
}