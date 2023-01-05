package com.simple.seguros.core;
/*
 * Mensajes de informacion utilizados en toda la apliacion
 */
public interface Mensajes {
    public interface Persona{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de persona por id={}";
            public static final String ALL="Iniciamos Busqueda de personas";
            public static final String COMPLETO="Busqueda de Personas Completada, {}";
        }
        public interface Crear{
            public static final String INICIANDO="Creando Persona con datos, {}";
            public static final String COMPLETO="Creacion de Persona completada, {}";
        }
        public static final String ELIMINADO="Persona deshabilitada";
    }
    public interface Vehiculo{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de vehiculo por valor={}";
            public static final String ALL="Iniciamos Busqueda de vehiculos";
            public static final String COMPLETO="Busqueda de Vehiculos Completada, {}";
        }
        public interface Crear{
            public static final String INICIANDO="Creando Vehiculo con datos, {}";
            public static final String COMPLETO="Creacion de Vehiculo completada, {}";
        }
        public static final String ELIMINADO="Vehiculo deshabilitada";
    }
    public interface Poliza{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de poliza por valor={}";
            public static final String ALL="Iniciamos Busqueda de poliza";
            public static final String COMPLETO="Busqueda de Polizias Completada, {}";
        }
        public interface Crear{
            public static final String INICIANDO="Creando Poliza con datos, {}";
            public static final String COMPLETO="Creacion de Poliza completada, {}";
        }
        public static final String ELIMINADO="Poliza deshabilitada";
    }

    public interface ClaseVehiculo{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de clase de Vehiculo por valor={}";
            public static final String ALL="Iniciamos Busqueda de clase de Vehiculo";
            public static final String COMPLETO="Busqueda de ClaseVehiculo Completada, {}";
            
        }
        public interface Crear{
            public static final String INICIANDO="Creando ClaseVehiculo con datos, {}";
            public static final String COMPLETO="Creacion de ClaseVehiculo completada, {}";
        }
        public static final String ELIMINADO="ClaseVehiculo deshabilitada";
    }

    public interface Color{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de color por valor={}";
            public static final String ALL="Iniciamos Busqueda de color";
            public static final String COMPLETE="Busqueda de Color Completada, {}";
        }
        public interface Crear{
            public static final String INICIANDO="Creando Color con datos, {}";
            public static final String COMPLETO="Creacion de Color completada, {}";
        }
        public static final String ELIMINADO="Color deshabilitada";
    }

    public interface Combustible{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de combustible por valor={}";
            public static final String ALL="Iniciamos Busqueda de combustible";
            public static final String COMPLETO="Busqueda de Combustible Completada, {}";
            
        }
        public interface Crear{
            public static final String INICIANDO="Creando Combustible con datos, {}";
            public static final String COMPLETO="Creacion de Combustible completada, {}";
        }
        public static final String ELIMINADO="Combustible deshabilitada";
    }
    public interface Ubicacion{
        public interface Busqueda{
            public static final String ID="Iniciando Busqueda de ubicacion por valor={}";
            public static final String ALL="Iniciamos Busqueda de ubicacion";
            public static final String COMPLETO="Busqueda de Ubicacion Completada, {}";
        }
        public interface Crear{
            public static final String INICIANDO="Creando Ubicacion con datos, {}";
            public static final String COMPLETO="Creacion de Ubicacion completada, {}";
        }
        public static final String ELIMINADO="Ubicacion deshabilitada";
    }
    
    public interface Varios{
        public static final String LOAD_HEADERS="Procesando headers en busqueda de filtros, Headers={}";
        public static final String RESPONSE="Armando Respuesta, {}";
        public static final String ENTITYNOTFOUND= "Entidad no encontrada";
        public static final String INVALIDFIELDS= "Campos Invalidos";
        public static final String ENTITYEXIST= "Entidad ya existe";
    }
}