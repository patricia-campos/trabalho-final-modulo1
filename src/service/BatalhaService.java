package service;

import model.entities.Batalha;
import exceptions.BancoDeDadosException;
import repository.BatalhaRepository;

public class BatalhaService {

    BatalhaRepository batalhaRepository = new BatalhaRepository();

    public void adicionar(Batalha batalha) throws BancoDeDadosException {
        if (batalha == null) {
            System.out.println("Batalha não iniciada.");
        } else {
            batalhaRepository.adicionar(batalha);
        }
    }

    public void listar() throws BancoDeDadosException {
        for (Batalha batalha2 : batalhaRepository.listar()) {
            System.out.println(batalha2);
        }
    }

    // TODO CHECAR COMO SERÁ A REMOÇÃO, SE VAI EXISTIR REEMOÇÃO / COMO IMPLEMENTAR

    public void remover(Batalha batalha) throws BancoDeDadosException {
        if (batalha == null) {
            System.out.println("Não existe batalha para ser removida");
        } else {
            batalhaRepository.remover(batalha.getIdBatalha());
        }
    }

    // TODO CHECAR A IMPRESSÃO DO UPDATE

    public void editar(Integer id, Batalha batalha) {

        try {
            boolean conseguiuEditar = batalhaRepository.editar(id, batalha);
            System.out.println("Novo round");

        } catch (BancoDeDadosException e) {
            e.printStackTrace();
        }
    }

}
