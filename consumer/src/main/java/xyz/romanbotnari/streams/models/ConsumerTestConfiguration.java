package xyz.romanbotnari.streams.models;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConsumerTestConfiguration implements Serializable {
    
    @JsonProperty
    private int lag;

    public int getLag() {
        return lag;
    }

    public void setLag(int lag) {
        this.lag = lag;
    }

    private static ConsumerTestConfiguration ctc = new ConsumerTestConfiguration();

    private ConsumerTestConfiguration() {
        this.lag = 0;
    }

    private ConsumerTestConfiguration(int lag) {
        this.lag = lag;
    }

    public static ConsumerTestConfiguration getInstance() {
        if ( ctc == null ) {
            ctc = new ConsumerTestConfiguration();
        } 
        
        return ctc;
    }

}