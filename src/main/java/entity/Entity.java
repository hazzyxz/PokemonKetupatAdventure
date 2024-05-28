package entity;

import java.awt.*;
import java.io.Serializable;

interface Entity {

    void update();

    void draw(Graphics2D g2);

}