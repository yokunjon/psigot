package com.psigot.Psigot.nms;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_15_R1.CraftServer;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class sharedNMS_1_15_R1 implements SharedNMS {

    @Override
    public void syncCommands() {
        try {
            CraftServer craftServer = (CraftServer) Bukkit.getServer();
            Method syncCommandsMethod = craftServer.getClass().getDeclaredMethod("syncCommands");

            syncCommandsMethod.setAccessible(true);
            syncCommandsMethod.invoke(craftServer);
            syncCommandsMethod.setAccessible(false);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
