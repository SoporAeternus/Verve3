package Products;

/**
 * Name: Alikhan Amandyk, Varun Patel, Di Wang Section: [Alikhan and Varun -
 * 001; Di- 002] Program: verve3 Phase 1 Date: 02/15/2013
 *
 */

/*
 * This class contains various methods for managing the DVD Items sold by verve3
 * This class is the extension of abstract Class Item.
 * 
 * @author Alikhan Amandyk
 * @author Varun Patel
 * @author Di Wang
 * @version 1.0 02/15/2013
 */
public class DVD extends Item {

    private String DIRECTOR;      // director of DVD
    private String PRODUCER;      // producer of DVD

    // default constructor  
    public DVD() 
    {
        super();
        DIRECTOR = "";
        PRODUCER= "";
    }

    public DVD(String[] newDVD)
    {   
        super();
    }
    /**
     * Set function acts as Init Constructor to Set Director of DVD
     *
     * @param director type string- assigned to private data member director
     * using this operator
     */
    public void setDirector(String director) {
        this.DIRECTOR = director;
    }
        
    /**
     * Set function acts as Init Constructor to Set Producer of DVD
     *
     * @param producer type string- assigned to private data member producer
     * using this operator
     */
    public void setProducer(String producer) {
        this.PRODUCER = producer;
    }

    public String getDirector() {
        // POST: returns the director of the DVD
        return DIRECTOR;
    }

    public String getProducer() {
        // POST: returns the producer of the DVD
        return PRODUCER;
    }
}
