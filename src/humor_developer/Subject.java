package humor_developer;

import java.sql.Date;

	public class Subject {

	private int subjectid = 0;

	private String title = null;

	private String content = null;

	private String linkurl = null;

	private int category1 = 0;

	private String category1name = null;

	private int category2 = 0;

	private String category2name = null;

	private int category3 = 0;

	private String category3name = null;

	private Date modified = null;

	public String getCategory1name() {
		return category1name;
	}

	public void setCategory1name(String category1name) {
		this.category1name = category1name;
	}

	public String getCategory2name() {
		return category2name;
	}

	public void setCategory2name(String category2name) {
		this.category2name = category2name;
	}

	public String getCategory3name() {
		return category3name;
	}

	public void setCategory3name(String category3name) {
		this.category3name = category3name;
	}

	public int getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLinkurl() {
		return linkurl;
	}

	public void setLinkurl(String linkurl) {
		this.linkurl = linkurl;
	}

	public int getCategory1() {
		return category1;
	}

	public void setCategory1(int category1) {
		this.category1 = category1;
	}

	public int getCategory2() {
		return category2;
	}

	public void setCategory2(int category2) {
		this.category2 = category2;
	}

	public int getCategory3() {
		return category3;
	}

	public void setCategory3(int category3) {
		this.category3 = category3;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}
}
