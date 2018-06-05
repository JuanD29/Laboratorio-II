/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Admin extends Empleado{
    
    public Admin(String usuario, String clave) {
        super(usuario, clave);
    }
    
    public boolean cambiarNombreProductoPorCodigo(String codigoIn, String nuevoNombre){
        for(int i=0; i<this.getNegocio().getInventario().size(); i++){
            //comprobar si el nombre ya existe
            if(this.getNegocio().getInventario().get(i).getNombre().equalsIgnoreCase(nuevoNombre)){
                System.out.println("El nombre ya existe");
            }else{         
                if(this.getNegocio().getInventario().get(i).getCodigo().equalsIgnoreCase(codigoIn)){
                    this.getNegocio().getInventario().get(i).setNombre(nuevoNombre);
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean cambiarCantidadProductoPorCodigo(String codigoIn, int nuevaCantidad){
        if(nuevaCantidad>=0){
            for(int i=0; i<this.getNegocio().getInventario().size(); i++){

                if(this.getNegocio().getInventario().get(i).getCodigo().equalsIgnoreCase(codigoIn)){
                    this.getNegocio().getInventario().get(i).setCantidad(nuevaCantidad);
                    return true;
                }

            }
        }
        return false;
    }    
    
        public boolean cambiarPrecioProductoPorCodigo(String codigoIn, double nuevoPrecio){
        if(nuevoPrecio>=0){
            for(int i=0; i<this.getNegocio().getInventario().size(); i++){

                if(this.getNegocio().getInventario().get(i).getCodigo().equalsIgnoreCase(codigoIn)){
                    this.getNegocio().getInventario().get(i).setPrecio(nuevoPrecio);
                    return true;
                }

            }
        }
        return false;
    }
    
    public boolean anadirProducto(String nombre, String codigo, int cantidad, double precio){
        
        for(int i=0; i<this.getNegocio().getInventario().size(); i++){
            if(this.getNegocio().getInventario().get(i).getCodigo() != codigo
                    && this.getNegocio().getInventario().get(i).getNombre() != nombre){
                Producto producto = new Producto(nombre, codigo, cantidad, precio);
               return this.getNegocio().getInventario().add(producto);
                
            }
        }
        return false;
    }
    
    public boolean removerProductoXCodigo(String codigo){
        for(int i=0; i<this.getNegocio().getInventario().size(); i++){
            if(this.getNegocio().getInventario().get(i).getCodigo().equalsIgnoreCase(codigo)){
            this.getNegocio().getInventario().remove(i);
               return true;
                
            }
        }
        return false;
        
    }
    
    public boolean anadirVendedor(String usuario, String clave){
        for(int i=0; i< this.getNegocio().getVendedores().size(); i++){
            if(this.getNegocio().getVendedores().get(i).getUsuario().equalsIgnoreCase(usuario) == false){
                Vendedor vendedor = new Vendedor(usuario, clave);
                this.getNegocio().getVendedores().add(vendedor);
                int t = this.getNegocio().getVendedores().size() - 1;
                this.getNegocio().getVendedores().get(t).setNegocio(this.getNegocio());
                return true;
            }
        }
        return false;
    }
    
    public boolean removerVendedorXUsuario(String usuario){
        for(int i=0; i< this.getNegocio().getVendedores().size(); i++){
            if(this.getNegocio().getVendedores().get(i).getUsuario().equalsIgnoreCase(usuario)){
                this.getNegocio().getVendedores().remove(i);
            }
        }
        return false;
    }
    
    
    //para el main usar el nextLine
    public boolean anadirClientes(String id, String nombre, String direccion){
        for(int i=0; i< this.getNegocio().getClientes().size(); i++){
            if(this.getNegocio().getClientes().get(i).getId().equalsIgnoreCase(id)==false){
                Cliente cliente = new Cliente(id, nombre, direccion);
                this.getNegocio().getClientes().add(cliente);
                return true;
            }
        }
        return false;
    }
    
    public boolean  removerClienteXId(String Id){
        for(int i=0; i< this.getNegocio().getClientes().size(); i++){
            if(this.getNegocio().getClientes().get(i).getId().equalsIgnoreCase(Id)){
                this.getNegocio().getClientes().remove(i);
                return true;
            }
        }
        return false;
    }
    //Puede no funconar en javaFX
    public void vizualizarDineroXCaja(){
        for(int i=0; i< this.getNegocio().getCajasRegistradoras().size(); i++){
            int numCaja = this.getNegocio().getCajasRegistradoras().get(i).getNumeroCaja();
            double efectivo = this.getNegocio().getCajasRegistradoras().get(i).getEfectivo();
            System.out.println("La caja " + numCaja + " tiene " + efectivo + " de efectivo");
        }
    }
}
