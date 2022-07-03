package service;

import entities.Cenario;
import entities.ClassePersonagem;
import entities.Personagem;
import exceptions.BancoDeDadosException;
import repository.CenarioRepository;

import java.util.Objects;

public class CenarioService {

    CenarioRepository cenarioRepository = new CenarioRepository();

    public void adicionarCenario(Cenario cenario) throws BancoDeDadosException {
        if (cenario == null) {
            System.out.println("Cenario inexistente");
        } else {
            cenarioRepository.adicionar(cenario);
        }
    }

    public void listarTodos() throws BancoDeDadosException {
        for (Cenario cenario : cenarioRepository.listar()) {
            System.out.println(cenario);
        }
    }

    public void remover(Cenario cenario) throws BancoDeDadosException {
        if (cenario == null) {
            System.out.println("Cenario inexistente");
        } else {
            cenarioRepository.remover(cenario.getIdCenario());
        }
    }

    public void editar(Cenario cenario) throws BancoDeDadosException {
        if (cenario == null) {
            System.out.println("Cenario inexistente");
        } else {
            cenarioRepository.editar(cenario.getIdCenario(), cenario);
        }
    }

    public Cenario retornaCenario(String tipo) throws BancoDeDadosException {
        return cenarioRepository.listar().stream().filter(a -> Objects.equals(a.getTipoCenario(), tipo)).map(a -> {
            return new Cenario(a.getIdCenario(), a.getNomeCenario(), a.getTipoCenario(), a.getHorario());
        }).findFirst().orElse(null);
    }


    public boolean verificaNomeCenario(Cenario cenario) throws BancoDeDadosException {
        if (cenario == null) {
            System.out.println("Cenario inexistente");
        } else {
            Cenario cenario1 = this.retornaCenario(cenario.getNomeCenario());
            if (cenario1 == null) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
