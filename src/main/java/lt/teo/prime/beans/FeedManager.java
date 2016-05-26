package lt.teo.prime.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import lt.teo.core.model.Feeds;
import lt.teo.core.model.Items;
import lt.teo.core.service.FeedsService;
import lt.teo.core.service.ItemsService;
import lt.teo.core.spring.configuration.AppConfig;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@ManagedBean
@SessionScoped
public class FeedManager implements Serializable {

	private static final long serialVersionUID = 1L;

	FeedsService service;

	ItemsService serviceItems;

	public void init() {
		initialize();
	}

	public void initialize() {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(
				AppConfig.class);
		service = (FeedsService) context.getBean("feedsService");
		serviceItems = (ItemsService) context.getBean("itemsService");
	}

	public List<Feeds> view() {
		return service.findAllFeeds();
	}

	public List<Items> getFeedItem(Feeds feed) {
		return serviceItems.findByparent(feed);
	}

	public void onRowEdit(RowEditEvent event) {
		Feeds feed = (Feeds) event.getObject();
		service.updateFeeds(feed);
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage("The Feed edit Success :" + feed.getName()));
	}
	
	  public void onRowCancel(RowEditEvent event) {
		  FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("The Feed edit Canceled"));
	    }
}
