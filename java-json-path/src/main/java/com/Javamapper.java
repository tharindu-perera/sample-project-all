package com;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Javamapper {
    @JsonProperty("color")
    Train26 train26;

    public Train26 getTrain26() {
        return train26;
    }

    public void setTrain26(Train26 train26) {
        this.train26 = train26;
    }

    @Override
    public String toString() {
        return "Javamapper{" +
                "train26=" + train26 +
                '}';
    }
}

class Train26 {
    @JsonProperty("a")
    B text;

    public B getText() {
        return text;
    }

    public void setText(B text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Train26{" +
                "text=" + text +
                '}';
    }
}
@JsonIgnoreProperties(value = { "bb" })
    class B{
        @JsonProperty("bb")

        String  text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return "B{" +
                    "text='" + text + '\'' +
                    '}';
        }
    }