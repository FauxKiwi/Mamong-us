package tk.mamong_us.objects;

import com.siinus.simpleGrafix.gfx.ImageTile;
import org.jetbrains.annotations.NotNull;
import tk.mamong_us.Main;
import tk.mamong_us.PlayerSprite;
import tk.mamong_us.core.Handler;

public class OtherPlayer extends GameObject {
    private final String name;
    private boolean moving = false;
    private boolean left = false;
    private byte frame = 1;
    private byte buffer = 0;

    /**
     * Creates a new OtherPlayer object.
     *
     * @param program The associated program
     * @param name The name
     */
    public OtherPlayer(Main program, String name, ImageTile spriteSheet) {
        super(program,spriteSheet, 0,0,0,0);
        this.name = name;
    }

    @Override
    public void update() {
        if (moving) {
            frameUp();
        } else {
            frame = 1;
            buffer = 0;
        }
    }

    @Override
    public void render() {
        program.getRenderer().drawImageTile(spriteSheet, x+offX(), y+offY(),left?1:0,moving?(4-frame):4);
        program.getRenderer().drawText(name, x+offX()+100, y+offY(), 0xff000000, null);
    }

    public void destroy() {
        Handler.deleteObject(this);
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void frameUp() {
        if (buffer > 0) {
            buffer--;
            return;
        }
        buffer = 5;
        if (frame < 4) {
            frame++;
            return;
        }
        frame = 1;
    }

    public void setSprite(@NotNull PlayerSprite sprite) {
        this.spriteSheet = sprite.image;
    }
}
