package org.example.behavioural.state;

public interface State {

    void play();

    void pause();

    void stop();
}

class PlayingState implements State {
    private MediaPlayer mediaPlayer;

    public PlayingState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
        System.out.println("Already playing...");
    }

    @Override
    public void pause() {
        System.out.println("pausing the player.");
        mediaPlayer.setCurrentState(mediaPlayer.getPausedState());
    }

    @Override
    public void stop() {
        System.out.println("stopping the player");
        mediaPlayer.setCurrentState(mediaPlayer.getStoppedState());
    }
}

class PausedState implements State {
    private MediaPlayer mediaPlayer;

    public PausedState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
        System.out.println("resuming the player");
        mediaPlayer.setCurrentState(mediaPlayer.getPlayingState());
    }

    @Override
    public void pause() {
        System.out.println("already paused...");
    }

    @Override
    public void stop() {
        System.out.println("stopping the player.");
        mediaPlayer.setCurrentState(mediaPlayer.getStoppedState());
    }
}

class StoppedState implements State {
    private MediaPlayer mediaPlayer;

    public StoppedState(MediaPlayer mediaPlayer) {
        this.mediaPlayer = mediaPlayer;
    }

    @Override
    public void play() {
        System.out.println("Starting the player");
        mediaPlayer.setCurrentState(mediaPlayer.getPlayingState());
    }

    @Override
    public void pause() {
        System.out.println("Can't paused.the player is paused");
        mediaPlayer.setCurrentState(mediaPlayer.getPausedState());
    }

    @Override
    public void stop() {
        System.out.println("Already stopped.");
    }
}

