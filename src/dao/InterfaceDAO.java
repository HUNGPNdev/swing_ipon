/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author Lenovo
 */
public interface InterfaceDAO<T, K> {
    List<T> getAll();
    T getById(K id);
    void insert(T t);
    void update(T t);
    void deleteById(K id);
    List<T> search(String name);
}
