package dev.luzifer.gui.util;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;

public final class ImageUtil {

    private static final ImageResolution DEFAULT_RESOLUTION = ImageResolution.MEDIUM;

    public static Image getImage(String path) {
        return getImage(path, DEFAULT_RESOLUTION);
    }

    public static Image getImage(String path, ImageResolution resolution) {
        return new Image(path, resolution.getWidth(), resolution.getHeight(), true, true);
    }

    public static ImageView getImageView(String path) {
        return getImageView(path, DEFAULT_RESOLUTION);
    }

    public static ImageView getImageView(String path, ImageResolution resolution) {
        return new ImageView(getImage(path, resolution));
    }
    
    public static ImagePattern getImagePattern(String path) {
        return getImagePattern(path, DEFAULT_RESOLUTION);
    }
    
    public static ImagePattern getImagePattern(String path, ImageResolution resolution) {
        return new ImagePattern(getImage(path, resolution));
    }
    
    private ImageUtil() {
    }

    public enum ImageResolution {

        SMALL(16, 16),
        OKAY(24, 24),
        MEDIUM(32, 32),
        ORIGINAL(64, 64); // large

        private final int width;
        private final int height;

        ImageResolution(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }
}