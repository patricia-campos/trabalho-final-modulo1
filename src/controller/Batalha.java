package controller;

import entities.boss.Boss;
import entities.boss.BossReinoLuz;
import entities.boss.BossReinoSombrio;
import entities.cenario.Cenario;
import entities.cenario.ReinoLuz;
import entities.cenario.ReinoSombrio;
import entities.personagem.Personagem;
import interfaces.Ataca;

import java.util.Random;

public class Batalha implements Ataca {

    private Cenario cenario;
    private ReinoLuz reinoLuz = new ReinoLuz();
    private ReinoSombrio reinoSombrio = new ReinoSombrio();
    private Personagem personagem = new Personagem();
    private Boss boss = new Boss();
    private final BossReinoLuz bossLuz = new BossReinoLuz();
    private final BossReinoSombrio bossSombrio = new BossReinoSombrio();
    private int roundAtual = 0;

    public ReinoLuz getReinoLuz() {
        return reinoLuz;
    }

    public void setReinoLuz(ReinoLuz reinoLuz) {
        this.reinoLuz = reinoLuz;
    }

    public ReinoSombrio getReinoSombrio() {
        return reinoSombrio;
    }

    public void setReinoSombrio(ReinoSombrio reinoSombrio) {
        this.reinoSombrio = reinoSombrio;
    }

    public BossReinoLuz getBossLuz() {
        return bossLuz;
    }

    public BossReinoSombrio getBossSombrio() {
        return bossSombrio;
    }

    public Cenario getCenario() {
        return cenario;
    }

    public void setCenario(Cenario cenario) {
        this.cenario = cenario;
    }

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public Boss getBoss() {
        return boss;
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public int getRoundAtual() {
        return roundAtual;
    }

    public void setRoundAtual(int roundAtual) {
        this.roundAtual = roundAtual;
    }

    @Override
    public void atacar() {
        //ataque do jogador no boss
        Random random = new Random();
        int valor = random.nextInt(10);
        int atqJogador = this.personagem.getClassePersonagem().getAtaqueClasse();
        int vidaBoss = this.boss.getVida();
        int defesaBoss = this.boss.getDefesa();
        int valorAtq = atqJogador + valor;

        if (valor <= 2) {
            System.out.println("\nO Boss desviou do seu ataque\n");

        } else {
            System.out.println("\nAtaque bem sucedido\n");

            this.boss.setVida(vidaBoss + defesaBoss - valorAtq);
        }
    }

    public String imprimiStatusJogador() {
        String nome = getPersonagem().getClassePersonagem().getTipoNome();
        int vida = getPersonagem().getClassePersonagem().getVidaClasse();
        int ataque = getPersonagem().getClassePersonagem().getAtaqueClasse();
        int defesa = getPersonagem().getClassePersonagem().getDefesaClasse();

        return "" +
                "| Personagem: " + nome +
                "\n| Vida: " + vida
                + "\n" +
                "| Ataque: " + ataque
                + "\n" +
                "| Defesa: " + defesa +
                "";
    }

    public String imprimiStatusBoss() {
        String nome = getBoss().getNome();
        int vida = getBoss().getVida();
        int ataque = getBoss().getAtaque();
        int defesa = getBoss().getDefesa();

        return "" +
                "| Boss: " + nome +
                "\n| Vida: " + vida
                + "\n" +
                "| Ataque: " + ataque
                + "\n" +
                "| Defesa: " + defesa
                + "\n" +
                "";
    }

    @Override
    public void ataqueBoss() {

        Random random = new Random();
        int valor = random.nextInt(10);
        int vidaJogador = this.personagem.getClassePersonagem().getVidaClasse();
        int atqBoss = this.boss.getAtaque();
        int valorAtq = atqBoss + valor;
        if (valor <= 3) {
            System.out.println("\nVocê desviou do ataque do boss\n");
        } else {
            this.personagem.getClassePersonagem().setVidaClasse(vidaJogador - valorAtq);
        }
    }

    public void sortearCenario() {
        if (this.personagem == null) {
            System.out.println("| Não há personagem disponível para a batalha |");
        }
        Random random = new Random();
        int sortear = random.nextInt(2) + 1;
        if (sortear == 1) {
            setCenario(reinoLuz);
            setBoss(bossLuz);
        }else if (sortear == 2) {
            this.cenario = reinoSombrio;
            setBoss(bossSombrio);
        } else if(sortear > 2) {
            System.out.println("| Cenário Inválido |");
        }
    }


    public void inciarRound() {

        if (this.boss == bossLuz) {

            System.out.println("""
                    --------------------
                    O BOSS DA LUZ ESTÁ CHEGANDO...
                    --------------------        
                               /                            )
                              (                             |\\
                             /|                              \\\\
                            //                                \\\\
                           ///                                 \\|
                          /( \\                                  )\\
                          \\\\  \\_                               //)
                           \\\\  :\\__                           ///
                            \\\\     )                         // \\
                             \\\\:  /                         // |/
                              \\\\ / \\                       //  \\
                               /)   \\   ___..-'           (|  \\_|
                              //     /   _.'              \\ \\  \\
                             /|       \\ \\________          \\ | /
                            (| _ _  __/          '-.       ) /.'
                             \\\\ .  '-.__            \\_    / / \\
                              \\\\_'.     > --._ '.     \\  / / /
                               \\ \\      \\     \\  \\     .' /.'
                                \\ \\  '._ /     \\ )    / .' |
                                 \\ \\_     \\_   |    .'_/ __/
                                  \\  \\      \\_ |   / /  _/ \\_
                                   \\  \\       / _.' /  /     \\
                                   \\   |     /.'   / .'       '-,_
                                    \\   \\  .'   _.'_/             \\
                       /\\    /\\      ) ___(    /_.'           \\    |
                      | _\\__// \\    (.'      _/               |    |
                      \\/_  __  /--'`    ,                   __/    /
                      (_ ) /b)  \\  '.   :            \\___.-'_/ \\__/
                      /:/:  ,     ) :        (      /_.'__/-'|_ _ /
                     /:/: __/\\ >  __,_.----.__\\    /        (/(/(/
                    (_(,_/V .'/--'    _/  __/ |   /
                     VvvV  //`    _.-' _.'     \\   \\
                       n_n//     (((/->/        |   /
                       '--'         ~='          \\  |
                                                  | |_,,,
                                                  \\  \\  /
                                                   '.__)""");
        } else {

            System.out.println("""
                    --------------------
                    O BOSS DAS SOMBRAS ESTÁ CHEGANDO...
                    --------------------              
                                                                       ,--,  ,.-.
                                   ,                   \\,       '-,-`,'-.' | ._
                                  /|           \\    ,   |\\         }  )/  / `-,',
                                  [ ,          |\\  /|   | |        /  \\|  |/`  ,`
                                  | |       ,.`  `,` `, | |  _,...(   (      .',
                                  \\  \\  __ ,-` `  ,  , `/ |,'      Y     (   /_L\\
                                   \\  \\_\\,``,   ` , ,  /  |         )         _,/
                                    \\  '  `  ,_ _`_,-,<._.<        /         /
                                     ', `>.,`  `  `   ,., |_      |         /
                                       \\/`  `,   `   ,`  | /__,.-`    _,   `\\
                                   -,-..\\  _  \\  `  /  ,  / `._) _,-\\`       \\
                                    \\_,,.)  \\    ` /  / ) (-,, ``    ,        |
                                   ,` )  | \\_\\       '-`  |  `(               \\
                                  /  /```(   , --, ,' \\   |`<`    ,            |
                                 /  /_,--`\\   <\\  V /> ,` )<_/)  | \\      _____)
                           ,-, ,`   `   (_,\\ \\    |   /) / __/  /   `----`
                          (-, \\           ) \\ ('_.-._)/ /,`    /
                          | /  `          `/ \\\\ V   V, /`     /
                       ,--\\(        ,     <_/`\\\\     ||      /
                      (   ,``-     \\/|         \\-A.A-`|     /
                     ,>,_ )_,..(    )\\          -,,_-`  _--`
                    (_ \\|`   _,/_  /  \\_            ,--`
                     \\( `   <.,../`     `-.._   _,-`""");

        }
        setRoundAtual(roundAtual++);

        if (getBoss() == getBossLuz()) {
            System.out.println(getBossLuz().recuperarVida());
            getReinoLuz().ajudaSoldados(this);
            getReinoLuz().bonusHorario(this);
            getCenario().buffDebuff(this);
            this.atacar();
            this.ataqueBoss();
            System.out.println(this.imprimiStatusJogador());
            System.out.println("-------------------------");
            System.out.println(this.imprimiStatusBoss());
        } else if (getBoss() == getBossSombrio()) {
            System.out.println(getBossSombrio().getVida());
            getCenario().buffDebuff(this);
            System.out.println(getBossSombrio().danoAdicional(this));
            getReinoSombrio().ajudaSombria(this);
            getReinoSombrio().armadilha(this);
            this.atacar();
            this.ataqueBoss();
            System.out.println(this.imprimiStatusJogador());
            System.out.println("-------------------------");
            System.out.println(this.imprimiStatusBoss());
        }
    }

    public void retornaStatusVitoria(Boolean vitoria) {
        if (vitoria) {

            System.out.println("""
                    Parabéns! Você venceu e salvou o Reino!
                    ██╗   ██╗ ██████╗  ██████╗███████╗                     \s
                    ██║   ██║██╔═══██╗██╔════╝██╔════╝                     \s
                    ██║   ██║██║   ██║██║     █████╗                       \s
                    ╚██╗ ██╔╝██║   ██║██║     ██╔══╝                       \s
                     ╚████╔╝ ╚██████╔╝╚██████╗███████╗                     \s
                      ╚═══╝   ╚═════╝  ╚═════╝╚══════╝                     \s
                        ██╗   ██╗███████╗███╗   ██╗ ██████╗███████╗██╗   ██╗
                        ██║   ██║██╔════╝████╗  ██║██╔════╝██╔════╝██║   ██║
                        ██║   ██║█████╗  ██╔██╗ ██║██║     █████╗  ██║   ██║
                        ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║     ██╔══╝  ██║   ██║
                         ╚████╔╝ ███████╗██║ ╚████║╚██████╗███████╗╚██████╔""");

        } else {
            System.out.println("""
                    O Reino continua em perigo...
                     ██▒   █▓ ▒█████   ▄████▄  ▓█████               \s
                    ▓██░   █▒▒██▒  ██▒▒██▀ ▀█  ▓█   ▀               \s
                     ▓██  █▒░▒██░  ██▒▒▓█    ▄ ▒███                 \s
                      ▒██ █░░▒██   ██░▒▓▓▄ ▄██▒▒▓█  ▄               \s
                       ▒▀█░  ░ ████▓▒░▒ ▓███▀ ░░▒████▒              \s
                       ░ ▐░  ░ ▒░▒░▒░ ░ ░▒ ▒  ░░░ ▒░ ░              \s
                       ░ ░░    ░ ▒ ▒░   ░  ▒    ░ ░  ░              \s
                         ░░  ░ ░ ░ ▒  ░           ░                 \s
                          ░      ░ ░  ░ ░         ░  ░              \s
                     ██▓███  ▓█████  ██▀███  ▓█████▄ ▓█████  █    ██\s
                    ▓██░  ██▒▓█   ▀ ▓██ ▒ ██▒▒██▀ ██▌▓█   ▀  ██  ▓██▒
                    ▓██░ ██▓▒▒███   ▓██ ░▄█ ▒░██   █▌▒███   ▓██  ▒██░
                    ▒██▄█▓▒ ▒▒▓█  ▄ ▒██▀▀█▄  ░▓█▄   ▌▒▓█  ▄ ▓▓█  ░██░
                    ▒██▒ ░  ░░▒████▒░██▓ ▒██▒░▒████▓ ░▒████▒▒▒█████▓\s
                    ▒▓▒░ ░  ░░░ ▒░ ░░ ▒▓ ░▒▓░ ▒▒▓  ▒ ░░ ▒░ ░░▒▓▒ ▒ ▒\s
                    ░▒ ░      ░ ░  ░  ░▒ ░ ▒░ ░ ▒  ▒  ░ ░  ░░░▒░ ░ ░\s
                    ░░          ░     ░░   ░  ░ ░  ░    ░    ░░░ ░ ░\s
                                ░  ░   ░        ░       ░  ░   ░    \s
                                              ░                    \s""");
        }
    }
}
