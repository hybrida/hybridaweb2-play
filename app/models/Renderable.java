package models;

import play.twirl.api.Html;

public interface Renderable {
    public Html renderFrontPageSample();
    public Html renderFull();
}
