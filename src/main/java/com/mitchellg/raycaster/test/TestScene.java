package com.mitchellg.raycaster.test;

import com.mitchellg.raycaster.engine.model.game.Game;
import com.mitchellg.raycaster.engine.model.game.GameScene;
import com.mitchellg.raycaster.engine.model.location.Vector3f;
import com.mitchellg.raycaster.engine.model.render.Color;
import com.mitchellg.raycaster.engine.model.render.Light;
import com.mitchellg.raycaster.engine.model.render.Material;
import com.mitchellg.raycaster.engine.model.render.Skybox;
import com.mitchellg.raycaster.test.objects.*;

public class TestScene extends GameScene {
    public TestScene(Game game){
        super(game);


        this.skybox = new Skybox("sky.jpg");
        this.light = new Light(new Vector3f(-1, 2, -1));

        PlaneObj plane = new PlaneObj(-1f);
        plane.setMaterial(new Material(Color.WHITE, 0.08f, 0){

            @Override
            public Color getTextureColor(Vector3f point) {
                if (((point.getX() > 0) & (point.getZ() > 0)) || ((point.getX() < 0) & (point.getZ() < 0))) {
                    if ((int)point.getX() % 2 == 0 ^ (int)point.getZ() % 2 != 0) {
                        return Color.GRAY;
                    } else {
                        return Color.DARK_GRAY;
                    }
                } else {
                    if ((int)point.getX() % 2 == 0 ^ (int)point.getZ() % 2 != 0) {
                        return Color.DARK_GRAY;
                    } else {
                        return Color.GRAY;
                    }
                }
            }
        });

        TableObj table = new TableObj();
        table.setPosition(1, 0, 5);
        table.setScale(0.01f);

        CubeObj cube = new CubeObj();
        cube.setPosition(0, 0, 2);
        cube.setScale(1f);
        cube.setRotation(0, 45, 0);
        cube.setMaterial(new Material(Color.BLACK, 1f, 0));

        SphereObj sphere = new SphereObj(.5f);
        sphere.setMaterial(new Material(Color.RED, 0f, 0));
        sphere.setPosition(0, 0, -1);

        this.addObjects(cube, sphere, plane);

    }


    @Override
    public void onUpdate() {
    }
}
