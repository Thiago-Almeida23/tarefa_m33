import br.com.thiago.Acessorio;
import br.com.thiago.Carro;
import br.com.thiago.Marca;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("tarefa_m33");
        EntityManager em = emf.createEntityManager();

        Marca marca = new Marca();
        marca.setNome("Toyota");

        Carro carro = new Carro();
        carro.setModelo("Corolla");
        carro.setMarca(marca);

        Acessorio acessorio1 = new Acessorio();
        acessorio1.setNome("Ar-condicionado");
        acessorio1.setCarro(carro);

        Acessorio acessorio2 = new Acessorio();
        acessorio2.setNome("GPS");
        acessorio2.setCarro(carro);

        List<Carro> carros = new ArrayList<>();
        carros.add(carro);
        marca.setCarros(carros);

        List<Acessorio> acessorios = new ArrayList<>();
        acessorios.add(acessorio1);
        acessorios.add(acessorio2);
        carro.setAcessorios(acessorios);

        em.getTransaction().begin();

        em.persist(marca);
        em.persist(carro);

        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Dados salvos com sucesso!");
    }
}
