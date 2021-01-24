package me.notmyfault.serverlib;

import static me.notmyfault.serverlib.forks.AirplaneLite.isAirplaneLite;
import static me.notmyfault.serverlib.forks.AirplaneLiteChunkConcurrency.isAirplaneLiteChunkConcurrency;
import static me.notmyfault.serverlib.forks.Akarin.isAkarin;
import static me.notmyfault.serverlib.forks.Forge.isForge;
import static me.notmyfault.serverlib.forks.KibblePatcher.isKibblePatcher;
import static me.notmyfault.serverlib.forks.Yatopia.isYatopia;

public class ServerLib {

    public static void checkUnsafeForks() {
        isAirplaneLite();
        isAirplaneLiteChunkConcurrency();
        isAkarin();
        isForge();
        isKibblePatcher();
        isYatopia();
    }
}