package com.proyecto.service;

import org.springframework.web.multipart.MultipartFile;

public interface FirebaseStorageService {

    public String cargaImagen(MultipartFile archivoLocalCliente, String carpeta, Long id);

    //El BuketName es el <id_del_proyecto> + ".appspot.com"
    final String BucketName = "proyecto-c0a8f.appspot.com";

    //Esta es la ruta básica de este proyecto
    final String rutaSuperiorStorage = "proyecto";

    //Ubicación donde se encuentra el archivo de configuración Json
    final String rutaJsonFile = "firebase";

    //El nombre del archivo Json
    final String archivoJsonFile = "proyecto-c0a8f-firebase-adminsdk-fsq2j-218ed4a333.json";
}
