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

}
