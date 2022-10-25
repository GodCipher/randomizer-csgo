package dev.luzifer.gui.view.views.game;

import dev.luzifer.gui.view.views.game.objects.entity.LivingEntity;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HealthBar extends Pane implements LivingEntity { // TODO: Very dirty workaround
    
    private final Rectangle healthBar = new Rectangle();
    private final Rectangle healthBarBackground = new Rectangle();
    
    private final Label healthLabel = new Label();
    
    private int health = 1;
    
    public HealthBar(int initialHealth) {
        
        healthBarBackground.setWidth(100);
        healthBarBackground.setHeight(15);
        healthBarBackground.setFill(Color.RED);
        
        updateHealth(initialHealth);
        healthBar.setHeight(15);
        healthBar.setFill(Color.GREEN);
        
        healthLabel.setTextFill(Color.WHITE);
        
        getChildren().addAll(healthBarBackground, healthBar, healthLabel);
    }
    
    public void updateHealth(int health) {
        
        healthBar.setWidth(health);
        healthLabel.setText("Health: " + health);
        
        if(health <= 0)
            damage(1);
    }
    
    @Override
    public void update() {
    
    }
    
    @Override
    public Position getPosition() {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void setHealth(int health) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void damage(int amount) {
        health -= amount;
    }
    
    @Override
    public int getHealth() {
        return health;
    }
}