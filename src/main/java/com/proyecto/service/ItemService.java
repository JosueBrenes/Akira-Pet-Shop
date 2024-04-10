package com.proyecto.service;

import com.proyecto.domain.Item;
import java.util.ArrayList;
import java.util.List;

public interface ItemService {

    List<Item> listaItems = new ArrayList<>();

    public List<Item> gets();

    //Recuperar el registro que tiene el IdItem pasado por parametro.
    // vamos a obtenerlo por medio del item = IdItem
    public Item get(Item item);

    // aqui eliminamos los items por medio de su ID.
    public void delete(Item item);

    public void save(Item item);

    public void actualiza(Item item);

    public void facturar();

}
