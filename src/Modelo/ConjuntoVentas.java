/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class ConjuntoVentas {
    private ArrayList<Venta> ventas;
    private CajaRegistradora caja;
    
    
    ConjuntoVentas(){
        this.ventas = new ArrayList<>();
    }

    public ArrayList<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<Venta> ventas) {
        this.ventas = ventas;
    }
    
    public void anadirVenta(Venta venta){
        this.ventas.add(venta);
    }

    public CajaRegistradora getCaja() {
        return caja;
    }

    public void setCaja(CajaRegistradora caja) {
        this.caja = caja;
    }
    
    

    public void HacernuevaVenta(){
        
        Date fechaActual = new Date(118, 7, 4);
       
        Venta nuevaVenta = new Venta(fechaActual, caja, caja.getOperador());
        
        if(nuevaVenta.HacerVenta()==true){
            this.ventas.add(nuevaVenta);
            System.out.println("funciono");
        }
        else System.out.println("no funciono");
    }
}
