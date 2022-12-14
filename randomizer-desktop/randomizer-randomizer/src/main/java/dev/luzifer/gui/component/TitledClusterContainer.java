package dev.luzifer.gui.component;

import dev.luzifer.gui.util.ImageUtil;
import dev.luzifer.model.event.Event;
import dev.luzifer.model.event.cluster.EventCluster;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// TODO: This class should not know any model stuff since its UI
public class TitledClusterContainer extends TitledPane {
    
    private final List<Label> finishedEvents = new ArrayList<>();
    
    private final VBox vBox = new VBox();
    private final EventCluster eventCluster;
    
    private boolean finished;
    
    public TitledClusterContainer(String title, EventCluster eventCluster) {
        
        this.eventCluster = eventCluster;
        
        setText(title);
        setContent(vBox);
        setGraphic(ImageUtil.getImageView("images/loading_gif.gif", ImageUtil.ImageResolution.MEDIUM));
        
        fill(eventCluster);
    }
    
    public List<Label> getEventLabels() {
        return vBox.getChildren().stream().filter(Label.class::isInstance).map(Label.class::cast).collect(Collectors.toList());
    }
    
    public void visualizeExecution(Event event) {
        for(Label label : getEventLabels()) {
            if(label.getText().equals(event.name()) && !finishedEvents.contains(label)) {
                label.setGraphic(ImageUtil.getImageView("images/loading_gif.gif", ImageUtil.ImageResolution.SMALL));
                break;
            }
        }
    }
    
    public void finish() {
        
        this.finished = true;
        
        setGraphic(ImageUtil.getImageView("images/checkmark_icon.png", ImageUtil.ImageResolution.MEDIUM));
        setExpanded(false);
        
        // fallback
        getEventLabels().forEach(label -> label.setGraphic(ImageUtil.getImageView("images/checkmark_icon.png", ImageUtil.ImageResolution.SMALL)));
    }
    
    public void finish(Event event) {
        for(Label label : getEventLabels()) {
            if(label.getText().equals(event.name()) && !finishedEvents.contains(label)) {
                label.setGraphic(ImageUtil.getImageView("images/checkmark_icon.png", ImageUtil.ImageResolution.SMALL));
                finishedEvents.add(label);
                break;
            }
        }
    }
    
    public boolean isFinished() {
        return finished;
    }
    
    public EventCluster getEventCluster() {
        return eventCluster;
    }
    
    private void fill(EventCluster eventCluster) {
        eventCluster.getEvents().forEach(event -> {
            
            Label label = new Label(event.name());
            label.setGraphic(ImageUtil.getImageView("images/squat_icon.png", ImageUtil.ImageResolution.SMALL));
            
            vBox.getChildren().add(label);
        });
    }
}
