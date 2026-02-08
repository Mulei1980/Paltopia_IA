using Hytale.API;
using Hytale.API.World;
using System.Collections.Generic;

namespace Paltopia.ME {
    public class METerminalLogic : IBlockScript {
        public void OnInteract(Player player, BlockPos pos) {
            // Nachricht im Chat
            player.SendMessage("§b[ME System] §fVerbinde mit Lagernetzwerk...");
            
            // Öffnet das oben erstellte UI-Fenster
            player.OpenUI("paltopia:ui/terminal.html");
        }
    }
}
