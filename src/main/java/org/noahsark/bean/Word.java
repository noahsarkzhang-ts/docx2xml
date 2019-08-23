package org.noahsark.bean;

import org.jdom.CDATA;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * 有道单词
 */
public class Word  implements Serializable {

    @XmlElement(name = "word")
    private String word;

    @XmlElement(name = "trans")
    private String trans;

    @XmlElement(name = "phonetic")
    private String phonetic;

    @XmlElement(name = "tags")
    private String tags = "common-2000";

    @XmlElement(name = "progress")
    private String progress = "1";

    @XmlTransient
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @XmlTransient
    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    @XmlTransient
    public String getPhonetic() {
        return phonetic;
    }

    public void setPhonetic(String phonetic) {
        this.phonetic = phonetic;
    }

    @XmlTransient
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @XmlTransient
    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }
}

