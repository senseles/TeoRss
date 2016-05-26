package lt.teo.prime.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import lt.teo.core.RSSFeedParser;
import lt.teo.core.model.Feeds;
import lt.teo.core.service.FeedsService;
import lt.teo.core.spring.configuration.AppConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

@ManagedBean
@SessionScoped
public class RegisterFeed implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public Feeds feed;
    
    public RSSFeedParser readerRss;
    
    public String feedName;
    
    public String feedUrl;
    
    FeedsService service;

	public void init(){
	  feedUrl = ("http://www.vogella.com/article.rss"); // https://15min.lt/rss
	  feedName = "vogella.com";//15min
	  initialize();
	}
	
	@SuppressWarnings("resource")
	public void initialize(){
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		service = (FeedsService) context.getBean("feedsService");
	}
	
	public void register() {
		feed = new RSSFeedParser(feedUrl).readFeed();
		feed.setName(feedName);
		feed.setUrl(feedUrl);
		save();
	}
	
	public void  save(){
		service.saveFeeds(feed);
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage("The Feed "+feed.getName()+" Is add Successfully"));
	}
	
    public Feeds getFeed() {
		return feed;
	}

	public void setFeed(Feeds feed) {
		this.feed = feed;
	}
	
	public String getFeedName() {
		return feedName;
	}

	public void setFeedName(String feedName) {
		this.feedName = feedName;
	}
	
	public String getFeedUrl() {
		return feedUrl;
	}

	public void setFeedUrl(String feedUrl) {
		this.feedUrl = feedUrl;
	}

}
 