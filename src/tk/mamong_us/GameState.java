package tk.mamong_us;

public enum GameState {
    MAIN_MENU,
    SINGLEPLAYER,
    MULTIPLAYER,
    LOADING,
    ERROR,
    PAUSE,
    SHHH;

    public enum MultiplayerState {
        LOBBY,
        GAME
    }
}
