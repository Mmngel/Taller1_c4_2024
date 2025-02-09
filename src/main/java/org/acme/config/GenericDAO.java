package org.acme.config;

import java.util.List;

public interface GenericDAO<T, I> {
    public List<T> listar();

    public T obtener(I id);

    public void eliminar(I id);

    public T modificar(T param);

    public T agregar(T param);

}
