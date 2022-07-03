package service;

import entities.Boss;
import exceptions.BancoDeDadosException;
import repository.BossRepository;

import java.util.Objects;

public class BossService {
    BossRepository bossRepository = new BossRepository();

    //Lista e exibe os Bosses cadastrados - READ
    public void listar() throws BancoDeDadosException {
        for (Boss boss2 : bossRepository.listar()) {
            System.out.println(boss2);
        }
    }

    public void adicionar(Boss boss) throws BancoDeDadosException {

        bossRepository.adicionar(boss);
    }

    public void remover(Boss boss) throws BancoDeDadosException {
        if (boss == null) {
            System.out.println("Cenario inexistente");
        } else {
            bossRepository.remover(boss.getIdBoss());
        }
    }

    public void editar(Boss boss) throws BancoDeDadosException {
        if (boss == null) {
            System.out.println("Cenario inexistente");
        }
        bossRepository.editar(boss.getIdBoss(), boss);

    }

    public Boss retornaBoss(String nome) throws BancoDeDadosException {
        return bossRepository.listar().stream().filter(a -> Objects.equals(a.getNome(), nome)).map(a -> {
            return new Boss(a.getIdBoss(), a.getNome());
        }).findFirst().orElse(null);
    }

}
