public class Producto {
    //Atributos
    private String nombre;
    private Categoria categoria;
    private Double precio;
    private Integer cantidad;

    //Cosntructor

    public Producto(String nombre, Categoria categoria, Double precio, Integer cantidad){
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Double subtotal(){
        return precio * cantidad;
    }

    //Getters

    public String getNombre(){
        return nombre;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public Double getPrecio(){
        return precio;
    }

    public Integer getCantidad(){
        return cantidad;
    }

    //Setters

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public void setPrecio(Double precio){
        this.precio = precio;
    }

    public void setCantidad(Integer cantidad){
        this.cantidad = cantidad;
    }


}
