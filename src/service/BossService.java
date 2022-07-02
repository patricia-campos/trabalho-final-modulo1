package service;

import entities.Boss;
import exceptions.BancoDeDadosException;
import repository.BossRepository;
import java.util.Objects;

public class BossService {
    BossRepository bossRepository = new BossRepository();


    //Add novo Boss - CREATE
    public void adicionar(Boss boss) throws BancoDeDadosException {

        if (boss == null) {
            System.out.println("Boss não encontrado!");
        } else {

            //Sugestão do Rafa- Deixar como UK no banco para proteger também de alterações no banco
            if (this.verificaNomeBoss(boss)) {
                bossRepository.adicionar(boss);

            } else {
                System.out.println("O Boss já existe!");
            }
        }
    }

    //Lista e exibe os Bosses cadastrados - READ
    public void listar() throws BancoDeDadosException {
        for (Boss boss2 : bossRepository.listar()) {
            System.out.println(boss2);
        }
    }
    //Remove Boss cadastrado - DELETE
    public void remover(Boss boss) throws BancoDeDadosException {
        if (boss == null) {
            System.out.println("O boss não foi encontrado!");
        } else {
            bossRepository.remover(boss.getIdBoss());
        }
    }

    //Atualiza o Boss existente no cadastro - UPDATE
    public void editar(Boss boss, String nome) throws BancoDeDadosException {
        if (boss == null) {
            System.out.println("Boss não localizado!");
        } else {
            boss.setNome(nome);
            if (this.verificaNomeBoss(boss)) {
                bossRepository.editar(boss.getIdBoss(), boss);
            } else {
                System.out.println("Não é possível alterar Boss não localizado");
            }
        }
    }

    //Varre a lista de Boss e traz objetos iguais
    public Boss retornaBoss(String nome) throws BancoDeDadosException {
        return bossRepository.listar().stream().filter(a -> Objects.equals(a.getNome(), nome)).map(a -> {
            return new Boss(a.getIdBoss(), a.getNome());
        }).findFirst().orElse(null);
    }

    //Eric - Verifica se existe boss com o mesmo nome, traz e não permite alteração
    public boolean verificaNomeBoss(Boss boss) throws BancoDeDadosException {
        if (boss == null) {
            System.out.println("Boss não localizado!");
        } else {
            Boss boss2 = this.retornaBoss(boss.getNome());
            if (boss2 == null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }



}
