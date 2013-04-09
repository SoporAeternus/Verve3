package team_14_verve3;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the Music Items sold by verve3
 * This class is the extension of abstract Class Item.
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class Music extends Item {

    private String artist;               // artist of CD music
    private String producer;             // producer of CD music
    private String filename;             // file name that allows preview of music when not bought
    // and access to full file when music is bought
    // default constructor

    public Music() {
        super();
        artist = "";
        producer = "";
        filename = "";
    }

    /**
     * Set function acts as Init Constructor to Set Artist of Music
     *
     * @param artist type string- assigned to private data member artist using
     * this operator
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Set function acts as Init Constructor to Set Producer of Music
     *
     * @param producer type string- assigned to private data member producer
     * using this operator
     */
    public void setProducer(String producer) {
        this.producer = producer;
    }

    /**
     * Set function acts as Init Constructor to Set file Name of Music to
     * preview or full access to music purchased
     *
     * @param fileName type string- assigned to private data member fileName
     * using this operator
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getArtist() {
        // POST: returns the name of artist of Song
        return artist;
    }

    public String getProducer() {
        // POST: returns the producer of the Song
        return producer;
    }
}
