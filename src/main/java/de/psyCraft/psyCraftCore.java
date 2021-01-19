package de.psyCraft;

import de.psyCraft.core.lobby.LobbyJoinListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class psyCraftCore extends JavaPlugin {
	
	@Override
	public void onEnable() {
		// Plugin startup logic
		
	}
	
	private void register() {
		registerCommands();
		registerListeners(this.getServer().getPluginManager());
	}
	
	private void registerCommands() {
	
	}
	
	private void registerListeners(PluginManager manager) {
		manager.registerEvents(new LobbyJoinListener(), this);
	}
	
	@Override
	public void onDisable() {
		// Plugin shutdown logic
	}
}
