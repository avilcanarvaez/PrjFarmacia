package org.farmacia.util;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {

    public static String convertirObjetoACadenaJson(Object objeto){
        Gson objetoGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy")).create();
        return objetoGson.toJson(objeto);
    }
    
    public static <T> T convertirCadenaJsonAObjeto(String cadena, Class<T> clase){        
        GsonBuilder objetoGsonBuilder = new GsonBuilder();
        objetoGsonBuilder.registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy"));
        Gson objetoGson = objetoGsonBuilder.create();
        objetoGson.fromJson(cadena, clase);
        return objetoGson.fromJson(cadena, clase);
    }
    
    public static String convertirObjetoACadenaJson(Object objeto, String formatoFecha){
        Gson objetoGson = new GsonBuilder().registerTypeAdapter(Date.class, new DateSerializer(formatoFecha)).create();
        return objetoGson.toJson(objeto);
    }
    
    public static <T> T convertirCadenaJsonAObjetoRequest(String cadena, Class<T> clase){        
    	Gson objetoGson=null;
        GsonBuilder objetoGsonBuilder = new GsonBuilder();        
        objetoGsonBuilder.registerTypeAdapter(Date.class, new DateSerializer("dd/MM/yyyy"));        
        objetoGson = objetoGsonBuilder.create();
        objetoGson.fromJson(cadena, clase);
        return objetoGson.fromJson(cadena, clase);
    }
    
}
