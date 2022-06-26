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
    private final ReinoLuz reinoLuz = new ReinoLuz();
    private final ReinoSombrio reinoSombrio = new ReinoSombrio();
    private Personagem personagem = new Personagem();
    private Boss boss = new Boss();
    private final BossReinoLuz bossLuz = new BossReinoLuz("Boss da Luz",reinoLuz);
    private final BossReinoSombrio bossSombrio = new BossReinoSombrio("Boss das Sombras ",reinoSombrio);
    private int roundAtual = 0;

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

    public void sortearCenario(){
        if(this.personagem == null){
            System.out.println("| Não há personagem disponível para a batalha |");
        }
        Random random = new Random();
        int sortear = random.nextInt(2) + 1;
        switch (sortear) {
            case 1 -> {
                setCenario(reinoLuz);
                setBoss(bossLuz);
            }
            case 2 -> {
                this.cenario = reinoSombrio;
                setBoss(bossSombrio);

            }
            case default -> System.out.println("| Cenário Inválido |");
        }
    }

    public void inciarBatalha(){

        if(this.boss == bossLuz){

            System.out.println("--------------------\nO BOSS DA LUZ ESTÁ CHEGANDO...\n--------------------" +
                    "        /                            )\n" +
                    "          (                             |\\\n" +
                    "         /|                              \\\\\n" +
                    "        //                                \\\\\n" +
                    "       ///                                 \\|\n" +
                    "      /( \\                                  )\\\n" +
                    "      \\\\  \\_                               //)\n" +
                    "       \\\\  :\\__                           ///\n" +
                    "        \\\\     )                         // \\\n" +
                    "         \\\\:  /                         // |/\n" +
                    "          \\\\ / \\                       //  \\\n" +
                    "           /)   \\   ___..-'           (|  \\_|\n" +
                    "          //     /   _.'              \\ \\  \\\n" +
                    "         /|       \\ \\________          \\ | /\n" +
                    "        (| _ _  __/          '-.       ) /.'\n" +
                    "         \\\\ .  '-.__            \\_    / / \\\n" +
                    "          \\\\_'.     > --._ '.     \\  / / /\n" +
                    "           \\ \\      \\     \\  \\     .' /.'\n" +
                    "            \\ \\  '._ /     \\ )    / .' |\n" +
                    "             \\ \\_     \\_   |    .'_/ __/\n" +
                    "              \\  \\      \\_ |   / /  _/ \\_\n" +
                    "               \\  \\       / _.' /  /     \\\n" +
                    "               \\   |     /.'   / .'       '-,_\n" +
                    "                \\   \\  .'   _.'_/             \\\n" +
                    "   /\\    /\\      ) ___(    /_.'           \\    |\n" +
                    "  | _\\__// \\    (.'      _/               |    |\n" +
                    "  \\/_  __  /--'`    ,                   __/    /\n" +
                    "  (_ ) /b)  \\  '.   :            \\___.-'_/ \\__/\n" +
                    "  /:/:  ,     ) :        (      /_.'__/-'|_ _ /\n" +
                    " /:/: __/\\ >  __,_.----.__\\    /        (/(/(/\n" +
                    "(_(,_/V .'/--'    _/  __/ |   /\n" +
                    " VvvV  //`    _.-' _.'     \\   \\\n" +
                    "   n_n//     (((/->/        |   /\n" +
                    "   '--'         ~='          \\  |\n" +
                    "                              | |_,,,\n" +
                    "                              \\  \\  /\n" +

                    "                               '.__)");
        }else{

            System.out.println("--------------------\nO BOSS DAS SOMBRAS ESTÁ CHEGANDO...\n--------------------" +
                    "                                             ,--,  ,.-.\n" +
                    "               ,                   \\,       '-,-`,'-.' | ._\n" +
                    "              /|           \\    ,   |\\         }  )/  / `-,',\n" +
                    "              [ ,          |\\  /|   | |        /  \\|  |/`  ,`\n" +
                    "              | |       ,.`  `,` `, | |  _,...(   (      .',\n" +
                    "              \\  \\  __ ,-` `  ,  , `/ |,'      Y     (   /_L\\\n" +
                    "               \\  \\_\\,``,   ` , ,  /  |         )         _,/\n" +
                    "                \\  '  `  ,_ _`_,-,<._.<        /         /\n" +
                    "                 ', `>.,`  `  `   ,., |_      |         /\n" +
                    "                   \\/`  `,   `   ,`  | /__,.-`    _,   `\\\n" +
                    "               -,-..\\  _  \\  `  /  ,  / `._) _,-\\`       \\\n" +
                    "                \\_,,.)  \\    ` /  / ) (-,, ``    ,        |\n" +
                    "               ,` )  | \\_\\       '-`  |  `(               \\\n" +
                    "              /  /```(   , --, ,' \\   |`<`    ,            |\n" +
                    "             /  /_,--`\\   <\\  V /> ,` )<_/)  | \\      _____)\n" +
                    "       ,-, ,`   `   (_,\\ \\    |   /) / __/  /   `----`\n" +
                    "      (-, \\           ) \\ ('_.-._)/ /,`    /\n" +
                    "      | /  `          `/ \\\\ V   V, /`     /\n" +
                    "   ,--\\(        ,     <_/`\\\\     ||      /\n" +
                    "  (   ,``-     \\/|         \\-A.A-`|     /\n" +
                    " ,>,_ )_,..(    )\\          -,,_-`  _--`\n" +
                    "(_ \\|`   _,/_  /  \\_            ,--`\n" +
                    " \\( `   <.,../`     `-.._   _,-`");

        }if(this.boss.getVida() <= 0){

/*            System.out.println("Parabéns! Você venceu e salvou o Reino!\n" +
                    "██╗   ██╗ ██████╗  ██████╗███████╗                      \n" +
                    "██║   ██║██╔═══██╗██╔════╝██╔════╝                      \n" +
                    "██║   ██║██║   ██║██║     █████╗                        \n" +
                    "╚██╗ ██╔╝██║   ██║██║     ██╔══╝                        \n" +
                    " ╚████╔╝ ╚██████╔╝╚██████╗███████╗                      \n" +
                    "  ╚═══╝   ╚═════╝  ╚═════╝╚══════╝                      \n" +
                    "    ██╗   ██╗███████╗███╗   ██╗ ██████╗███████╗██╗   ██╗\n" +
                    "    ██║   ██║██╔════╝████╗  ██║██╔════╝██╔════╝██║   ██║\n" +
                    "    ██║   ██║█████╗  ██╔██╗ ██║██║     █████╗  ██║   ██║\n" +
                    "    ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║     ██╔══╝  ██║   ██║\n" +
                    "     ╚████╔╝ ███████╗██║ ╚████║╚██████╗███████╗╚██████╔");*/

        }else if(this.getPersonagem().getClassePersonagem().getVidaClasse() == 0){
/*            System.out.println("Você foi derrotado.\n" +
                    " ██▒   █▓ ▒█████   ▄████▄  ▓█████                \n" +
                    "▓██░   █▒▒██▒  ██▒▒██▀ ▀█  ▓█   ▀                \n" +
                    " ▓██  █▒░▒██░  ██▒▒▓█    ▄ ▒███                  \n" +
                    "  ▒██ █░░▒██   ██░▒▓▓▄ ▄██▒▒▓█  ▄                \n" +
                    "   ▒▀█░  ░ ████▓▒░▒ ▓███▀ ░░▒████▒               \n" +
                    "   ░ ▐░  ░ ▒░▒░▒░ ░ ░▒ ▒  ░░░ ▒░ ░               \n" +
                    "   ░ ░░    ░ ▒ ▒░   ░  ▒    ░ ░  ░               \n" +
                    "     ░░  ░ ░ ░ ▒  ░           ░                  \n" +
                    "      ░      ░ ░  ░ ░         ░  ░               \n" +
                    " ██▓███  ▓█████  ██▀███  ▓█████▄ ▓█████  █    ██ \n" +
                    "▓██░  ██▒▓█   ▀ ▓██ ▒ ██▒▒██▀ ██▌▓█   ▀  ██  ▓██▒\n" +
                    "▓██░ ██▓▒▒███   ▓██ ░▄█ ▒░██   █▌▒███   ▓██  ▒██░\n" +
                    "▒██▄█▓▒ ▒▒▓█  ▄ ▒██▀▀█▄  ░▓█▄   ▌▒▓█  ▄ ▓▓█  ░██░\n" +
                    "▒██▒ ░  ░░▒████▒░██▓ ▒██▒░▒████▓ ░▒████▒▒▒█████▓ \n" +
                    "▒▓▒░ ░  ░░░ ▒░ ░░ ▒▓ ░▒▓░ ▒▒▓  ▒ ░░ ▒░ ░░▒▓▒ ▒ ▒ \n" +
                    "░▒ ░      ░ ░  ░  ░▒ ░ ▒░ ░ ▒  ▒  ░ ░  ░░░▒░ ░ ░ \n" +
                    "░░          ░     ░░   ░  ░ ░  ░    ░    ░░░ ░ ░ \n" +
                    "            ░  ░   ░        ░       ░  ░   ░     \n" +
                    "                          ░                     ");*/
        }
            setRoundAtual(roundAtual++);

            if (this.boss == bossLuz) {

                if (this.boss.getVida() <= 0) {

                    System.out.println("Parabéns! Você venceu e salvou o Reino!\n" +
                            "██╗   ██╗ ██████╗  ██████╗███████╗                      \n" +
                            "██║   ██║██╔═══██╗██╔════╝██╔════╝                      \n" +
                            "██║   ██║██║   ██║██║     █████╗                        \n" +
                            "╚██╗ ██╔╝██║   ██║██║     ██╔══╝                        \n" +
                            " ╚████╔╝ ╚██████╔╝╚██████╗███████╗                      \n" +
                            "  ╚═══╝   ╚═════╝  ╚═════╝╚══════╝                      \n" +
                            "    ██╗   ██╗███████╗███╗   ██╗ ██████╗███████╗██╗   ██╗\n" +
                            "    ██║   ██║██╔════╝████╗  ██║██╔════╝██╔════╝██║   ██║\n" +
                            "    ██║   ██║█████╗  ██╔██╗ ██║██║     █████╗  ██║   ██║\n" +
                            "    ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║     ██╔══╝  ██║   ██║\n" +
                            "     ╚████╔╝ ███████╗██║ ╚████║╚██████╗███████╗╚██████╔");

                }else if (this.getPersonagem().getClassePersonagem().getVidaClasse() <= 0) {

                    System.out.println("Você foi derrotado.\n" +
                            " ██▒   █▓ ▒█████   ▄████▄  ▓█████                \n" +
                            "▓██░   █▒▒██▒  ██▒▒██▀ ▀█  ▓█   ▀                \n" +
                            " ▓██  █▒░▒██░  ██▒▒▓█    ▄ ▒███                  \n" +
                            "  ▒██ █░░▒██   ██░▒▓▓▄ ▄██▒▒▓█  ▄                \n" +
                            "   ▒▀█░  ░ ████▓▒░▒ ▓███▀ ░░▒████▒               \n" +
                            "   ░ ▐░  ░ ▒░▒░▒░ ░ ░▒ ▒  ░░░ ▒░ ░               \n" +
                            "   ░ ░░    ░ ▒ ▒░   ░  ▒    ░ ░  ░               \n" +
                            "     ░░  ░ ░ ░ ▒  ░           ░                  \n" +
                            "      ░      ░ ░  ░ ░         ░  ░               \n" +
                            " ██▓███  ▓█████  ██▀███  ▓█████▄ ▓█████  █    ██ \n" +
                            "▓██░  ██▒▓█   ▀ ▓██ ▒ ██▒▒██▀ ██▌▓█   ▀  ██  ▓██▒\n" +
                            "▓██░ ██▓▒▒███   ▓██ ░▄█ ▒░██   █▌▒███   ▓██  ▒██░\n" +
                            "▒██▄█▓▒ ▒▒▓█  ▄ ▒██▀▀█▄  ░▓█▄   ▌▒▓█  ▄ ▓▓█  ░██░\n" +
                            "▒██▒ ░  ░░▒████▒░██▓ ▒██▒░▒████▓ ░▒████▒▒▒█████▓ \n" +
                            "▒▓▒░ ░  ░░░ ▒░ ░░ ▒▓ ░▒▓░ ▒▒▓  ▒ ░░ ▒░ ░░▒▓▒ ▒ ▒ \n" +
                            "░▒ ░      ░ ░  ░  ░▒ ░ ▒░ ░ ▒  ▒  ░ ░  ░░░▒░ ░ ░ \n" +
                            "░░          ░     ░░   ░  ░ ░  ░    ░    ░░░ ░ ░ \n" +
                            "            ░  ░   ░        ░       ░  ░   ░     \n" +
                            "                          ░                     ");
                }
                System.out.println(bossLuz.recuperarVida());
                reinoLuz.ajudaSoldados(this);
                reinoLuz.bonusHorario(this);
                cenario.buffDebuff(this);
                this.atacar();
                this.ataqueBoss();
                System.out.println(this.imprimiStatusJogador());
                System.out.println("-------------------------");
                System.out.println(this.imprimiStatusBoss());

            } else if (this.boss == bossSombrio) {

                if(this.boss.getVida() <= 0){

                    System.out.println("Parabéns! Você venceu e salvou o Reino!\n" +
                            "██╗   ██╗ ██████╗  ██████╗███████╗                      \n" +
                            "██║   ██║██╔═══██╗██╔════╝██╔════╝                      \n" +
                            "██║   ██║██║   ██║██║     █████╗                        \n" +
                            "╚██╗ ██╔╝██║   ██║██║     ██╔══╝                        \n" +
                            " ╚████╔╝ ╚██████╔╝╚██████╗███████╗                      \n" +
                            "  ╚═══╝   ╚═════╝  ╚═════╝╚══════╝                      \n" +
                            "    ██╗   ██╗███████╗███╗   ██╗ ██████╗███████╗██╗   ██╗\n" +
                            "    ██║   ██║██╔════╝████╗  ██║██╔════╝██╔════╝██║   ██║\n" +
                            "    ██║   ██║█████╗  ██╔██╗ ██║██║     █████╗  ██║   ██║\n" +
                            "    ╚██╗ ██╔╝██╔══╝  ██║╚██╗██║██║     ██╔══╝  ██║   ██║\n" +
                            "     ╚████╔╝ ███████╗██║ ╚████║╚██████╗███████╗╚██████╔");

                }else if(this.getPersonagem().getClassePersonagem().getVidaClasse() <= 0){

                    System.out.println("Você foi derrotado.\n" +
                            " ██▒   █▓ ▒█████   ▄████▄  ▓█████                \n" +
                            "▓██░   █▒▒██▒  ██▒▒██▀ ▀█  ▓█   ▀                \n" +
                            " ▓██  █▒░▒██░  ██▒▒▓█    ▄ ▒███                  \n" +
                            "  ▒██ █░░▒██   ██░▒▓▓▄ ▄██▒▒▓█  ▄                \n" +
                            "   ▒▀█░  ░ ████▓▒░▒ ▓███▀ ░░▒████▒               \n" +
                            "   ░ ▐░  ░ ▒░▒░▒░ ░ ░▒ ▒  ░░░ ▒░ ░               \n" +
                            "   ░ ░░    ░ ▒ ▒░   ░  ▒    ░ ░  ░               \n" +
                            "     ░░  ░ ░ ░ ▒  ░           ░                  \n" +
                            "      ░      ░ ░  ░ ░         ░  ░               \n" +
                            " ██▓███  ▓█████  ██▀███  ▓█████▄ ▓█████  █    ██ \n" +
                            "▓██░  ██▒▓█   ▀ ▓██ ▒ ██▒▒██▀ ██▌▓█   ▀  ██  ▓██▒\n" +
                            "▓██░ ██▓▒▒███   ▓██ ░▄█ ▒░██   █▌▒███   ▓██  ▒██░\n" +
                            "▒██▄█▓▒ ▒▒▓█  ▄ ▒██▀▀█▄  ░▓█▄   ▌▒▓█  ▄ ▓▓█  ░██░\n" +
                            "▒██▒ ░  ░░▒████▒░██▓ ▒██▒░▒████▓ ░▒████▒▒▒█████▓ \n" +
                            "▒▓▒░ ░  ░░░ ▒░ ░░ ▒▓ ░▒▓░ ▒▒▓  ▒ ░░ ▒░ ░░▒▓▒ ▒ ▒ \n" +
                            "░▒ ░      ░ ░  ░  ░▒ ░ ▒░ ░ ▒  ▒  ░ ░  ░░░▒░ ░ ░ \n" +
                            "░░          ░     ░░   ░  ░ ░  ░    ░    ░░░ ░ ░ \n" +
                            "            ░  ░   ░        ░       ░  ░   ░     \n" +
                            "                          ░                     ");
                }
                System.out.println(bossSombrio.getVida());
                cenario.buffDebuff(this);
                bossSombrio.danoAdicional();
                reinoSombrio.ajudaSombria(this);
                this.atacar();
                this.ataqueBoss();
                System.out.println(this.imprimiStatusJogador());
                System.out.println("-------------------------");
                System.out.println(this.imprimiStatusBoss());


            }
    }

    @Override
    public void atacar() {

        Random random = new Random();
        int valor = random.nextInt(10);
        int atqJogador = this.personagem.getClassePersonagem().getAtaqueClasse();
        int vidaBoss = this.boss.getVida();
        int defesaBoss = this.boss.getDefesa();
        int valorAtq = atqJogador + valor;

        if(valor <= 2) {
            System.out.println("\nO Boss desviou do seu ataque\n");

        }else {
            System.out.println("\nAtaque bem sucedido\n");

            this.boss.setVida(vidaBoss + defesaBoss - valorAtq );
        }
    }

    public String imprimiStatusJogador(){
        String nome = this.getPersonagem().getClassePersonagem().getTipoNome();
        int vida = this.getPersonagem().getClassePersonagem().getVidaClasse();
        int ataque = this.getPersonagem().getClassePersonagem().getAtaqueClasse();
        int defesa = this.getPersonagem().getClassePersonagem().getDefesaClasse();

        return  "" +
                "| Personagem: " + nome +
                "\n| Vida: " + vida
                + "\n"+
                "| Ataque: " + ataque
                + "\n"+
                "| Defesa: " + defesa +
                "" ;
    }

    public String imprimiStatusBoss(){
        String nome = this.getBoss().getNome();
        int vida = this.getBoss().getVida();
        int ataque = this.getBoss().getAtaque();
        int defesa = this.getBoss().getDefesa();

        return  "" +
                "| Boss: " + nome +
                "\n| Vida: " + vida
                + "\n"+
                "| Ataque: " + ataque
                + "\n"+
                "| Defesa: " + defesa
                + "\n"+
                "" ;
    }


    @Override
    public void ataqueBoss() {

        Random random = new Random();
        int valor = random.nextInt(10);
        int vidaJogador = this.personagem.getClassePersonagem().getVidaClasse();
        int atqBoss = this.boss.getAtaque();
        int valorAtq = atqBoss + valor;
        if(valor <= 3) {
            System.out.println("\nVocê desviou do ataque do boss\n");
        }else {
            this.personagem.getClassePersonagem().setVidaClasse(vidaJogador - valorAtq);
        }
    }
}
