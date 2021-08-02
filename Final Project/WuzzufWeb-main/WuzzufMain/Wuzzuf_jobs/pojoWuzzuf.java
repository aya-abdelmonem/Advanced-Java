package Wuzzuf;

/**
 *
 * @author rawan
 */
public class pojoWuzzuf {
    private String Title;
    private String Location;
    private String Company;
    private String Count;

    public pojoWuzzuf() {
    }

    public pojoWuzzuf(String Title, String Location, String Company, String Category) {
        this.Title = Title;
        this.Location = Location;
        this.Company = Company;
        this.Count = Category;
        
    }

    public String getCount() {
        return Count;
    }

    public void setCount(String Count) {
        this.Count = Count;
    }
    

    public String getTitle() {
        return Title;
    }

    public String getLocation() {
        return Location;
    }

    public String getCompany() {
        return Company;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    @Override
    public String toString() {
        return "pojoWuzzuf{" + "Title=" + Title + ", Location=" + Location + ", Company=" + Company + '}';
    }
    
    
    
}

