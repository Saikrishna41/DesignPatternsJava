package org.example.behavioural.state;

public class MediaPlayer {
    private State playingState;
    private State pausedState;
    private State stoppedState;
    private State currentState;

    public MediaPlayer() {
        this.playingState = new PlayingState(this);
        this.pausedState = new PausedState(this);
        this.stoppedState = new StoppedState(this);
        this.currentState = stoppedState;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public State getPlayingState() {
        return playingState;
    }

    public State getPausedState() {
        return pausedState;
    }

    public State getStoppedState() {
        return stoppedState;
    }

    public void play() {
        currentState.play();
    }

    public void stop() {
        currentState.stop();
    }

    public void pause() {
        currentState.pause();
    }
}
