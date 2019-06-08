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
            File backgroundImageFile1 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0010_1.png");
            backgroundImage1 = ImageIO.read(backgroundImageFile1);
            File backgroundImageFile2 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0009_2.png");
            backgroundImage2 = ImageIO.read(backgroundImageFile2);
            File backgroundImageFile3 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0008_3.png");
            backgroundImage3 = ImageIO.read(backgroundImageFile3);
            File backgroundImageFile4 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0006_4.png");
            backgroundImage4 = ImageIO.read(backgroundImageFile4);

            // Динамический фон
            File backgroundImageFile5 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0005_5.png");
            backgroundImage5 = ImageIO.read(backgroundImageFile5);
            File backgroundImageFile6 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0003_6.png");
            backgroundImage6 = ImageIO.read(backgroundImageFile6);
            File backgroundImageFile7 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0002_7.png");
            backgroundImage7 = ImageIO.read(backgroundImageFile7);
            File backgroundImageFile8 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0001_8.png");
            backgroundImage8 = ImageIO.read(backgroundImageFile8);
            File backgroundImageFile9 = new File(PATH_TO_RESOURCE + "background" + FS + "level_1" + FS + "Layer_0000_9.png");
            backgroundImage9 = ImageIO.read(backgroundImageFile9);

            //Конец игры
            File gameOverImageFile = new File(PATH_TO_RESOURCE + "Game_Over.png");
            gameOverImage = ImageIO.read(gameOverImageFile);

            // Враги
            File fireBallImageFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "FireBall.png");
            fireBallImage = ImageIO.read(fireBallImageFile);
            File enemyCarrionImageFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyCarrion.png");
            enemyCarrionImage = ImageIO.read(enemyCarrionImageFile);
            File enemyHuskImageFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyHusk.png");
            enemyHuskImage = ImageIO.read(enemyHuskImageFile);
            File enemyHuskShootImageFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyHuskShoot.png");
            enemyHuskShootImage = ImageIO.read(enemyHuskShootImageFile);
            File carrion2ImageFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "carrion2.png");
            hungryCarrion = ImageIO.read(carrion2ImageFile);
            File enemyPestilenceImageFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "EnemyPestilence.png");
            enemyPestilenceImage = ImageIO.read(enemyPestilenceImageFile);
            File enemyMummyZombieLeftFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS +"MummyZombieLeft.png");
            enemyMummyZombieLeftImage = ImageIO.read(enemyMummyZombieLeftFile);
            File enemyMummyZombieRightFile = new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS +"MummyZombieRight.png");
            enemyMummyZombieRightImage = ImageIO.read(enemyMummyZombieRightFile);

            File enemyMummyZombieRageLeftFile_1 = new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS +"MummyZombieRageLeft_1.png");
            enemyMummyZombieRageLeftImage_1 = ImageIO.read(enemyMummyZombieRageLeftFile_1);
            File enemyMummyZombieRageLeftFile_2 = new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS +"MummyZombieRageLeft_2.png");
            enemyMummyZombieRageLeftImage_2 = ImageIO.read(enemyMummyZombieRageLeftFile_2);

            File enemyMummyZombieRageRightFile_1 = new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS +"MummyZombieRageRight_1.png");
            enemyMummyZombieRageRightImage_1 = ImageIO.read(enemyMummyZombieRageRightFile_1);
            File enemyMummyZombieRageRightFile_2 = new File(PATH_TO_RESOURCE + "enemies" + FS + "mummy_zombie" + FS +"MummyZombieRageRight_2.png");
            enemyMummyZombieRageRightImage_2 = ImageIO.read(enemyMummyZombieRageRightFile_2);

            // Игрок
            File playerImageFile = new File(PATH_TO_RESOURCE + "player" + FS + "Player.png");
            playerImage = ImageIO.read(playerImageFile);
            File playerWounded = new File(PATH_TO_RESOURCE + "player" + FS + "PlayerWounded.png");
            playerWoundedImage = ImageIO.read(playerWounded);
            File playerMoveRightImageFile = new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveRight.png");
            playerMoveRightImage = ImageIO.read(playerMoveRightImageFile);
            File playerMoveRightWoundedImageFile = new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveRightWounded.png");
            playerMoveRightWoundedImage = ImageIO.read(playerMoveRightWoundedImageFile);
            File playerMoveLeft = new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveLeft.png");
            playerMoveLeftImage = ImageIO.read(playerMoveLeft);
            File playerMoveLeftWounded = new File(PATH_TO_RESOURCE + "player" + FS + "PlayerMoveLeftWounded.png");
            playerMoveLeftWoundedImage = ImageIO.read(playerMoveLeftWounded);
            File playerJump = new File(PATH_TO_RESOURCE + "player" + FS + "PlayerJump.png");
            playerJumpImage = ImageIO.read(playerJump);
            File playerJumpWounded = new File(PATH_TO_RESOURCE + "player" + FS + "PlayerJumpWounded.png");
            playerJumpWoundedImage = ImageIO.read(playerJumpWounded);
            // огненные шары игрока
            File playerFireBall_1 = new File(PATH_TO_RESOURCE + "player" + FS + "player_fire_balls" + FS + "PlayerFireBall_1.png");
            playerFireBallImage_1 = ImageIO.read(playerFireBall_1);
            File playerFireBall_2 = new File(PATH_TO_RESOURCE + "player" + FS + "player_fire_balls" + FS + "PlayerFireBall_2.png");
            playerFireBallImage_2 = ImageIO.read(playerFireBall_2);

            // Предметы
            File heartImageFile = new File(PATH_TO_RESOURCE + "heart.png");
            heartImage = ImageIO.read(heartImageFile);


            //Картинки для уровня 2

            //Фон
            File backgroundLevel2ImageFile1 = new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "1.png");
            backgroundLevel2Image1 = ImageIO.read(backgroundLevel2ImageFile1);
            File backgroundLevel2ImageFile2 = new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "2.png");
            backgroundLevel2Image2 = ImageIO.read(backgroundLevel2ImageFile2);
            File backgroundLevel2ImageFile3 = new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "3.png");
            backgroundLevel2Image3 = ImageIO.read(backgroundLevel2ImageFile3);
            File backgroundLevel2ImageFile4 = new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "4.png");
            backgroundLevel2Image4 = ImageIO.read(backgroundLevel2ImageFile4);
            File backgroundLevel2ImageFile5 = new File(PATH_TO_RESOURCE + "background" + FS + "level_2" + FS + "5.png");
            backgroundLevel2Image5 = ImageIO.read(backgroundLevel2ImageFile5);


            //Картинки для уровня 3

            //Фон
            File backgroundLevel3ImageFile1 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "sky.png");
            backgroundLevel3Image1 = ImageIO.read(backgroundLevel3ImageFile1);
            File backgroundLevel3ImageFile2 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "rocks.png");
            backgroundLevel3Image2 = ImageIO.read(backgroundLevel3ImageFile2);
            File backgroundLevel3ImageFile3 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "clouds_1.png");
            backgroundLevel3Image3 = ImageIO.read(backgroundLevel3ImageFile3);
            File backgroundLevel3ImageFile4 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "clouds_2.png");
            backgroundLevel3Image4 = ImageIO.read(backgroundLevel3ImageFile4);
            File backgroundLevel3ImageFile5 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "ground_1.png");
            backgroundLevel3Image5 = ImageIO.read(backgroundLevel3ImageFile5);
            File backgroundLevel3ImageFile6 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "ground_2.png");
            backgroundLevel3Image6 = ImageIO.read(backgroundLevel3ImageFile6);
            File backgroundLevel3ImageFile7 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "ground_3.png");
            backgroundLevel3Image7 = ImageIO.read(backgroundLevel3ImageFile7);
            File backgroundLevel3ImageFile8 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "plant.png");
            backgroundLevel3Image8 = ImageIO.read(backgroundLevel3ImageFile8);
            File backgroundLevel3ImageFile9 = new File(PATH_TO_RESOURCE + "background" + FS + "level_3" + FS + "layer_01_1920 x 1080.png");
            backgroundLevel3Image9 = ImageIO.read(backgroundLevel3ImageFile9);

        } catch (IOException e) {
            e.printStackTrace();
        }
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
