package org.akademija.six.gui.dao;

import java.util.List;

/**
 * Tabelu u bazi sports koja se zove players će predstavljati neki entity Player.
 *
 *
 * <p>
 *     CRUD template
 *     <li>1. Create</li>
 *     <li>2. Retrieve</li>
 *     <li>3. Update</li>
 *     <li>4. Delete</li>
 * </p>
 * @param <E>
 */
public interface Dao<E>{
    /**
     * CREATE
     */
    E save(E entity);

    /**
     * RETRIEVE
     */
    List<E> getAll();

    E get(Long id);

    /**
     * UPDATE
     */
    E update(E entity);

    /**
     * DELETE
     */
    boolean delete(E entity);
}
