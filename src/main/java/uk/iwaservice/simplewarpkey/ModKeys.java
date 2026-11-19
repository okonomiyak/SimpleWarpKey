package uk.iwaservice.simplewarpkey;

import net.minecraft.client.KeyMapping;
import org.lwjgl.glfw.GLFW;

public class ModKeys {
    public static final KeyMapping WARP = new KeyMapping(
            "key.simplewarpkey.warp", GLFW.GLFW_KEY_G, "key.categories.gameplay");
}