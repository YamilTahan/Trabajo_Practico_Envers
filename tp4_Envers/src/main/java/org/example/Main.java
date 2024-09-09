package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("example-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Cliente cliente = Cliente.builder()
                .dni(12345678L)
                .apellido("Tahan")
                .nombre("Yamil")
                .build();

        System.out.println("Cliente creado: "+cliente.toString());

        Domicilio domicilio1 = Domicilio.builder()
                .nombreCalle("Ruta 66")
                .numero(808)
                .build();
        System.out.println("Domicilio creado: "+domicilio1.toString());

        Categoria golosinas = Categoria.builder()
                .denominacion("Golosinas")
                .build();
        System.out.println("Categoria creada: "+golosinas.toString());

        Categoria galletas = Categoria.builder()
                .denominacion("Galletas")
                .build();
        System.out.println("Categoria creada: "+galletas.toString());

        Categoria chocolates = Categoria.builder()
                .denominacion("Chocolates")
                .build();
        System.out.println("Categoria creada: "+chocolates.toString());

        Categoria gomitas = Categoria.builder()
                .denominacion("Gomitas")
                .build();
        System.out.println("Categoria creada: "+gomitas.toString());

        Articulo art1 = Articulo.builder()
                .cantidad(20)
                .denominacion("Oreo")
                .precio(500)
                .build();
        System.out.println("Articulo creado: "+art1.toString());

        Articulo art2 = Articulo.builder()
                .cantidad(30)
                .denominacion("Ositos de goma")
                .precio(150)
                .build();
        System.out.println("Articulo creado: "+art2.toString());

        Articulo art3 = Articulo.builder()
                .cantidad(40)
                .denominacion("Milka")
                .precio(1000)
                .build();
        System.out.println("Articulo creado: "+art3.toString());

        Factura factura = Factura.builder()
                .fecha("08/09/2004")
                .numero(123)
                .total(3800)
                .build();
        System.out.println("Factura creada: "+factura.toString());

        DetalleFactura detalle1 = DetalleFactura.builder()
                .cantidad(1)
                .subtotal(500)
                .build();
        System.out.println("DetalleFactura creado: "+detalle1.toString());

        DetalleFactura detalle2 = DetalleFactura.builder()
                .cantidad(2)
                .subtotal(300)
                .build();
        System.out.println("DetalleFactura creado: "+detalle2.toString());

        DetalleFactura detalle3 = DetalleFactura.builder()
                .cantidad(3)
                .subtotal(3000)
                .build();
        System.out.println("DetalleFactura creado: "+detalle3.toString());

        domicilio1.setCliente(cliente);
        System.out.println("Cliente insertado en domicilio");
        cliente.setDomicilio(domicilio1);
        System.out.println("Domicilio insertado en cliente");
        cliente.setFacturas(Set.of(factura));
        System.out.println("Factura insertada en cliente");

        art1.setDetalle(Set.of(detalle1));
        art1.setCategorias(Set.of(golosinas, galletas));

        art2.setDetalle(Set.of(detalle2));
        art2.setCategorias(Set.of(golosinas, gomitas));

        art3.setDetalle(Set.of(detalle3));
        art3.setCategorias(Set.of(golosinas, chocolates));

        factura.setCliente(cliente);
        factura.setDetalles(Set.of(detalle1,detalle2,detalle3));

        detalle1.setFactura(factura);
        detalle1.setArticulo(art1);

        detalle2.setFactura(factura);
        detalle2.setArticulo(art2);

        detalle3.setFactura(factura);
        detalle3.setArticulo(art3);
        entityManager.persist(factura);

//        Cliente cliente = entityManager.find(Cliente.class,  1L);
//        cliente.setNombre("Ryan");
//        cliente.setApellido("Gosling");
//
//        entityManager.merge(cliente);
//
//        Factura fac = entityManager.find(Factura.class, 1L);
//        entityManager.remove(fac);

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }
}
