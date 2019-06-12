package com.plekhanov.game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageLoader {

    private static BufferedImage backgroundImage1;
    private static BufferedImage backgroundImage2;
    private static BufferedImage backgroundImage3;
    private static BufferedImage backgroundImage4;
    private static BufferedImage backgroundImage5;
    private static BufferedImage backgroundImage6;
    private static BufferedImage backgroundImage7;
    private static BufferedImage backgroundImage8;
    private static BufferedImage backgroundImage9;

    private static BufferedImage backgroundLevel2Image1;
    private static BufferedImage backgroundLevel2Image2;
    private static BufferedImage backgroundLevel2Image3;
    private static BufferedImage backgroundLevel2Image4;
    private static BufferedImage backgroundLevel2Image5;

    private static BufferedImage backgroundLevel3Image1;
    private static BufferedImage backgroundLevel3Image2;
    private static BufferedImage backgroundLevel3Image3;
    private static BufferedImage backgroundLevel3Image4;
    private static BufferedImage backgroundLevel3Image5;
    private static BufferedImage backgroundLevel3Image6;
    private static BufferedImage backgroundLevel3Image7;
    private static BufferedImage backgroundLevel3Image8;
    private static BufferedImage backgroundLevel3Image9;

    private static BufferedImage gameOverImage;

    private static BufferedImage enemyCarrionImage;
    private static BufferedImage hungryCarrion;
    private static BufferedImage enemyHuskImage;
    private static BufferedImage enemyHuskShootImage;
    private static BufferedImage enemyPestilenceImage;
    private static BufferedImage fireBallImage;
    private static BufferedImage enemyMummyZombieLeftImage;
    private static BufferedImage enemyMummyZombieRightImage;

    private static BufferedImage enemyMummyZombieRageLeftImage_1;
    private static BufferedImage enemyMummyZombieRageLeftImage_2;
    private static BufferedImage enemyMummyZombieRageRightImage_1;
    private static BufferedImage enemyMummyZombieRageRightImage_2;

    private static BufferedImage enemyOgreWalkImage_1;
    private static BufferedImage enemyOgreWalkImage_2;
    private static BufferedImage enemyOgreWalkImage_3;
    private static BufferedImage enemyOgreWalkImage_4;
    private static BufferedImage enemyOgreWalkImage_5;
    private static BufferedImage enemyOgreWalkImage_6;
    private static BufferedImage enemyOgreWalkImage_7;
    private static BufferedImage enemyOgreJumpImage_1;
    private static BufferedImage enemyOgreJumpImage_2;
    private static BufferedImage enemyOgreJumpImage_3;
    private static BufferedImage enemyOgreJumpImage_4;
    private static BufferedImage enemyOgreJumpImage_5;
    private static BufferedImage enemyOgreJumpImage_6;
    private static BufferedImage enemyOgreJumpImage_7;

    private static BufferedImage playerImage;
    private static BufferedImage playerWoundedImage;
    private static BufferedImage playerMoveRightImage;
    private static BufferedImage playerMoveRightWoundedImage;
    private static BufferedImage playerMoveLeftImage;
    private static BufferedImage playerMoveLeftWoundedImage;
    private static BufferedImage playerJumpImage;
    private static BufferedImage playerJumpWoundedImage;

    private static BufferedImage playerFireBallImage_1;
    private static BufferedImage playerFireBallImage_2;

    private static BufferedImage heartImage;

    private static final String FS = File.separator;
    private static String PATH_TO_RESOURCE = "Game" + FS + "src" + FS + "main" + FS + "resources" + FS + "images" + FS;


    static {

        try {
            //Картинки для уровня 1

            // Статический фон
            backgroundImage1 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0010_1.png"));
            backgroundImage2 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0009_2.png"));
            backgroundImage3 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0008_3.png"));
            backgroundImage4 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0006_4.png"));

            // Динамический фон
            backgroundImage5 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0005_5.png"));
            backgroundImage6 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0003_6.png"));
            backgroundImage7 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0002_7.png"));
            backgroundImage8 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0001_8.png"));
            backgroundImage9 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0000_9.png"));

            //Конец игры
            gameOverImage = ImageIO.read(new File(PATH_TO_RESOURCE + "Game_Over.png"));

            // Враги
            fireBallImage = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "FireBall.png"));
            enemyCarrionImage = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyCarrion.png"));
            enemyHuskImage = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyHusk.png"));
            enemyHuskShootImage = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyHuskShoot.png"));
            hungryCarrion = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "carrion2.png"));
            enemyPestilenceImage = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyPestilence.png"));
            enemyMummyZombieLeftImage = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS + "MummyZombieLeft.png"));
            enemyMummyZombieRightImage = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS + "MummyZombieRight.png"));

            enemyMummyZombieRageLeftImage_1 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS + "MummyZombieRageLeft_1.png"));
            enemyMummyZombieRageLeftImage_2 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS + "MummyZombieRageLeft_2.png"));

            enemyMummyZombieRageRightImage_1 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS + "MummyZombieRageRight_1.png"));
            enemyMummyZombieRageRightImage_2 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS + "MummyZombieRageRight_2.png"));

            // Enemy Ogre
            enemyOgreWalkImage_1 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "walk" + FS + "ogre_walk_1.png"));
            enemyOgreWalkImage_2 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "walk" + FS + "ogre_walk_2.png"));
            enemyOgreWalkImage_3 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "walk" + FS + "ogre_walk_3.png"));
            enemyOgreWalkImage_4 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "walk" + FS + "ogre_walk_4.png"));
            enemyOgreWalkImage_5 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "walk" + FS + "ogre_walk_5.png"));
            enemyOgreWalkImage_6 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "walk" + FS + "ogre_walk_6.png"));
            enemyOgreWalkImage_7 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "walk" + FS + "ogre_walk_7.png"));

            enemyOgreJumpImage_1 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "jump" + FS + "ogre_jump_1.png"));
            enemyOgreJumpImage_2 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "jump" + FS + "ogre_jump_2.png"));
            enemyOgreJumpImage_3 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "jump" + FS + "ogre_jump_3.png"));
            enemyOgreJumpImage_4 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "jump" + FS + "ogre_jump_4.png"));
            enemyOgreJumpImage_5 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "jump" + FS + "ogre_jump_5.png"));
            enemyOgreJumpImage_6 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "jump" + FS + "ogre_jump_6.png"));
            enemyOgreJumpImage_7 = ImageIO.read(new File(PATH_TO_RESOURCE + "enemies" + FS + "ogre" + FS + "jump" + FS + "ogre_jump_7.png"));

            // Игрок
            playerImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "Player.png"));
            playerWoundedImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "PlayerWounded.png"));
            playerMoveRightImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveRight.png"));
            playerMoveRightWoundedImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveRightWounded.png"));
            playerMoveLeftImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveLeft.png"));
            playerMoveLeftWoundedImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveLeftWounded.png"));
            playerJumpImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "PlayerJump.png"));
            playerJumpWoundedImage = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "PlayerJumpWounded.png"));
            // огненные шары игрока
            playerFireBallImage_1 = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "player_fire_balls" + FS + "PlayerFireBall_1.png"));
            playerFireBallImage_2 = ImageIO.read(new File(PATH_TO_RESOURCE + "player" + FS + "player_fire_balls" + FS + "PlayerFireBall_2.png"));

            // Предметы
            heartImage = ImageIO.read(new File(PATH_TO_RESOURCE + "heart.png"));


            //Картинки для уровня 2

            //Фон
            backgroundLevel2Image1 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "1.png"));
            backgroundLevel2Image2 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "2.png"));
            backgroundLevel2Image3 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "3.png"));
            backgroundLevel2Image4 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "4.png"));
            backgroundLevel2Image5 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "5.png"));


            //Картинки для уровня 3

            //Фон
            backgroundLevel3Image1 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "sky.png"));
            backgroundLevel3Image2 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "rocks.png"));
            backgroundLevel3Image3 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "clouds_1.png"));
            backgroundLevel3Image4 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "clouds_2.png"));
            backgroundLevel3Image5 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "ground_1.png"));
            backgroundLevel3Image6 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "ground_2.png"));
            backgroundLevel3Image7 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "ground_3.png"));
            backgroundLevel3Image8 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "plant.png"));
            backgroundLevel3Image9 = ImageIO.read(new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "layer_01_1920 x 1080.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage getEnemyOgreJumpImage_1() {
        return enemyOgreJumpImage_1;
    }

    public static BufferedImage getEnemyOgreJumpImage_2() {
        return enemyOgreJumpImage_2;
    }

    public static BufferedImage getEnemyOgreJumpImage_3() {
        return enemyOgreJumpImage_3;
    }

    public static BufferedImage getEnemyOgreJumpImage_4() {
        return enemyOgreJumpImage_4;
    }

    public static BufferedImage getEnemyOgreJumpImage_5() {
        return enemyOgreJumpImage_5;
    }

    public static BufferedImage getEnemyOgreJumpImage_6() {
        return enemyOgreJumpImage_6;
    }

    public static BufferedImage getEnemyOgreJumpImage_7() {
        return enemyOgreJumpImage_7;
    }

    public static BufferedImage getEnemyOgreWalkImage_1() {
        return enemyOgreWalkImage_1;
    }

    public static BufferedImage getEnemyOgreWalkImage_2() {
        return enemyOgreWalkImage_2;
    }

    public static BufferedImage getEnemyOgreWalkImage_3() {
        return enemyOgreWalkImage_3;
    }

    public static BufferedImage getEnemyOgreWalkImage_4() {
        return enemyOgreWalkImage_4;
    }

    public static BufferedImage getEnemyOgreWalkImage_5() {
        return enemyOgreWalkImage_5;
    }

    public static BufferedImage getEnemyOgreWalkImage_6() {
        return enemyOgreWalkImage_6;
    }

    public static BufferedImage getEnemyOgreWalkImage_7() {
        return enemyOgreWalkImage_7;
    }

    public static BufferedImage getEnemyCarrionImage() {
        return enemyCarrionImage;
    }

    public static BufferedImage getEnemyHuskImage() {
        return enemyHuskImage;
    }

    public static BufferedImage getEnemyHuskShootImage() {
        return enemyHuskShootImage;
    }

    public static BufferedImage getEnemyPestilenceImage() {
        return enemyPestilenceImage;
    }

    public static BufferedImage getEnemyMummyZombieLeftImage() {
        return enemyMummyZombieLeftImage;
    }

    public static BufferedImage getEnemyMummyZombieRightImage() {
        return enemyMummyZombieRightImage;
    }

    public static BufferedImage getEnemyMummyZombieRageLeftImage_1() {
        return enemyMummyZombieRageLeftImage_1;
    }

    public static BufferedImage getEnemyMummyZombieRageLeftImage_2() {
        return enemyMummyZombieRageLeftImage_2;
    }

    public static BufferedImage getEnemyMummyZombieRageRightImage_1() {
        return enemyMummyZombieRageRightImage_1;
    }

    public static BufferedImage getEnemyMummyZombieRageRightImage_2() {
        return enemyMummyZombieRageRightImage_2;
    }

    public static BufferedImage getPlayerImage() {
        return playerImage;
    }

    public static BufferedImage getPlayerMoveRightImage() {
        return playerMoveRightImage;
    }

    public static BufferedImage getPlayerMoveRightWoundedImage() {
        return playerMoveRightWoundedImage;
    }

    public static BufferedImage getPlayerMoveLeftImage() {
        return playerMoveLeftImage;
    }

    public static BufferedImage getPlayerMoveLeftWounded() {
        return playerMoveLeftWoundedImage;
    }

    public static BufferedImage getPlayerJumpImage() {
        return playerJumpImage;
    }

    public static BufferedImage getPlayerJumpWoundedImage() {
        return playerJumpWoundedImage;
    }

    public static BufferedImage getPlayerFireBallImage_1() {
        return playerFireBallImage_1;
    }

    public static BufferedImage getPlayerFireBallImage_2() {
        return playerFireBallImage_2;
    }

    public static BufferedImage getFireBallImage() {
        return fireBallImage;
    }

    public static BufferedImage getBackgroundImage1() {
        return backgroundImage1;
    }

    public static BufferedImage getBackgroundImage2() {
        return backgroundImage2;
    }

    public static BufferedImage getBackgroundImage3() {
        return backgroundImage3;
    }

    public static BufferedImage getBackgroundImage4() {
        return backgroundImage4;
    }

    public static BufferedImage getBackgroundImage5() {
        return backgroundImage5;
    }

    public static BufferedImage getBackgroundImage6() {
        return backgroundImage6;
    }

    public static BufferedImage getBackgroundImage7() {
        return backgroundImage7;
    }

    public static BufferedImage getBackgroundImage8() {
        return backgroundImage8;
    }

    public static BufferedImage getBackgroundImage9() {
        return backgroundImage9;
    }

    public static BufferedImage getHeartImage() {
        return heartImage;
    }

    public static BufferedImage getPlayerWoundedImage() {
        return playerWoundedImage;
    }

    public static BufferedImage getHungryCarrion() {
        return hungryCarrion;
    }

    public static BufferedImage getGameOverImage() {
        return gameOverImage;
    }

    public static BufferedImage getBackgroundLevel2Image1() {
        return backgroundLevel2Image1;
    }

    public static BufferedImage getBackgroundLevel2Image2() {
        return backgroundLevel2Image2;
    }

    public static BufferedImage getBackgroundLevel2Image3() {
        return backgroundLevel2Image3;
    }

    public static BufferedImage getBackgroundLevel2Image4() {
        return backgroundLevel2Image4;
    }

    public static BufferedImage getBackgroundLevel2Image5() {
        return backgroundLevel2Image5;
    }

    public static BufferedImage getBackgroundLevel3Image1() {
        return backgroundLevel3Image1;
    }

    public static BufferedImage getBackgroundLevel3Image2() {
        return backgroundLevel3Image2;
    }

    public static BufferedImage getBackgroundLevel3Image3() {
        return backgroundLevel3Image3;
    }

    public static BufferedImage getBackgroundLevel3Image4() {
        return backgroundLevel3Image4;
    }

    public static BufferedImage getBackgroundLevel3Image5() {
        return backgroundLevel3Image5;
    }

    public static BufferedImage getBackgroundLevel3Image6() {
        return backgroundLevel3Image6;
    }

    public static BufferedImage getBackgroundLevel3Image7() {
        return backgroundLevel3Image7;
    }

    public static BufferedImage getBackgroundLevel3Image8() {
        return backgroundLevel3Image8;
    }

    public static BufferedImage getBackgroundLevel3Image9() {
        return backgroundLevel3Image9;
    }
}
