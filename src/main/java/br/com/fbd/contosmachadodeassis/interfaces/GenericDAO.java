/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.fbd.contosmachadodeassis.interfaces;

/**
 *
 * @author Nicholas Zortea (zorteanicholas619@gmail.com)
 */

public interface GenericDAO {
    public void insert();
    public void findByID(int id);
    public void findByProperty(String property);
}
