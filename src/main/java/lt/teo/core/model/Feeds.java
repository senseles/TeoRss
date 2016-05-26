package lt.teo.core.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "feeds")
public class Feeds implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACT_SEQ")
    @SequenceGenerator(name = "ACT_SEQ", sequenceName = "ACT_SEQ")
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "url")
    private String url;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "last_update")
    private Date lastUpdate;

	@Column(name = "feed_name")
    private String name;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "feeds", cascade = CascadeType.ALL, orphanRemoval = true)
    @OrderBy("id DESC")
    private List<Items> item = new ArrayList<Items>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public List<Items> getItem() {
		return item;
	}

	public void setItem(List<Items> item) {
		this.item = item;
	}
	
    @Override
    public String toString() {
        return "Feeds [url=" + url + ", title=" + title + ", lastUpdate=" + lastUpdate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Feeds other = (Feeds) obj;
        if (id != other.id)
            return false;
        return true;
    }

    public Feeds() {
        super();
    }

	public Feeds(String title, Date pubdate) {
		this.title = title;
		this.lastUpdate = pubdate;
	}


   

}
