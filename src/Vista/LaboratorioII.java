/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.*;
import java.awt.Button;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class LaboratorioII extends Application {

    private TextField porcentajes, graficoventas, informeventas, termometroventas;

    //private Label lMensaje;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        Date fechaActual = new Date();
        Scanner input = new Scanner(System.in);

        Admin administrador = new Admin("wiux", "AB123");

        Vendedor vendedor1 = new Vendedor("Juan", "XYZ");

        ArrayList<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(vendedor1);
        vendedores.add(new Vendedor("Alex", "ZXY"));
        vendedores.add(new Vendedor("Gabo", "123AB"));

        ArrayList<CajaRegistradora> CajasRegistradoras = new ArrayList<>();

        CajasRegistradoras.add(new CajaRegistradora(1, 15000));
        CajasRegistradoras.add(new CajaRegistradora(2, 20000));
        CajasRegistradoras.add(new CajaRegistradora(3, 30000));

        Producto producto1 = new Producto("Manzana", "0001", 10, 1000);
        Producto producto2 = new Producto("Pera", "0002", 10, 1000);

        ArrayList<Producto> inventario = new ArrayList<>();

        inventario.add(producto1);
        inventario.add(producto2);

        Negocio negocio = new Negocio("D1", administrador, vendedores, CajasRegistradoras, inventario);

        administrador.cambiarCantidadProductoPorCodigo("0001", 8);

        vendedor1.accederCaja(2);

        if (vendedor1.getCajaQueOpera() == null) {
            System.out.println("no hay caja que opere");
        } else {
            System.out.println("si hay una caja muy bonita");
            vendedor1.getCajaQueOpera().getVentas().HacernuevaVenta();
        }

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        
        Label porcentaje = new Label("  1. Porcentajes de Ventas   ");      
        javafx.scene.control.Button bt1 = new javafx.scene.control.Button("Ir a 1");
        
        Label grafico = new Label("  2. Gráfico de Ventas   ");       
        javafx.scene.control.Button bt2 = new javafx.scene.control.Button("Ir a 2");
        
        Label informe = new Label("  3. Informe de Ventas   ");    
        javafx.scene.control.Button bt3 = new javafx.scene.control.Button("Ir a 3");
        
        Label termometro = new Label("  4. Termometro de ventas   ");    
        javafx.scene.control.Button bt4 = new javafx.scene.control.Button("Ir a 4");
        
        grid.add(porcentaje, 0, 0);      
        grid.add(grafico, 0, 1);      
        grid.add(informe, 0, 2);       
        grid.add(termometro, 0, 3);
        
        grid.add(bt1, 1, 0);
        grid.add(bt2, 1, 1);
        grid.add(bt3, 1, 2);
        grid.add(bt4, 1, 3);
       

        Scene scene = new Scene(grid, 500, 300);

        primaryStage.setTitle("Información de ventas");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    private class OkEvent implements EventHandler<ActionEvent> {

        public void handle(ActionEvent e) {

        }

    }
}
