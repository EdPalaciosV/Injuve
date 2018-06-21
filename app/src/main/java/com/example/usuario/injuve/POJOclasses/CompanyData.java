package com.example.usuario.injuve.POJOclasses;

public class CompanyData {

    String latitud,longitud;
    public CompanyData()
    {

    }
    public CompanyData(String latitud, String longitud)
    {
        this.latitud=latitud;
        this.longitud=longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }
}
