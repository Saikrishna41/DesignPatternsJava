package org.example.behavioural.state;

public interface State {

    void play();

    void pause();

    void stop();
}

class PlayingState implements State {

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }
}

class PausedState implements State {

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }
}

class StoppedState implements State {

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }
}

