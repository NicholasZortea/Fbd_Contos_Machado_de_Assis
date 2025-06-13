/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.fbd.contosmachadodeassis.interfaces;

import java.util.List;

/**
 *
 * @author Nicholas Zortea (zorteanicholas619@gmail.com)
 */

public interface GenericDAO<T> {
    void insert(T obj);
    T findByID(int id);
    List<T> findByProperty(String property, String value);
}
