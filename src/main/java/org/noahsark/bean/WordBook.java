package org.noahsark.bean;

import org.noahsark.bean.Word;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 * 有道词典本
 */
@XmlRootElement(name="wordbook")
public class WordBook implements Serializable {

    @XmlElement(name="item")
    private List<Word> item;

    @XmlTransient
    public List<Word> getItem() {
        return item;
    }

    public void setItem(List<Word> item) {
        this.item = item;
    }
}
