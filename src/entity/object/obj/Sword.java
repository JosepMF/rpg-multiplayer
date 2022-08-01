package entity.object.obj;

import entity.object.SuperObject;

public class Sword extends SuperObject {
    @Override
    public void action() {
        for (int i = 0; i <= gp.enemyLoader.enemies.length - 1; i++) {
            if (gp.enemyLoader.enemies[i] != null) {
                if(gp.enemyLoader.enemies[i].worldX > gp.player.worldX - gp.squareSize*5 &&
                        gp.enemyLoader.enemies[i].worldY > gp.player.worldY - gp.squareSize*5 &&
                        gp.enemyLoader.enemies[i].worldX < gp.player.worldX + gp.player.width + gp.squareSize*5 &&
                        gp.enemyLoader.enemies[i].worldY < gp.player.worldY + gp.player.height + gp.squareSize*5
                ){
                    gp.enemyLoader.enemies[i].damageItSelf(damage);
                }
            }
        }
    }
}
