package com.app.cricapi.model;

import java.util.List;

public class Root {

    List<Match> matches;

    public Root(List<Match> matches) {
        this.matches = matches;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
