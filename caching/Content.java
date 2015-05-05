package caching;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


/**
 * Created by rushabhmehta91 on 4/6/15.
 */
public class Content implements Serializable {
    public HashMap<Integer, Integer> listofScoreOnInterfaces;
    private String contentName;
    private int maxNScore;
    private int timeToLive;
    private List<Integer> trail;
    private long sizeInBytes;
    private Date lastUsed;
    private Object contentCache;

    // constructors start
    public Content( String contentName, List<Integer> trail, long sizeInBytes, Object contentCache) {
        this.contentName = contentName;
//        this.lastUsed = now;
        this.contentCache = contentCache;
        this.maxNScore = 100;
        this.timeToLive = 999999;
        this.trail = trail;
        this.sizeInBytes = sizeInBytes;
    }
    public Content(String contentName, int maxNScore, int timeToLive, List<Integer> trail, long sizeInBytes, Object contentCache) {

        this.contentName = contentName;
        this.maxNScore = maxNScore;
        this.timeToLive = timeToLive;
        this.trail = trail;
        this.sizeInBytes = sizeInBytes;
//        this.lastUsed = lastUsed;
        this.contentCache = contentCache;
    }
    // constructors ends

    //getter and setters starts

    public String getContentName() {
        return contentName;
    }

    public void setContentName(String contentName) {
        this.contentName = contentName;
    }

    public int getMaxNScore() {
        return maxNScore;
    }

    public void setMaxNScore(int maxNScore) {
        this.maxNScore = maxNScore;
    }

    public int getTimeToLive() {
        return timeToLive;
    }

    public void setTimeToLive(int timeToLive) {
        this.timeToLive = timeToLive;
    }

    public HashMap<Integer, Integer> getListofScoreOnInterfaces() {
        return listofScoreOnInterfaces;
    }

    public void setListofScoreOnInterfaces(HashMap<Integer, Integer> listofScoreOnInterfaces) {
        this.listofScoreOnInterfaces = listofScoreOnInterfaces;
    }

    public List<Integer> getTrail() {
        return trail;
    }

    public void setTrail(List<Integer> trail) {
        this.trail = trail;
    }

    public long getSizeInBytes() {
        return sizeInBytes;
    }

    public void setSizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
    }

    public Object getContentCache() {
        return contentCache;
    }

    public void setContentCache(Object contentCache) {
        this.contentCache = contentCache;
    }

    //getter and setters ends

    public byte[] getBytes() throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(out);
        os.writeObject(this);
        return out.toByteArray();
    }

//    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
//        ByteArrayInputStream in = new ByteArrayInputStream(data);
//        ObjectInputStream is = new ObjectInputStream(in);
//        return is.readObject();
//    }
}