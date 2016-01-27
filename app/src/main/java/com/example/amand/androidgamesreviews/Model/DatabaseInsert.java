package com.example.amand.androidgamesreviews.Model;

import android.content.Context;

import java.util.List;

/**
 * André Amândio
 * Trabalho: PDM2
 * Ficheiro: DatabaseInsert
 * Data entrega: 27/01/2016
 */
public class DatabaseInsert {

    public DatabaseInsert(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        List<Categoria> categorias = db.getAllCategorys();
        List<Produtora> produtoras = db.getAllProdutions();
        List<Jogo> jogos = db.getAllGames();

        if (categorias.size() == 0){
            insert_Dados(context);
        } else if (produtoras.size() == 0){
            insert_Dados(context);
        } else if(jogos.size() == 0){
            insert_Dados(context);
        }
    }

    /**
     *
     * @param context
     */
    public void insert_Dados(Context context){
        DatabaseHandler db = new DatabaseHandler(context);
        db.addCategory(new Categoria("Arcada"));
        db.addCategory(new Categoria("Cartas"));
        db.addCategory(new Categoria("Desporto"));
        db.addCategory(new Categoria("Corridas"));
        db.addCategory(new Categoria("Puzzle"));
        db.addCategory(new Categoria("Estratégia"));
        db.addCategory(new Categoria("Música"));

        db.addProdution(new Produtora("Clean Master Games"));
        db.addProdution(new Produtora("TaoGames Limited"));
        db.addProdution(new Produtora("First Touch"));
        db.addProdution(new Produtora("Kiloo"));
        db.addProdution(new Produtora("Miniclip.com"));
        db.addProdution(new Produtora("Electronic Arts"));
        db.addProdution(new Produtora("Soner Kara"));
        db.addProdution(new Produtora("King"));
        db.addProdution(new Produtora("Tapps - Top Apps and Games"));
        db.addProdution(new Produtora("Invictus Games Ltd."));

        db.addGame(new Jogo("Piano Tiles", "Piano Tiles 2 é a sequência do Piano Tiles (Don't Tap the White Tile), " +
                "que é mundialmente conhecido e popular. " +
                "Nova jogabilidade, a qualidade de som de primeira e o modo de competição " +
                "global lhe trará a emoção ao controlar o dedo e prazer de tocar piano.", 4.7, "pianotiles",
                "https://youtu.be/kkvSM-0vxHg", "https://play.google.com/store/apps/details?id=com.cmplay.tiles2", "1", "1"));

        db.addGame(new Jogo("Solitário", "Jogue o #1 jogo de cartas Solitário (ou Solitário Klondike / Paciência) no Android!\n" +
                "Solitário Clássico, também conhecido como Paciência, é o jogo de cartas mais popular do mundo. " +
                "Experimente o nosso app de cartas, o MELHOR SOLITÁRIO GRÁTIS," +
                " que é bonito e divertido como o Solitário clássico do Windows.", 4.7, "solitario",
                "", "https://play.google.com/store/apps/details?id=com.spacegame.solitaire.basic", "2", "2"));

        db.addGame(new Jogo("Score! Hero", "Score! Hero, dos premiados criadores de Score! World Goals, Dream League Soccer e First Touch Soccer.\n" +
                "SEJA UM HERÓI! Passe, chute e marque seu caminho até um status de lenda, enquanto explora a dramática " +
                "carreira do seu HERÓI por 320 níveis desafiadores!", 4.7, "scorehero",
                "https://youtu.be/M5XXJ_rNzNc", "https://play.google.com/store/apps/details?id=com.firsttouchgames.story", "3", "3"));

        db.addGame(new Jogo("Subway Surfers", "DASH as fast as you can! \n" +
                "DODGE the oncoming trains!\n" +
                "Help Jake, Tricky & Fresh escape from the grumpy Inspector and his dog.", 4.4, "subwaysurfers",
                "https://youtu.be/fUk_eBKL3q8", "https://play.google.com/store/apps/details?id=com.kiloo.subwaysurf", "4", "1"));

        db.addGame(new Jogo("8 Ball Pool", "O jogo de bilhar nº 1 do mundo - agora para Android!\n" +
                "Joga com amigos! Joga com lendas. Joga o famoso jogo 8 Ball Pool da Miniclip no " +
                "teu dispositivo móvel e torna-te o melhor!", 4.5, "eightballpool",
                "https://youtu.be/MarGQrmbPm0", "https://play.google.com/store/apps/details?id=com.miniclip.eightballpool", "5", "3"));

        db.addGame(new Jogo("Need for Speed™ No Limits", "Corra para dominar o asfalto na primeira edição eletrizante de Need for Speed feita só para dispositivos móveis – " +
                "dos mesmos desenvolvedores que deram a você Real Racing 3. Construa sua máquina dos sonhos com uma variedade inacreditável de veículos e personalizações. " +
                "Viva no limite tênue entre caos e controle, pisando fundo na subcultura dos carros de corrida urbanos. Ganhe corridas, aumente sua reputação e depois caia dentro de mais corridas, " +
                "mais personalizações e mais carrões. Faça suas escolhas e nunca olhe para trás. A noite é sua!\n" +
                "Este aplicativo oferece compras internas. Você pode desativar as compras pelo aplicativo nas configurações do seu dispositivo.", 4.3, "nfs",
                "https://youtu.be/9DQvlNm20x0", "https://play.google.com/store/apps/details?id=com.ea.game.nfs14_row", "6", "4"));

        db.addGame(new Jogo("Traffic Rider",
                "Outra obra-prima dos criadores do Traffic Racer. Desta vez, você está no comando de uma moto vivenciando uma " +
                        "experiência muito mais detalhada, mas mantendo a antiga diversão e a simplicidade.\n" +
                        "O Traffic Rider leva a experiência do gênero de corrida interminável a um nível totalmente " +
                        "novo, adicionando um modo carreira completo, perspectiva de visão em primeira pessoa, imagens " +
                        "melhores e sons de motos reais gravados. A essência da corrida arcade ainda existe, mas com as novidades" +
                        " da próxima geração. Pilote sua moto em estradas intermináveis, enfrentando trânsito, aprimorando e comprando novas motos para cumprir missões no modo carreira."
                ,4.8 , "traficrider",
                "https://youtu.be/0FimuzxUiQY", "https://play.google.com/store/apps/details?id=com.skgames.trafficrider",
                "7", "4" ));

        db.addGame(new Jogo("Candy Crush Jelly Saga",
                "A Jelly Queen chegou à cidade e quer desafiar-te para um jogo de Candy Crush Jelly Saga! Quaisquer que sejam as tuas jogadas," +
                        " é bom que sejam jelly-ciosas o suficiente para derrotares a poderosa Jelly Queen.\n" +
                        "Espalha a diversão! O novo Candy Crush Jelly Saga traz novos modos de jogo, funcionalidades e batalhas contra bosses... no caso, bossa: a Jelly Queen! No jogo, tu és a Jenny e" +
                        " precisas de mostrar o que sabes para enfrentar a Jelly Queen em cada rodada. Vence quem conseguir espalhar mais gelatina no ecrã! Tens o que é preciso?"
                ,4.3 , "jellysaga",
                "", "https://play.google.com/store/apps/details?id=com.king.candycrushjellysaga",
                "8", "5" ));

        db.addGame(new Jogo("Vlogger Go Viral - Clicker",
                "Prepare-se para se tornar a próxima sensação da internet em Vlogger Go Viral, um jogo clicker em que " +
                        "cada clique deixa seu canal mais próximo da fama. Comece apenas com um sonho na cabeça e uma câmera nas mãos e trilhe seu caminho para o estrelato. Será que você consegue?\n" +
                        "Faça a produção de vídeos, gerencie seu canal, consiga milhões de seguidores e visualizações, fique bilionário e melhore seus equipamentos e estúdio. O céu é o limite!"
                ,4.7 , "vlog",
                "https://youtu.be/K-ORc7hTYyQ", "https://play.google.com/store/apps/details?id=br.com.tapps.vloggergoviral",
                "9", "6" ));

        db.addGame(new Jogo("Desiste! 2",
                "Chegou a sequência do popular jogo de plataforma baseado em ritmo!\n" +
                        "☆☆Mais de 10 milhões de downloads de Desiste! no mundo todo. ☆☆\n" +
                        "Desiste! 2 combina os melhores recursos dos jogos de plataforma e de ritmo, fazendo um Desiste! ainda melhor.\n" +
                        "Jogue com a Bolha e seus amigos em um mundo surreal acinzentado e exclusivo de espinhos mortais e plataformas."
                ,4.3 , "desiste2",
                "https://youtu.be/x_h-TL87jHE", "https://play.google.com/store/apps/details?id=com.invictus.giveitup2",
                "10", "7" ));

        //Método de adicionar jogos
        /*db.addGame(new Jogo("",
                ""
                , , "",
                "", "",
                "", "" ));*/
    }

}
