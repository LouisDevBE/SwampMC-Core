package dev.swampmc.swampmccore.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import dev.swampmc.swampmccore.SwampMC_Core;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;

public class BungeeCordUtil {
    public static void connectToServer(SwampMC_Core plugin, Player player, String servername) {
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("Connect");
        out.writeUTF(servername);
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }
}
