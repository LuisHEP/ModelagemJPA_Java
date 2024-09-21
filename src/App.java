

import domain.Marca;
import domain.Acessorio;
import domain.Carro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Marca marca = new Marca();
        marca.setNome("Toyota");
        em.persist(marca);

        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Ar Condicionado");
        em.persist(acessorio1);

        Acessorio acessorio2 = new Acessorio();
        acessorio2.setNome("Teto Solar");
        em.persist(acessorio2);

        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setMarca(marca);
        carro.setAcessorios(Arrays.asList(acessorio1, acessorio2));
        em.persist(carro);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
