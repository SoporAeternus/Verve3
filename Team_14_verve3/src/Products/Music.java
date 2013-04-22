package Products;

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

    private String ARTIST;               // artist of CD music
    private String PRODUCER;             // producer of CD music
    private String FILENAME;             // file name that allows preview of music when not bought
    // and access to full file when music is bought
    // default constructor

    public Music() 
    {
        super();
        ARTIST = "";
        PRODUCER = "";
        FILENAME = "";
    }

    public Music(String[] newMusic)
    {
        super();
    }
    
    /**
     * Set function acts as Init Constructor to Set Producer of Music
     *
     * @param producer type string- assigned to private data member producer
     * using this operator
     */
    public void setProducer(String producer) {
        this.PRODUCER = producer;
    }
    
    public void setArtist(String artist)
    {
        this.ARTIST = artist;
    }

    /**
     * Set function acts as Init Constructor to Set file Name of Music to
     * preview or full access to music purchased
     *
     * @param fileName type string- assigned to private data member fileName
     * using this operator
     */
    public void setFilename(String filename) {
        this.FILENAME = filename;
    }

    public String getArtist() {
        // POST: returns the name of artist of Song
        return ARTIST;
    }

    public String getProducer() {
        // POST: returns the producer of the Song
        return PRODUCER;
    }
}
