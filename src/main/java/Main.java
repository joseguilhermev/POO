import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Configuração do Hibernate e criação da SessionFactory
        Configuration cfg = new Configuration();
        cfg.configure(); // Lê o hibernate.cfg.xml
        SessionFactory sessionFactory = cfg.buildSessionFactory();

        // Criação e abertura de uma sessão
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Inserção de jogadores
        Jogador jogador1 = new Jogador("Jogador1", "Atirador", "Time A", "Platina");
        Jogador jogador2 = new Jogador("Jogador2", "Suporte", "Time B", "Ouro");
        Jogador jogador3 = new Jogador("Jogador3", "Jungler", "Time C", "Diamante");

        session.save(jogador1);
        session.save(jogador2);
        session.save(jogador3);

        transaction.commit();

        // Consulta e impressão dos dados dos jogadores
        List<Jogador> jogadores = session.createQuery("from Jogador", Jogador.class).list();
        for (Jogador jogador : jogadores) {
            jogador.imprimirDados();
        }

        // Fechamento da sessão e da SessionFactory
        session.close();
        sessionFactory.close();
    }
}
